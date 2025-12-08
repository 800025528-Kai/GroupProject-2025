package src;

public class Pointer {
    public static Sprite pointer = new Sprite(General.convTo2dBool(new int[][]{
        {1, 0, 0, 0, 0},
        {0, 1, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 1, 0, 0, 0},
        {1, 0, 0, 0, 0},
    }), 0, 0);

    public static void pointTo(int x, int y){
        pointer.setPos(x-2, y-5);
    }

    public static void pointTo(Sprite s){
        pointer.setPos(s.getX()+s.getHeight()/2-2, s.getY()-1);
    }


}
