import java.util.*;

public class Scrambles {
    public static boolean scramble(String str1, String str2) {
        // Create a map of the second string
        // decrement when looping through str1 if character is found
        // expect the hashmap to be empty if true
        // else false
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            char cur = str2.charAt(i);
            if (!counter.containsKey(cur)) {
                counter.put(cur, 1);
            } else {
                counter.put(cur, counter.get(cur) + 1);
            }
        }

        for (int i = 0; i < str1.length(); i++) {
            char cur = str1.charAt(i);
            if (counter.containsKey(cur) && counter.get(cur) > 0) {
                counter.put(cur, counter.get(cur) - 1);
            }
        }

        int total = 0;
        for (int n: counter.values()) { total += n; }

        return total == 0;
    }

    public static void main(String[] args) {
        System.out.println(scramble("rkqodlw", "world"));
        System.out.println(scramble("cedewaraaossoqqyt","codewars"));
    }
}
