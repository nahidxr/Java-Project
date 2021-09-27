import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Product_Available extends JFrame {

    private Container c;
    private JPanel heading;
    private JLabel pName,c_id;
    private JTextField tf;
    private JButton b1,b2,back;
    private Font font;
    private JTextArea ta;


    ////////////////////////
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private String[] colums={"Product Id", "Product Name","Available","Price","Company"};
    private String[] rows=new String[5];

    Product_Available (){

        initComponent();



    }

    private void initComponent() {

        c=this.getContentPane();
        c.setLayout(null);
        font=new Font("courier",Font.BOLD,25);

        heading=new JPanel();
        heading.setBackground(new Color(51, 5, 50, 248));
        heading.setBounds(0,0,650,50);

        pName=new JLabel("BILL SEARCH ");
        pName.setFont(font);
        pName.setForeground(Color.white);
        pName.setBounds(100,25,450,50);

        c_id=new JLabel("Product ID");
        c_id.setFont(font);
        c_id.setBounds(20,115,200,50);

        tf=new JTextField();
        tf.setBounds(210,120,200,40);

        b1=new JButton("Search");
        b1.setBounds(470,120,100,40);

        back=new JButton("Back");
        back.setBounds(170,470,100,40);

        b2 =new JButton("clear");
        b2.setBounds(330,470,100,40);



        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                BillMenu frame=new BillMenu();

                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(100,30,1000,700);
                frame.setTitle("Bill");
                frame.setResizable(false);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText("");


            }
        });

        // ta=new JTextArea();
        //  ta.setBounds(100,200,400,250);
        ///////////////table/////////////////////

        table=new JTable();
        model=new DefaultTableModel();
        model.setColumnIdentifiers(colums);
        table.setModel(model);
        //table.setFont(font2);
        table.setSelectionBackground(Color.green);
        table.setBackground(Color.white);
        table.setRowHeight(30);

        scroll=new JScrollPane(table);
        scroll.setBounds(70,200,500,200);




        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String bill_id=tf.getText();

                try {
                    FileReader fr = new FileReader("files/cbill.txt");
                    BufferedReader reader = new BufferedReader(fr);

                    String line;

                    // String maxCgpaName = "";
                    // double maxCgpa = 0.0;
                    boolean flag=false;

                    while((line = reader.readLine()) != null){
                        String [] sa = line.split(" ");
                        String b_id = sa[0];
                        String customer_name = sa[1];
                        String  amount= sa[2];
                        String  date= sa[3];


                        if(bill_id.equals(b_id)){

                            rows[0] = b_id;
                            rows[1] = customer_name;
                            rows[2] = amount;
                            rows[3] = date;
                            model.addRow(rows);
                            flag=true;
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
        // c.add(ta);
        c.add(b2);
        c.add(back);
        c.add(heading);
        c.add(scroll);


    }

    public static void main(String[] args) {
        Product_Available frame=new Product_Available();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(350,80,650,600);
        frame.setTitle("Product Search");
        frame.setResizable(false);
    }
}
