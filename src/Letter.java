public class Letter {
    private char symbol;

    public Letter(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol + "";
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
}