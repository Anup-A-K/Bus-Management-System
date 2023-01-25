import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.border.EmptyBorder;

public class Customerlogin
{
    Customerlogin()
    {
        JFrame frame = new JFrame("Customer Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JPanel contentpane = new JPanel();
        contentpane.setBackground(new Color(204, 255, 255));
        contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentpane);
        contentpane.setLayout(null);


        // DECLARE COMPONENTS

        JLabel lblcustomerlogin = new JLabel("Customer Login");
        contentpane.add(lblcustomerlogin);
        JLabel lbusername = new JLabel("Username");
        contentpane.add(lbusername);
        JLabel lbpassword = new JLabel("Password");
        contentpane.add(lbpassword);
        JTextField tfusername = new JTextField();
        contentpane.add(tfusername);
        JPasswordField tfpassword = new JPasswordField();
        contentpane.add(tfpassword);
        JCheckBox chshowpass = new JCheckBox("show password");
        contentpane.add(chshowpass);
        JButton btlogin = new JButton("Login");
        btlogin.setBackground(new Color(0, 255, 64));
        contentpane.add(btlogin);
        JButton btcancel = new JButton("Cancel");
        btcancel.setBackground(new Color(255, 0, 0));
        contentpane.add(btcancel);
        JButton btback = new JButton("<- Back");
        btback.setBackground(new Color(192, 192, 192));
        contentpane.add(btback);
        JButton btsignup = new JButton("Sign up");
        btsignup.setBackground(new Color(192, 192, 192));
        contentpane.add(btsignup);


        // POSITIONING

        lblcustomerlogin.setHorizontalAlignment(SwingConstants.CENTER);
        lbusername.setHorizontalAlignment(SwingConstants.CENTER);
        lbpassword.setHorizontalAlignment(SwingConstants.CENTER);


        // SET BOUNDS

        lblcustomerlogin.setBounds(0, 18, 484, 75);
        lbusername.setBounds(10, 90, 114, 51);
        lbpassword.setBounds(10, 171, 114, 51);
        tfusername.setBounds(20, 135, 295, 25);
        tfpassword.setBounds(20, 219, 295, 25);
        chshowpass.setBounds(340, 226, 120, 17);
        btlogin.setBounds(20, 267, 99, 51);
        btcancel.setBounds(216, 267, 99, 51);
        btback.setBounds(395, 333, 79, 17);
        btsignup.setBounds(300, 333, 75, 17);


        // SET FONT

        lblcustomerlogin.setFont(new Font("Gadugi", Font.BOLD, 40));
        lbusername.setFont(new Font("Gadugi", Font.PLAIN, 20));
        lbpassword.setFont(new Font("Gadugi", Font.PLAIN, 20));
        tfusername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        chshowpass.setFont(new Font("Gadugi", Font.PLAIN, 12));
        btlogin.setFont(new Font("Gadugi", Font.BOLD, 15));
        btcancel.setFont(new Font("Gadugi", Font.BOLD, 15));
        btback.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btsignup.setFont(new Font("Tahoma", Font.PLAIN, 12));

        
        // SET BACKGROUND COLOR

        lblcustomerlogin.setBackground(new Color(204, 255, 255));
        lbusername.setBackground(new Color(204, 255, 255));
        lbpassword.setBackground(new Color(204, 255, 255));
        chshowpass.setBackground(new Color(204, 255, 255));
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 128, 128));
        panel.setBounds(0, 26, 484, 62);
        contentpane.add(panel);
        panel.setLayout(new GridLayout(1, 0, 0, 0));


        // ADD ACTION LISTENERS

        btback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new Index();
            }
        });
        btcancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                tfusername.setText("");
                tfpassword.setText("");
            }
        });
        chshowpass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(chshowpass.isSelected()){
                    tfpassword.setEchoChar((char)0);
                }
                else{
                    tfpassword.setEchoChar('*');
                }
            }
        });
        btsignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new Signup();
            }
        });
        btlogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String username = tfusername.getText();
                String password = tfpassword.getText();
                Sqlconnect connection = new Sqlconnect();
                Connection con = connection.connect();
                try{
                    Statement stmt = con.createStatement();
                    String query = "select * from customer where username = '"+username+"' and password = '"+password+"'";
                    ResultSet rs = stmt.executeQuery(query);
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Login successful");
                        frame.dispose();
                        new Customerpage(username);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                    }
                }
                catch(Exception e1){
                    System.out.println(e1);
                }
            }
        });
    }
    public static void main(String[] args)
    {
        new Customerlogin();
    }
}