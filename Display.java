public class Display {
    static boolean[][] screen = new boolean[48][80];

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

}
