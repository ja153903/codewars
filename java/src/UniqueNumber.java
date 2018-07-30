import java.util.HashMap;
import java.util.Map;

public class UniqueNumber {
    public static double findUniq(double[] arr) {
        Map<Double, Integer> counter = new HashMap<>();
        for (double n : arr) {
            if (!counter.containsKey(n)) {
                counter.put(n, 1);
            } else {
                counter.put(n, counter.get(n)+1);
            }
        }
        for (double n: counter.keySet()) {
            if (counter.get(n) == 1) return n;
        }

        return -1;
    }
}
