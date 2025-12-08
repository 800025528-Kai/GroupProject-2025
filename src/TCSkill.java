package src;
import java.util.ArrayList;


public class TCSkill extends Ability {
    private Atk attack;
    private ArrayList<Double> center;
    private ArrayList<Double> side;
    private ArrayList<Sprite> animations;

    public TCSkill() {
        super("TC Skill", true);
        center = new ArrayList<Double>();
        center.add(1.0);
        side = new ArrayList<Double>();
        side.add(0.5);
        attack = new Atk(center, side);
        animations = new ArrayList<Sprite>();
    }

    public void execute(Character user, Character target) {
        CombatEngine engine = new CombatEngine(user, target, attack);
        engine.executeDamage();
    }
}
