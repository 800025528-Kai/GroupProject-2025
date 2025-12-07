package src;
public class Pair {
    private Character first;
    private double second;
    public Pair(Character first, double second) {
        this.first = first;
        this.second = second;
    }
    public Character getChar() {
        return first;
    }
    public double getAV() {
        return second;
    }
    public void setAV(double newAV) {
        second = newAV;
    }
}   