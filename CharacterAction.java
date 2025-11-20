public class CharacterAction {
    private Character c;
    private boolean isMainAction;
    
    public CharacterAction(Character character, boolean isMainAction) {
        c = character;
        this.isMainAction = isMainAction;
    }
    public Character Character() {
        return c;
    }
    public boolean isMainAction() {
        return isMainAction;
    }
}