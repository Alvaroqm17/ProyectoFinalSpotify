package utilDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class UtilDB {

	private static final String cadenaConexion = "jdbc:mysql://127.0.0.1:3306/FantasyMusic";
	private static final String usuarioBD = "root";
	private static final String contraseñaBD = "QMalvaro17";
	private static Connection conexion;
	
	public static Statement conectarDB() {
		
	try {
		if(conexion==null) {
			conexion=DriverManager.getConnection(cadenaConexion,usuarioBD,contraseñaBD);
			
		}
		return conexion.createStatement();
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("No se ha podido conectar intentelo luego");
			return null;
		}
	}
	
	public static void desconectarBD() {
		if(conexion!=null) {
			try {
				conexion.close();
				conexion = null;
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("No se pudo desconectar");
			}
		}
	}
}