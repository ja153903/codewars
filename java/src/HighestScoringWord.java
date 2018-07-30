import java.util.Arrays;
import java.util.Comparator;

public class HighestScoringWord {
    // char - 97
    private static int getScore(String s) {
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            score += s.charAt(i) - 96;
        }
        return score;
    }

    public static String high(String s) {
        String[] arr = s.split(" ");

        int maxScore = Arrays.stream(arr)
                .mapToInt(HighestScoringWord::getScore)
                .max().getAsInt();

        // if there is more than one max score, then
        // get the earliest one

        return (String) Arrays.stream(arr)
                .filter(el -> getScore(el) == maxScore)
                .toArray()[0];
    }

    public static String effHigh(String s) {
        return Arrays.stream(s.split(" "))
                .max(Comparator.comparingInt(
                        a -> a.chars().map(i -> i - 96).sum()
                )).get();
    }

    public static void main(String[] args) {
        String s = "nlmwukzl ssxdfalyv";
        System.out.println(high(s));
    }
}
