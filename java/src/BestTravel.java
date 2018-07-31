import java.util.*;

public class BestTravel {
    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        List<Integer> sums = new ArrayList<>();
        backtrack(t, k, ls, sums, 0, 0);
        return sums.size() > 0 ? Collections.max(sums) : null;
    }

    public static void backtrack(int t, int k, List<Integer> ls, List<Integer> sums, int sum, int start) {
        if (k == 0 &&  sum <= t) {
            sums.add(sum);
            return;
        } else {
            for (int i = start; i < ls.size(); i++) {
                sum += ls.get(i); k--;
                backtrack(t, k, ls, sums, sum, i+1);
                sum -= ls.get(i); k++;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        int n = chooseBestSum(163, 3, ts);
        System.out.println(n);
    }
}
