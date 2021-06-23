import java.util.Scanner;

public class MainBlackJack {
    public static void main(String[] args) {
        boolean gameOver = false;
        String playerName = "Ciprian";
        int playerBalance = 2900;
        while (gameOver == false) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Va rugam sa introduceti bet-ul:");
            int ValBet = scanner.nextInt();

                System.out.println("--New Game--");
                CardDeck DeckOfCards = new CardDeck();
                DeckOfCards.shuffleDeck();
                //shuffle la deck

                CardHand PlayerHand = new CardHand();
                CardHand DealerHand = new CardHand();

                DealerHand.addCard(DeckOfCards.getCard());
                PlayerHand.addCard(DeckOfCards.getCard());
                DealerHand.addCard(DeckOfCards.getCard());
                PlayerHand.addCard(DeckOfCards.getCard());
                //System.out.println(PlayerHand);
                //System.out.println(DealerHand);
                System.out.println("Dealer Hard:" + "X " + DealerHand.ElementAtId(1));
                System.out.print("Player Hand:");
                PlayerHand.AfisHand();
                int option = 1;
                //player turn
                System.out.println("--player turn--");
                while (option != 0) {
                    System.out.println("0:Stand");
                    System.out.println("1:Hit");

                    option = scanner.nextInt();
                    if (option == 1) {
                        PlayerHand.addCard(DeckOfCards.getCard());
                    }
                    System.out.println("Dealer Hard:" + "X " + DealerHand.ElementAtId(1));
                    System.out.print("Player Hand:");
                    PlayerHand.AfisHand();
                    // System.out.println(PlayerHand.sumHard());
                    if (PlayerHand.sumHard() > 21) {
                        System.out.println("Dealer Wins!You lost " + ValBet + "$");
                        gameOver = true;
                        break;
                    }
                }
                //dealer turn
                if (gameOver == true)
                    break;
                //reveal la cartile dealerului
                //apoi trage carti dealerul
                System.out.println("--dealer turn--");
                System.out.print("Dealer Hand:");
                DealerHand.AfisHand();
                System.out.print("Player Hand:");
                PlayerHand.AfisHand();
                while (DealerHand.sumHard() < 17) {
                    DealerHand.addCard(DeckOfCards.getCard());
                    System.out.println("Dealer draws ...");
                    System.out.print("Dealer Hand:");
                    DealerHand.AfisHand();
                    System.out.print("Player Hand:");
                    PlayerHand.AfisHand();
                }

                // System.out.println(DealerHand);

                if (DealerHand.sumHard() > 21) {
                    System.out.println("Player Wins!You gained " + ValBet * 2 + "$");
                    gameOver = true;
                    break;
                }

                if (DealerHand.sumHard() == PlayerHand.sumHard())
                    System.out.println("Push!");
                else if (DealerHand.sumHard() > PlayerHand.sumHard())
                    System.out.println("Dealer Wins!You lost " + ValBet + "$");
                else System.out.println("Player Wins!You gained " + ValBet * 2 + "$");
                gameOver = true;


            }
        }
    }


