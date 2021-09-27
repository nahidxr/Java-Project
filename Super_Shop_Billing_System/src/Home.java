import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    private Container c;
    private  Font font;
    private  ImageIcon image;
    private JLabel imageLabel, pName;
    private  JPanel heading;
    private JButton b1,b2;


    Home(){

        initialComponent();
    }

    private void initialComponent() {
        c=this.getContentPane();
        //c.setBackground(Color.CYAN);
        c.setLayout(null);
        font=new Font("courier",Font.BOLD,30);

        image=new ImageIcon(getClass().getResource("home.jpg"));
        imageLabel=new JLabel(image);
        imageLabel.setBounds(0,0,800,600);
        //imageLabel.setBounds(10,10,image.getIconWidth(),image.getIconHeight());

        heading=new JPanel();
        heading.setBackground(new Color(51,255,51,80));
        heading.setBounds(0,0,800,50);

        pName=new JLabel("Welcome To My Super Market ");
        pName.setFont(font);
        //pName.setForeground(Color.black);
        pName.setBounds(200,25,450,50);
        b1=new JButton("ADMIN LOGIN");
        b2=new JButton("CASHIER LOGIN");
        b1.setBounds(550,300,150,60);
        b2.setBounds(550,400,150,60);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminLogin frame= new AdminLogin();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(350,100,650,550);
                frame.setTitle("Login");
                frame.setResizable(false);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                CashierLogin frame= new  CashierLogin();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(350,100,650,550);
                frame.setTitle("Login");
                frame.setResizable(false);
            }
        });



         heading.add(pName);
         imageLabel.add(heading);
         imageLabel.add(b1);
         imageLabel.add(b2);
         c.add(imageLabel);

         c.setVisible(true);


    }

    public static void main(String[] args) {
        Home frame=new Home();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(350,90,800,600);
        frame.setTitle("HOME");
        frame.setResizable(false);

    }
}
