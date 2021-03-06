import java.util.Arrays;

public class Text {
    private Sentence[] sentences;
    private static String[] sentencesEdited;
    private static String[][][] sentencesEdited_v2;


    public Text(String s) {
        String[] split = s.split("(?<=[?!.]) ");
        sentences = new Sentence[split.length];
        sentencesEdited = new String[split.length];
        sentencesEdited_v2 = new String[split.length][][];

        for (int i = 0; i < split.length; i++) {
            sentences[i] = new Sentence(split[i]);
            sentencesEdited[i] = Sentence.getSentenceMembersEdited();
            sentencesEdited_v2[i] = Sentence.getSentenceMembersEdited_v2();
        }
    }


    public static void getSentencesEdited() {
        String result = "";
        for (String some : sentencesEdited) {
            result += some;
        }

        System.out.println(result);
    }


    public static void getSentencesEdited_v2() {

        for (String[][] some : sentencesEdited_v2) {
            for (int i = 0; i < some.length; i++) {
                String[] some_2 = some[i];

                for (String some_3 : some_2) {
                    System.out.print(some_3);
                }
                if (i != some.length - 2) {
                    System.out.print(" ");
                }
            }
        }
    }


    @Override
    public String toString() {
        String result = "";
        for (Sentence sentence : sentences) {
            result += sentence.toString() + " ";
        }
        return result;
    }
}
