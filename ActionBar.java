import java.util.ArrayList;

public class ActionBar {
    private ArrayList<Pair> actionOrder;
    // Character action value pairs

    public ActionBar() {
        this.actionOrder = new ArrayList<Pair>();
    }

    private int searchInsertIndex(double AV) {
        for (int i = 0; i < actionOrder.size(); i++) {
            if (AV < actionOrder.get(i).getAV()) {
                return i;
            }
        }
        return actionOrder.size();
    }

    public void addCharacter(Character c) {
        //dw abt it for now ill do smth weird with lists
        double AV = 10000 / c.getStat()[3];
        Pair newPair = new Pair(c, AV);
        actionOrder.add(searchInsertIndex(AV), newPair);
    }

    public ArrayList<Pair> getActionOrder() {
        return actionOrder;
    }
}