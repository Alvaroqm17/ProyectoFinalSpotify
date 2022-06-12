package clases;

import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.CancionNoExisteException;
import utilDB.UtilDB;


public class ListaCanciones extends ObjetoConNombre {

	private String nombre;
	private ArrayList<Cancion> lista;
	private String cancion;
	
	

	public void setCancion(String cancion) {
		this.cancion = cancion;
	}

	public ArrayList<Cancion> getCancion() {
		return lista;
	}

	public void setCancion(ArrayList<Cancion> lista) {
		this.lista = lista;
	}

	public ListaCanciones(ArrayList<Cancion> lista, String nombre) {
		super();
		this.lista = lista;
		this.nombre = nombre;
	}

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
	
	public ListaCanciones(String nombre, String cancion) throws SQLException, CancionNoExisteException {
		super();
		
			Scanner sc = new Scanner(System.in);
			Statement smt = UtilDB.conectarDB();
			ResultSet cursor = smt.executeQuery("select * from canciones where nombre='" + cancion + "'");

			if (cursor.next()) {
				this.cancion = cursor.getString("nombre").toUpperCase();

				if (!this.cancion.equals(cancion)) {
					UtilDB.desconectarBD();
					throw new CancionNoExisteException("La cancion no existe, o actualmente no ha sido añadida a la aplicacion.");
				}else {
					System.out.println("Cancion insertada en la playlist");
					smt.executeUpdate("INSERT INTO playlist (nombre) VALUES ('"+nombre+"'");
					smt.executeUpdate("INSERT INTO canciones (nombre) VALUES ('"+cancion+"'");
								
							}
				}

			UtilDB.desconectarBD();
			}

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
