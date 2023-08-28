package akitochalam.DatabaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class JDBCConnection {
	String host = "localhost";
	String port = "3306";
	String connURL = "jdbc:mysql://" + host + ":" + port + "/testdb";

	@Test
	public void DBConnection() throws SQLException {

		Connection conn = DriverManager.getConnection(connURL, "root", "Arun_mysql@13");

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("Select * from EmployeeInfo where name = 'Arun'");

		// "Before start of result set" error will display if rs.next() is not given
		// since the result is pointing to the base index and not the first index up
		// until this point.

		rs.next();

		System.out.println("Name: " + rs.getString("name") + "\n" + "ID: " + rs.getString("id") + "\n" + "Location: "
				+ rs.getString("location") + "\n" + "Age: " + rs.getString("age"));

	}

}
