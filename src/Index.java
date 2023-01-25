import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class Index{
	public Index()
	{
            JFrame frame = new JFrame("Login Menu");
            frame.setBounds(100, 100, 500, 400);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            
            JPanel contentpane = new JPanel();
            contentpane.setBackground(new Color(204, 255, 255));
            contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
            frame.setContentPane(contentpane);
            contentpane.setLayout(null);
            frame.setVisible(true);
            
            JButton btcustomerlogin = new JButton("Customer login");
            contentpane.add(btcustomerlogin);
            btcustomerlogin.setBounds(155, 250, 180, 68);
            btcustomerlogin.setBackground(new Color(255, 255, 128));
            btcustomerlogin.setFont(new Font("Gadugi", Font.BOLD, 20));
            
            JButton btadminlogin = new JButton("Admin Login");
            contentpane.add(btadminlogin);
            btadminlogin.setBackground(new Color(128, 255, 128));
            btadminlogin.setBounds(155, 132, 180, 68);
            btadminlogin.setFont(new Font("Gadugi", Font.BOLD, 20));
           
            
            JLabel txtrLogin = new JLabel("Login");
            txtrLogin.setHorizontalAlignment(SwingConstants.CENTER);
            contentpane.add(txtrLogin);
            txtrLogin.setBackground(new Color(0, 128, 192));
            txtrLogin.setFont(new Font("Gadugi", Font.BOLD, 40));
            txtrLogin.setBounds(0, 22, 484, 57);

            
            JLabel txtrLoginAsAdmin = new JLabel("Login as Admin :");
            contentpane.add(txtrLoginAsAdmin);
            txtrLoginAsAdmin.setBackground(new Color(204, 255, 255));
            txtrLoginAsAdmin.setFont(new Font("Gadugi", Font.BOLD, 15));
            txtrLoginAsAdmin.setBounds(50, 101, 127, 32);

            
            JLabel txtrLoginAsCustomer = new JLabel("Login as Customer :");
            contentpane.add(txtrLoginAsCustomer);
            txtrLoginAsCustomer.setFont(new Font("Gadugi", Font.BOLD, 15));
            txtrLoginAsCustomer.setBackground(new Color(204, 255, 255));
            txtrLoginAsCustomer.setBounds(50, 218, 143, 32);


            // SET ACTION LISTENER

            btadminlogin.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                        new Adminlogin();
                        frame.dispose();
                  }
            });
            btcustomerlogin.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                        new Customerlogin();
                        frame.dispose();
                  }
            });
	}
	public static void main(String[] args)
	{
		new Index();
	}
}