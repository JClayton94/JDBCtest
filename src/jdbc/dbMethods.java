package jdbc;

import java.sql.*;
import java.util.ArrayList;

public class dbMethods {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/sakila";

	static final String USER = "root";
	static final String PASS = "Mu9ruduVa5rAH33";

	Connection conn = null;
	Statement stmt = null;


	public void accessDB() {

		try {

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch(SQLException sqle) {

			sqle.printStackTrace();

		}
	}

	public void sqlToDB(String sql) {
		

		try {

			stmt = conn.createStatement();

			stmt.executeUpdate(sql);

		} catch (SQLException sqle) {

			sqle.printStackTrace();

		}

	}

	public ArrayList<Actor> readFromDB(String what, String fromWhere) {

		String sql = "Select " + what + " from " + fromWhere;

		ArrayList<Actor> resultSet = new ArrayList<Actor>();

		try {

			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {

				resultSet.add(new Actor(rs.getString("first_name"), rs.getString("last_name")));

			}

			rs.close();

		} catch(SQLException sqle) {

			sqle.printStackTrace();

		}
		return resultSet;
	}
	
	public void insertIntoDB(String data, String table) {
		
		sqlToDB("insert into " + table + "(first_name, last_name) values (" + data + ")"); 
		
	}
	
	
}

