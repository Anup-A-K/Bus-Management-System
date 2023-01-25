import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Searchbus{
    Searchbus(String a)
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

        JButton search = new JButton("Search Bus");
        contentpane.add(search);
        JButton back = new JButton("<- Back");
        contentpane.add(back);
        JLabel from = new JLabel("From");
        contentpane.add(from);
        JLabel to = new JLabel("To");
        contentpane.add(to);
        JLabel date = new JLabel("Date");
        contentpane.add(date);
        JLabel time = new JLabel("Time");
        contentpane.add(time);
        JTextField fromtext = new JTextField();
        contentpane.add(fromtext);
        JTextField totext = new JTextField();
        contentpane.add(totext);
        JTextField datetext = new JTextField();
        contentpane.add(datetext);
        JTextField timetext = new JTextField();
        contentpane.add(timetext);
            JTable table = new JTable(0,9);
            DefaultTableModel bus_details = new DefaultTableModel();
            bus_details.setColumnIdentifiers(new String[] {"Bus Number", "Route", "Capacity","Source","Destination", "Bus Depot", "Bus Type", "Driver Name", "Driver Contact"});
            table.setModel(bus_details);
            table.setFont(new Font("Tahoma", Font.PLAIN, 15));
            table.setRowHeight(30);
            JScrollPane scroll = new JScrollPane(table);
            contentpane.add(scroll);
        JButton book = new JButton("Book");
        contentpane.add(book);



        // SET BOUNDS

        from.setBounds(300, 80, 46, 14);
        to.setBounds(300, 120, 46, 14);
        date.setBounds(300, 160, 46, 14);
        time.setBounds(300, 200, 46, 14);
        fromtext.setBounds(400, 80, 200, 20);
        totext.setBounds(400, 120, 200, 20);
        datetext.setBounds(400, 160, 200, 20);
        timetext.setBounds(400, 200, 200, 20);
        search.setBounds(400, 250, 200, 30);
        back.setBounds(10, 10, 79, 17);
        scroll.setBounds(100, 300, 800, 300);
        book.setBounds(400, 620, 200, 30);


        // SET FONT

        from.setFont(new Font("Tahoma", Font.PLAIN, 15));
        to.setFont(new Font("Tahoma", Font.PLAIN, 15));
        date.setFont(new Font("Tahoma", Font.PLAIN, 15));
        time.setFont(new Font("Tahoma", Font.PLAIN, 15));
        fromtext.setFont(new Font("Tahoma", Font.PLAIN, 15));
        totext.setFont(new Font("Tahoma", Font.PLAIN, 15));
        datetext.setFont(new Font("Tahoma", Font.PLAIN, 15));
        timetext.setFont(new Font("Tahoma", Font.PLAIN, 15));
        search.setFont(new Font("Tahoma", Font.PLAIN, 15));
        back.setFont(new Font("Tahoma", Font.PLAIN, 12));


        Sqlconnect connection = new Sqlconnect();
        Connection con = connection.connect();
            try{
                Statement stmt = con.createStatement();
                String query = "SELECT * FROM bus_details";
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    String bus_number = rs.getString("bus_number");
                    String route = rs.getString("route");
                    String capacity = rs.getString("capacity");
                    String source = rs.getString("source");
                    String destination = rs.getString("destination");
                    String bus_depot = rs.getString("bus_depot");
                    String bus_type = rs.getString("bus_type");
                    String driver_name = rs.getString("driver_name");
                    String driver_contact = rs.getString("driver_contact");
                    bus_details.addRow(new String[] {bus_number, route, capacity, source, destination, bus_depot, bus_type, driver_name, driver_contact});
                    con.close();
                }
            }
            catch(Exception e1){
                System.out.println(e1);
            }

        // SET ACTION LISTENER

        book.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int row = table.getSelectedRow();
                String bus_number = table.getModel().getValueAt(row, 0).toString();
                String route = table.getModel().getValueAt(row, 1).toString();
                String source = table.getModel().getValueAt(row, 3).toString();
                String destination = table.getModel().getValueAt(row, 4).toString();
                String bus_type = table.getModel().getValueAt(row, 6).toString();
                String driver_name = table.getModel().getValueAt(row, 7).toString();
                String driver_contact = table.getModel().getValueAt(row, 8).toString();
                Sqlconnect connection = new Sqlconnect();
                Connection con = connection.connect();
                int bool = JOptionPane.showConfirmDialog(null, "Are you sure you want to book this bus?", "Book Bus", JOptionPane.YES_NO_OPTION);
                if(bool == 0)
                {
                String input = JOptionPane.showInputDialog("Number of seats to be booked");
                try{
                    Statement stmt = con.createStatement();
                    String query = "INSERT INTO booked_tickets VALUES('"+a+"','"+bus_number+"','"+route+"','"+source+"','"+destination+"','"+bus_type+"','"+driver_name+"','"+driver_contact+"')";
                    for(int i=0;i<Integer.parseInt(input);i++){
                        stmt.executeUpdate(query);
                    }
                    JOptionPane.showMessageDialog(null, "Bus Booked");
                    }
                    catch(Exception e1){
                        JOptionPane.showMessageDialog(null, e1);
                    }
                }
            }
        });


        search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
				bus_details.setRowCount(0);
                String from = fromtext.getText();
                String to = totext.getText();
                // String date = datetext.getText();
                // String time = timetext.getText();
                Sqlconnect connection = new Sqlconnect();
                Connection con = connection.connect();
                try{
                    Statement stmt = con.createStatement();
                    String query = "SELECT * FROM bus_details WHERE source = '"+from+"' AND destination = '"+to+"'";
                    ResultSet rs = stmt.executeQuery(query);
                    while(rs.next()){
                        String bus_number = rs.getString("bus_number");
                        String route = rs.getString("route");
                        String capacity = rs.getString("capacity");
                        String source = rs.getString("source");
                        String destination = rs.getString("destination");
                        String bus_depot = rs.getString("bus_depot");
                        String bus_type = rs.getString("bus_type");
                        String driver_name = rs.getString("driver_name");
                        String driver_contact = rs.getString("driver_contact");
                        bus_details.addRow(new String[] {bus_number, route, capacity, source, destination, bus_depot, bus_type, driver_name, driver_contact});
                        con.close();
                    }
                }
                catch(Exception e1){
                    System.out.println(e1);
                }
            }
        });
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new Customerpage(a);
            }
        });
    }
    public static void main(String[] args)
    {
        new Searchbus("");
    }
}