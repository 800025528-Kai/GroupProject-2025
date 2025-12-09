package src;

import javax.sound.sampled.*;
import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Simple audio player utility.
 *
 * Features:
 * - Preload sounds to avoid playback delay
 * - Play multiple sounds concurrently
 * - Play immediately from file (no preload)
 * - Looping and volume control
 *
 * Supported formats depend on the Java runtime (typically WAV/AIFF/AU).
 */
public class AudioPlayer {
    private static final Map<String, LoadedSound> sounds = new ConcurrentHashMap<>();
    private static final Set<Clip> activeClips = ConcurrentHashMap.newKeySet();
    private static final ExecutorService executor = Executors.newCachedThreadPool(r -> {
        Thread t = new Thread(r, "AudioPlayer-thread");
        t.setDaemon(true);
        return t;
    });

    private static class LoadedSound {
        final AudioFormat format;
        final byte[] data;

        LoadedSound(AudioFormat format, byte[] data) {
            this.format = format;
            this.data = data;
        }
    }

    /**
     * Preload an audio file into memory under the given id.
     * Use `play(id)` to play the preloaded audio with minimal delay.
     *
     * @param id       key to reference the sound
     * @param filePath path to the audio file (wav/aiff/au recommended)
     * @throws Exception if loading fails or format unsupported
     */
    public static void load(String id, String filePath) throws Exception {
        try (AudioInputStream ais = AudioSystem.getAudioInputStream(new File(filePath))) {
            AudioFormat baseFormat = ais.getFormat();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int read;
            while ((read = ais.read(buffer)) != -1) baos.write(buffer, 0, read);
            sounds.put(id, new LoadedSound(baseFormat, baos.toByteArray()));
        }
    }

    /**
     * Play a preloaded sound by id. Returns the Clip used so callers can stop or adjust it.
     * If the id is not loaded, throws IllegalArgumentException.
     *
     * @param id   sound id loaded with {@link #load(String, String)}
     * @param loop when true, loops continuously
     * @return started Clip
     * @throws Exception on playback error
     */
    public static Clip play(String id, boolean loop) throws Exception {
        LoadedSound ls = sounds.get(id);
        if (ls == null) throw new IllegalArgumentException("Sound not loaded: " + id);
        return playBytes(ls.format, ls.data, loop);
    }

    /**
     * Convenience: play once (no loop) and don't keep it in the preload map.
     * This still avoids blocking the caller by running playback asynchronously.
     *
     * @param filePath path to audio file
     */
    public static void playFile(String filePath) {
        executor.submit(() -> {
            try (AudioInputStream ais = AudioSystem.getAudioInputStream(new File(filePath))) {
                AudioFormat format = ais.getFormat();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int read;
                while ((read = ais.read(buffer)) != -1) baos.write(buffer, 0, read);
                playBytes(format, baos.toByteArray(), false);
            } catch (Exception e) {
                System.err.println("AudioPlayer.playFile error: " + e.getMessage());
            }
        });
    }

    private static Clip playBytes(AudioFormat format, byte[] data, boolean loop) throws Exception {
        Clip clip = AudioSystem.getClip();
        clip.open(format, data, 0, data.length);
        activeClips.add(clip);
        clip.addLineListener(ev -> {
            if (ev.getType() == LineEvent.Type.STOP || ev.getType() == LineEvent.Type.CLOSE) {
                try {
                    clip.stop();
                } catch (Exception ignored) { }
                clip.close();
                activeClips.remove(clip);
            }
        });
        if (loop) clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();
        return clip;
    }

    /**
     * Stop and close all active clips.
     */
    public static void stopAll() {
        for (Clip c : activeClips.toArray(new Clip[0])) {
            try {
                c.stop();
                c.close();
            } catch (Exception ignored) { }
            activeClips.remove(c);
        }
    }

    /**
     * Set volume for a running clip. Gain in decibels (0 = original, negative to reduce).
     * If clip doesn't support volume control, this is a no-op.
     */
    public static void setVolume(Clip clip, float gainDb) {
        if (clip == null) return;
        try {
            if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                FloatControl vol = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                float clamped = Math.max(vol.getMinimum(), Math.min(vol.getMaximum(), gainDb));
                vol.setValue(clamped);
            }
        } catch (Exception ignored) { }
    }

    public static void loadFromResource(String id, String resourcePath) throws Exception {
    try (InputStream is = AudioPlayer.class.getResourceAsStream(resourcePath)) {
        if (is == null) throw new FileNotFoundException("Resource not found: " + resourcePath);
        try (BufferedInputStream bis = new BufferedInputStream(is);
             AudioInputStream ais = AudioSystem.getAudioInputStream(bis)) {
            AudioFormat fmt = ais.getFormat();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[4096];
            int r;
            while ((r = ais.read(buf)) != -1) baos.write(buf, 0, r);
            sounds.put(id, new LoadedSound(fmt, baos.toByteArray()));
        }
    }
}

    /**
     * Shutdown the audio system for this utility. After calling this, new playback may not work.
     */
    public static void shutdown() {
        stopAll();
        executor.shutdownNow();
        sounds.clear();
    }
}
