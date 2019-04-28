import java.util.Arrays;

public class Sentence extends Object {
    private static String punctuationSymbols = ",.!?;";
    private SentenceMember[] sentenceMembers;
    private static String[] sentenceMembersEdited;
    private static String[][] sentenceMembersEdited_v2;
    public static String sent;
    public String[] some_pun;

    public Sentence(String s) {
        String[] split = s.split("(?=,|\\.|!|\\?)|\\s");
        sentenceMembers = new SentenceMember[split.length];
        sentenceMembersEdited = new String[split.length];
        sentenceMembersEdited_v2 = new String[split.length][];

        some_pun = new String[1];


        for (int i = 0; i < split.length; i++) {
            if (punctuationSymbols.contains(split[i])) {
                sentenceMembers[i] = new Punctuation(split[i]);

                some_pun[0] = split[i];

                sentenceMembersEdited[i] = split[i];
                sentenceMembersEdited_v2[i] = some_pun;
            } else {
                sentenceMembers[i] = new Word(split[i]);
                sentenceMembersEdited[i] = Word.getLettersEdited();
                sentenceMembersEdited_v2[i] = Word.getLettersEdited_v2();
            }
        }


    }

    public static String getSentenceMembersEdited() {
        sent = "";
        for (int i = 0; i < sentenceMembersEdited.length; i++) {
            String sentence = sentenceMembersEdited[i];
            sent += sentence;
            if (i != sentenceMembersEdited.length - 2){
                sent += " ";
            }
        }
        return sent;
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


    public static void printClass(SentenceMember sentenceMember) {
        if (sentenceMember instanceof Word) {
            System.out.println("It is Word.");
        } else {
            if (sentenceMember instanceof Punctuation) {
                System.out.println("It is Punctuation.");
            } else {
                System.out.println("It is unknown class.");
            }
        }
    }

    public boolean isQuestion() {
        /*if () {
            return true;
        }
        return false; */
        int indexLastElement = sentenceMembers.length - 1;
        SentenceMember sentenceMember = sentenceMembers[indexLastElement];
        Punctuation punctuation = (Punctuation) sentenceMember;
        boolean result = punctuation.isQuestion();
        return result;
    }

    public String getWordsWithLength(int wordLength) {
        String result = "";

        for (SentenceMember sentenceMember : sentenceMembers) {
            if (sentenceMember instanceof Word) {
                if (((Word) sentenceMember).getLength() == wordLength) {
                    result += sentenceMember.toString() + " ";
                }
            }
        }
        return result;
    }
}