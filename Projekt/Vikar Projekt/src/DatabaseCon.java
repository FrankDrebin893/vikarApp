import java.sql.*;

public class DatabaseCon {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost/vikarapp";
	static Connection con;
	String pass = "123456";
	String user = "root";

//	public String getAllSub() throws SQLException {
//		String a = "";
//		try {
//			Class.forName(JDBC_DRIVER);
//			con = DriverManager.getConnection(DATABASE_URL, user, pass); // <--Password
//
//			Statement s = con.createStatement();
//			ResultSet rs = s.executeQuery("SELECT * FROM substitute");
//
//			if (rs != null) {
//
//				while (rs.next()) {
//
//					a += "ID: "+rs.getString(1) + "\n Navn: " + rs.getString(2) + " "
//							+ rs.getString(3) + "\n " + "Email: " + rs.getString(4) + "\n "
//							+ "Mobil Nr.: "+ rs.getString(5) + " Hjemme Nr.: " + rs.getString(6) + " \n \n";
//
//				}
//
//			}
//
//		} catch (SQLException sqlex) {
//			try {
//				System.out.println(sqlex.getMessage());
//				con.close();
//				System.exit(1);
//			} catch (SQLException sql) {
//			}
//		} catch (ClassNotFoundException noClass) {
//			System.err.println("Driver Class not found");
//			System.out.println(noClass.getMessage());
//			System.exit(1);
//		}
//		return a;
//	}

//	public String getAllTeacher() throws SQLException {
//
//		String a = "";
//		try {
//			Class.forName(JDBC_DRIVER);
//			con = DriverManager.getConnection(DATABASE_URL, user, pass); // <--Password
//
//			Statement s = con.createStatement();
//			ResultSet rs = s.executeQuery("SELECT * FROM Teacher");
//
//			if (rs != null) {
//
//				while (rs.next()) {
//
//					a += "ID: "+rs.getString(1) + "\n Navn: " + rs.getString(2) + " "
//							+ rs.getString(3) + "\n " + "Email: " + rs.getString(4) + "\n "
//							+ "Mobil Nr.: "+ rs.getString(5) + " Hjemme Nr.: " + rs.getString(6) + " \n \n";
//
//				}
//
//			}
//
//		} catch (SQLException sqlex) {
//			try {
//				System.out.println(sqlex.getMessage());
//				con.close();
//				System.exit(1);
//			} catch (SQLException sql) {
//			}
//		} catch (ClassNotFoundException noClass) {
//			System.err.println("Driver Class not found");
//			System.out.println(noClass.getMessage());
//			System.exit(1);
//		}
//		return a;
//	}

//	// Rasmus kode
//	public void addEmployee(String table, String fName, String lName,
//			String email, String cellPhone, String homePhone) {
//		if (table.equals("teacher")) {
//			try {
//				Class.forName(JDBC_DRIVER);
//				con = DriverManager.getConnection(DATABASE_URL, user, pass); // <--Password
//
//				Statement s = con.createStatement();
//				s.executeUpdate("INSERT INTO teacher " + "VALUES(0 ,'" + fName
//						+ "', '" + lName + "', '" + email + "', '" + cellPhone
//						+ "', '" + homePhone + "')");
//
//			} catch (SQLException sqlex) {
//				try {
//					System.out.println(sqlex.getMessage());
//					con.close();
//					System.exit(1);
//				} catch (SQLException sql) {
//				}
//			} catch (ClassNotFoundException noClass) {
//				System.err.println("Driver Class not found");
//				System.out.println(noClass.getMessage());
//				System.exit(1);
//			}
//		} else if (table.equals("substitute")) {
//			try {
//				Class.forName(JDBC_DRIVER);
//				con = DriverManager.getConnection(DATABASE_URL, user, pass); // <--Password
//
//				Statement s = con.createStatement();
//				s.executeUpdate("INSERT INTO substitute " + "VALUES(0 ,'"
//						+ fName + "', '" + lName + "', '" + email + "', '"
//						+ cellPhone + "', '" + homePhone + "')");
//				s.executeUpdate("SET @lid := LAST_INSERT_ID(); ");
//				for (int i = 0; i <= 6; i++) {
//
//					s.executeUpdate("INSERT INTO weekday "
//							+ "VALUES(null, @lid," + i
//							+ " ,  NOW(),  NOW(), 0)");
//				}
//
//			} catch (SQLException sqlex) {
//				try {
//					System.out.println(sqlex.getMessage());
//					con.close();
//					System.exit(1);
//				} catch (SQLException sql) {
//				}
//			} catch (ClassNotFoundException noClass) {
//				System.err.println("Driver Class not found");
//				System.out.println(noClass.getMessage());
//				System.exit(1);
//			}
//		}
//	}

//	public String[] login() throws SQLException {
//		String a = "";
//		String b = "";
//		String[] enter = new String[2];
//		try {
//			Class.forName(JDBC_DRIVER);
//			con = DriverManager.getConnection(DATABASE_URL, user, pass); // <--Password
//
//			Statement s = con.createStatement();
//			ResultSet rs = s
//					.executeQuery("SELECT username,password FROM login");
//
//			if (rs != null) {
//
//				while (rs.next()) {
//
//					a = rs.getString(1);
//					b = rs.getString(2);
//					enter[0] = a;
//					enter[1] = b;
//
//				}
//
//			}
//
//		} catch (SQLException sqlex) {
//			try {
//				System.out.println(sqlex.getMessage());
//				con.close();
//				System.exit(1);
//			} catch (SQLException sql) {
//			}
//		} catch (ClassNotFoundException noClass) {
//			System.err.println("Driver Class not found");
//			System.out.println(noClass.getMessage());
//			System.exit(1);
//		}
//		return enter;
//	}

//	public void setEmployee(String table, String id, String fName, String lName,
//			String email, String cellPhone, String homePhone)
//			throws SQLException {
//		String idRow = findIdRow(table);
//		try {
//			Class.forName(JDBC_DRIVER);
//			con = DriverManager.getConnection(DATABASE_URL, user, pass); // <--Password
//
//			Statement s = con.createStatement();
//
//			s.executeUpdate("UPDATE "+table+" SET fName = '" + fName
//					+ "', lName = '" + lName + "', email = '" + email
//					+ "', cellPhone = '" + cellPhone + "', homePhone = '"
//					+ homePhone + "' WHERE " + idRow + " = '" + id + "' ");
//
//		} catch (SQLException sqlex) {
//			try {
//				System.out.println(sqlex.getMessage());
//				con.close();
//				System.exit(1);
//			} catch (SQLException sql) {
//			}
//		} catch (ClassNotFoundException noClass) {
//			System.err.println("Driver Class not found");
//			System.out.println(noClass.getMessage());
//			System.exit(1);
//		}
//
//	}

//	public String[] getEmployeeInfo(int id, String table ) throws SQLException {
//		int employeeId = id;
//		String idRow = findIdRow(table);
//		String employeeTable = table;
//		String[] list = new String[5];
//		ResultSet rs = null;
//		String fName;
//		String lName;
//		String email;
//		String cellphone;
//		String homephone;
//		try {
//			Class.forName(JDBC_DRIVER);
//			con = DriverManager.getConnection(DATABASE_URL, user, pass); // <--Password
//
//			Statement s = con.createStatement();
//			rs = s.executeQuery("SELECT * "
//					+ "                                        FROM "+employeeTable+""
//					+ "                                        WHERE "+idRow+" = ' "
//					+ employeeId + " '");
//
//			if (rs != null) {
//
//				while (rs.next()) {
//					fName = rs.getString(2);
//					lName = rs.getString(3);
//					email = rs.getString(4);
//					cellphone = rs.getString(5);
//					homephone = rs.getString(6);
//
//					list[0] = fName;
//					list[1] = lName;
//					list[2] = email;
//					list[3] = cellphone;
//					list[4] = homephone;
//
//				}
//			}
//
//		} catch (SQLException sqlex) {
//			try {
//				System.out.println(sqlex.getMessage());
//				con.close();
//				System.exit(1);
//			} catch (SQLException sql) {
//			}
//		} catch (ClassNotFoundException noClass) {
//			System.err.println("Driver Class not found");
//			System.out.println(noClass.getMessage());
//			System.exit(1);
//		}
//
//		return list;
//	}
//	public String findIdRow(String table) {
//		String idRow = "";
//		if (table.equals("teacher")) {
//			idRow = "idTeacher";
//		}
//		else if(table.equals("substitute")) {
//			idRow = "idSubstitute";
//		}
//		else {
//			System.out.println("idRow er hverken lærer eller vikar");
//		}
//		return idRow;
//	}

//	public void deleteEmployee(String id, String table) throws SQLException {
//		String idRow = "";
//		idRow = findIdRow(table);
//		try {
//			Class.forName(JDBC_DRIVER);
//			con = DriverManager.getConnection(DATABASE_URL, user, pass); // <--
//																			// Password
//			Statement s = con.createStatement();
//			s.executeUpdate("DELETE FROM " + table + " WHERE " + idRow
//					+ " =  " + id + " ");
//		} catch (SQLException sqlex) {
//			try {
//				System.out.println(sqlex.getMessage());
//				con.close();
//				System.exit(1);
//			} catch (SQLException sql) {
//			}
//		} catch (ClassNotFoundException noClass) {
//			System.err.println("Driver Class not found");
//			System.out.println(noClass.getMessage());
//			System.exit(1);
//		}
//	}
	
//	public void updateWeekdays(String id, String weekdays[]) throws SQLException {
//		try {
//			Class.forName(JDBC_DRIVER);
//			con = DriverManager.getConnection(DATABASE_URL, user, pass); // <--
//																			// Password
//			Statement s = con.createStatement();
//			
//			for(int i = 0; i <= 6; i++) {
//			s.executeUpdate("UPDATE weekday SET available = ' " +weekdays[i]+ " ' WHERE idSubstitute =  " + id + " AND Weekday = ' " + i + "' ");
//			}
//			
//		} catch (SQLException sqlex) {
//			try {
//				System.out.println(sqlex.getMessage());
//				con.close();
//				System.exit(1);
//			} catch (SQLException sql) {
//			}
//		} catch (ClassNotFoundException noClass) {
//			System.err.println("Driver Class not found");
//			System.out.println(noClass.getMessage());
//			System.exit(1);
//		}
//	}
	
//	public String[] getAvailable(String id) throws SQLException {
//		String[] available = new String[7];
//		int i = 0;
//		try {
//			Class.forName(JDBC_DRIVER);
//			con = DriverManager.getConnection(DATABASE_URL, user, pass); // <--Password
//
//			Statement s = con.createStatement();
//			ResultSet rs = s.executeQuery("SELECT available " +
//					"					   FROM weekday" +
//					"					   JOIN substitute on substitute.idSubstitute = weekday.idSubstitute" +
//					"					   WHERE substitute.idsubstitute = ' " + id + " '");
//			
//			if (rs != null) {
//
//				while (rs.next()) {
//					available[i] = rs.getString(1);
//					i++;
//				}
//			}
//			
//			
//			
//
//		} catch (SQLException sqlex) {
//			try {
//				System.out.println(sqlex.getMessage());
//				con.close();
//				System.exit(1);
//			} catch (SQLException sql) {
//			}
//		} catch (ClassNotFoundException noClass) {
//			System.err.println("Driver Class not found");
//			System.out.println(noClass.getMessage());
//			System.exit(1);
//		}
//		
//		return available;
//	}
//	public String getAvailableWeekday(int weekday) throws SQLException {
//		String a = "";
//		try {
//			Class.forName(JDBC_DRIVER);
//			con = DriverManager.getConnection(DATABASE_URL, user, pass); // <--Password
//
//			Statement s = con.createStatement();
//			ResultSet rs = s.executeQuery("SELECT * " +
//					"					   FROM substitute" +
//					"					   JOIN weekday on weekday.idSubstitute = substitute.idSubstitute" +
//					"					   WHERE weekday.available = '1' AND weekday.Weekday = ' " + weekday + " '");
//			if (rs != null) {
//
//				while (rs.next()) {
//
//					a += "ID: "+rs.getString(1) + "\n Navn: " + rs.getString(2) + " "
//							+ rs.getString(3) + "\n " + "Email: " + rs.getString(4) + "\n "
//							+ "Mobil Nr.: "+ rs.getString(5) + " Hjemme Nr.: " + rs.getString(6) + " \n \n";
//
//				}
//
//			}
//
//		} catch (SQLException sqlex) {
//			try {
//				System.out.println(sqlex.getMessage());
//				con.close();
//				System.exit(1);
//			} catch (SQLException sql) {
//			}
//		} catch (ClassNotFoundException noClass) {
//			System.err.println("Driver Class not found");
//			System.out.println(noClass.getMessage());
//			System.exit(1);
//		}return a;
//	}
	

}
