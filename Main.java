public class Main {
    public static void main(String[] args) throws Exception {
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


    Display.randomizeScreen();
    Display.drawScreen();
    
    Thread.sleep(5000);
    Display.clearScreen();
    Display.drawScreen();
    }
}