package src;
import java.util.ArrayList;

public class HuohuoSkill extends Ability {
    
    private Atk attack;
    private ArrayList<Double> skill;
    private ArrayList<Sprite> animations;

    public HuohuoSkill() {
        super("Huohuo Skill Attack", true);
        skill = new ArrayList<Double>();
        attack = new Atk(skill, false);
        animations = new ArrayList<Sprite>();
    }

    public void execute(Character user, Character target) {
        ArrayList<Character> teammates = Battle.getTeammates();
        int targetIndex = teammates.indexOf(target);
        CombatEngine engine;
        if (targetIndex == 0) {
            target.modifyHP(0.21*user.maxHP() + 560);
            teammates.get(1).modifyHP(0.168*user.maxHP() + 448);
        }
        else if (targetIndex == teammates.size() - 1) {
            target.modifyHP(0.21*user.maxHP() + 560);
            teammates.get(targetIndex - 1).modifyHP(0.168*user.maxHP() + 448);
        }
        else {
            target.modifyHP(0.21*user.maxHP() + 560);
            teammates.get(targetIndex - 1).modifyHP(0.168*user.maxHP() + 448);
            teammates.get(targetIndex + 1).modifyHP(0.168*user.maxHP() + 448);
        }
        
    }
}
