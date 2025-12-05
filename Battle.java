import java.util.ArrayList;

public class Battle {
    private ArrayList<Character> teammates;
    private ArrayList<Character> enemies;
    private ArrayList<Pair> actionOrder;

    public Battle(ArrayList<Character> teammates, ArrayList<Character> enemies, ArrayList<Pair> actionOrder) {
        this.teammates = teammates;
        this.enemies = enemies;
        this.actionOrder = actionOrder;
    }

    public ArrayList<Character> getTeammates() {
        return teammates;
    }
    public ArrayList<Character> getEnemies() {
        return enemies;
    }
    
    public Character getEnemy(int index){
        return enemies.get(index);
    }

    public Character getTeammate(int index){
        return teammates.get(index);
    }

    public void doAction(int index, Character self, Character target) {
        
    }
    
}