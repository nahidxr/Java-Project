import javax.swing.*;
import java.awt.*;

public class  CashierLogin extends JFrame {

    private Container c;
    private JLabel imageLabel,pName,userName,password;
    private ImageIcon img;
    private JPanel heading,loginPanel;
    private Font font;
    private JTextField tf1;
    private JPasswordField pf;
    private JButton button1;


    CashierLogin(){
        initComponent();

    }

    private void initComponent() {
        c=this.getContentPane();
        //c.setBackground(Color.CYAN);
        c.setLayout(null);
        font=new Font("courier",Font.BOLD,30);

        img=new ImageIcon(getClass().getResource("1.jpg"));
        imageLabel=new JLabel(img);
        imageLabel.setBounds(0,0,650,550);

        heading=new JPanel();
        heading.setBackground(new Color(175,0,42,80));
        heading.setBounds(0,0,650,50);


        pName=new JLabel("LOGIN CASHIER");
        pName.setFont(font);
        //pName.setForeground(Color.black);
        pName.setBounds(200,25,450,50);

        loginPanel=new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setSize(400,300);
        loginPanel.setBounds(140,150,350,250);
        loginPanel.setBackground(new Color(0,0,0,80));

        // userName=new JLabel("Username");
        tf1=new JTextField("Enter your Username");
        pf=new JPasswordField("Enter your Password");

        tf1.setBounds(50,50,250,40);
        // tf1.setBackground(new Color(204,255,247,50));
        pf.setBounds(50,110,250,40);
        // pf.setBackground(new Color(255,255,247,50));

        button1=new JButton("Login");
        //  button2=new JButton("SignUp");
        button1.setBounds(120,180,100,30);
        // button2.setBounds(190,180,100,30);




        heading.add(pName);
        imageLabel.add(heading);
        imageLabel.add(loginPanel);
        loginPanel.add(tf1);
        loginPanel.add(pf);
        loginPanel.add(button1);
        //loginPanel.add(button2);
        c.add(imageLabel);





        setVisible(true);




    }

    public static void main(String[] args) {

        CashierLogin frame= new  CashierLogin();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(350,100,650,550);
        frame.setTitle("Login");
        frame.setResizable(false);

    }


}
