package src;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TurnOrderManager {
    private PriorityQueue<Pair> turnOrder;

    public TurnOrderManager() {
        turnOrder = new PriorityQueue<>((Comparator.comparingDouble(Pair::getAV)));
    }

    public void update() {
        
    }
}
