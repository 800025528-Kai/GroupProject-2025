import java.util.ArrayList;
public class Character{
    private String name;
    private double[] stats;
    private double[] baseStats;
    // stats in this order: hp, atk, def, spd, crit rate, crit dmg, break effect, heal multiplier, max energy, energy regen, effect hit rate, eff res, damage boost, dot boost, weaken, level, res, res pen, vul multiplier, dmg mitigation, toughness, 
    private ArrayList<StatusEffect> buffs;

    public Character(String newName, double[] charStats){
        name = newName;
        stats = charStats.clone();
        baseStats = charStats.clone();
    }

    public Character(){
        name = "default";
        stats = new double[]{100, 10, 10, 100, 5, 50, 0, 1, 100, 10, 0, 0};
        buffs = new ArrayList<StatusEffect>();
    }

    public String getName(){
        return name;
    }
    public double[] getStat(){
        return stats;
    }
    public void addBuff(StatusEffect newBuff){
        buffs.add(newBuff);
    }

    //getters
    public double hp(){
        return stats[0];
    }
    public double atk(){
        return stats[1];
    }
    public double def(){
        return stats[2];
    }
    public double spd(){
        return stats[3];
    }
    public double critRate(){
        return stats[4];
    }
    public double critDmg(){
        return stats[5];
    }
    public double breakEffect(){
        return stats[6];
    }
    public double healMulti(){
        return stats[7];
    }
    public double maxEnergy(){
        return stats[8];
    }
    public double energyRegen(){
        return stats[9];
    }
    public double effectHitRate(){
        return stats[10];
    }
    public double effectRes(){
        return stats[11];
    }
    public double dmgBoost(){
        return stats[12];
    }
    public double dotBoost(){
        return stats[13];
    }
    public double weakenMulti(){
        return stats[14];
    }
    public double level(){
        return stats[15];
    }
    public double res(){
        return stats[16];
    }
    public double resPen(){
        return stats[17];
    }
    public double vulMulti(){
        return stats[18];
    }
    public double dmgMitigation(){
        return stats[19];
    }
    public double toughness(){
        return stats[20];
    }
    public boolean isBroken(){
        return stats[20] == 0;
    }
    // damage boost, dot boost, weaken, level, res, res pen, vul multiplier, dmg mitigation, toughness, 

    @Override
    public String toString(){
        return name;
    }
}