package utilDB;

import java.sql.Connection;

/**
 * Clase en la que se hace la conexion con  la base de datos y se registran en las variables internas los datos necesarios para acceder a la base de datos.
 * 
 * @author Alvaro Quiñones Melero
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class UtilDB {

	private static final String cadenaConexion = "jdbc:mysql://127.0.0.1:3306/FantasyMusic";
	private static final String usuarioBD = "root";
	private static final String contraseñaBD = "QMalvaro17";
	private static Connection conexion;

	/**
	 * Funcion que es llamada para establecer la conexion con la base de datos.
	 * 
	 * @return devuelve la conexion con la base de datos si se ha logrado establecer dados los datos en  las variables internas
	 * 
	 */
	
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
	
	/**
	 * Esta funcion es llamada para desconectar la base de datos que ha tenido que ser iniciada previamente
	 */
	
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