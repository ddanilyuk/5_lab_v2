import java.util.Arrays;

public class Sentence extends Object {
    private static String punctuationSymbols = ",.!?;";
    private SentenceMember[] sentenceMembers;

    private static String[] sentenceMembersEdited;
    private static String[][] sentenceMembersEdited_v2;

    public static String sentencesToString;
    public String[] addPunctuation;

    public Sentence(String s) {
        String[] split = s.split("(?=,|\\.|!|\\?)|\\s");
        sentenceMembers = new SentenceMember[split.length];
        sentenceMembersEdited = new String[split.length];
        sentenceMembersEdited_v2 = new String[split.length][];

        addPunctuation = new String[1];

        for (int i = 0; i < split.length; i++) {
            if (punctuationSymbols.contains(split[i])) {
                sentenceMembers[i] = new Punctuation(split[i]);

                addPunctuation[0] = split[i];

                sentenceMembersEdited[i] = split[i];
                sentenceMembersEdited_v2[i] = addPunctuation;
            } else {
                sentenceMembers[i] = new Word(split[i]);

                sentenceMembersEdited[i] = Word.getLettersEdited();
                sentenceMembersEdited_v2[i] = Word.getLettersEdited_v2();
            }
        }
    }


    public static String getSentenceMembersEdited() {
        sentencesToString = "";
        for (int i = 0; i < sentenceMembersEdited.length; i++) {
            String sentence = sentenceMembersEdited[i];
            sentencesToString += sentence;
            if (i != sentenceMembersEdited.length - 2){
                sentencesToString += " ";
            }
        }
        return sentencesToString;
    }


    public static String[][] getSentenceMembersEdited_v2() {
        return sentenceMembersEdited_v2;
    }


    @Override
    public String toString() {
        String result = "";
        SentenceMember currentSentenceMember;
        for (int i = 0; i < sentenceMembers.length; i++) {
            currentSentenceMember = sentenceMembers[i];
            result += (currentSentenceMember instanceof Word && i != 0 ? " " : "") + sentenceMembers[i].toString();
        }
        return result;
    }
}
