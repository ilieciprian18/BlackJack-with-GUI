import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    private int count =0;
    private Button b1,b2;
    private Label label2;

    public GUI(){
        this.setSize(1000,800);
        this.setTitle("BlackJack");
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton hit,stand,b1,b2;

        JPanel panel = new JPanel();
        //JPanel jp2 = new JPanel();
        panel.setBackground(new Color(0,153,0));
        //background GUI

        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);
        // margine intre elemente

        JLabel PlayerHand = new JLabel();
        PlayerHand.setFont(new Font("Serif",Font.PLAIN,28));
        PlayerHand.setForeground(Color.white);
        PlayerHand.setText(PlayerHand.getText() + " "+ "Player's Hand:");
        c.gridy = 0;
        c.gridx = 0;
        panel.add(PlayerHand,c);

        /*
        hit = new JButton("Hit");
        c.gridx = 0;
        c.gridy = 0;
        panel.add(hit,c);

        stand = new JButton("Stand");
        c.gridx = 1;
        c.gridy = 0;
        panel.add(stand,c);

        b3 = new JButton("b3");
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(b3,c);
        b3.setVisible(true);
        */
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("C:\\Users\\Ciprian\\Desktop\\Untitled.png"));
        c.gridy=1;
        c.gridx=0;
        panel.add(label,c);

        b1 = new JButton("Hit");
        b2 = new JButton("Stand");
        int nr=0;
        b1.addActionListener(this);
        b2.addActionListener(this);
        panel.add(b1);
        panel.add(b2);

        JLabel label2 = new JLabel();
        label2.setText(PlayerHand.getText() + " "+ count);
        panel.add(label2);


        JPanel uga = new JPanel();
        //JOptionPane.showMessageDialog(null,"A winner","Score",JOptionPane.INFORMATION_MESSAGE);
        this.add(panel);
        this.add(uga);
        this.add(panel);
        validate();
    }



    public void paintComponent(Graphics g){
        super.paintComponents(g);
        ImageIcon img = new ImageIcon("Images\\sunset.png");
        img.paintIcon(this,g,1,1);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1) {
            count++;
            label2.setText(Integer.toString(count));
        }


        if(e.getSource() == b2)
            System.out.println("uga");
    }
}
