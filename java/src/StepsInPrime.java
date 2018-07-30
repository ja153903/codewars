import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.LongStream;

public class StepsInPrime {
    public static boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) { return true; }
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i+=2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static long[] step(int g, long m, long n) {
        if (m == n) { return null; }

        long[] arr = LongStream.rangeClosed(m, n)
                .filter(StepsInPrime::isPrime)
                .toArray();

        // Find the pairs of difference g
        ArrayList<long[]> pairs = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] - arr[i] == g) {
                    pairs.add(new long[]{ arr[i], arr[j] });
                }
            }
        }

        return pairs.size() > 0 ? pairs.get(0) : null;
    }

    public static void printArray(long[] res) {
        Arrays.stream(res).forEach(System.out::println);
    }

    public static void main(String[] args) {
        long[] res = step(2, 100, 110);
        long[] res2 = step(8, 300, 400);
//        long[] res3 = step(6, 100, 110);
//        long[] res4 = step(10, 300, 400);
        printArray(res2);
    }
}
