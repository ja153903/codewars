public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int resultHours = 0, resultMinutes = 0, resultSeconds = 0;

        if ((resultHours = seconds / 3600) > 0) {
            seconds %= 3600;
        }

        if ((resultMinutes = seconds / 60) > 0) {
            seconds %= 60;
        }

        resultSeconds = seconds;

        String[] s = new String[]{
          String.valueOf(resultHours),
          String.valueOf(resultMinutes),
          String.valueOf(resultSeconds)
        };

        // if length of the string is 1, then append 0 to the front of the string
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() == 1) {
                s[i] = "0" + s[i];
            }
        }

        return String.join(":", s);
    }

    public static String bestPractice(int seconds) {
        return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
    }

    public static void main(String[] args) {
        System.out.println(makeReadable(0));
        System.out.println(makeReadable(5));
        System.out.println(makeReadable(60));
        System.out.println(makeReadable(86399));
        System.out.println(makeReadable(359999));

        System.out.println(bestPractice(0));
        System.out.println(bestPractice(5));
        System.out.println(bestPractice(60));
        System.out.println(bestPractice(86399));
        System.out.println(bestPractice(359999));
    }
}
