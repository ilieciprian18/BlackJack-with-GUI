import java.util.Vector;

public class CardHand {

    protected Vector<Card> CardHand;

    public CardHand(){
        this.CardHand = new Vector<>();
    }

    public void addCard(Card x){//adaugan carte
        this.CardHand.add(x);
    }

    public void AfisElementAtPosition(int intex){
        System.out.println();
    }

    public Card ElementAtId(int index){
        return this.CardHand.elementAt(index);
    }

    public Card lastElement(){
        return this.CardHand.lastElement();
    }

    public int lastElementId(){
        return this.CardHand.size()-1;
    }

    public int sumHard(){
        int sum = 0;
        int nrA = 0;
        //tinem minte nr de A
        //deoarece A este 1 sau 11
        for(int i=0;i<CardHand.size();i++){
            if( CardHand.elementAt(i).number.equals("Q") || CardHand.elementAt(i).number.equals("K") || CardHand.elementAt(i).number.equals("J"))
                sum = sum + 10;
            else if (CardHand.elementAt(i).number.equals("A")) {
                nrA++;
                sum = sum + 11;
            }
            else {
                sum = sum + Integer.parseInt(CardHand.elementAt(i).number);
            }
            }
        if(sum > 21)
            while(nrA > 0 && sum > 21)
            {
                sum = sum -10;
                nrA--;
            }


        return sum;
    }

    public void AfisHand(){
        for(int i=0;i<CardHand.size();i++)
            System.out.print(CardHand.elementAt(i) + " ");
        System.out.println();
    }
    @Override
    public String toString() {
        return  CardHand + " ";
    }
}
