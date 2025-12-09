package src;
import java.util.ArrayList;

public class Battle {
    private static ArrayList<Character> teammates;
    private static ArrayList<Character> enemies;
    private static ActionBar actionBar;
    

    public Battle(ArrayList<Character> teammates, ArrayList<Character> enemies) {
        this.teammates = teammates;
        this.enemies = enemies;
        this.actionBar = new ActionBar();
    }

    public static ArrayList<Character> getTeammates() {
        return teammates;
    }
    public static ArrayList<Character> getEnemies() {
        return enemies;
    }
    
    public Character getEnemy(int index){
        return enemies.get(index);
    }

    public Character getTeammate(int index){
        return teammates.get(index);
    }

    public void init(){
        for (Character c : teammates){
            actionBar.addCharacter(c);
        }
        for (Character c : enemies){
            actionBar.addCharacter(c);
        }
        actionBar.next();
    }

    public static ActionBar getActionBar() {
        return actionBar;
    }

    public void doBasic(int index) {
        Character self = actionBar.getCurrentAction().Character();
        if (self.getAbilities().get(0).targetsEnemy()){
            self.useAbility(0, enemies.get(index));
        }
        else{
            self.useAbility(0, teammates.get(index));
        }
        if (actionBar.getCurrentAction().isMainAction()) {
             actionBar.addCharacter(actionBar.getCurrentAction().Character());
        }
        actionBar.next();
        checks();
    }

    public void doSkill(int index) {
        Character self = actionBar.getCurrentAction().Character();
        if (self.getAbilities().get(1).targetsEnemy()){
            self.useAbility(1, enemies.get(index));
        }
        else{
            self.useAbility(1, teammates.get(index));
        }
        if (actionBar.getCurrentAction().isMainAction()) {
             actionBar.addCharacter(actionBar.getCurrentAction().Character());
        }
        actionBar.next();
        checks();
    }
    
    public void doUltimate(int index) {
        Character self = actionBar.getCurrentAction().Character();
        if (self.getAbilities().get(2).targetsEnemy()){
            self.useAbility(2, enemies.get(index));
        }
        else{
            self.useAbility(2, teammates.get(index));
        }
        if (actionBar.getCurrentAction().isMainAction()) {
             actionBar.addCharacter(actionBar.getCurrentAction().Character());
        }
        actionBar.next();
        checks();
    }

    public void checks() {
        if (teammates.size() == 0) {
            Main.gameState = "loss";
        }
        else if (enemies.size() == 0) {
            Main.gameState = "win";
        }
        for (Character c : teammates) {
            if (c.hp() <= 0) {
                teammates.remove(c);
                actionBar.removeCharacter(c);
                break;
            }
        }
        for (Character c : enemies) {
            if (c.hp() <= 0) {
                enemies.remove(c);
                actionBar.removeCharacter(c);
                break;
            }
        }
    }
    
}