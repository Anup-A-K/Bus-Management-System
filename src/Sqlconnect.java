import java.sql.*;
public class Sqlconnect {
	public Connection connect() {
		Connection db= null;
		try {
			db = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "qwerty");
			if(db!=null)
				System.out.println("Connected!");
			}catch(Exception e) {
				System.out.println(e);
			}
		return db;
	}
}