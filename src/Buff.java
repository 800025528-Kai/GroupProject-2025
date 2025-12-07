package src;
public class Buff{
    private StatusEffect buff;
    private boolean isAOE;

    public Buff(StatusEffect buff, boolean isAOE){
        this.buff = buff;
        this.isAOE = isAOE;
    }
}