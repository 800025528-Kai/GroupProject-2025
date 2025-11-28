public class Main {
    public static void main(String[] args) throws Exception{
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

    System.out.println(General.arrayToString(new DamageCalculation(a, b, 2.0).calculateDamage(), false));
    double[] mult1 = new double[21];
    double[] flat1 = new double[21];
    flat1[1] = 100;
    mult1[19] = 1.0;
    double[] mult2 = mult1.clone();
    double[] flat2 = flat1.clone();
    mult2[19] = 0.2;
    StatusEffect buff1 = new StatusEffect("Buff1", 2, mult1, flat1);
    StatusEffect buff2 = new StatusEffect("Buff2", 3, mult2, flat2);

    a.addBuff(buff1);
    a.applyBuffs();
    System.out.println(General.arrayToString(new DamageCalculation(a, b, 2.0).calculateDamage(), false));
    System.out.println(a.dmgMitigation() + ", " + b.dmgMitigation());

    b.addBuff(buff2);
    b.applyBuffs();
    System.out.println(General.arrayToString(new DamageCalculation(a, b, 2.0).calculateDamage(), false));
        System.out.println(a.dmgMitigation() + ", " + b.dmgMitigation());

    b.addBuff(buff2);
    b.applyBuffs();
    System.out.println(General.arrayToString(new DamageCalculation(a, b, 2.0).calculateDamage(), false));
        System.out.println(a.dmgMitigation() + ", " + b.dmgMitigation());


    Display.randomizeScreen();
    Display.drawScreen();
    
    Thread.sleep(5000);
    Display.clearScreen();
    Display.drawScreen();
    }
}