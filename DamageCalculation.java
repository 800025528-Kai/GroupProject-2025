import java.lang.Math;

public class DamageCalculation{
    private Character a;
    private Character d;
    private double abilityMultiplier;
    public DamageCalculation(Character attacker, Character defender, double abilityMultiplier){
        a = attacker;
        d = defender;
        this.abilityMultiplier = abilityMultiplier;
    }
    public double[] calculateDamage() {
        double damage = baseDmg();
        double cc = critMultiplier();
        damage *= cc;
        damage *= damageBoost();
        damage *= weakenMultiplier();
        damage *= defMultiplier();
        damage *= resistanceMultiplier();
        damage *= vulerabilityMultiplier();
        damage *= dmgMitigationMultiplier();
        damage *= brokenMultiplier();
        double[] a = {baseDmg(), cc, damageBoost(), weakenMultiplier(), defMultiplier(), resistanceMultiplier(), vulerabilityMultiplier(), dmgMitigationMultiplier(), brokenMultiplier(), damage};
        return a;
    }
    private double baseDmg(){
        return a.atk() * abilityMultiplier;
    }
    // do the other stats thingymagigicicthanmusleirples

    private double critMultiplier(){
        if (Math.random()<a.critRate()){
            return 1.0 + a.critDmg();
        }
        return 1.0;
    }

    private double damageBoost(){
        return 1.0 + a.dmgBoost();
    }

    private double weakenMultiplier() {
        return 1-a.weakenMulti();
    }

    private double defMultiplier() {
        System.out.println(d.def() + " " + a.level());
        return General.max(1.0 - d.def()/(d.def() + 200 + 10*a.level()), 0.0);
    }

    private double resistanceMultiplier() {
        return 1.0 - d.res() + a.resPen();
    }
    private double vulerabilityMultiplier() {
        return 1 + d.vulMulti();
    }
    private double dmgMitigationMultiplier() {
        return d.dmgMitigation();
    }
    private double brokenMultiplier() {
        if (d.isBroken()) {
            return 1.0;
        }
        return 0.9;
    }
}