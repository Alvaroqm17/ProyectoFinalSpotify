package clases;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utilDB.UtilDB;


public class ListaCanciones extends ObjetoConNombre {

	private String nombre;
	private ArrayList<Cancion> lista;

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

	public ListaCanciones() {

	}

}
