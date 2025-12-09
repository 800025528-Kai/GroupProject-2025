package src;
import java.util.ArrayList;

public class BronyaUltimate extends Ability {
    
    private Atk attack;
    private ArrayList<Double> ultimate;
    private ArrayList<Sprite> animations;

    public BronyaUltimate() {
        super("Bronya Ultimate Attack", true);
        ultimate = new ArrayList<Double>();
        ultimate.add(1.0);
        attack = new Atk(ultimate, true);
        animations = new ArrayList<Sprite>();
    }

    public void execute(Character user, Character target) {
        StatusEffect AtkCrit = new StatusEffect("Atk Crit", 2, new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new double[]{0, 0.55, 0, 0, 0,    +0.2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        user.addBuff(AtkCrit);
    }
}
