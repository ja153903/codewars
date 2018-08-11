public class Mumbling {
    public static String accum(String s) {
        String[] sArr = s.split("");
        // at index i, we want i+1 copies of the same string
        String[] result = new String[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            String str = sArr[i].toLowerCase();
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < i+1; j++) {
                if (j == 0) {
                    temp.append(str.toUpperCase());
                } else {
                    temp.append(str);
                }
            }
            result[i] = temp.toString();
        }

        return String.join("-", result);
    }

    public static void main(String[] args) {
        System.out.println(accum("abcd"));
    }
}
