import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Bookedtickets{
	Bookedtickets(String a)
	{
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 1000, 800);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		JPanel contentpane = new JPanel();
		contentpane.setBackground(new Color(204, 255, 255));
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentpane);
		contentpane.setLayout(null);

		// DECLARE COMPONENTS

		JTable table = new JTable(0,7);
        DefaultTableModel bus_details = new DefaultTableModel();
        bus_details.setColumnIdentifiers(new String[] {"Bus Number", "Route","Source","Destination", "Bus Type", "Driver Name", "Driver Contact"});
        table.setModel(bus_details);
        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
        table.setRowHeight(30);
        JScrollPane scroll = new JScrollPane(table);
        contentpane.add(scroll);

		Sqlconnect sql = new Sqlconnect();
		Connection con = sql.connect();
		try
		{
			Statement stmt = con.createStatement();
			String query = "select * from booked_tickets where username = '"+a+"'";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				bus_details.addRow(new Object[] {rs.getString("bus_number"), rs.getString("route"), rs.getString("source"), rs.getString("destination"), rs.getString("bus_type"), rs.getString("driver_name"), rs.getInt("driver_contact")});
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		JButton cancle = new JButton("Cancle");
		contentpane.add(cancle);
		JButton back = new JButton("<- Back");
		contentpane.add(back);
		JButton logout = new JButton("Logout");
		contentpane.add(logout);


		// SET BOUNDS

		scroll.setBounds(100, 100, 800, 500);
		cancle.setBounds(400, 650, 100, 20);
		back.setBounds(100, 650, 100, 20);
		logout.setBounds(700, 650, 100, 20);


		// SET FONT

		cancle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		back.setFont(new Font("Tahoma", Font.PLAIN, 15));
		logout.setFont(new Font("Tahoma", Font.PLAIN, 15));


		// ADD ACTION LISTENER

		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new Customerpage(a);
			}
		});
		logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new Customerlogin();
			}
		});

		cancle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				int row = table.getSelectedRow();
				String bus_number = (String)table.getValueAt(row, 0);
				String route = (String)table.getValueAt(row, 1);
				String source = (String)table.getValueAt(row, 2);
				String destination = (String)table.getValueAt(row, 3);
				String bus_type = (String)table.getValueAt(row, 4);
				String driver_name = (String)table.getValueAt(row, 5);
				int driver_contact = (int)table.getValueAt(row, 6);
				try
				{
					Statement stmt = con.createStatement();
					JOptionPane.showConfirmDialog(null, "Are you sure you want to cancle this ticket?", "Cancle Ticket", JOptionPane.YES_NO_OPTION);
					String query = "DELETE FROM booked_tickets WHERE bus_number = '"+bus_number+"' AND route = '"+route+"' AND source = '"+source+"' AND destination = '"+destination+"' AND bus_type = '"+bus_type+"' AND driver_name = '"+driver_name+"' AND driver_contact = '"+driver_contact+"'";
					stmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Ticket Cancled");
					frame.dispose();
					new Bookedtickets(a);
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		
	}
	public static void main (String[] args)
	{
		new Bookedtickets("");
	}
}