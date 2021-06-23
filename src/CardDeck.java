import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class CardDeck {

    protected Vector<Card> CardDeck;

    public CardDeck(){
        String[] symbols = {"♠","♣","♥","♦"};
        String[] numbers = {"2","3","4","5","6","7","8","9","10","A","J","Q","K"};
        this.CardDeck = new Vector<>();
        for(int i = 0;i< numbers.length;i++)
            for(int j=0;j<symbols.length;j++)
            {
            Card temp = new Card(symbols[j],numbers[i]);
           // System.out.println(temp);
            this.CardDeck.add(temp);
            //System.out.println(CardDeck);
            }
    }

    public Card getCard(){
        // alegem o carte si o eliminam din pachet
        Random random = new Random();
        int index = random.nextInt(CardDeck.size());
        Card temp = CardDeck.elementAt(index);
        CardDeck.removeElementAt(index);
        return temp;
    }

    public void shuffleDeck(){
        Collections.shuffle(this.CardDeck);
    }
    @Override
    public String toString() {
        return  CardDeck + " ";
    }
}
