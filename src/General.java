package src;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class General {
    static double max(double a, double b){
        if (a > b){
            return a;
        } else {
            return b;
        }
    }
    static int max(int a, int b){
        if (a > b){
            return a;
        } else {
            return b;
        }
    }
    static double min(double a, double b){
        if (a < b){
            return a;
        } else {
            return b;
        }
    }
    static int min(int a, int b){
        if (a < b){
            return a;
        } else {
            return b;
        }
    }

    // element-wise element wise product of two arrays
    static double[] eleWiseProd(double[] a, double[] b){
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++){
            result[i] = a[i] * b[i];
        }
        return result;
    }
    static int[] eleWiseProd(int[] a, int[] b){
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++){
            result[i] = a[i] * b[i];
        }
        return result;
    }

    // convert arrays to string and print if specified
    static String arrayToString(double[] arr, boolean print){
        String result = "[";
        for (int i = 0; i < arr.length; i++){
            result += arr[i];
            if (i < arr.length - 1){
                result += ", ";
            }
        }
        result += "]";
        if (print) {
            System.out.println(result);
        }
        return result;
    }
    static String arrayToString(int[] arr, boolean print){
        String result = "[";
        for (int i = 0; i < arr.length; i++){
            result += arr[i];
            if (i < arr.length - 1){
                result += ", ";
            }
        }
        result += "]";
        if (print) {
            System.out.println(result);
        }
        return result;
    }
    static String arrayToString(String[] arr, boolean print){
        String result = "[";
        for (int i = 0; i < arr.length; i++){
            result += arr[i];
            if (i < arr.length - 1){
                result += ", ";
            }
        }
        result += "]";
        if (print) {
            System.out.println(result);
        }
        return result;
    }
    
    // deep array to string and print if specified
    static String deepArrayToString(double[][] arr, boolean print){
        String result = "[";
        for (int i = 0; i < arr.length; i++){
            result += arrayToString(arr[i], false);
            if (i < arr.length - 1){
                result += "\n";
            }
        }
        result += "]";
        if (print) {
            System.out.println(result);
        }
        return result;
    }
    static String deepArrayToString(int[][] arr, boolean print){
        String result = "[";
        for (int i = 0; i < arr.length; i++){
            result += arrayToString(arr[i], false);
            if (i < arr.length - 1){
                result += "\n";
            }
        }
        result += "]";
        if (print) {
            System.out.println(result);
        }
        return result;
    }
    static String deepArrayToString(String[][] arr, boolean print){
        String result = "[";
        for (int i = 0; i < arr.length; i++){
            result += arrayToString(arr[i], false);
            if (i < arr.length - 1){
                result += "\n";
            }
        }
        result += "]";
        if (print) {
            System.out.println(result);
        }
        return result;
    }

    
}