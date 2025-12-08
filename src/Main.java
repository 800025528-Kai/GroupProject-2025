package src;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.ArrayList;

public class Main {
    static ConcurrentLinkedQueue<Integer> keyEvents = new ConcurrentLinkedQueue<>();
    static volatile String gameState = "input";
    public static void main(String[] args) throws Exception {

    Terminal terminal = TerminalBuilder.builder().system(true).build();

    terminal.enterRawMode();

    Thread inputThread = new Thread(() -> {
            try {
                int ch;
                while ((ch = terminal.reader().read()) != -1 && gameState.equals("input")) {
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
    Sprite sprite = new Sprite(General.convTo2dBool(new int[][]{
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        }), 0, 0);
    
    ArrayList<Character> teammates = new ArrayList<Character>();
    ArrayList<Character> enemies = new ArrayList<Character>();
    teammates.add(new TC());
    teammates.get(0).getSprite().setPos(10, 10);
    teammates.add(new TC());
    teammates.get(1).getSprite().setPos(40, 10);
    teammates.add(new TC());
    teammates.get(2).getSprite().setPos(70, 10);
    teammates.add(new TC());
    teammates.get(3).getSprite().setPos(100, 10);
    enemies.add(new TC());
    enemies.get(0).getSprite().setPos(10, 100);
    enemies.add(new TC());
    enemies.get(1).getSprite().setPos(40, 100);
    enemies.add(new TC());
    enemies.get(2).getSprite().setPos(70, 100);
    enemies.add(new TC());
    enemies.get(3).getSprite().setPos(100, 100);

    final long FRAME_DURATION_NS = 20_000_000L;
    long nextFrameTime = FramePacer.initNextFrameTimestamp(FRAME_DURATION_NS);

    while (!gameState.equals("end")) {
        Integer key;
        while ((gameState.equals("input") && (key = keyEvents.poll()) != null)) {
            if (key == 'k') {
                for (Character c : teammates) {
                    Display.addSprite(c.getSprite());
                }
                for (Character c : enemies) {
                    Display.addSprite(c.getSprite());
                }
            }
            if (key == 'q') {
                gameState = "end";
            }
            if (key == 'c') {
                Display.clearScreen();
            }
            if (key == 'r') {
                sprite.goTo(100, 100, 100);
            }
            if (key == 'x') {
                Character a = new Character("a", new double[]{1203, 620, 460, 100, 0.05, 0.5, 0, 0, 100, 1, 0, 0, 0, 0, 0, 80, 0, 0, 0, 1, 0, 1203, 5}, false, new Sprite(new boolean[][] {{true, true, true}, {false, true, false}, {true, true, true}}, 0, 0));
                TC tc = new TC();

                 tc.useAbility(0, a);

                terminal.writer().println(a.hp());
            }
            if (key == 'm') {
                sprite.mirrorHorizontally();
            }
            Display.updateScreen();
            Display.drawScreen();
        }

        terminal.writer().flush();
        nextFrameTime = FramePacer.waitForNextFrame(nextFrameTime, FRAME_DURATION_NS);
    }
    terminal.close();
    }
}