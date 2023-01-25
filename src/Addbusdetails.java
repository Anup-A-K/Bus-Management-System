import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Addbusdetails
{
	Addbusdetails()
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

		//DECLARE COMPONENTS
		JLabel lbaddbusdetails = new JLabel("Add Bus Details");
		contentpane.add(lbaddbusdetails);
		DefaultTableModel bus_details = new DefaultTableModel(2,9);
		JTable table = new JTable(0,9);
		table.setModel(bus_details);
		bus_details.setColumnIdentifiers(new String[] {"Bus Number", "Route", "Capacity","Source","Destination", "Bus Depot", "Bus Type", "Driver Name", "Driver Contact"});
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(20);
		table.setBounds(50, 130, 900, 400);
		contentpane.add(table);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 130, 900, 400);
		contentpane.add(scrollPane);
		scrollPane.setViewportView(table);
		JButton addrow = new JButton("Add Row");
		contentpane.add(addrow);
		JButton clearrow = new JButton("Delete Row");
		contentpane.add(clearrow);
		JButton update = new JButton("Update");
		contentpane.add(update);
		JButton back = new JButton("Back");
		contentpane.add(back);
		JButton delete = new JButton("Delete");
		contentpane.add(delete);
		JButton logout = new JButton("Logout");
		contentpane.add(logout);
		JButton refresh = new JButton("Refresh");
		contentpane.add(refresh);


		//SET BOUNDS
		addrow.setBounds(50, 550, 100, 20);
		clearrow.setBounds(200, 550, 100, 20);
		update.setBounds(350, 550, 100, 20);
		lbaddbusdetails.setBounds(400, 30, 300, 68);
		back.setBounds(800, 550, 100, 20);
		delete.setBounds(650, 550, 100, 20);
		logout.setBounds(850, 30, 100, 20);
		refresh.setBounds(500, 550, 100, 20);


		//SET FONT
		lbaddbusdetails.setFont(new Font("Tahoma", Font.BOLD, 30));


		// SET COLOR
		table.setBackground(new Color(204, 255, 255));


		//ADD ACTION LISTENERS
		Sqlconnect sql = new Sqlconnect();
		Connection con = sql.connect();
		addrow.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				bus_details.addRow(new Object[] {"", "", "", "", "", "", "","",""});
			}
		});
		clearrow.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				bus_details.removeRow(table.getSelectedRow());
			}
		});
		update.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// String query = "insert into bus_details values(?,?,?,?,?,?,?,?,?)";
				// String busnumber = table.getValueAt(0, 0).toString();
				// String route = table.getValueAt(0, 1).toString();
				// int capacity = Integer.parseInt(table.getValueAt(0, 2).toString());
				// String source = table.getValueAt(0, 3).toString();
				// String destination = table.getValueAt(0, 4).toString();
				// String busdepot = table.getValueAt(0, 5).toString();
				// String bustype = table.getValueAt(0, 6).toString();
				// String drivername = table.getValueAt(0, 7).toString();
				// int drivercontact = Integer.parseInt(table.getValueAt(0, 8).toString());
				String query = "insert into bus_details values(?,?,?,?,?,?,?,?,?)";
				try
				{
					PreparedStatement st = con.prepareStatement(query);
					for(int i = 0; i < table.getRowCount(); i++)
					{
						String busnumber = table.getValueAt(i, 0).toString();
						String route = table.getValueAt(i, 1).toString();
						int capacity = Integer.parseInt(table.getValueAt(i, 2).toString());
						String source = table.getValueAt(i, 3).toString();
						String destination = table.getValueAt(i, 4).toString();
						String busdepot = table.getValueAt(i, 5).toString();
						String bustype = table.getValueAt(i, 6).toString();
						String drivername = table.getValueAt(i, 7).toString();
						int drivercontact = Integer.parseInt(table.getValueAt(i, 8).toString());
						st.setString(1, busnumber);
						 st.setString(2, route);
						 st.setInt(3, capacity);
						 st.setString(4, source);
						 st.setString(5, destination);
						 st.setString(6, busdepot);
						 st.setString(7, bustype);
						 st.setString(8, drivername);
						 st.setInt(9, drivercontact);
						st.executeUpdate();
					}
					JOptionPane.showMessageDialog(null, "Data Updated Successfully");
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new Adminpage();
			}
		});
		delete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String query = "delete from bus_details where bus_number = ?";
				try
				{
					PreparedStatement st = con.prepareStatement(query);
					st.setString(1, (String) table.getValueAt(table.getSelectedRow(), 0));
					st.executeUpdate();
					bus_details.removeRow(table.getSelectedRow());
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
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
		refresh.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				bus_details.setRowCount(0);
				String query = "SELECT * FROM bus_details";
				try
				{
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					while(rs.next())
					{
						bus_details.addRow(new Object[] {rs.getString("bus_number"), rs.getString("route"), rs.getInt("capacity"), rs.getString("source"), rs.getString("destination"), rs.getString("bus_depot"), rs.getString("bus_type"), rs.getString("driver_name"), rs.getInt("driver_contact")});
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
	}
	public static void main(String[] args)
	{
		new Addbusdetails();
	}
}