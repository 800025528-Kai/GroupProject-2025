package src;

public final class FramePacer {

    private FramePacer() {
        // Utility class
    }

    /**
     * Returns the timestamp (in nanoseconds) when the next frame should end,
     * based on the desired frame duration.
     */
    public static long initNextFrameTimestamp(long frameDurationNs) {
        return System.nanoTime() + frameDurationNs;
    }

    /**
     * Sleeps just long enough so that the animation stays aligned with the
     * scheduled frame boundary. Returns the timestamp for the following frame,
     * making it easy to chain calls in a loop.
     */
    public static long waitForNextFrame(long scheduledFrameNs, long frameDurationNs) throws InterruptedException {
        long sleepNs = scheduledFrameNs - System.nanoTime();
        if (sleepNs > 0) {
            Thread.sleep(sleepNs / 1_000_000L, (int) (sleepNs % 1_000_000L));
        } else {
            // If we're behind, reset the schedule to "now" so we don't drift further.
            scheduledFrameNs = System.nanoTime();
        }
        return scheduledFrameNs + frameDurationNs;
    }
}
