import java.util.Arrays;
import java.util.stream.IntStream;

public class SortTheOdd {
    public static int[] sortArray(int[] array) {
        int[] indices = IntStream.rangeClosed(0, array.length-1)
                .filter(index -> array[index] % 2 == 1)
                .toArray();

         int[] sortedValues = IntStream.rangeClosed(0, indices.length-1)
                 .map(index -> array[indices[index]])
                 .sorted()
                 .toArray();

         for (int i = 0; i < indices.length; i++) {
             array[indices[i]] = sortedValues[i];
         }

         return array;
    }

    public static void main(String[] args) {
        int[] array = new int[] {5, 3, 2, 8, 1, 4};
        Arrays.stream(sortArray(array)).forEach(System.out::println);
    }
}
