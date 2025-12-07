package src;
import java.util.ArrayList;

public class Animations {
    private ArrayList<Sprite> frames;

    public Animations(ArrayList<Sprite> frames) {
        this.frames = frames;
    }

    public void next() {
        if (!frames.isEmpty()) {
            Display.removeSprite(frames.get(0));
            frames.remove(0);
            if (!frames.isEmpty()) {
                Display.addSprite(frames.get(0));
            }
        }
    }
}
