package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import javax.sound.sampled.Clip;
import enums.Estilos;
import exceptions.CancionNoExisteException;
import utilDB.UtilDB;

/**

 * Esta clase se conecta con la base de datos para insertar y consultar canciones que luego se usan en el programa para añdirlas a la lista de canciones
 * @author: Alvaro Quiñones Melero
 * @version: 1.0
 */

public class Cancion {

	private String nombre;
	
	 /**

     * Constructor para añadir la cancion a la lista de tus canciones primero comprobando si esta en la base de datos

     * @param nombre es el nombre de la cancion que comprobamos si esta en la tabla canciones y luego insertamos en la tabla canciones_añadidas

     */

	public Cancion(String nombre) throws SQLException, CancionNoExisteException {
		super();
		Scanner sc = new Scanner(System.in);
		Statement smt = UtilDB.conectarDB();
		ResultSet cursor = smt.executeQuery("select * from canciones where nombre='" + nombre.toUpperCase() + "'");

		if (cursor.next()) {
			this.nombre = cursor.getString("nombre");

			if (!this.nombre.equals(nombre)) {
				UtilDB.desconectarBD();
				throw new CancionNoExisteException(
						"La cancion no existe, o actualmente no ha sido añadida a la aplicacion.");
			} else {
				if (smt.executeUpdate("insert into canciones_añadidas (nombre) values('" + nombre + "')") > 0) {
					this.nombre = nombre;
				}
			}

			UtilDB.desconectarBD();
		}
	}

	 /**

     * Constructor para crear el arrayList de las funciones getTodos y getTodas

     */
	public Cancion() {
		// TODO Auto-generated constructor stub
	}

	/**

     * Método que devuelve el nombre

     * @return el nombre la cancion

     */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	 /**

     * Método que consulta la base de datos y concatena los nombres de las canciones en un arrayList

     */

	public static ArrayList<Cancion> getTodos() {
		Statement smt = UtilDB.conectarDB();
		ArrayList<Cancion> ret = new ArrayList<Cancion>();

		try {
			ResultSet cursor = smt.executeQuery("select * from canciones_añadidas");
			while (cursor.next()) {
				Cancion actual = new Cancion();
				actual.setNombre(cursor.getString("nombre"));

				ret.add(actual);
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

		UtilDB.desconectarBD();
		return ret;
	}
	
	 /**

     * Método que consulta la base de datos y concatena los nombres de las canciones previamente añadidas en un arrayList
     
	 * @return Si no hay canciones en la tabla, va a devolver un arraylist vacio.

     */
	
	public static ArrayList<Cancion> getTodas() {
		Statement smt = UtilDB.conectarDB();
		ArrayList<Cancion> ret = new ArrayList<Cancion>();

		try {
			ResultSet cursor = smt.executeQuery("select * from canciones");
			while (cursor.next()) {
				Cancion actual = new Cancion();
				actual.setNombre(cursor.getString("nombre"));

				ret.add(actual);
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

		UtilDB.desconectarBD();
		return ret;
	}
	
	

}
