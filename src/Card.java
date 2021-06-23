public class Card {
    protected String symbol;
    protected String number;

    public Card(String symbol, String number) {
        this.symbol = symbol;
        this.number = number;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getNumber() {
        return number;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number + symbol;
    }
}
