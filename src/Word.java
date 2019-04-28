import java.util.Arrays;

public class Word extends SentenceMember {
    private Letter[] letters;
    private static Letter[] lettersEdited;
    private static String[] lettersEdited_v2;
    public static String ret;


    public Word(String s) {
        int j = 1;
        int h = 1;
        int for_none = -1;
        char[] chars = s.toCharArray();
        letters = new Letter[s.length()];


        for (int i = 0; i < chars.length; i++) {
            letters[i] = new Letter(chars[i]);
        }

        String temp = letters[0].toString();
        Letter temp_2 = letters[0];

        for (int i = 0; i < chars.length; i++) {
            if (temp.equals(letters[i].toString())) {
                for_none += 1;
            }
        }
        lettersEdited = new Letter[s.length() - for_none];
        lettersEdited_v2 = new String[s.length() - for_none];

        lettersEdited[0] = temp_2;
        lettersEdited_v2[0] = temp;
        for (int i = 0; i < chars.length; i++) {
            if (!temp.equals(letters[i].toString())) {
                // TODO: 2019-04-27 edit equals
                lettersEdited[j] = letters[i];

                j += 1;
            }
            if (!temp.equals(letters[i].toString())) {
                lettersEdited_v2[h] = letters[i].toString();
                h += 1;
            }

        }

    }

    public static String getLettersEdited() {
        ret = "";
        for (Letter letter:lettersEdited) {
            ret += letter.toString();
        }
        return ret;
    }

    public static String[] getLettersEdited_v2() {
        return lettersEdited_v2;
    }


    /*
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Letter) {
            return Character.toLowerCase(((Letter) obj).symbol) == Character.toLowerCase(symbol);
        }
        return false;
    }
    */

    @Override
    public String toString() {
        String result = "";
        for (Letter letter : letters) {
            result += letter.toString();
        }
        return result;
    }


    public int getLength() {
        return letters.length;
    }
}
