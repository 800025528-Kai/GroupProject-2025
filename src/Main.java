package src;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    static ConcurrentLinkedQueue<Integer> keyEvents = new ConcurrentLinkedQueue<>();
    static volatile String gameState = "startMenu";
    public static void main(String[] args) throws Exception {

    Terminal terminal = TerminalBuilder.builder().system(true).build();

    terminal.enterRawMode();

    Thread inputThread = new Thread(() -> {
            try {
                int ch;
                while ((ch = terminal.reader().read()) != -1) {
                    keyEvents.add(ch);
                }
            } catch (Exception e) {}
        });

/*
    Character a = new Character("a", new double[]{100, 100, 100, 100, 0, 0.5, 1, 1, 100, 1, 0, 0, 0, 0, 0, 90, 0, 0, 0, 1, 0});
    Character b = new Character("b", new double[]{100, 100, 100, 100, 0.05, 0.5, 1, 1, 100, 1, 0, 0, 0, 0, 0, 90, 0, 0, 0, 1, 0});
    ActionBar ab = new ActionBar();
    ab.addCharacter(a);
    ab.addCharacter(b);
    for (Pair p : ab.getActionOrder()) {
        System.out.println(p.getChar().getName() + ": " + p.getAV());
    }
    ab.modifyActionValue(b, 1);
    for (Pair p : ab.getActionOrder()) {
        System.out.println(p.getChar().getName() + ": " + p.getAV());
    }
        System.out.println(a.dmgMitigation() + ", " + b.dmgMitigation());

    boolean[][] sprite = {{true, true, true}, {false, true, false}, {true, true, true}};
    boolean alreadyDrawn = false;
    if (!alreadyDrawn) {
    Display.randomizeScreen();
    Display.drawScreen();
        alreadyDrawn = true;
    }
        */
    
    inputThread.setDaemon(true);
    inputThread.start();
    Display.initTerminal.main(new String[]{});
    while (!gameState.equals("end")) {
        Integer key;
        Sprite sprite = new Sprite(new boolean[][]{{true, true, true}, {false, true, false}, {true, true, true}}, 0, 0);

            while ((key = keyEvents.poll()) != null) {

                terminal.writer().println("Pressed: " + (char)(int)key);
                if (key == 'q') {
                    gameState = "end";
                    terminal.writer().flush(); 
                }
                if (key == 'd') {
                    Display.drawScreen();
                    terminal.writer().flush(); 
                }
                if (key == 's') {
                    Display.addSprite(sprite);
                    Display.drawScreen();
                    terminal.writer().flush(); 
                }
                if (key == 'm') {
                    Display.addSprite(sprite);
                    for (int i = 0; i < 10; i++) {
                        sprite.move(1, 0);
                        Display.drawScreen();
                        terminal.writer().flush(); 
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (key == 'c') {
                    Display.clearScreen();
                    Display.drawScreen();
                    terminal.writer().flush(); 
                }
                if (key == 'r') {
                    for (int i = 0; i < 100; i++) {
                        Display.addSprite(sprite);
                        sprite.goTo(0, (int)EasingFunctions.lerp(0, 100, EasingFunctions.easeInOutCubic(0, 1, i / 100.0)));
                        Display.drawScreen();
                        terminal.writer().flush();
                        Thread.sleep(20);
                    }                }
                if (key == 'x') {
                    Character a = new Character("a", new double[]{1203, 620, 460, 100, 0.05, 0.5, 0, 0, 100, 1, 0, 0, 0, 0, 0, 80, 0, 0, 0, 1, 0, 1203, 5}, false);
                    TC tc = new TC();

                    tc.useAbility(0, a);

                    terminal.writer().println(a.hp());
                    terminal.writer().flush();
                }
            }

        }
    terminal.close();
    }
}