import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class exercici3 {
	static Connection conexion;

	public static void main(String[] args) {

		try {
			Scanner teclat = new Scanner(System.in);

			String usuario = "root";
			String password = "";
			String urlBBDD = "jdbc:mysql://localhost:3306/seguros?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

//			String usuario = "zuk5X2TjSn";
//			String password = "ioXxebaOEY";
//			String urlBBDD = "jdbc:mysql://remotemysql.com:3306/zuk5X2TjSn?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			conexion = DriverManager.getConnection(urlBBDD, usuario, password);
//			Statement st = conexion.createStatement();
//			st.executeUpdate("UPDATE asistenciamedica SET asistenciamedica.importe = 6523.34 WHERE asistenciamedica.breveDescripcion = 'Dermatitis infecciosa';");

//			st.close();
			System.out.println("Digues el nom del pacient");
			String nom = teclat.nextLine();
			System.out.println("Digues el cognom1 del pacient");
			String cognom1 = teclat.nextLine();
			System.out.println("Digues el cognom2 del pacient");
			String cognom2 = teclat.nextLine();
			llistat(nom, cognom1, cognom2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void llistat(String nom, String cognom1, String cognom2) {
		try {
			Statement st = conexion.createStatement();
			System.out.println("Nom de l'assegurat:" + nom + " " + cognom1 + " " + cognom2);
			ResultSet rs = null;
			rs = st.executeQuery("Select * from seguro where nombre='"+nom+"' and ape1='"+cognom1+"' and ape2='"+cognom2+"';");
			String idseguroo = "";
			while (rs.next()) {
				idseguroo = (""+ rs.getObject("idSeguro"));
			}
			rs = null;
			rs = st.executeQuery("SELECT COUNT(IdAsistenciaMedica) FROM asistenciamedica WHERE IdSeguro="+idseguroo+";");
			String total = "";
			while (rs.next()) {
				total = ("Total assistencia medica: "+ rs.getObject("COUNT(IdAsistenciaMedica)"));
System.out.println(total);
			}
			rs = null;
			rs = st.executeQuery("SELECT SUM(importe) FROM asistenciamedica WHERE IdSeguro="+idseguroo+";");
			String totalImport = "";
			while (rs.next()) {
				totalImport = ("Import: "+ rs.getObject("SUM(importe)")+" €");
System.out.println(totalImport);
			}
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
