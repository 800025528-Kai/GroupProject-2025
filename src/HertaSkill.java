package src;
import java.util.ArrayList;

public class HertaSkill extends Ability {
    
    private Atk attack;
    private ArrayList<Double> skill;
    private ArrayList<Sprite> animations;

    public HertaSkill() {
        super("Herta Skill Attack", true);
        skill = new ArrayList<Double>();
        skill.add(0.3);
        skill.add(0.7);
        attack = new Atk(skill, true);
        animations = new ArrayList<Sprite>();
    }

    public void execute(Character user, Character target) {
        CombatEngine engine = new CombatEngine(user, Battle.getEnemies(), attack);
        engine.executeDamage();
    }
}
