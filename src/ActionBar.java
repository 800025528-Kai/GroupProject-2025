package src;
import java.util.ArrayList;

public class ActionBar {
    private ArrayList<Pair> actionOrder;
    // Character action value pairs

    public ActionBar() {
        this.actionOrder = new ArrayList<Pair>();
    }

    private int searchInsertIndex(double AV) { //find index to insert based on AV
        for (int i = 0; i < actionOrder.size(); i++) {
            if (AV < actionOrder.get(i).getAV()) {
                return i;
            }
        }
        return actionOrder.size();
    }

    public void addCharacter(Character c) { //add character to action order
        //dw abt it for now ill do smth weird with lists
        double AV = 10000 / c.spd();
        Pair newPair = new Pair(c, AV);
        actionOrder.add(searchInsertIndex(AV), newPair);
    }

    public void modifyActionValue(Character c, double a){ //modify action value of character and reorder
        for (int i = 0; i < actionOrder.size(); i++) {
            if (actionOrder.get(i).getChar().getName().equals(c.getName())) {
                actionOrder.get(i).setAV(a);
                Pair temp = actionOrder.remove(i);
                actionOrder.add(searchInsertIndex(temp.getAV()), temp);
            }
        }
    }
    
    public double findCharacterAV(Character c){ //find current action value of character
        for (int i = 0; i < actionOrder.size(); i++) {
            if (actionOrder.get(i).getChar().getName().equals(c.getName())) {
                return actionOrder.get(i).getAV();
            }
        }
        return -1;
    }
    
    public void speedChangeAV(Character c, double oldSpd, double newSpd){ //modify action value based on speed change
        modifyActionValue(c , findCharacterAV(c)*oldSpd/newSpd);
    }

    public void actionAdvance(Character c, double advance){ //advance action value based on percentage
        double baseAV = 10000 / c.spd();
        double newAV = findCharacterAV(c)-baseAV*(advance/100);
        if (newAV > 0)
            modifyActionValue(c, newAV);
        else
            modifyActionValue(c, 0);
    }

    public Character getNext() { //get character with next turn
        return actionOrder.get(0).getChar();
    }

    //getters
    public ArrayList<Pair> getActionOrder() {
        return actionOrder;
    }
}