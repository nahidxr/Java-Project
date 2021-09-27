import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class BillCreate extends JFrame {
    private Container c;
    private  Font font,font2;
    private  JLabel imageLabel, pName,l1,l2,l3,l4,l5,l6,l7,date,orderlist;
    private  JPanel heading;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    private JTextArea ta;
    private JButton b1,b2,back,total,save;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private String[] colums={"Quantity", "Product Name","Price","Discount"};
    private String[] rows=new String[4];
    private String []cbstr={"","10","20","30","40"};



    BillCreate(){

        initComponent();

    }

    private void initComponent() {

        c=this.getContentPane();
        // c.setBackground(Color.white);
        c.setLayout(null);
        font=new Font("courier",Font.BOLD,35);
        font2=new Font("courier",Font.BOLD,16);



        heading=new JPanel();
        heading.setBackground(new Color(51,5,50,248));
        heading.setBounds(0,0,1200,60);


        pName=new JLabel("BILL");
        pName.setFont(font);
        pName.setForeground(Color.white);
        pName.setBounds(200,25,450,50);


        l1 =new JLabel("Bill Id ");
        l1.setBounds(100,130,200,30);
        l1.setFont(font2);
        l2=new JLabel("Customer Name ");
        l2.setBounds(100,180,200,30);
        l2.setFont(font2);
        l3=new JLabel("Product Id");
        l3.setBounds(100,230,200,30);
        l3.setFont(font2);
        l4=new JLabel("Product Name");
        l4.setBounds(100,280,200,30);
        l4.setFont(font2);
        l5=new JLabel("Quantity ");
        l5.setBounds(100,330,200,30);
        l5.setFont(font2);
        l6=new JLabel("Price  ");
        l6.setBounds(100,380,100,30);
        l6.setFont(font2);
        l7=new JLabel("Discount  ");
        l7.setBounds(100,430,100,30);
        l7.setFont(font2);
        date=new JLabel("Date");
        date.setFont(font2);
        date.setBounds(600,130,100,30);
        date.setFont(font2);
        orderlist=new JLabel("Ordered Item List");
        orderlist.setFont(font);
        orderlist.setBounds(650,200,400,30);


        t1=new JTextField();
        t1.setBounds(310,130,150,30);
        t2=new JTextField();
        t2.setBounds(310,180,150,30);
        t3=new JTextField();
        t3.setBounds(310,230,150,30);
        t4=new JTextField();
        t4.setBounds(310,280,150,30);
        t5=new JTextField();
        t5.setBounds(310,330,150,30);
        t6=new JTextField();
        t6.setBounds(310,380,150,30);
        t9=new JTextField();
        t9.setBounds(310,430,150,30);

        t7=new JTextField("5/5/2019");
        t7.setBounds(690,130,100,30);
        t8=new JTextField();
        t8.setBounds(730,550,200,40);

        b1=new JButton("Add New");
        b1.setBounds(100,530,110,40);


        b2=new JButton("Genrate Bill");
        b2.setBounds(230,530,110,40);

        back=new JButton("Back");
        back.setBounds(370,530,110,40);
        total=new JButton(" Grand Totall");
        total.setBounds(600,550,110,40);
        save=new JButton("SAVE");
        save.setBounds(950,550,110,40);






        table=new JTable();
        model=new DefaultTableModel();
        model.setColumnIdentifiers(colums);
        table.setModel(model);
        //table.setFont(font2);
        table.setSelectionBackground(Color.green);
        table.setBackground(Color.white);
        table.setRowHeight(30);

        scroll=new JScrollPane(table);
        scroll.setBounds(600,250,500,250);
        //scroll.setBackground(Color.red);


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {





                try {
                    FileWriter fw = new FileWriter("files/bill.txt", true);
                    BufferedWriter writer = new BufferedWriter(fw);

                    writer.write(t1.getText());
                    writer.write(" ");
                    writer.write(t2.getText());;
                    writer.write(" ");
                    writer.write(t3.getText());;
                    writer.write(" ");
                    writer.write(t4.getText());
                    writer.write(" ");
                    writer.write(t5.getText());
                    writer.write(" ");
                    writer.write(t6.getText());
                    writer.write(" ");
                    writer.write(t9.getText());
                    writer.newLine();
                    writer.close();

                }catch (IOException ex){
                    System.out.println("Unable to open file");
                }




                int a=Integer.parseInt(t9.getText());
                int b=Integer.parseInt(t6.getText());
                double result=(a*b)/100;
                String s=Double.toString(result);

            if(e.getSource()==b1) {
                rows[0] = t5.getText();
                rows[1] = t4.getText();
                rows[2] = t6.getText();
                rows[3] = s;
                model.addRow(rows);
            }


              //  t1.setText("");
               // t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t9.setText("");

            }



        });




        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            JOptionPane.showMessageDialog(null,"Bill genrated");


            }
        });

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




        total.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               try {
                    FileReader fr = new FileReader("files/bill.txt");
                    BufferedReader reader = new BufferedReader(fr);

                    String line,str;

                  double sum=0.0;
                  double discnt=0.0;
                  double prc=0.0;

                    while((line = reader.readLine()) != null){
                        String [] sa = line.split(" ");

                        int bill=Integer.parseInt(sa[0]);
                        //String cname=sa[1];
                      //  int p_id=Integer.parseInt(sa[2]);
                      //  String pname=sa[3];
                      //  int quantity=Integer.parseInt(sa[4]);
                        double price =Double.parseDouble(sa[5]);
                        System.out.println(price);
                        double discount=Double.parseDouble(sa[6]);

                        discnt=(discount*price)/100;
                        prc=price-discnt;


                         sum=sum+prc;

                    }

                   str = Double.toString(sum);
                   System.out.println(str);
                   t8.setText(str);


                    reader.close();
                }catch (IOException ex){
                    System.out.println("Unable to open file");
                }


            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fw = new FileWriter("Files/cbill.txt", true);
                    BufferedWriter writer = new BufferedWriter(fw);

                    writer.write(t1.getText());
                    writer.write(" ");
                    writer.write(t2.getText());
                    writer.write(" ");
                    writer.write(t8.getText());
                    writer.write(" ");
                    writer.write(t7.getText());
                    writer.newLine();

                    writer.close();

                }catch (IOException ex){
                    System.out.println("Unable to open file");
                }

            }
        });





        heading.add(pName);
        c.add(heading);
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        c.add(l6);
        c.add(date);
        c.add(back);
        c.add(t1);
        c.add(t2);
        c.add(t3);
        c.add(t4);
        c.add(t5);
        c.add(t6);
        c.add(t7);
        c.add(b1);
        c.add(b2);
        c.add(total);
        c.add(t8);
        c.add(orderlist);
        c.add(back);
        c.add(t9);
        c.add(l7);
        c.add(scroll);
        c.add(save);

        c.setVisible(true);


    }

    public static void main(String[] args) {

        BillCreate frame=new BillCreate();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,30,1200,700);
        frame.setTitle("Bill");
        frame.setResizable(false);

    }
}
