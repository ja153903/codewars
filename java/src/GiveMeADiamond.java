public class GiveMeADiamond {
    public static String print(int n) {
        StringBuffer sb = new StringBuffer();
        int offset = n / 2;
        int forward = 1;
        int backward = n-2;

        if (n % 2 == 0 || n < 0) return null;


        while (offset >= 0) {
            for (int i = offset; i > 0; i--) {
                sb.append(" ");
            }
            for (int i = 0; i < forward; i++) {
                sb.append("*");
            }

            sb.append("\n");

            offset--;
            forward += 2;
        }

        offset = 0;

        while (offset < n / 2) {
            for (int i = 0; i <= offset; i++) {
                sb.append(" ");
            }
            for (int i = 0; i < backward; i++) {
                sb.append("*");
            }

            sb.append("\n");

            offset++;
            backward -= 2;
        }

        return sb.toString();
    }


}
