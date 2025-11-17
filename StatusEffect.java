public class StatusEffect{
    private int type;
    private double multiplier;
    private double flat;
    private boolean isBuff;
    private boolean isDebuff;

    public StatusEffect(int type, double multiplier, double flat){
        this.type = type;
        this.multiplier = multiplier;
        this.flat = flat;
    }
    public int getType(){ //index of Character Stats
        return type;
    }
    public double getMultiplier(){
        return multiplier;
    }
    public double getFlat(){
        return flat;
    }
}