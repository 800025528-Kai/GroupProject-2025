package src;
import java.util.ArrayList;

public class HuohuoUltimate extends Ability {
    
    private Atk attack;
    private ArrayList<Double> ultimate;
    private ArrayList<Sprite> animations;

    public HuohuoUltimate() {
        super("Huohuo Ultimate Attack", true);
        ultimate = new ArrayList<Double>();
        ultimate.add(4.25);
        attack = new Atk(ultimate, true);
        animations = new ArrayList<Sprite>();
    }

    public void execute(Character user, Character target) {
        StatusEffect damageAMP = new StatusEffect("damage AMP", 2, new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new double[]{0, 0.4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        for (Character c : Battle.getTeammates()) {
            c.modifyEnergy(0.2*c.maxEnergy());
            user.addBuff(damageAMP);
        }
    }
}
