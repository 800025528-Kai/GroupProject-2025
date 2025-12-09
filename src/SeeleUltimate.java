package src;
import java.util.ArrayList;

public class SeeleUltimate extends Ability {
    
    private Atk attack;
    private ArrayList<Double> basic;
    private ArrayList<Sprite> animations;

    public SeeleUltimate() {
        super("Seele Ultimate Attack", true);
        basic = new ArrayList<Double>();
        basic.add(4.25);
        attack = new Atk(basic, false);
        animations = new ArrayList<Sprite>();
    }

    public void execute(Character user, Character target) {
        CombatEngine engine = new CombatEngine(user, target, attack);
        engine.executeDamage();
    }
}
