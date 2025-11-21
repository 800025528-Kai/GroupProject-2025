import java.util.ArrayList;
public class Abilities{
    private Atk basic;
    private Atk atkUltimate;
    private Buff nonAtkUltimate;
    private Passive passive;
    private Atk atkSkill;
    private Buff buffSkill;
    
    public Abilities(Atk basic, Atk atkUltimate, Buff nonAtkUltimate, Passive passive, Atk atkSkill, Buff buffSkill){
        this.basic = basic;
        this.atkUltimate = atkUltimate;
        this.nonAtkUltimate = nonAtkUltimate;
        this.passive = passive;
        this.atkSkill = atkSkill;
        this.buffSkill = buffSkill;
    }

    public ArrayList<Double> basicHitSplit(int times){
        ArrayList<Double> basicHits = new ArrayList<Double>();
        if (basic.isAoe() == true)
        {
            for (int i = 0; i < times; i++){
            basicHits.add()
            }
        }
        

    }

}