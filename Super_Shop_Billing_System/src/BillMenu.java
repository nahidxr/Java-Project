import javax.swing.*;
import java.awt.*;

public class BillMenu extends JFrame {
    private Container c;
    private JMenuBar mb;
    private JMenu bill,billSearch,product,sales,help;

    BillMenu(){

        inititComponent();
    }

    private void inititComponent() {
        c=this.getContentPane();
        c.setLayout(null);

        mb=new JMenuBar();
        this.setJMenuBar(mb);

        bill=new JMenu("BILL Crate");
        billSearch=new JMenu("BILL Search");
        product=new JMenu("Product Search");
        sales=new JMenu("Sales");
        help=new JMenu("Help");

        mb.add(bill);
        mb.add(billSearch);
        mb.add(product);
        mb.add(sales);
        mb.add(help);
        c.add(mb);





    }

    public static void main(String[] args) {
        BillMenu frame=new BillMenu();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,30,1000,700);
        frame.setTitle("Bill");
        frame.setResizable(false);
    }
}
