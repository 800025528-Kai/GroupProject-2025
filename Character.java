import java.util.ArrayList;
public class Character{
    private String name;
    private double[] stats;
    private double[] baseStats;
    private int[] hitSplits;
    // stats in this order: hp, atk, def, spd, crit rate, crit dmg, break effect, heal multiplier, max energy, energy regen, effect hit rate, eff res, damage boost, dot boost, weaken, level, res, res pen, vul multiplier, dmg mitigation, toughness, maxHP, energy
    private ArrayList<StatusEffect> buffs;
    private Abilities abilities;


    public Character(String newName, double[] charStats, Abilities charAbilities){
        name = newName;
        stats = charStats.clone();
        baseStats = charStats.clone();
        buffs = new ArrayList<StatusEffect>();
        abilities = charAbilities;
        
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
    

    public void applyBuffs(){
        stats = baseStats.clone();
        double [] multi = new double[stats.length];
        for (int i = 0; i < stats.length; i++) {
            multi[i] = 1.0;
        }
        double [] flat = new double[stats.length];
        for (StatusEffect a : buffs) {
            for (int i = 0; i < stats.length; i++) {
                if (stats[2] == 200) {
                    System.out.println("hi");
                }
                if (i != 19) {
                    multi[i] += a.multiplier()[i];
                    flat[i] += a.flat()[i];
                }
                else {
                    multi[i] *= a.multiplier()[i]; // dmg mitigation is multiplicative
                    System.out.println(stats[i]);
                }
            }
            General.arrayToString(a.multiplier(), true);
        }
        General.arrayToString(multi, true);
        General.arrayToString(baseStats, true);
        stats = General.eleWiseProd(baseStats, multi);
        for (int i = 0; i < stats.length; i++) {
            stats[i] += flat[i];
        }
    }

    public void modifyHP(double change){
        stats[0] += change;
        stats[0] = General.min(stats[0], stats[21]);
        stats[0] = General.max(stats[0], 0);
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
    public double maxHP(){
        return stats[21];
    }
    public double energy(){
        return stats[22];
    }

    @Override
    public String toString(){
        return name;
    }
}