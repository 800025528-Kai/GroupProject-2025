import java.lang.Math;

public class DamageCalculation{
    private Character a;
    private Character d;
    public DamageCalculation(Character attacker, Character defender){
        a = attacker;
        d = defender;
    }
    private double getBaseDmg(){
        return atk();
    }

    private double critMultiplier(){
        if (Math.random()<a.critRate()){
            
        }
    }
}