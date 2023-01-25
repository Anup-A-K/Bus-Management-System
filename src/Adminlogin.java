import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.border.EmptyBorder;

public class Adminlogin{
	Adminlogin()
	{
		JFrame frame = new JFrame("Admin Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 500, 400);
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JPanel contentpane = new JPanel();
        contentpane.setBackground(new Color(204, 255, 255));
        contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentpane);
        contentpane.setLayout(null);
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
        btback.setBackground(new Color(128, 128, 128));
        contentpane.add(btback);
        lbusername.setHorizontalAlignment(SwingConstants.CENTER);
        lbpassword.setHorizontalAlignment(SwingConstants.CENTER);
        lbusername.setBounds(10, 90, 114, 51);
        lbpassword.setBounds(10, 172, 114, 51);
        tfusername.setBounds(20, 135, 295, 25);
        tfpassword.setBounds(20, 219, 295, 25);
        chshowpass.setBounds(330, 226, 120, 17);
        btlogin.setBounds(20, 273, 114, 60);
        btcancel.setBounds(201, 273, 114, 60);
        btback.setBounds(395, 333, 79, 17);
        lbusername.setFont(new Font("Gadugi", Font.PLAIN, 20));
        lbpassword.setFont(new Font("Gadugi", Font.PLAIN, 20));
        tfusername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        chshowpass.setFont(new Font("Gadugi", Font.PLAIN, 12));
        btlogin.setFont(new Font("Tahoma", Font.BOLD, 15));
        btcancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        btback.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbusername.setBackground(new Color(204, 255, 255));
        lbpassword.setBackground(new Color(204, 255, 255));
        chshowpass.setBackground(new Color(204, 255, 255));
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(64, 128, 128));
        panel.setBounds(0, 19, 484, 60);
        contentpane.add(panel);
                panel.setLayout(new BorderLayout(0, 0));
        
        
                // DECLARE COMPONENT
        
                JLabel lbadminlogin = new JLabel("Admin Login");
                panel.add(lbadminlogin);
                
                
                        // POSITIONIN
                
                        lbadminlogin.setHorizontalAlignment(SwingConstants.CENTER);
                        
                        
                                // SET FONT
                        
                                lbadminlogin.setFont(new Font("Gadugi", Font.BOLD, 40));
                                

                                // SET BACKGROUND COLOR

                                lbadminlogin.setBackground(new Color(204, 255, 255));

		
        // ADD ACTION LISTENER

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
        btlogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String username = tfusername.getText();
                String password = tfpassword.getText();
                Sqlconnect sql = new Sqlconnect();
                Connection con = sql.connect();
                try{
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select * from admin where username='"+username+"' and password='"+password+"'");
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Login Success");
                        frame.dispose();
                        new Adminpage();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Login Failed");
                    }
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
    }

	public static void main(String[] args)
	{
		new Adminlogin();
    }
}