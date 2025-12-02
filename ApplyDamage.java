import java.util.ArrayList;

public class ApplyDamage {
    public static void applyDamage(Character attacker, Character defender, ArrayList<Double> hitSplits) {
        for (double split : hitSplits) {
            double damage = new DamageCalculation(attacker, defender, split).calculateDamage();
            defender.modifyHP(damage);
        }
    }
}
