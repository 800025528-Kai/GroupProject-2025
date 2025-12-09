package src;
public class StatusEffect{
    private String name;
    private int duration;
    private double[] multiplier;
    private double[] flat;
    private boolean isDebuff;

    public StatusEffect(String name, int duration, double[] multiplier, double[] flat){
        this.name = name;
        this.duration = duration;
        // %buffs for multiplier stats are considered flat
        this.flat = flat;
        this.multiplier = multiplier;
    }
    public StatusEffect(String name, int duration, double[] multiplier, double[] flat, boolean isDebuff){
        this.name = name;
        this.duration = duration;
        // %buffs for multiplier stats are considered flat
        this.flat = flat;
        this.multiplier = multiplier;
        this.isDebuff = isDebuff;
    }

    public void onApply() {
    }

    public void onExpire() {
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    //getters
    public String name(){
        return name;
    }
    public double[] multiplier(){
        return multiplier;
    }
    public double[] flat(){
        return flat;
    }
    public int duration(){
        return duration;
    }
    public void reduceDuration(){
        duration -= 1;
    }
}