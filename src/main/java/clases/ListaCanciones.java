package clases;

import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.CancionNoExisteException;
import utilDB.UtilDB;

/**
 *Clase que crea nuevas playlists y las inserta en la base de datos 
 * 
 * @author Alvaro Quiñones
 *
 */

public class ListaCanciones {

	private String nombre;
	private String cancion;
	
	

	public void setCancion(String cancion) {
		this.cancion = cancion;
	}
	

		
	 public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	/**

    * Constructor para añadir la playlist a tu libreria primero comprobando si esta en la base de datos

    * @param nombre es el nombre de la cancion que insertamos en la tabla playlist

    */

	public ListaCanciones(String nombre) throws SQLException {
		super();
		Statement query = UtilDB.conectarDB();
		// Insertar

		if (query.executeUpdate("insert into playlist (nombre) values('" + nombre + "')") > 0) {
			this.nombre = nombre;

		} else {
			throw new SQLException("Lo siento, no se ha podido crear la playlist.");
		}
		UtilDB.desconectarBD();
	}
	
	 /**

     * Método que consulta la base de datos y concatena los nombres de las playlists en un arrayList

     */

	public ListaCanciones() {
	}
	
	public static ArrayList<ListaCanciones> getTodos() {
		Statement smt = UtilDB.conectarDB();
		ArrayList<ListaCanciones> ret = new ArrayList<ListaCanciones>();

		try {
			ResultSet cursor = smt.executeQuery("select * from playlist");
			while (cursor.next()) {
				ListaCanciones actual = new ListaCanciones();
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
