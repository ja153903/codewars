import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

// {1,1,1,1,1,1,1,1  ,0,0,0,0,0,0,0,0,  0,0,0,0,1,1,1,1,  1,0,1,0,1,0,1,0}
// {
public class DataReverse {
    public static int[] dataReverse(int[] data) {
        int[][] arr = new int[data.length / 8][8];
        for (int i = 0; i < data.length; i++) {
            arr[i / 8][i % 8] = data[i];
        }

        // reverse rows of multidimensional array
        for (int i = 0, j = arr.length-1; i < j; i++, j--) {
            int[] temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return Arrays.stream(arr).flatMapToInt(Arrays::stream).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0};
        Arrays.stream(dataReverse(nums)).forEach(el -> System.out.print(el + " "));
    }
}
