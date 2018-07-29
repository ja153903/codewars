public class PlayingWithDigits {
    public static long digPow(int n, int p) {
        long total = 0;
        String nString = String.valueOf(n);

        for (int i = 0; i < nString.length(); i++, p++) {
            total += (long) Math.pow(Character.getNumericValue(nString.charAt(i)), p);
        }

        if (total % n == 0)
            return total / n;

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(digPow(89, 1));
        System.out.println(digPow(92, 1));
        System.out.println(digPow(46288, 3));
    }
}
