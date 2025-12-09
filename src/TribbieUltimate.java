package src;
import java.util.ArrayList;

public class TribbieUltimate extends Ability {
    
    private Atk attack;
    private ArrayList<Double> ultimate;
    private ArrayList<Sprite> animations;

    public TribbieUltimate() {
        super("Tribbie Ultimate Attack", true);
        ultimate = new ArrayList<Double>();
        ultimate.add(1.0);
        attack = new Atk(ultimate, true);
        animations = new ArrayList<Sprite>();
    }

    public void execute(Character user, Character target) {
        CombatEngine engine = new CombatEngine(user, Battle.getEnemies(), attack);
        engine.executeDamage();
    }

    //kai make this rq thank pookie
}
