public class Main {
    public static void main(String[] args) {

        System.out.println("BEFORE : ");
        String text_1 = "HellhHHho is lulcky. I am leaderlol. It is successful Some words without el as as lf!";
        System.out.println(text_1);


        System.out.println("AFTER : ");
        Text enter = new Text(text_1);
        Text.getSentencesEdited();
        System.out.print("");
        Text.getSentencesEdited_v2();
    }
}
