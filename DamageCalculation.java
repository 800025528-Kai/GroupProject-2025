import java.lang.Math;

public class DamageCalculation{
    private Character a;
    private Character d;
    public DamageCalculation(Character attacker, Character defender){
        a = attacker;
        d = defender;
    }
    private double getBaseDmg(){
        return 0;
    }

    private double critMultiplier(){
        if (Math.random()<a.critRate()){
            return 1.0 + a.critDmg();
        }
        return 1.0;
    }

    private double damageBoost(){
        return 0;
    }

    private double defMultiplier() {
        return 0;
    }
}