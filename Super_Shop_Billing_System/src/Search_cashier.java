import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Search_cashier extends JFrame {

    private Container c;
    private JPanel heading;
    private JLabel pName,c_id;
    private JTextField tf;
    private JButton b1,b2,back;
    private Font font;
    private JTextArea ta;

    Search_cashier (){

        initComponent();



    }

    private void initComponent() {

        c=this.getContentPane();
        c.setLayout(null);
        font=new Font("courier",Font.BOLD,25);

        heading=new JPanel();
        heading.setBackground(new Color(51, 5, 50, 248));
        heading.setBounds(0,0,650,50);

        pName=new JLabel("Search Cashier ");
        pName.setFont(font);
        pName.setForeground(Color.white);
        pName.setBounds(100,25,450,50);

        c_id=new JLabel("Cashier ID");
        c_id.setFont(font);
        c_id.setBounds(20,115,200,50);

        tf=new JTextField();
        tf.setBounds(210,120,200,40);
        b1=new JButton("Search");

        b1.setBounds(470,120,100,40);
        back=new JButton("Back");
        back.setBounds(170,470,100,40);
        b2 =new JButton("Clear");
        b2.setBounds(330,470,100,40);




        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminMenu frame= new AdminMenu ();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(200,20,900,700);
                frame.setTitle("Admin Menu");
                frame.setResizable(false);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText(" ");
                ta.setText(" ");
            }
        });

        ta=new JTextArea();
        ta.setBounds(100,200,400,250);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cashier_id=tf.getText();

                try {
                    FileReader fr = new FileReader("files/cashierinfo.txt");
                    BufferedReader reader = new BufferedReader(fr);

                    String line;

                   // String maxCgpaName = "";
                   // double maxCgpa = 0.0;
                    boolean flag=false;

                    while((line = reader.readLine()) != null){
                        String [] sa = line.split(" ");
                        String c_id = sa[0];
                        String c_name = sa[1];
                        String  c_number= sa[2];
                        String  c_add= sa[3];
                        String  c_email= sa[4];
                        String  c_pass= sa[5];


                        if(cashier_id.equals(c_id)){

                            flag=true;
                            ta.append("Cashier id :"+c_id +"  "+ "Name :"+c_name+ "   "+"Mobile No :"+c_number+"  "+"Address :"+c_add+ "\n");
                            break;

                        }

                    }

                    if(!flag){

                        JOptionPane.showMessageDialog(null,"Empty");
                    }


                    reader.close();
                }catch (IOException ex){
                    System.out.println("Unable to open file");
                }
            }
        });


        heading.add(pName);
        c.add(c_id);
        c.add(tf);
        c.add(b1);
        c.add(ta);
        c.add(b2);
        c.add(back);
        c.add(heading);


    }

    public static void main(String[] args) {
        Search_cashier frame=new Search_cashier();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(350,80,650,600);
        frame.setTitle("Search");
        frame.setResizable(false);
    }
}
