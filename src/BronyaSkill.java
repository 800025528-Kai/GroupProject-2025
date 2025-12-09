package src;
import java.util.ArrayList;

public class BronyaSkill extends Ability {
    
    private Atk attack;
    private ArrayList<Double> skill;
    private ArrayList<Sprite> animations;

    public BronyaSkill() {
        super("Bronya Skill Attack", true);
        skill = new ArrayList<Double>();
        skill.add(1.0);
        attack = new Atk(skill, false);
        animations = new ArrayList<Sprite>();
    }

    public void execute(Character user, Character target) {
        StatusEffect damageBoost = new StatusEffect("Damage Boost", 1, new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.66, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        user.addBuff(damageBoost);
        Battle.getActionBar().actionAdvance(target, 1.0);
    }
}
