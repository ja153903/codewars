import java.util.*;
import java.util.stream.Collectors;

public class Josephus {
    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        // We want to continuously iterate through the list
        // one by one we want to put them in JP order
        LinkedHashSet<Integer> indices = new LinkedHashSet<>();
        int count = 1, index = 0, indexSize = 0;
        int itemSize = items.size();
        while (indexSize != itemSize) {
            int curIndex = index % itemSize;
            if (count == k && !indices.contains(curIndex)) {
                indices.add(curIndex); indexSize++;
                count = 1;
            } else if (!indices.contains(curIndex)) {
                count++;
            }
            index++;
        }

        return indices.stream()
                .map(i -> items.get(i))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        josephusPermutation(new ArrayList(Arrays.asList(new Object[]{1,2,3,4,5,6,7})), 3);
    }
}
