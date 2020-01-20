import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class exercici2 {
	public static void main(String[] args) {
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
			st.executeUpdate("UPDATE asistenciamedica SET asistenciamedica.importe = 6523.34 WHERE asistenciamedica.breveDescripcion = 'Dermatitis infecciosa';");
			
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
