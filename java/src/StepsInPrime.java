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

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] - arr[i] == g) {
                return new long[]{ arr[i], arr[i+1]};
            }
        }

        return null;
    }

    public static void printArray(long[] res) {
        Arrays.stream(res).forEach(System.out::println);
    }

    public static void main(String[] args) {
         long[] res = step(2, 100, 110);
        long[] res2 = step(8, 300, 400);
        long[] res3 = step(6, 100, 110);
        long[] res4 = step(10, 300, 400);
//        System.out.println(Arrays.toString(res2));
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res2));
        System.out.println(res3);
        System.out.println(Arrays.toString(res4));
    }
}
