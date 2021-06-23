import javax.swing.*;
import javax.xml.stream.FactoryConfigurationError;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Blackjack {
    public JFrame frame;
    public JPanel panel;
    public JPanel panelGame;
    public JLabel tempImg;
    //public JButton stand;
    private String name;
    private int fonduriPlayer;
    private int betAmountInCash;
    private boolean betAccepted;
    private boolean gameOver = false;

    private CardHand PlayerHand,DealerHand;
    private CardDeck DeckOfCards;
    Blackjack(String name,int fonduriPlayer){

        this.name = name;
        this.fonduriPlayer = fonduriPlayer;

        //declarari de Frame
        frame = new JFrame();
        frame.setSize(1000,800);
        frame.setTitle("BlackJack");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //background color verde
        panel = new JPanel();
        panel.setBackground(new Color(0,153,0));

        frame.add(panel);

        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);

        //textul de welcome player
        JLabel welcomeText = new JLabel();
        welcomeText.setFont(new Font("Serif",Font.PLAIN,28));
        welcomeText.setForeground(Color.white);
        welcomeText.setText(welcomeText.getText() + " "+ "Welcome to Blackjack, " + this.name + "!");
        c.gridx = 0;
        c.gridy = 0;
        panel.add(welcomeText,c);


        //textul de please enter the amount to bet
        JLabel betAmount = new JLabel();
        betAmount.setFont(new Font("Serif",Font.PLAIN,16));
        betAmount.setForeground(Color.white);
        betAmount.setText(betAmount.getText() + "Your balance seems to be "+Integer.toString(fonduriPlayer) + "$.Please enter the amount you would like to bet: ");
        c.gridx = 0;
        c.gridy = 1;
        panel.add(betAmount,c);

        //textboxul de enter bet amount
        JTextField enterBetAmount = new JTextField(10);
        //incepe sa scrie din centru
        enterBetAmount.setHorizontalAlignment(JTextField.CENTER);
        //enterBetAmount.setSize();
        c.gridx = 0;
        c.gridy = 2;
        panel.add(enterBetAmount,c);

        //butonul de submit
        JButton enter = new JButton("Enter");
        c.gridx = 0;
        c.gridy = 3;
        panel.add(enter,c);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = enterBetAmount.getText();
                boolean validInt = false;
                try {
                    betAmountInCash = Integer.parseInt(input);
                    String message = "The bet of " + input + "$" + " was registered!";
                    //JOptionPane.showMessageDialog(null,message,"Bet Information",JOptionPane.INFORMATION_MESSAGE);
                    validInt = true;
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null,"Input Invalid","Bet Information",JOptionPane.INFORMATION_MESSAGE);
                }

                //verificam daca are fonduri jucatorul
                boolean gameOver = false;
                if(validInt == true){
                    if(betAmountInCash <= fonduriPlayer && betAmountInCash >= 0) {
                        betAccepted = true;
                        String message = "The bet of " + input + "$" + " was registered!";
                        JOptionPane.showMessageDialog(null, message, "Bet Information", JOptionPane.INFORMATION_MESSAGE);
                        //incepem jocul
                        StartGame();

                            DeckOfCards = new CardDeck();
                            DeckOfCards.shuffleDeck();
                            //shuffle la deck

                            //creem mainile jucatorilor
                            PlayerHand = new CardHand();
                            DealerHand = new CardHand();

                            //se primeste mana initiala
                            DealerHand.addCard(DeckOfCards.getCard());
                            //desenez manual ca sa am index pentru remove
                            tempImg = new JLabel();
                            String path ="C:\\Users\\Ciprian\\Desktop\\BlackJack\\src\\Images\\back.png";
                            tempImg.setIcon(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT)));
                            GridBagConstraints c = new GridBagConstraints();
                            c.gridx=0;
                            c.gridy=3;
                            panelGame.add(tempImg,c);

                            //drawCard("back", 0, "d");
                            PlayerHand.addCard(DeckOfCards.getCard());
                            drawCard(PlayerHand.ElementAtId(0).toString(), 0, "p");
                            DealerHand.addCard(DeckOfCards.getCard());
                            drawCard(DealerHand.ElementAtId(1).toString(), 1, "d");
                            PlayerHand.addCard(DeckOfCards.getCard());
                            drawCard(PlayerHand.ElementAtId(1).toString(), 1, "p");

                            /*
                            if(PlayerHand.sumHard() == 21){
                                JButton playAgain = new JButton("Play Again");
                                playAgain.setPreferredSize(new Dimension(160,40));
                                playAgain.setFont(new Font("Serif",Font.BOLD,18));
                                c.insets = new Insets(5,5,5,5);
                                c.gridx=0;
                                c.gridy=4;
                                c.gridwidth = 2;
                                panelGame.add(playAgain,c);
                                playAgain.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        frame.setVisible(false);
                                        Blackjack newGame = new Blackjack(name,fonduriPlayer);
                                    }
                                });
                            }

                             */




                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Not enough founds","Bet Information",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        JButton rules = new JButton("Game Rules");
        c.gridx=0;
        c.gridy=4;
        panel.add(rules,c);
        rules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ruleSet = " Regulile jocului de BlackJack: \n" +
                        "-The player attempts to beat the dealer by getting a count as close to 21 as possible, without going over 21.\n" +
                        "-It is up to each individual player if an ace is worth 1 or 11. Face cards are 10 and any other card is its pip value.\n"+
                        "-Before the deal begins, the player places a bet (2:1)\n"+
                        "-The player receives 2 cards while the dealer receives one card revealed and one card hidden\n"+
                        "-The player has to choose during his turn between hit(draw a card) or stand(pass the turn to the dealer)\n"+
                        "-The dealer turn: dealer reveals his card and draws untill he has a sum >= 17\n"+
                        "-The one with the closest sum to 21 wins the game/push if both have 21\n"+
                        "-In case of the player getting 21 from his 2 cards, the game ends instantly with a 3:1 bet\n";

                JOptionPane.showMessageDialog(null,ruleSet,"Game Rules",JOptionPane.INFORMATION_MESSAGE);

            }
        });





        frame.setVisible(true);

    }

    public void setBetAccepted(boolean betAccepted) {
        this.betAccepted = betAccepted;
    }

    public boolean isBetAccepted() {
        return betAccepted;
    }

    public int getBetAmountInCash() {
        return betAmountInCash;
    }

    public int getFonduriPlayer() {
        return fonduriPlayer;
    }

    public void StartGame(){
        //masa dupa ce se incepe jocul
        //e tot un fel de constructor
        panelGame = new JPanel();
        panelGame.setBackground(new Color(0,153,0));

        //remove panel de bet si adaugat panel al jocului
        frame.remove(panel);
        frame.add(panelGame);

        panelGame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);

        //text pentru Player Hand
        JLabel Player = new JLabel();
        Player.setFont(new Font("Serif",Font.PLAIN,42));
        Player.setForeground(Color.white);
        Player.setText(Player.getText() + " "+ "Player Hand: ");
        c.gridx=0;
        c.gridy=0;
        c.gridwidth = 2;
        panelGame.add(Player,c);

        JLabel Dealer = new JLabel();
        Dealer.setFont(new Font("Serif",Font.PLAIN,42));
        Dealer.setForeground(Color.white);
        Dealer.setText(Dealer.getText() + " "+ "Dealer Hand: ");
        c.gridx=0;
        c.gridy=2;
        c.gridwidth=2;
        panelGame.add(Dealer,c);

        //butonul de hit se afla pe nivelul cartilor playerului
        JButton hit = new JButton("Hit");
        hit.setPreferredSize(new Dimension(100,40));
        hit.setFont(new Font("Serif",Font.BOLD,18));
        c.gridx=10;
        c.gridy=1;
        panelGame.add(hit,c);

        JButton stand = new JButton("Stand");
        stand.setPreferredSize(new Dimension(100,40));
        stand.setFont(new Font("Serif",Font.BOLD,18));
        c.gridx=10;
        c.gridy=3;
        panelGame.add(stand,c);
        hit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PlayerHand.addCard(DeckOfCards.getCard());

                drawCard(PlayerHand.lastElement().toString(),PlayerHand.lastElementId(),"p");
                if(PlayerHand.sumHard() >21){
                    gameOver = true;
                    String message = "Dealer wins!You lost " + betAmountInCash + "$";
                    fonduriPlayer = fonduriPlayer - betAmountInCash;
                    //System.out.println(fonduriPlayer);
                    JOptionPane.showMessageDialog(null, message, "Game State", JOptionPane.INFORMATION_MESSAGE);
                    hit.setVisible(false);
                    stand.setVisible(false);

                    //play again
                    JButton playAgain = new JButton("Play Again");
                    playAgain.setPreferredSize(new Dimension(160,40));
                    playAgain.setFont(new Font("Serif",Font.BOLD,18));
                    c.insets = new Insets(5,5,5,5);
                    c.gridx=0;
                    c.gridy=4;
                    c.gridwidth = 2;
                    panelGame.add(playAgain,c);
                    playAgain.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame.setVisible(false);
                            Blackjack newGame = new Blackjack(name,fonduriPlayer);
                        }
                    });

                }

            }
        });

        //butonul de stand se afla pe nivelul cartilor playerului
        stand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stand.setVisible(false);
                hit.setVisible(false);
                //dealer hand
                panelGame.remove(tempImg);
                drawCard(DealerHand.ElementAtId(0).toString(),0,"d");
                while(DealerHand.sumHard() <17){
                    DealerHand.addCard(DeckOfCards.getCard());
                    drawCard(DealerHand.lastElement().toString(),DealerHand.lastElementId(),"d");

                }

                if(DealerHand.sumHard() > 21){
                    String message = "Player wins!You gained " + 2 *betAmountInCash + "$";
                    fonduriPlayer = fonduriPlayer + betAmountInCash; // teoretic 2* bet - bet
                    JOptionPane.showMessageDialog(null, message, "Game State", JOptionPane.INFORMATION_MESSAGE);
                    gameOver = true;
                }else {

                    if (DealerHand.sumHard() == PlayerHand.sumHard()) {
                        String message = "Push!";
                        JOptionPane.showMessageDialog(null, message, "Game State", JOptionPane.INFORMATION_MESSAGE);
                    } else if (DealerHand.sumHard() > PlayerHand.sumHard()) {
                        String message = "Dealer Wins!You lost " + betAmountInCash + "$";
                        fonduriPlayer = fonduriPlayer-betAmountInCash;
                        JOptionPane.showMessageDialog(null, message, "Game State", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        String message = "Player wins!You gained " + 2 * betAmountInCash + "$";
                        fonduriPlayer = fonduriPlayer+ betAmountInCash; //practic 2*bet - 1bet
                        JOptionPane.showMessageDialog(null, message, "Game State", JOptionPane.INFORMATION_MESSAGE);

                    }
                }
                //play again
                JButton playAgain = new JButton("Play Again");
                playAgain.setPreferredSize(new Dimension(160,40));
                playAgain.setFont(new Font("Serif",Font.BOLD,18));
                c.insets = new Insets(5,5,5,5);
                c.gridx=0;
                c.gridy=4;
                c.gridwidth = 2;
                panelGame.add(playAgain,c);
                frame.setVisible(true);
                playAgain.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                        Blackjack newGame = new Blackjack(name,fonduriPlayer);
                    }
                });
            }
        });

        frame.setVisible(true);
    }

    public void disableButtons(){
    }
    public void drawCard(String ImageName,int poz,String type){
        JLabel tempLabel = new JLabel();
        String path = "C:\\Users\\Ciprian\\Desktop\\BlackJack\\src\\Images\\" + ImageName + ".png";
        tempLabel.setIcon(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT)));

        GridBagConstraints c = new GridBagConstraints();
        //c.insets = new Insets(5,5,5,5);
        //pentru player y este 1
        if(type == "p")
        {c.gridy = 1;}
        else {
            //pentru Dealer y este 3
            c.gridy = 3;
        }
        c.gridx = poz;
        panelGame.add(tempLabel,c);
        frame.setVisible(true);


    }
}
