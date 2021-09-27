import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProductDetails extends JFrame {
    private Container c;
    private  Font font,font2;
    private ImageIcon img;
    private  JLabel imageLabel, pName,l1,l2,l3,l4,l5,l6;
    private  JPanel heading;
    private JTextField t1,t2,t3,t4,t5,t6;
    private JTextArea ta;
    private JButton b1,b2,b3,b4,back;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private String[] colums={"product Id", "product Name","Quantity","Price","Company","Dealer"};
    private String[] rows=new String[6];



    ProductDetails(){

        initComponent();

    }

    private void initComponent() {

        c=this.getContentPane();
        // c.setBackground(Color.white);
        c.setLayout(null);
        font=new Font("courier",Font.BOLD,20);
        font2=new Font("courier",Font.BOLD,16);


        heading=new JPanel();
        heading.setBackground(new Color(0, 102, 204, 80));
        heading.setBounds(0,0,1200,50);


        pName=new JLabel("Product DETAILS");
        pName.setFont(font);
        //pName.setForeground(Color.black);
        pName.setBounds(200,30,450,50);

        l1 =new JLabel("product Id ");
        l1.setBounds(100,100,200,30);
        l1.setFont(font2);
        l2=new JLabel("product Name ");
        l2.setBounds(100,150,200,30);
        l2.setFont(font2);
        l3=new JLabel("Quantity");
        l3.setBounds(100,200,200,30);
        l3.setFont(font2);
        l4=new JLabel("Price ");
        l4.setBounds(100,250,200,30);
        l4.setFont(font2);
        l5=new JLabel("Company");
        l5.setBounds(100,300,200,30);
        l5.setFont(font2);
        l6=new JLabel("Dealer ");
        l6.setBounds(100,350,100,30);
        l6.setFont(font2);

        t1=new JTextField();
        t1.setBounds(310,100,200,30);
        t2=new JTextField();
        t2.setBounds(310,150,200,30);
        t3=new JTextField();
        t3.setBounds(310,200,200,30);
        t4=new JTextField();
        t4.setBounds(310,250,200,30);
        t5=new JTextField();
        t5.setBounds(310,300,200,30);
        t6=new JTextField();
        t6.setBounds(310,350,200,30);
        //  ta=new JTextArea();
        // ta.setBounds(350,100,200,30);

        b1=new JButton("Add New");
        b1.setBounds(100,500,110,40);
        b2=new JButton("Update");
        b2.setBounds(230,500,110,40);
        b3=new JButton("Delete");
        b3.setBounds(360,500,110,40);


        b4=new JButton("clear");
        b4.setBounds(490,500,110,40);
        back=new JButton("Back");
        back.setBounds(620,500,110,40);



        table=new JTable();
        model=new DefaultTableModel();
        model.setColumnIdentifiers(colums);
        table.setModel(model);
        //table.setFont(font2);
        table.setSelectionBackground(Color.green);
        table.setBackground(Color.white);
        table.setRowHeight(30);

        scroll=new JScrollPane(table);
        scroll.setBounds(600,100,500,350);
        //scroll.setBackground(Color.red);


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(e.getSource()==b1) {

                    rows[0] = t1.getText();
                    rows[1] = t2.getText();
                    rows[2] = t3.getText();
                    rows[3] = t4.getText();
                    rows[4] = t5.getText();
                    rows[5] = t6.getText();
                    model.addRow(rows);
                }
                ///////////////new code for file////////


                try {
                    FileWriter fw = new FileWriter("files/productDetails.txt", true);
                    BufferedWriter writer = new BufferedWriter(fw);

                    writer.write("Product_id: " + t1.getText());
                    writer.write(" ");
                    writer.write("Product_Name: " + t2.getText());
                    writer.write(" ");
                    writer.write("Quantity: " + t3.getText());
                    writer.write(" ");
                    writer.write(" Price: " + t4.getText());
                    writer.write(" ");
                    writer.write("Company: " + t5.getText());
                    writer.write(" ");
                    writer.write("Dealer: " + t6.getText());
                    writer.newLine();
                    writer.close();

                }catch (IOException ex){
                    System.out.println("Unable to open file");
                }


            }



        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==b4){

                    t1.setText(" ");
                    t2.setText(" ");
                    t3.setText(" ");
                    t4.setText(" ");
                    t5.setText(" ");
                    t6.setText(" ");

                }
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==b3){

                    int nOfValue=table.getSelectedRow();

                    if(nOfValue>=0) {
                        model.removeRow(nOfValue);
                    }
                    else{

                        JOptionPane.showMessageDialog(null,"NO Row has been selected ..!!");
                    }

                }
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                int nOfvalue=table.getSelectedRow();

                String c_Id=model.getValueAt(nOfvalue,0).toString();
                String c_Name=model.getValueAt(nOfvalue,1).toString();
                String c_Mobile=model.getValueAt(nOfvalue,2).toString();
                String c_add=model.getValueAt(nOfvalue,3).toString();
                String c_email=model.getValueAt(nOfvalue,4).toString();
                String c_pass=model.getValueAt(nOfvalue,5).toString();

                t1.setText(c_Id);
                t2.setText(c_Name);
                t3.setText(c_Mobile);
                t4.setText(c_add);
                t5.setText(c_email);
                t6.setText(c_pass);

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==b2){

                    int nOfValue=table.getSelectedRow();
                    String c_id=t1.getText();
                    String c_name=t2.getText();
                    String c_mobile=t3.getText();
                    String c_add=t4.getText();
                    String c_email=t5.getText();
                    String c_pass=t6.getText();

                    model.setValueAt(c_id,nOfValue,0);
                    model.setValueAt(c_name,nOfValue,1);
                    model.setValueAt(c_mobile,nOfValue,2);
                    model.setValueAt(c_add,nOfValue,3);
                    model.setValueAt(c_email,nOfValue,4);
                    model.setValueAt(c_pass,nOfValue,5);



                }
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





        heading.add(pName);
        c.add(heading);
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        c.add(l6);
        c.add(t1);
        c.add(t2);
        c.add(t3);
        c.add(t4);
        c.add(t5);
        c.add(t6);
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(b4);
        c.add(back);
        c.add(scroll);


        c.setVisible(true);


    }

    public static void main(String[] args) {

        ProductDetails frame=new ProductDetails();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150,30,1200,700);
        frame.setTitle("Cashier Details");
        frame.setResizable(false);

    }
}
