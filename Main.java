public class Main {
    public static void main(String[] args) {
    Character a = new Character("a", new double[]{10, 20, 30, 40, 50, 1, 1, 1, 1, 1, 1, 1});
    Character b = new Character("b", new double[]{1, 2, 3, 4, 5, 1, 1, 1, 1, 1, 1, 1});
    ActionBar ab = new ActionBar();
    ab.addCharacter(a);
    ab.addCharacter(b);
    for (Pair p : ab.getActionOrder()) {
        System.out.println(p.getChar().getName() + ": " + p.getAV());
    }
    }
}