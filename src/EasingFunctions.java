package src;
public class EasingFunctions {

    static double lerp(double start, double end, double t) {
        return start + t * (end - start);
    }
    
    static double easeInOutCubic(double start, double end, double t) {
        return t < 0.5 ? 4 * t * t * t : 1 - Math.pow(-2 * t + 2, 3) / 2;
    }

}
