import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Users{
    Users()
    {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 1000, 700);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        JPanel contentpane = new JPanel();
        contentpane.setBackground(new Color(204, 255, 255));
        contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentpane);
        contentpane.setLayout(null);


        // DECLARE COMPONENTS
        
        JTable table = new JTable(0,9);
        DefaultTableModel users = new DefaultTableModel();
        users.setColumnIdentifiers(new String[] {"First Name", "Last Name", "Username","Gender","Contact Number", "Email", "address", "State", "City"});
        table.setModel(users);
        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
        table.setRowHeight(20);
        JScrollPane scroll = new JScrollPane(table);
        contentpane.add(scroll);
        scroll.setBounds(76, 60, 850, 500);

        JButton back = new JButton("<- Back");
        contentpane.add(back);
        back.setBounds(10, 10, 80, 15);
        back.setFont(new Font("Tahoma", Font.PLAIN, 12));

        JLabel remove = new JLabel("Remove User");
        contentpane.add(remove);
        remove.setBounds(525, 600, 106, 20);
        
        JTextField removetext = new JTextField();
        contentpane.add(removetext);
        removetext.setBounds(626, 600, 165, 20);
        removetext.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JButton removebutton = new JButton("Remove");
        contentpane.add(removebutton);
        removebutton.setBounds(823, 600, 80, 20);

        JLabel searchUser = new JLabel("Search user");
        contentpane.add(searchUser);
        searchUser.setBounds(90, 600, 106, 20);
        
        JTextField searchtext = new JTextField();
        contentpane.add(searchtext);
        searchtext.setBounds(195, 600, 165, 20);

        JButton search = new JButton("Search");
        contentpane.add(search);
        search.setBounds(370, 600, 80, 20);


        searchtext.setFont(new Font("Tahoma", Font.PLAIN, 15));
        search.setFont(new Font("Tahoma", Font.PLAIN, 12));
        removebutton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        searchUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
        remove.setFont(new Font("Tahoma", Font.PLAIN, 15));



        Sqlconnect sql = new Sqlconnect();
        Connection con = sql.connect();
        try{
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM customer";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                String first_name = rs.getString("fname");
                String last_name = rs.getString("lname");
                String username = rs.getString("username");
                String gender = rs.getString("Gender");
                Integer contact_number = rs.getInt("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String state = rs.getString("state");
                String city = rs.getString("city");
                users.addRow(new String[] {first_name,last_name,username,gender,contact_number.toString(),email,address,state,city});
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                new Adminpage();
            }
        });
        removebutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String username = removetext.getText();
                try{
                    Statement stmt = con.createStatement();
                    String query = "DELETE FROM customer WHERE username = '"+username+"'";
                    stmt.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "User Removed");
                    frame.dispose();
                    new Users();
                }
                catch(Exception e1)
                {
                    System.out.println(e1);
                }
            }
        });
        search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String fname = searchtext.getText();
                try{
                    Statement st = con.createStatement();
                    String query = "SELECT * FROM customer WHERE fname = '"+fname+"'";
                    ResultSet rs = st.executeQuery(query);
                    if(rs.next())
                    {
                        while(rs.next())
                        {
                            String first_name = rs.getString("fname");
                            String last_name = rs.getString("lname");
                            String username = rs.getString("username");
                            String gender = rs.getString("Gender");
                            Integer contact_number = rs.getInt("phone");
                            String email = rs.getString("email");
                            String address = rs.getString("address");
                            String state = rs.getString("state");
                            String city = rs.getString("city");
                            users.addRow(new String[] {first_name,last_name,username,gender,contact_number.toString(),email,address,state,city});
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No user found with name:- "+ fname );
                    }
                }
                catch(Exception e1)
                {
                    System.out.println(e1);
                }
            }
        });

    }
    public static void main(String[] args) {
        new Users();
    }
}