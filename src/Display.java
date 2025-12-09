package src;
import java.util.ArrayList;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class Display {
    static final int WIDTH = 208;
    static final int HEIGHT = 117;
    static boolean[][] screen = new boolean[HEIGHT][WIDTH];
    static ArrayList<Sprite> sprites = new ArrayList<Sprite>();

    static void randomizeScreen() {
        for (int x = 0; x < screen.length; x++) {
            for (int y = 0; y < screen[x].length; y++) {
                screen[x][y] = Math.random() < 0.5;
            }
        }
    }

    static void clearScreen() {
        for (int x = 0; x < HEIGHT; x++) {
            for (int y = 0; y < WIDTH; y++) {
                screen[x][y] = false;
            }
        }
    }

    static void drawScreen() {
        // Move cursor to top-left of terminal
        System.out.print("\u001b[H");

        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < HEIGHT; x += 2) {
            for (int y = 0; y < WIDTH; y++) {
                boolean upper = screen[x][y];
                boolean lower = (x + 1 < HEIGHT) ? screen[x + 1][y] : false;

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

    static void addSprite(Sprite s) {
        sprites.add(s);
    }

    static void removeSprite(Sprite s) {
        sprites.remove(s);
    }

    static void displaySprite(int X, int Y, boolean[][] sprite) {
        int startI = Math.max(0, -X);
        int endI = Math.min(sprite.length, HEIGHT - X);

        for (int i = startI; i < endI; i++) {
            int rowLen = sprite[i].length;
            int startJ = Math.max(0, -Y);
            int endJ = Math.min(rowLen, WIDTH - Y);
            for (int j = startJ; j < endJ; j++) {
                if (sprite[i][j]) {
                    screen[X + i][Y + j] = true;
                }
            }
        }
    }

    static void updateScreen() {
        clearScreen();
        for (Sprite s : sprites) {
            boolean[][] sprite = s.getSprite();
            int X = s.getX();
            int Y = s.getY();
            displaySprite(X, Y, sprite);
        }
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (i == 0 || i == HEIGHT - 1 || j == 0 || j == WIDTH - 1) {
                    screen[i][j] = true;
                }
            }
        }
    }

    static class initTerminal {
    public static void main(String[] args) throws Exception {
        Terminal terminal = TerminalBuilder.builder()
            .system(true)
            .build();

        String resizeSequence = "\u001b[8;" + (HEIGHT/2 + 1) + ";" + (WIDTH + 1) + "t";

        terminal.writer().write(resizeSequence);
        terminal.writer().flush();
    }
}




}
