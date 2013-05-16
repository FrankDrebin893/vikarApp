import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Weekday extends DatabaseCon {
	
			public void updateWeekdays(String id, String weekdays[]) throws SQLException {
				try {
					Class.forName(JDBC_DRIVER);
					con = DriverManager.getConnection(DATABASE_URL, user, pass); // <--
																					// Password
					Statement s = con.createStatement();
					
					for(int i = 0; i <= 6; i++) {
					s.executeUpdate("UPDATE weekday SET available = ' " +weekdays[i]+ " ' WHERE idSubstitute =  " + id + " AND Weekday = ' " + i + "' ");
					}
					
				} catch (SQLException sqlex) {
					try {
						System.out.println(sqlex.getMessage());
						con.close();
						System.exit(1);
					} catch (SQLException sql) {
					}
				} catch (ClassNotFoundException noClass) {
					System.err.println("Driver Class not found");
					System.out.println(noClass.getMessage());
					System.exit(1);
				}
			}
			
			public String[] getAvailable(String id) throws SQLException {
				String[] available = new String[7];
				int i = 0;
				try {
					Class.forName(JDBC_DRIVER);
					con = DriverManager.getConnection(DATABASE_URL, user, pass); // <--Password

					Statement s = con.createStatement();
					ResultSet rs = s.executeQuery("SELECT available " +
							"					   FROM weekday" +
							"					   JOIN substitute on substitute.idSubstitute = weekday.idSubstitute" +
							"					   WHERE substitute.idsubstitute = ' " + id + " '");
					
					if (rs != null) {

						while (rs.next()) {
							available[i] = rs.getString(1);
							i++;
						}
					}
				} catch (SQLException sqlex) {
					try {
						System.out.println(sqlex.getMessage());
						con.close();
						System.exit(1);
					} catch (SQLException sql) {
					}
				} catch (ClassNotFoundException noClass) {
					System.err.println("Driver Class not found");
					System.out.println(noClass.getMessage());
					System.exit(1);
				}
				
				return available;
			}
			
			public String getAvailableWeekday(int weekday) throws SQLException {
				String a = "";
				try {
					Class.forName(JDBC_DRIVER);
					con = DriverManager.getConnection(DATABASE_URL, user, pass); // <--Password

					Statement s = con.createStatement();
					ResultSet rs = s.executeQuery("SELECT * " +
							"					   FROM substitute" +
							"					   JOIN weekday on weekday.idSubstitute = substitute.idSubstitute" +
							"					   WHERE weekday.available = '1' AND weekday.Weekday = ' " + weekday + " '");
					if (rs != null) {

						while (rs.next()) {

							a += "ID: "+rs.getString(1) + "\n Navn: " + rs.getString(2) + " "
									+ rs.getString(3) + "\n " + "Email: " + rs.getString(4) + "\n "
									+ "Mobil Nr.: "+ rs.getString(5) + " Hjemme Nr.: " + rs.getString(6) + " \n \n";

						}

					}

				} catch (SQLException sqlex) {
					try {
						System.out.println(sqlex.getMessage());
						con.close();
						System.exit(1);
					} catch (SQLException sql) {
					}
				} catch (ClassNotFoundException noClass) {
					System.err.println("Driver Class not found");
					System.out.println(noClass.getMessage());
					System.exit(1);
				}
				
				return a;
			}
}
