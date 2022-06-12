package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.sound.sampled.Clip;
import enums.Estilos;
import exceptions.CancionNoExisteException;
import utilDB.UtilDB;

public class Cancion extends ObjetoConSonido {

	private Artista artista;
	private int duracion;
	private Estilos EstiloCancion;
	private Clip reproducirCancion;
	private String nombre;

	public Cancion(String nombre) throws SQLException, CancionNoExisteException  {
		super();
		Scanner sc = new Scanner(System.in);
		Statement smt = UtilDB.conectarDB();
		ResultSet cursor = smt.executeQuery("select * from canciones where nombre='" + nombre.toUpperCase() + "'");

		if (cursor.next()) {
			this.nombre = cursor.getString("nombre");

			if (!this.nombre.equals(nombre)) {
				UtilDB.desconectarBD();
				throw new CancionNoExisteException("La cancion no existe, o actualmente no ha sido añadida a la aplicacion.");
			}else {
				if (smt.executeUpdate("insert into canciones_añadidas (nombre) values('" + nombre + "')") > 0) {
					this.nombre = nombre;
				}
			}

		UtilDB.desconectarBD();
		}
		}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Estilos getEstiloCancion() {
		return EstiloCancion;
	}

	public void setEstiloCancion(Estilos estiloCancion) {
		EstiloCancion = estiloCancion;
	}

	public Clip getReproducirCancion() {
		return reproducirCancion;
	}

	public void setReproducirCancion(Clip reproducirCancion) {
		this.reproducirCancion = reproducirCancion;
	}

}
