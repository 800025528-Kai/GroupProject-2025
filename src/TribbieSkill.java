package src;
import java.util.ArrayList;

public class TribbieSkill extends Ability {
    
    private ArrayList<Sprite> animations;

    public TribbieSkill() {
        super("Tribbie Skill Attack", true);
        animations = new ArrayList<Sprite>();
    }

    public void execute(Character user, Character target) {
        double[] flat = new double[23];
        double[] multi = new double [23];
        multi[17] = 0.2;
        StatusEffect tribbieEffect = new StatusEffect("Tribbie Buff", 3, multi, flat);
        for (Character c : Battle.getTeammates()) {
            c.addBuff(tribbieEffect);
        }
    }
}
