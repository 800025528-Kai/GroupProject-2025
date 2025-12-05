public class SpriteInfo {
    private boolean[][] sprite;
    private int positionX;
    private int positionY;

    public SpriteInfo(boolean[][] sprite, int positionX, int positionY) {
        this.sprite = sprite;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public boolean[][] getSprite() {
        return sprite;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
