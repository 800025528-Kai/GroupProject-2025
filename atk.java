import java.util.ArrayList;

public class Atk{
    private ArrayList<Double> hitSplit;
    private ArrayList<Double> altHitSplit;
    private boolean isAoe;
    private boolean isBlast;

    public Atk(ArrayList<Double> hits, ArrayList<Double> altHitSplit){
        hitSplit = hits;
        this.altHitSplit = altHitSplit;
        isBlast = true;
    }

    public Atk(ArrayList<Double> hits, boolean isAoe){
        hitSplit = hits;
        this.altHitSplit = new ArrayList<>();
        this.isAoe = isAoe;
    }
    
    public ArrayList<Double> hitSplitDmg(DamageCalculation a){
        for (int i = 0; i < hitSplit.size();i++){
            hitSplit.set(i, hitSplit.get(i)*a.calculateDamage());
        }
        return hitSplit;
    }
    public ArrayList<Double> altHitSplitDmg(DamageCalculation a){
        for (int i = 0; i < hitSplit.size();i++){
            altHitSplit.set(i, altHitSplit.get(i)*a.calculateDamage());
        }
        return hitSplit;
    }
    
    public ArrayList<Double> getHitSplit() {
        return hitSplit;
    }
    public ArrayList<Double> getAltHitSplit() {
        return altHitSplit;
    }
    public boolean isAoe() {
        return isAoe;
    }
    public boolean isBlast() {
        return isBlast;
    }
}
