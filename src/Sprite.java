package src;
public class Sprite {
    private boolean[][] sprite;
    private int positionX;
    private int positionY;

    public Sprite(boolean[][] sprite, int positionX, int positionY) {
        this.sprite = sprite;
        this.positionX = positionX;
        this.positionY = positionY;
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

    public void goTo(int x, int y) {
        positionX = x;
        positionY = y;
    }
}
