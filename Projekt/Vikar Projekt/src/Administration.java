import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Administration extends DatabaseCon {

	public String[] login() throws SQLException {
		String a = "";
		String b = "";
		String[] enter = new String[2];
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DATABASE_URL, user, pass); 

			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("SELECT username,password FROM login");

			if (rs != null) {

				while (rs.next()) {

					a = rs.getString(1);
					b = rs.getString(2);
					enter[0] = a;
					enter[1] = b;

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
		return enter;
	}
}
