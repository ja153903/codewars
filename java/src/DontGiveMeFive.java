import java.util.stream.IntStream;

public class DontGiveMeFive {
    public int dontGiveMeFive(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (!Integer.toString(i).contains("5")) count++;
        }
        return count;
    }
    public int streamSolution(int start, int end) {
        return (int) IntStream.rangeClosed(start, end)
                .filter(x -> !Integer.toString(x).contains("5"))
                .count();
    }
}
