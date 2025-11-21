public class StatusEffect{
    private String name;
    private int duration;
    private double[] multiplier;
    private double[] flat;

    public StatusEffect(String name, int duration, double[] multiplier, double[] flat){
        this.name = name;
        this.duration = duration;
        // %buffs for multiplier stats are considered flat
        this.flat = flat;
        this.multiplier = multiplier;
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
}