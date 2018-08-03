import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwiceLinear {
    public static int dblLinear(int n) {
        TreeSet<Integer> tset = new TreeSet<>();
//        int count = 0;
        tset.add(1);

//        while (!tset.isEmpty()) {
//            int curVal = tset.pollFirst(); count++;
//            tset.add(2 * curVal + 1);
//            tset.add(3 * curVal + 1);
//            if (count == n) break;
//        }

        for (int i = 0; i < n; i++) {
            int curVal = tset.first();
            tset.add(2 * curVal + 1);
            tset.add(3 * curVal + 1);
            tset.remove(curVal);
        }

        return tset.first();
    }

    public static void main(String[] args) {
        System.out.println(dblLinear(10));
        System.out.println(dblLinear(20));
        System.out.println(dblLinear(30));
        System.out.println(dblLinear(50));
    }
}
