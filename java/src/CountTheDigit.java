import java.util.stream.IntStream;

public class CountTheDigit {
    private static int findNum(String s, char d) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == d) counter++;
        }
        return counter;
    }

    public static int nDig(int n, int d) {
        return IntStream.rangeClosed(0, n)
                .map(x -> x * x)
                .filter(x -> String.valueOf(x).contains(String.valueOf(d)))
                .map(x -> findNum(String.valueOf(x), Character.forDigit(d, 10)))
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(nDig(25, 1));
        System.out.println(nDig(10, 1));
        System.out.println(nDig(5750, 0));
    }
}
