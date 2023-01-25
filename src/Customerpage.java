import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class Customerpage {
    Customerpage(String a)
    {
        JFrame frame = new JFrame("Customer Page");
        frame.setBounds(100, 100, 600, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        JPanel contentpane = new JPanel();
        contentpane.setBackground(new Color(204, 255, 255));
        contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentpane);
        contentpane.setLayout(null);
        
        JButton search = new JButton("Search Buses");
        contentpane.add(search);
        search.setBackground(new Color(128, 255, 128));

        JButton mybookings = new JButton("My Bookings");
        contentpane.add(mybookings);
        mybookings.setBackground(new Color(255, 255, 128));

        JButton logout = new JButton("Logout");
        contentpane.add(logout);
        
        search.setBounds(105, 160, 370, 47);
        mybookings.setBounds(105, 247, 370, 47);
        logout.setBounds(484, 327, 90, 23);
        
        search.setFont(new Font("Gadugi", Font.BOLD, 20));
        mybookings.setFont(new Font("Gadugi", Font.BOLD, 20));
        logout.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 192));
        panel.setBounds(0, 24, 584, 60);
        contentpane.add(panel);
        
                // DECLARE COMPONENTS
        
                JLabel lblcustomerpage = new JLabel("Welcome "+a);
                panel.add(lblcustomerpage);
                // cancel.setBounds(105, 280, 370, 47);
                // cancel.setBounds(105, 360, 370, 47);


                // SET FONT

                lblcustomerpage.setFont(new Font("Tahoma", Font.PLAIN, 40));
                
                JLabel txtrSearchForBuses = new JLabel("Search for buses :");
                contentpane.add(txtrSearchForBuses);
                txtrSearchForBuses.setBackground(new Color(204, 255, 255));
                txtrSearchForBuses.setFont(new Font("Gadugi", Font.BOLD, 15));
                txtrSearchForBuses.setBounds(61, 126, 153, 23);
                
                JLabel txtrBookingHistory = new JLabel("Booking History :");
                contentpane.add(txtrBookingHistory);
                txtrBookingHistory.setFont(new Font("Gadugi", Font.BOLD, 15));
                txtrBookingHistory.setBackground(new Color(204, 255, 255));
                txtrBookingHistory.setBounds(61, 213, 153, 23);

                JLabel txtrSeeYouAgain = new JLabel("See you again !!");
                contentpane.add(txtrSeeYouAgain);
                txtrSeeYouAgain.setFont(new Font("Gadugi", Font.PLAIN, 15));
                txtrSeeYouAgain.setBackground(new Color(204, 255, 255));
                txtrSeeYouAgain.setBounds(371, 325, 126, 23);

        // SET ACTION LISTENER

        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Searchbus(a);
            }
        });

        mybookings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Bookedtickets(a);
            }
        });
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Customerlogin();
            }
        });
    }
    public static void main(String[] args)
    {
        new Customerpage("");
    } 
}
