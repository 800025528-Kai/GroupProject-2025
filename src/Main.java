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
    
    ArrayList<Character> teammates = new ArrayList<Character>();
    ArrayList<Character> enemies = new ArrayList<Character>();
    ArrayList<Sprite> ui = new ArrayList<Sprite>();
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
    
    int pointIndex = 0;
    
    Pointer.pointTo(teammates.get(pointIndex).getSprite());

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
                for (Sprite s : ui) {
                    Display.addSprite(s);
                }
                Display.addSprite(Pointer.pointer);
            }
            if (key == 'q') {
                gameState = "end";
            }
            if (key == 'c') {
                Display.clearScreen();
            }
            if (key == 'w') {
                if (pointIndex > 0) {
                    pointIndex = (pointIndex - 1);
                }
                Pointer.pointTo(teammates.get(pointIndex).getSprite());
            }
            if (key == 's') {
                if (pointIndex < teammates.size() - 1) {
                    pointIndex = (pointIndex + 1);
                }
                Pointer.pointTo(teammates.get(pointIndex).getSprite());
            }
            Display.updateScreen();
            Display.drawScreen();
            terminal.writer().println("TeamHP: " + teammates.get(0).hp() + " " + teammates.get(1).hp() + " " + teammates.get(2).hp() + " " + teammates.get(3).hp() + "\n"
            + "EnemyHP: " + enemies.get(0).hp() + " " + enemies.get(1).hp() + " " + enemies.get(2).hp() + " " + enemies.get(3).hp());
        }
        terminal.writer().flush();
        nextFrameTime = FramePacer.waitForNextFrame(nextFrameTime, FRAME_DURATION_NS);
    }
    terminal.close();
    }
}