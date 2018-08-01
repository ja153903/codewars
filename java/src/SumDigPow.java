import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;

public class SumDigPow {
    public static boolean isDigPow(long num) {
        String n= String.valueOf(num);

        return IntStream.rangeClosed(0, n.length()-1)
                .mapToDouble(i -> Math.pow(Character.getNumericValue(n.charAt(i)), i+1))
                .sum() == num;

//        long total = 0;
//        for (int i = 0; i < n.length(); i++) {
//            total += (long) Math.pow(Character.getNumericValue(n.charAt(i)), i+1);
//        }
////        System.out.println(total);
////        System.out.println(num);
//        return total == num;
    }

    public static List<Long> sumDigPow(long a, long b) {
        return LongStream.rangeClosed(a, b)
                        .filter(SumDigPow::isDigPow)
                        .boxed()
                        .collect(Collectors.toList());

//        List<Long> arr = new ArrayList<>();
//        for (long num: l) {
//            arr.add(num);
//        }
//        return arr;
    }

    public static void main(String[] args) {
        List<Long> res = sumDigPow(1, 10);
        res.forEach(System.out::println);
    }
}
