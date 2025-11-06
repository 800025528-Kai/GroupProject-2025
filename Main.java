
public class Main {
    public static void main(String[] args) {
        Character a = new Character("a", new double[]{10, 20, 30, 40});
        Character b = new Character("b", new double[]{1, 2, 3, 4});
        General.arrayToString(General.dot(a.getStat(), b.getStat()), true);
    }
}