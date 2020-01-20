import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConnectionClase {
	public ConnectionClase() {
		Connection conexion;
		try {
			Scanner teclat = new Scanner(System.in);

			String usuario = "root";
			String password = "";
			String urlBBDD = "jdbc:mysql://localhost:3306/seguros?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

//			String usuario = "zuk5X2TjSn";
//			String password = "ioXxebaOEY";
//			String urlBBDD = "jdbc:mysql://remotemysql.com:3306/zuk5X2TjSn?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			conexion = DriverManager.getConnection(urlBBDD, usuario, password);
			Statement st = conexion.createStatement();
			
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
