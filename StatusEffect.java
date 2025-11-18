public class StatusEffect{
    private String name;
    private int duration;
    private double[] statModifiers;
    private boolean multiplier;

    public StatusEffect(String name, int duration, double[] statModifiers, boolean multiplier){
        this.name = name;
        this.duration = duration;
        this.statModifiers = statModifiers;
        this.multiplier = multiplier;
    }
}