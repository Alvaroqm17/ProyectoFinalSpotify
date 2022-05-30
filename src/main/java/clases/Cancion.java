package clases;

import java.lang.ProcessHandle.Info;
import java.util.ArrayList;

import javax.sound.sampled.Clip;

import enums.Estilos;

public class Cancion extends ObjetoConSonido {

	private Artista artista;
	private int duracion;
	private ArrayList<Estilos> EstiloCancion;
	private int cantidadReproducciones;
	private Clip reproducirCancion;

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

	public ArrayList<Estilos> getEstiloCancion() {
		return EstiloCancion;
	}

	public void setEstiloCancion(ArrayList<Estilos> estiloCancion) {
		EstiloCancion = estiloCancion;
	}

	public int getCantidadReproducciones() {
		return cantidadReproducciones;
	}

	public void setCantidadReproducciones(int cantidadReproducciones) {
		this.cantidadReproducciones = cantidadReproducciones;
	}

	public Clip getReproducirCancion() {
		return reproducirCancion;
	}

	public void setReproducirCancion(Clip reproducirCancion) {
		this.reproducirCancion = reproducirCancion;
	}

}
