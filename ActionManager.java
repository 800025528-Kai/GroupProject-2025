import java.util.ArrayList;

public class ActionManager {
    ArrayList<CharacterAction> actions;

    public ActionManager(CharacterAction mainAction) {
        this.actions = new ArrayList<>();
        this.actions.add(null);
        this.actions.add(mainAction);
    }

    public void addAction(CharacterAction action) {
        actions.add(1, action);
    }
    public void removeAction(int index) {
        actions.remove(index);
    }
}
