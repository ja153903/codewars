import java.util.Arrays;
import java.util.Comparator;

public class WeightForWeight {
    public static int weight(String s) {
        return s.chars()
                .map(i -> Character.getNumericValue(i))
                .sum();
    }
    public static String orderedWeight(String strng) {
        return Arrays.stream(strng.split(" "))
                .sorted(Comparator.comparingInt(WeightForWeight::weight)
                        .thenComparing(String::compareTo))
                .reduce((prev, cur) -> prev + " " + cur).get();
    }
}
