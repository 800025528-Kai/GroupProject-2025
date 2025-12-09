package src;
import java.util.ArrayList;

public class HuohuoBasic extends Ability {
    
    private Atk attack;
    private ArrayList<Double> basic;
    private ArrayList<Sprite> animations;

    public HuohuoBasic() {
        super("Huohuo Basic Attack", true);
        basic = new ArrayList<Double>();
        basic.add(0.1);
        basic.add(0.1);
        basic.add(0.1);
        basic.add(0.2);
        attack = new Atk(basic, false);
        animations = new ArrayList<Sprite>();
    }

    public void execute(Character user, Character target) {
        CombatEngine engine = new CombatEngine(user, target, attack);
        engine.executeDamage();
    }
}
