import java.util.ArrayList;

public class ActionBar {
    private ArrayList<Character> actionOrder;
    private ArrayList<Double> actionValue;
    // each index corresponds to each other
    // e.g. actionOrder.get(0) has actionValue.get(0) as its action value

    public ActionBar() {
        this.actionOrder = new ArrayList<>();
        this.actionValue = new ArrayList<>();
    }

    public void addCharacter(Character c, double value) {
        this.actionOrder.add(c);
        this.actionValue.add(value);
    }
}