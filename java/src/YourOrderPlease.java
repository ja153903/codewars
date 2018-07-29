import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class YourOrderPlease {
    public static int hashKey(String s) {
        return Integer.valueOf(s.replaceAll("[^0-9]", ""));
    }

    public static String order(String words) {
        if (words.equals("")) return words;
        String[] wordArr = words.split(" ");
        Map<Integer, String> map = new TreeMap<>();
        for (String word : wordArr) {
            map.put(hashKey(word), word);
        }
        return String.join(" ", map.values());
    }

    public static String streamSolution(String words) {
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("[^0-9]", ""))))
                .reduce((a, b) -> a + " " + b).get();
    }

    public static void main(String[] args) {
        String s = "is2 Thi1s T4est 3a";
        System.out.println(order(s));
    }
}
