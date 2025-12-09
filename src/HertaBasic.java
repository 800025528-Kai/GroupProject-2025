package src;
import java.util.ArrayList;

public class HertaBasic extends Ability {
    
    private Atk attack;
    private ArrayList<Double> basic;
    private ArrayList<Sprite> animations;

    public HertaBasic() {
        super("Herta Basic Attack", true);
        basic = new ArrayList<Double>();
        basic.add(1.0);
        attack = new Atk(basic, false);
        animations = new ArrayList<Sprite>();
    }

    public void execute(Character user, Character target) {
        CombatEngine engine = new CombatEngine(user, target, attack);
        engine.executeDamage();
        if (target.hp()<target.maxHP()/2){
            target.modifyHP(-0.4*user.atk());
        }
    }
}
