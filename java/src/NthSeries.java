import java.text.DecimalFormat;
import java.util.stream.DoubleStream;

public class NthSeries {
    public static String seriesSum(int n) {
       double res = DoubleStream.iterate(1, i -> i + 3.0)
                .limit(n)
                .reduce(0, (prev, cur) -> prev + (1 / cur));

       DecimalFormat df = new DecimalFormat("0.00");

        return df.format(res);
    }

    public static void main(String[] args) {
        System.out.println(seriesSum(3));
    }
}
