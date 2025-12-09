package src;
import java.util.ArrayList;

public class SeeleSkill extends Ability {
    
    private Atk attack;
    private ArrayList<Double> skill;
    private ArrayList<Sprite> animations;

    public SeeleSkill() {
        super("Seele Skill Attack", true);
        skill = new ArrayList<Double>();
        skill.add(0.44);
        skill.add(0.22);
        skill.add(0.22);
        skill.add(1.32);
        attack = new Atk(skill, false);
        animations = new ArrayList<Sprite>();
    }

    public void execute(Character user, Character target) {
        CombatEngine engine = new CombatEngine(user, target, attack);
        engine.executeDamage();
        StatusEffect speedBoost = new StatusEffect("Speed Boost", 2, new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new double[]{0, 0, 0, 0.25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        user.addBuff(speedBoost);
    }
}
