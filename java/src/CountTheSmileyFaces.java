import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountTheSmileyFaces {
    private static final Set<Character> VALID_FACES = new HashSet<Character>() {{
        add(':');
        add(';');
    }};

    private static final Set<Character> VALID_NOSES = new HashSet<Character>() {{
       add('-');
       add('~');
    }};

    private static final Set<Character> VALID_MOUTHS = new HashSet<Character>() {{
       add(')');
       add('D');
    }};

    public static boolean validFace(String face) {
        int faceLength = face.length();

        if (faceLength < 2 || faceLength > 3) return false;

        if (!VALID_FACES.contains(face.charAt(0))) return false;

        if (faceLength == 2) {
            return VALID_MOUTHS.contains(face.charAt(1));
        }

        if (!VALID_NOSES.contains(face.charAt(1))) return false;

        return VALID_MOUTHS.contains(face.charAt(2));
    }
    public static int countSmileys(List<String> sarr) {
        return (int) sarr.stream()
                .filter(smiley -> validFace(smiley))
                .count();
    }
}
