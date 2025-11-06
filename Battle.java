public class Battle {
    private ArrayList<Character> teammates;
    private ArrayList<Character> enemies;

    public Battle(ArrayList<Character> teammates, ArrayList<Character> enemies) {
        this.teammates = teammates;
        this.enemies = enemies;
    }

    public ArrayList<Character> getTeammates() {
        return teammates;
    }
    public ArrayList<Character> getEnemies() {
        return enemies;
    }
}