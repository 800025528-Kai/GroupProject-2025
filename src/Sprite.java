package src;
public class Sprite {
    private boolean[][] sprite;
    private int positionX;
    private int positionY;
    private boolean visible;

    public Sprite(boolean[][] sprite, int positionX, int positionY) {
        this.sprite = sprite;
        this.positionX = positionX;
        this.positionY = positionY;
        this.visible = true;
    }

    public boolean[][] getSprite() {
        return sprite;
    }

    public int getX() {
        return positionX;
    }

    public int getY() {
        return positionY;
    }

    public void move(int deltaX, int deltaY) {
        positionX += deltaX;
        positionY += deltaY;
    }

    public void setPos(int x, int y) {
        positionX = x;
        positionY = y;
    }

    public void goTo(double ticks, int x, int y) throws InterruptedException {


        // ticks are 20 ms slices
        int startX = positionX;
        int startY = positionY;

        long frameDurationNs = 20_000_000L; // 20ms in nanoseconds
        long totalFrames = Math.max(1, Math.round(ticks));
        long totalDurationNs = totalFrames * frameDurationNs;

        long startTime = System.nanoTime();
        long nextFrameTime = FramePacer.initNextFrameTimestamp(frameDurationNs);

        while (true) {
            long now = System.nanoTime();
            double linearProgress = Math.min(1.0, (double) (now - startTime) / totalDurationNs);

            double easedX = EasingFunctions.easeInOutCubic(0, 1, linearProgress);
            double easedY = EasingFunctions.easeInOutCubic(0, 1, linearProgress);

            this.setPos(
                (int) EasingFunctions.lerp(startX, x, easedX),
                (int) EasingFunctions.lerp(startY, y, easedY)
            );

            Display.drawScreen();

            if (linearProgress >= 1.0) {
                break;
            }

            nextFrameTime = FramePacer.waitForNextFrame(nextFrameTime, frameDurationNs);
        }
    }

    public void mirrorHorizontally() {
        int rows = sprite.length;
        int cols = sprite[0].length;
        boolean[][] mirrored = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mirrored[i][j] = sprite[i][cols - 1 - j];
            }
        }

        this.sprite = mirrored;
    }

    public int getWidth() {
        return sprite[0].length;
    }
    public int getHeight() {
        return sprite.length;
    }
}
