import java.util.ArrayList;

public class atk {
    private ArrayList<Double> hitSplit;
    private ArrayList<Double> altHitSplit;
    private String atkType;

    public atk(ArrayList<Double> hits, ArrayList<Double> altHitSplit, String type){
        hitSplit = hits;
        this.altHitSplit = altHitSplit;
        atkType = type;
    }
    
    public ArrayList<Double> getHitSplit() {
        return hitSplit;
    }
    public ArrayList<Double> getAltHitSplit() {
        return altHitSplit;
    }
    public String getAtkType() {
        return atkType;
    }
}
