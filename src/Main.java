package src;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.ArrayList;

public class Main {
    static ConcurrentLinkedQueue<Integer> keyEvents = new ConcurrentLinkedQueue<>();
    public static volatile String gameState = "input";
    public static volatile boolean targetEnemy;
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
    boolean pointEnemy = true;
    String currentAbility = "basic";
    boolean randomize = false;

    Battle battle = new Battle(teammates, enemies);
    battle.init();
    
    Pointer.pointTo(teammates.get(pointIndex).getSprite());

    final long FRAME_DURATION_NS = 20_000_000L;
    long nextFrameTime = FramePacer.initNextFrameTimestamp(FRAME_DURATION_NS);

    while (!gameState.equals("end")) {
        Integer key;
        while (gameState.equals("win")) {
            Display.clearScreen();
            Display.drawScreen();
            terminal.writer().println("You Win! Press 'p' to exit.");
            terminal.writer().flush();
            if ((key = keyEvents.poll()) != null) {
                if (key == 'p') {
                    gameState = "end";
                }
            }
        }
        while (gameState.equals("lose")) {
            Display.clearScreen();
            Display.drawScreen();
            terminal.writer().println("You Lose! Press 'p' to exit.");
            terminal.writer().flush();
            if ((key = keyEvents.poll()) != null) {
                if (key == 'p') {
                    gameState = "end";
                }
            }
        }
        while (gameState.equals("enemyTurn")) {
            double toDo = Math.random() * 3;
            double target = Math.random() * teammates.size();

            if (toDo < 1) {
                battle.doBasic((int) target);
            }
            else if (toDo < 2) {
                battle.doSkill((int) target);
            }
            else {
                battle.doUltimate((int) target);
            }

        }
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
            if (key == 'p') {
                gameState = "end";
            }
            if (key == 'c') {
                Display.clearScreen();
            }
            if (key == 'w') {
                if (pointIndex > 0) {
                    pointIndex = (pointIndex - 1);
                }
            }
            if (key == 's') {
                if (pointIndex < teammates.size() - 1) {
                    pointIndex = (pointIndex + 1);
                }
            }
            if (key == 'r') {
                randomize = !randomize;
            }
            if (key == '1') {
                // hide pointer if is aoe
                if (battle.getActionBar().getCurrentAction().Character().getAbilities().get(0).targetsEnemy()) {
                    pointEnemy = true;
                }
                else {
                    pointEnemy = false;
                }
                if(currentAbility == "basic"){
                    battle.doBasic(pointIndex);
                }
                else{
                    currentAbility = "basic";
                }
            }
            if(key == '2'){
                if (battle.getActionBar().getCurrentAction().Character().getAbilities().get(1).targetsEnemy()) {
                    pointEnemy = true;
                }
                else {
                    pointEnemy = false;
                }
                if(currentAbility == "skill"){
                    battle.doSkill(pointIndex);
                }
                else{
                    currentAbility = "skill";
                }
            }
            if(key == '3'){
                if (battle.getActionBar().getCurrentAction().Character().getAbilities().get(2).targetsEnemy()) {
                    pointEnemy = true;
                }
                else {
                    pointEnemy = false;
                }
                if (currentAbility == "ultimate") {
                    battle.doUltimate(pointIndex);
                }
                else {
                    currentAbility = "ultimate";
                }
            }
            if (pointEnemy) {
                Pointer.pointTo(enemies.get(pointIndex).getSprite());
            } 
            else {
                Pointer.pointTo(teammates.get(pointIndex).getSprite());
            }
            if (!randomize) {
                Display.updateScreen();
            }
            if (key == 'i') {
                ArrayList<String> files = new ArrayList<String>();
                files.add("car-horn.wav");
                files.add("collectathon.wav");
                files.add("echomorph-hpf.wav");
                for (String file : files) {
                    AudioPlayer.load(file.split("\\.")[0], "res/sfx/" + file);
                }
                AudioPlayer.play(Math.random() < 0.5 ? "car-horn" : "collectathon", false);
            }
            Display.drawScreen();
            terminal.writer().println("TeamHP: " + teammates.get(0).hp() + " " + teammates.get(1).hp() + " " + teammates.get(2).hp() + " " + teammates.get(3).hp() + "\n"
            + "EnemyHP: " + enemies.get(0).hp() + " " + enemies.get(1).hp() + " " + enemies.get(2).hp() + " " + enemies.get(3).hp());
            terminal.writer().println("action: " + battle.getActionBar().getActionOrder());
        }
        terminal.writer().flush();
        nextFrameTime = FramePacer.waitForNextFrame(nextFrameTime, FRAME_DURATION_NS);
    }
    terminal.close();
    }
}