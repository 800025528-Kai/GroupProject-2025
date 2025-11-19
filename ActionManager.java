import java.util.ArrayList;

public class ActionManager {
    ArrayList<CharacterAction> actions;

    public ActionManager(CharacterAction mainAction) { // initialize action object in actionOrder arraylist
        this.actions = new ArrayList<>();
        this.actions.add(null);
        this.actions.add(mainAction);
    }

    public void addAction(CharacterAction action) { // add an action
        actions.add(1, action);
    }
    public void removeAction(int index) { // remove an action
        actions.remove(index);
    }
}
