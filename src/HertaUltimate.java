package src;
import java.util.ArrayList;

public class HertaUltimate extends Ability {
    
    private Atk attack;
    private ArrayList<Double> ultimate;
    private ArrayList<Sprite> animations;

    public HertaUltimate() {
        super("Herta Ultimate Attack", true);
        ultimate = new ArrayList<Double>();
        ultimate.add(2.0);
        attack = new Atk(ultimate, true);
        animations = new ArrayList<Sprite>();
    }

    public void execute(Character user, Character target) {
        CombatEngine engine = new CombatEngine(user, Battle.getEnemies(), attack);
        engine.executeDamage();
        StatusEffect damageAMP = new StatusEffect("damageAMP", 1, new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new double[]{0, 0.25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        user.addBuff(damageAMP);
    }
}