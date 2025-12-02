import java.util.ArrayList;

public class CombatEngine {
    private Character attacker;
    private Character mainDefender;
    private Character sideDefender1;
    private Character sideDefender2;
    private ArrayList<Character> enemyTeam;
    private Atk ability;
    

    public CombatEngine(Character attacker, Character defender, Atk ability) {
        this.attacker = attacker;
        mainDefender = defender;
        this.ability = ability;
    }
    public CombatEngine(Character attacker, Character mainDefender, Character sideDefender1, Character sideDefender2, Atk ability) {
        this.attacker = attacker;
        this.mainDefender = mainDefender;
        this.sideDefender1 = sideDefender1;
        this.sideDefender2 = sideDefender2;
        this.ability = ability;
    }
    public CombatEngine(Character attacker, ArrayList<Character> enemyTeam, Atk ability) {
        this.attacker = attacker;
        this.enemyTeam = enemyTeam;
        this.ability = ability;
    }
    
    public void executeDamage(){
        if (mainDefender == null) {
            for (Character enemy : enemyTeam) {      
                ApplyDamage.applyDamage(attacker, enemy, ability.getHitSplit());          
            }
        }
        else if (sideDefender1 == null) {
            ApplyDamage.applyDamage(attacker, mainDefender, ability.getHitSplit());
        }
        else {
            ApplyDamage.applyDamage(attacker, mainDefender, ability.getHitSplit());
            ApplyDamage.applyDamage(attacker, sideDefender1, ability.getAltHitSplit());
            ApplyDamage.applyDamage(attacker, sideDefender2, ability.getAltHitSplit());
        }
    }
}
