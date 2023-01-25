import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class Adminpage
{
    Adminpage()
    {
        JFrame frame = new JFrame("Admin Page");
        frame.setBounds(100, 100, 600, 350);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        JPanel contentpane = new JPanel();
        contentpane.setBackground(new Color(204, 255, 255));
        contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentpane);
        contentpane.setLayout(null);

        // DECLARE COMPONENTS
        JButton adddetails = new JButton("Add Details");
        contentpane.add(adddetails);
        adddetails.setBackground(new Color(128, 255, 128));

        JButton viewusers = new JButton("View Users");
        contentpane.add(viewusers);
        viewusers.setBackground(new Color(0, 128, 255));

        JButton logout = new JButton("Logout");
        contentpane.add(logout);
        logout.setBackground(new Color(255, 128, 128));



        // SET BOUNDS
        adddetails.setBounds(105, 90, 369, 47);
        // cancelticket.setBounds(105, 231, 369, 47);
        logout.setBounds(485, 277, 89, 25);
        viewusers.setBounds(105, 202, 369, 47);


        // SET FONT
        adddetails.setFont(new Font("Gadugi", Font.BOLD, 17));
        viewusers.setFont(new Font("Gadugi", Font.BOLD, 17));
        logout.setFont(new Font("Gadugi", Font.BOLD, 15));
        
        JTextArea txtrWEL = new JTextArea(" W\r\n E\r\n L \r\n C\r\n O \r\n M\r\n E  ");
        contentpane.add(txtrWEL);
        txtrWEL.setColumns(5);
        txtrWEL.setFont(new Font("Gadugi", Font.BOLD, 17));
        txtrWEL.setBackground(new Color(0, 128, 128));
        txtrWEL.setBounds(0, 0, 34, 311);
        txtrWEL.setEditable(false);

        JTextArea txtrADM = new JTextArea("\r\n\r\n\r\n\r\n\r\n\r\n\r\n A\r\n D\r\n M\r\n I\r\n N\r\n");
        contentpane.add(txtrADM);
        txtrADM.setFont(new Font("Gadugi", Font.BOLD, 17));
        txtrADM.setColumns(5);
        txtrADM.setBackground(new Color(0, 128, 128));
        txtrADM.setBounds(28, 0, 34, 311);
        txtrADM.setEditable(false);

        JLabel txtrAddBusDetails = new JLabel("Add Bus Details :");
        contentpane.add(txtrAddBusDetails);
        txtrAddBusDetails.setFont(new Font("Gadugi", Font.PLAIN, 15));
        txtrAddBusDetails.setBackground(new Color(204, 255, 255));
        txtrAddBusDetails.setBounds(105, 51, 172, 40);

        JLabel txtrViewSignedIn = new JLabel("View Signed In Users :");
        contentpane.add(txtrViewSignedIn);
        txtrViewSignedIn.setFont(new Font("Gadugi", Font.PLAIN, 15));
        txtrViewSignedIn.setBackground(new Color(204, 255, 255));
        txtrViewSignedIn.setBounds(105, 162, 172, 40);

        
        JLabel txtrDoneWorkingFor = new JLabel("Done Working for the Day??\r\n");
        contentpane.add(txtrDoneWorkingFor);
        txtrDoneWorkingFor.setFont(new Font("Gadugi", Font.PLAIN, 15));
        txtrDoneWorkingFor.setBackground(new Color(204, 255, 255));
        txtrDoneWorkingFor.setBounds(285, 277, 198, 23);

        // SET ACTION LISTENER
        adddetails.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                new Addbusdetails();
            }
        });
        viewusers.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                new Users();
            }
        });
        logout.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                new Adminlogin();
            }
        });
    }
    public static void main(String[] args)
    {
        new Adminpage();
    }
}