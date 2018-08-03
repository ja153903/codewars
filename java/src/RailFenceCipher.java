import java.util.*;

public class RailFenceCipher {
    public static String encode(String s, int n) {
        Map<Integer, StringBuilder> translationMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            translationMap.put(i, new StringBuilder());
        }

        for (int i = 0, count = 1, increase = 1; i < s.length(); i++) {
            translationMap.get(count - 1).append(s.charAt(i));

            if (increase == 1) {
                count++;
                if (count == n) {
                    increase--;
                }
            } else {
                count--;
                if (count == 1) {
                    increase++;
                }
            }
        }

        return translationMap.entrySet().stream()
                .map(entry -> entry.getValue().toString())
                .reduce("", (prev, cur) -> prev + cur);
    }

    public static Map<Integer, Integer> getLevelCountMap(String s, int n) {

        Map<Integer, Integer> levelCount = new TreeMap<>();

        for (int i = 0, count = 1, increase = 1; i < s.length(); i++) {
            levelCount.put(count - 1, levelCount.getOrDefault(count - 1, 0)+1);
            if (increase == 1) {
                count++;
                if (count == n) {
                    increase--;
                }
            } else {
                count--;
                if (count == 1) {
                    increase++;
                }
            }
        }

        return levelCount;
    }

    public static Map<Integer, LinkedList<String>> getDecodeMap(String s, int n, Map<Integer, Integer> levelCount) {

        Map<Integer, LinkedList<String>> decodeMap = new TreeMap<>();

        for (int i = 0, beginningIndex = 0, endIndex = 0; i < n; i++) {
            beginningIndex = endIndex;
            endIndex = beginningIndex + levelCount.get(i);
            String[] subStr = s.substring(beginningIndex, endIndex).split("");
            decodeMap.put(i, new LinkedList<>(Arrays.asList(subStr)));
        }

        return decodeMap;
    }

    public static String decode(String s, int n) {

        if (s.isEmpty()) {
            return "";
        }

        Map<Integer, Integer> levelCount = getLevelCountMap(s, n);
        Map<Integer, LinkedList<String>> decodeMap = getDecodeMap(s, n, levelCount);

        StringBuilder sb = new StringBuilder();

        for (int count = 1, increase = 1; sb.toString().length() < s.length();) {
            if (!decodeMap.get(count-1).isEmpty()) {
                sb.append(decodeMap.get(count-1).pollFirst());
            }

            if (increase == 1) {
                count++;
                if (count == n) {
                    increase--;
                }
            } else {
                count--;
                if (count == 1) {
                    increase++;
                }
            }
        }

        return sb.toString();
    }
}
