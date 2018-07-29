import java.util.Arrays;
import java.util.stream.IntStream;

public class SortTheOdd {
    public static int[] sortArray(int[] array) {
        int[] sortedValues = Arrays.stream(array)
                .filter(element -> element % 2 == 1)
                .sorted()
                .toArray();

         for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                array[i] = sortedValues[j++];
            }
         }

         return array;
    }

    public static void main(String[] args) {
        int[] array = new int[] {5, 3, 2, 8, 1, 4};
        Arrays.stream(sortArray(array)).forEach(System.out::println);
    }
}
