public class Display {
    static boolean[][] screen = new boolean[100][160];

    static void randomizeScreen() {
        for (int x = 0; x < screen.length; x++) {
            for (int y = 0; y < screen[x].length; y++) {
                screen[x][y] = Math.random() < 0.5;
            }
        }
    }

    static void clearScreen() {
        for (int x = 0; x < screen.length; x++) {
            for (int y = 0; y < screen[x].length; y++) {
                screen[x][y] = false;
            }
        }
    }

    static void drawScreen() {
        // Move cursor to top-left of terminal
        System.out.print("\u001b[H");

        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < screen.length; x += 2) {
            for (int y = 0; y < screen[x].length; y++) {
                boolean upper = screen[x][y];
                boolean lower = (x + 1 < screen.length) ? screen[x + 1][y] : false;

                if (upper && lower) {
                    sb.append("\u2588"); // Full block
                } else if (upper) {
                    sb.append("\u2580"); // Upper half block
                } else if (lower) {
                    sb.append("\u2584"); // Lower half block
                } else {
                    sb.append(" "); // Space
                }
            }
            sb.append('\n');
        }
        
        System.out.print(sb);
    }

    static void addSprite(int X, int Y, boolean[][] sprite) {
        int startI = Math.max(0, -X);
        int endI = Math.min(sprite.length, screen.length - X);

        for (int i = startI; i < endI; i++) {
            int rowLen = sprite[i].length;
            int startJ = Math.max(0, -Y);
            int endJ = Math.min(rowLen, screen[0].length - Y);
            for (int j = startJ; j < endJ; j++) {
                if (sprite[i][j]) {
                    screen[X + i][Y + j] = true;
                }
            }
        }
    }



}
