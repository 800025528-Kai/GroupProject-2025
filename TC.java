import java.util.ArrayList;
public class TC extends Character{ //Template Character

    private double[] stats;
    private ArrayList<Ability> abilities = new ArrayList<Ability>();

    public TC(){
        
        super("TC", new double[]{1203, 620, 460, 100, 0.05, 0.5, 0, 0, 100, 1, 0, 0, 0, 0, 0, 80, 0, 0, 0, 0, 0, 1203, 5}, true); //HP, MP, ATK, DEF, CRIT RATE, CRIT DMG, ARMOR PEN, MAGIC PEN, ACC, EVA, HP REGEN, MP REGEN, LIFE STEAL, SPELL VAMP, COOLDOWN REDUCTION, MOVEMENT SPEED, ATTACK SPEED, CAST SPEED, DMG MITIGATION, SHIELD STRONGHOLD, MAX HP, LEVEL
        abilities.add(new TCBasic());
        //in this order: basic, skill, ult
    }

    public void useAbility(int index, Character target){
        abilities.get(index).execute(this, target);
    }

    
}
