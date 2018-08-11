import java.util.*;

class ResultComponents implements Comparable<ResultComponents> {
    public char USER; // =, 1, 2
    public int MAX_FREQUENCY;
    public char CHAR;

    public ResultComponents(char user, int maxFrequency, char char_) {
        USER = user;
        MAX_FREQUENCY = maxFrequency;
        CHAR = char_;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s:", USER));
        for (int i = 0; i < MAX_FREQUENCY; i++) {
            sb.append(CHAR);
        }
        return sb.toString();

    }

    @Override
    public int compareTo(ResultComponents resultComponents) {
        if (this.MAX_FREQUENCY < resultComponents.MAX_FREQUENCY) {
            return 1;
        } else if (this.MAX_FREQUENCY > resultComponents.MAX_FREQUENCY) {
            return -1;
        }

        // if not, then there's a tie. so we go to the next attribute
        if (this.USER < resultComponents.USER) {
            return -1;
        } else if (this.USER > resultComponents.USER) {
            return 1;
        }

        // next we check the character
        
        if (this.CHAR < resultComponents.CHAR) {
            return -1;
        } else if (this.CHAR > resultComponents.CHAR) {
            return 1;
        }

        return 0;

    }
}

public class Mix {
    // We can create another class to hold the components of the
    // desired string and then implement a comparator based on it
    // comparator order is: freq, user, character
    
    public static int[] getAsciiArray(String s) {
        int[] ascii = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isLetter(currentChar) && Character.isLowerCase(currentChar))
                ascii[currentChar - 97]++;
        }
        return ascii;
    }

    public static String mix(String s1, String s2) {
        if (s1.equals(s2)) return "";

        int[] s1A = getAsciiArray(s1);
        int[] s2A = getAsciiArray(s2);

        ArrayList<ResultComponents> objs = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (s1A[i] > 1 || s2A[i] > 1) {
                if (s1A[i] == s2A[i]) {
                    objs.add(new ResultComponents('=', s1A[i], (char) (i + 97)));
                } else if (s1A[i] > s2A[i]) {
                    objs.add(new ResultComponents('1', s1A[i], (char) (i + 97)));
                } else {
                    objs.add(new ResultComponents('2', s2A[i], (char) (i + 97)));
                }
            }
        }

        Collections.sort(objs);
        return objs.stream()
                .map(ResultComponents::toString)
                .reduce((prev, cur) -> prev + "/" + cur).get();
    }

    public static void main(String[] args) {
//        assertEquals("2:eeeee/2:yy/=:hh/=:rr", Mixing.mix("Are they here", "yes, they are here"))
        System.out.println(mix("Are they here", "yes, they are here"));
    }

}
