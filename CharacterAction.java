public class CharacterAction {
    private Character c;
    private boolean isMainAction;
    private boolean userInput;
    
    public CharacterAction(Character character, boolean isMainAction, boolean userInput) {
        c = character;
        this.isMainAction = isMainAction;
        this.userInput = userInput;
    }
    public Character Character() {
        return c;
    }
    public boolean isMainAction() {
        return isMainAction;
    }
}