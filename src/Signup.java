import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;
import javax.swing.border.EmptyBorder;

public class Signup{
    Signup()
    {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 450, 650);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        JPanel contentpane = new JPanel();
        contentpane.setBackground(new Color(204, 255, 255));
        contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentpane);
        contentpane.setLayout(null);

        //DECLARE COMPONENTS

        JLabel lbsignup = new JLabel("Signup");
        lbsignup.setHorizontalAlignment(SwingConstants.CENTER);
        contentpane.add(lbsignup);
        JLabel lbfname = new JLabel("First Name");
        contentpane.add(lbfname);
        JLabel lblname = new JLabel("Last Name");
        contentpane.add(lblname);
		JLabel lbgender = new JLabel("Gender");
        contentpane.add(lbgender);
        String[] genderoptions = {"Male", "Female","Other"};
		JComboBox<String> gendercombobox = new JComboBox<>(genderoptions);
        contentpane.add(gendercombobox);
        JLabel lbphone = new JLabel("Phone");
        contentpane.add(lbphone);
        JLabel lbemail = new JLabel("Email");
        contentpane.add(lbemail);
        JLabel lbaddress = new JLabel("Address");
        contentpane.add(lbaddress);
		JLabel lbstate = new JLabel("State");
        contentpane.add(lbstate);
        JLabel lbcity = new JLabel("City");
        contentpane.add(lbcity);
		JLabel lbpass = new JLabel("Password");
        contentpane.add(lbpass);
		JLabel lbconfirmpass = new JLabel("Confirm password");
        contentpane.add(lbconfirmpass);
        JLabel lbusername = new JLabel("Username");
        contentpane.add(lbusername);
        JTextField tffname = new JTextField();
        contentpane.add(tffname);
        JTextField tflname = new JTextField();
        contentpane.add(tflname);
        JTextField tfphone = new JTextField();
        contentpane.add(tfphone);
        JTextField tfemail = new JTextField();
        contentpane.add(tfemail);
        JTextField tfaddress = new JTextField();
        contentpane.add(tfaddress);
        JTextField tfstate = new JTextField();
        contentpane.add(tfstate);
        JTextField tfusername = new JTextField();
        contentpane.add(tfusername);
        JTextField tfcity = new JTextField();
        contentpane.add(tfcity);
        JPasswordField tfpassword = new JPasswordField();
        contentpane.add(tfpassword);
        JPasswordField tfconfirmpassword = new JPasswordField();
        contentpane.add(tfconfirmpassword);
        JCheckBox cbshowpass = new JCheckBox("showpass");
        contentpane.add(cbshowpass);
        JCheckBox cbterms = new JCheckBox("I agree to the terms and conditions");
        contentpane.add(cbterms);
        JButton btsignup = new JButton("Signup");
        contentpane.add(btsignup);
        JButton btcancel = new JButton("Cancel");
        contentpane.add(btcancel);
        JButton btuser = new JButton("already have an account? Login");
        contentpane.add(btuser);
        JTextField tfgender = new JTextField();
        contentpane.add(tfgender);

        //SET BOUNDS

        lbsignup.setBounds(0, 11, 434, 54);
		lbfname.setBounds(36, 93, 84, 14);
        tffname.setBounds(37, 111, 166, 20);
		lblname.setBounds(213, 93, 110, 14);
        tflname.setBounds(213, 111, 180, 20);
        lbusername.setBounds(36, 150, 110, 14);
        tfusername.setBounds(36, 165, 167, 20);
        lbgender.setBounds(36, 200, 110, 14);
        // tfgender.setBounds(80, 190, 250, 20);
        gendercombobox.setBounds(37, 216, 165, 20);
        lbphone.setBounds(213, 150, 110, 14);
        tfphone.setBounds(213, 165, 180, 20);
        lbemail.setBounds(213, 200, 110, 14);
        tfemail.setBounds(213, 215, 180, 20);
        lbaddress.setBounds(36, 256, 110, 14);
        tfaddress.setBounds(36, 271, 357, 20);
        lbstate.setBounds(36, 302, 110, 14);
        tfstate.setBounds(36, 321, 167, 20);
        lbcity.setBounds(213, 302, 110, 14);
        tfcity.setBounds(213, 321, 180, 20);
        lbpass.setBounds(36, 355, 110, 14);
        tfpassword.setBounds(36, 374, 357, 20);
        lbconfirmpass.setBounds(36, 405, 110, 14);
        tfconfirmpassword.setBounds(36, 420, 357, 20);
        cbshowpass.setBounds(36, 449, 110, 14);
        cbterms.setBounds(155, 449, 357, 14);
        btsignup.setBounds(36, 488, 94, 48);
        btcancel.setBounds(213, 488, 94, 48);
        btuser.setBounds(36, 558, 180, 23);



        //SET FONT

        lbsignup.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lbfname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbgender.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbaddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbstate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbcity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbpass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbconfirmpass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbphone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbemail.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btuser.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lbusername.setFont(new Font("Tahoma", Font.PLAIN, 13));

        //SET BACKGROUND
        
        cbshowpass.setBackground(new Color(204, 255, 255));
        cbterms.setBackground(new Color(204, 255, 255));
		// gendercombobox.setBackground(new Color(204, 255, 255));
        btcancel.setBackground(new Color(255, 0, 0));
        btsignup.setBackground(new Color(128, 255, 0));
        btuser.setBackground(new Color(255, 0, 0));
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 128));
        panel.setBounds(0, 11, 434, 54);
        contentpane.add(panel);
        panel.setLayout(null);

        //SET EVENT LISTENER

        cbshowpass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cbshowpass.isSelected()) {
                    tfpassword.setEchoChar((char) 0);
                    tfconfirmpassword.setEchoChar((char) 0);
                } else {
                    tfpassword.setEchoChar('*');
                    tfconfirmpassword.setEchoChar('*');
                }
            }
        });
        btsignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!cbterms.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please agree to the terms and conditions");
                }
                else if(!tfpassword.getText().equals(tfconfirmpassword.getText())) {
                    JOptionPane.showMessageDialog(null, "Password not matched");
                }
                else {
                    String fname = tffname.getText();
                    String lname = tflname.getText();
                    String gender = (String)gendercombobox.getSelectedItem();
                    int phone = Integer.parseInt(tfphone.getText());
                    String email = tfemail.getText();
                    String address = tfaddress.getText();
                    String state = tfstate.getText();
                    String city = tfcity.getText();
                    String password = tfpassword.getText();
                    String username = tfusername.getText();
                    String cnfpassword = tfconfirmpassword.getText();
                    Sqlconnect sql = new Sqlconnect();
                    Connection con = sql.connect();
                    try {
                        String query = "select * from customer where username = '"+username+"'";
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(query);
                        if(rs.next())
                        {
                            String user = rs.getString("username");
                            if(user.equals(username))
                            {
                                JOptionPane.showMessageDialog(null, "Username already exists");
                            }
                        }
                        else
                        {
                            PreparedStatement ps = con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?,?,?)");
                            ps.setString(1, fname);
                            ps.setString(2, lname);
                            ps.setString(3, username);
                            ps.setString(4, gender);
                            ps.setInt(5, phone);
                            ps.setString(6, email);
                            ps.setString(7, address);
                            ps.setString(8, state);
                            ps.setString(9, city);
                            ps.setString(10, password);
                            ps.setString(11, cnfpassword);
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Account created successfully");
                            frame.dispose();
                            new Customerlogin();
                        }

                    }
                    catch(Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        btuser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Customerlogin();
            }
        });
        btcancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tffname.setText("");
                tflname.setText("");
                tfphone.setText("");
                tfemail.setText("");
                tfaddress.setText("");
                tfstate.setText("");
                tfcity.setText("");
                tfpassword.setText("");
                tfconfirmpassword.setText("");
                gendercombobox.setSelectedIndex(0);
                cbterms.setSelected(false);
                cbshowpass.setSelected(false);
            }
        });
    }
    public static void main(String[] args) {
        new Signup();
    }
}