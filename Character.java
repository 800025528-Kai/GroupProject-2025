import java.util.ArrayList;

public class Character{
    private String name;
    private double[] stats;
    private ArrayList<StatusEffect> buffs;

    public Character(String newName, double[] charStats){
        name = newName;
        stats = new double[4];
        for (int i = 0; i < 4; i++){
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