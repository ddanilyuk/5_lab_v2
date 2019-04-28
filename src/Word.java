import java.util.Arrays;

public class Word extends SentenceMember {
    private Letter[] letters;
    private static Letter[] lettersEdited;
    private static String[] lettersEdited_v2;
    public static String lettersToString;


    public Word(String s) {

        int j = 1;
        int h = 1;
        int for_none = -1;
        char[] chars = s.toCharArray();
        letters = new Letter[s.length()];

        for (int i = 0; i < chars.length; i++) {
            letters[i] = new Letter(chars[i]);
        }

        String temp = letters[0].toString().toLowerCase();
        Letter temp_2 = letters[0];

        for (int i = 0; i < chars.length; i++) {
            if (temp.equals(letters[i].toString().toLowerCase())) {
                for_none += 1;
            }
        }
        lettersEdited = new Letter[s.length() - for_none];
        lettersEdited_v2 = new String[s.length() - for_none];

        lettersEdited[0] = temp_2;
        lettersEdited_v2[0] = temp_2.toString();

        for (int i = 0; i < chars.length; i++) {
            if (!temp.equals(letters[i].toString().toLowerCase())) {
                lettersEdited[j] = letters[i];
                j += 1;
            }
            if (!temp.equals(letters[i].toString().toLowerCase())) {
                lettersEdited_v2[h] = letters[i].toString();
                h += 1;
            }
        }

        //TO TRY SOME
        //System.out.println(Arrays.toString(letters));
        //System.out.println(Arrays.toString(lettersEdited_v2));
    }


    public static String getLettersEdited() {
        lettersToString = "";
        for (Letter letter : lettersEdited) {
            lettersToString += letter.toString();
        }
        return lettersToString;
    }


    public static String[] getLettersEdited_v2() {
        return lettersEdited_v2;
    }


    @Override
    public String toString() {
        String result = "";
        for (Letter letter : letters) {
            result += letter.toString();
        }
        return result;
    }
}
