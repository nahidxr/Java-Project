import javax.swing.*;
import java.awt.*;

public class Bill extends  JFrame{

    private Container c;
    private Font font;
    private JPanel heading;
    private JLabel pName;

    Bill(){

        initComponent();
    }

    private void initComponent() {

        c=this.getContentPane();
        c.setLayout(null);

        font=new Font("courier",Font.BOLD,40);



        heading=new JPanel();
        heading.setBackground(new Color(51,5,50,248));
        heading.setBounds(0,0,1200,60);


        pName=new JLabel("BILL");
        pName.setFont(font);
        pName.setForeground(Color.white);
        pName.setBounds(200,25,450,50);



        heading.add(pName);
        c.add(heading);

    }

    public static void main(String[] args) {
       Bill frame=new Bill();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,30,1200,700);
        frame.setTitle("Cashier Details");
        frame.setResizable(false);
    }
}
