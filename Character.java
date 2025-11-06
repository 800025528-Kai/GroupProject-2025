import java.util.ArrayList;

public class Character{
    private String name;
    private double[] stats;
    // stats in this order: hp, atk, def, spd, crit rate, crit dmg, break effect, heal multiplier, max energy, energy regen, effect hit rate, eff res
    private ArrayList<StatusEffect> buffs;

    public Character(String newName, double[] charStats){
        name = newName;
        stats = new double[12];
        for (int i = 0; i < stats.length; i++){
            stats[i] = charStats[i];
        }
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

    @Override
    public String toString(){
        return name;
    }
    
}