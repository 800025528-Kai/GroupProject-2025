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

    public void addCharacter(Character c) {
        actionValue.add(10000/c.getStat[3]);
        double temp = 0.0;
        int length = actionValue.size();
        for (int i = 0; i < length; i++){
            if (actionValue.get(length-1)<actionValue.get(i)){
                temp = actionValue.get(i);
                actionValue.set(i, actionValue.get(length-1));
            }
        }
    }

    // action value = 10000/spd, reset after character moves
}