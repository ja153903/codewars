import java.util.stream.DoubleStream;

public class Magnets {

    public static double v(int k, int n) {
        return 1. / (k * Math.pow(n + 1, 2 *k));
    }

    public static double doubles(int maxk, int maxn) {
        double total = 0;
        for (int i = 1; i <= maxk; i++) {
            double subtotal = 0;
            for (int j = 1; j <= maxn; j++) {
                subtotal += v(i, j);
            }
            total += subtotal;
        }

        return total;
    }

    public static double S(int maxk, int maxn) {
        return DoubleStream.iterate(1, x -> x + 1)
                .limit(maxk)
                .map(x -> u((int) x, maxn))
                .sum();
    }

    public static double u(int k, int maxn) {
        return DoubleStream.iterate(1, x -> x +1)
                .limit(maxn)
                .map(x -> v(k, (int) x))
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(doubles(1, 10));
        System.out.println(S(1, 10));
    }
}
