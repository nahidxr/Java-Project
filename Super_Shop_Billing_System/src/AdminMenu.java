import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends JFrame {

    private Container c;
    private JMenuBar mb;
    private JMenu cashierdetails,productdetails,transaction,sales;
    private JMenuItem cashierinfo,search_cashier,productinfo,search_product;





    AdminMenu(){

        initComponent();
    }

    private void initComponent() {
        c=this.getContentPane();
        c.setLayout(null);

        mb=new JMenuBar();
        this.setJMenuBar(mb);

        cashierdetails=new JMenu("Cashier");
        productdetails=new JMenu("Product");
        transaction=new JMenu("Transaction");
        sales=new JMenu("Sales");
        cashierinfo=new JMenuItem("Cashier Info");
        search_cashier=new JMenuItem("Search Cashier");
        productinfo=new JMenuItem("Product Info");
        search_product=new JMenuItem("Search Product");

        cashierdetails.add(cashierinfo);
        cashierdetails.add(search_cashier);
        productdetails.add(productinfo);
        productdetails.add(search_product);


        cashierinfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

                CasheirDetails frame=new CasheirDetails();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(150,30,1200,700);
                frame.setTitle("Cashier Details");
                frame.setResizable(false);
            }
        });

        search_cashier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Search_cashier frame=new Search_cashier();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(350,80,650,600);
                frame.setTitle("Search");
                frame.setResizable(false);
            }
        });

        productinfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                ProductDetails frame=new ProductDetails();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(150,30,1200,700);
                frame.setTitle("Cashier Details");
                frame.setResizable(false);
            }
        });

        mb.add(cashierdetails);
        mb.add(productdetails);
        mb.add(transaction);
        mb.add(sales);

        c.add(mb);
        c.setVisible(true);



    }


    public static void main(String[] args) {
        AdminMenu frame= new AdminMenu ();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200,20,900,700);
        frame.setTitle("Admin Menu");
        frame.setResizable(false);
    }
}
