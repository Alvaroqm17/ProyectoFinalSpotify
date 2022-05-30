package clases;

import java.util.ArrayList;

public class ColaReproduccion extends ObjetoConSonido {

	private ArrayList<Cancion> cancionReproducida;
	private ArrayList<Cancion> cancionesAReproducir;
	private Cancion cancionActual;

	public ArrayList<Cancion> getCancionReproducida() {
		return cancionReproducida;
	}

	public void setCancionReproducida(ArrayList<Cancion> cancionReproducida) {
		this.cancionReproducida = cancionReproducida;
	}

	public ArrayList<Cancion> getCancionesAReproducir() {
		return cancionesAReproducir;
	}

	public void setCancionesAReproducir(ArrayList<Cancion> cancionesAReproducir) {
		this.cancionesAReproducir = cancionesAReproducir;
	}

	public Cancion getCancionActual() {
		return cancionActual;
	}

	public void setCancionActual(Cancion cancionActual) {
		this.cancionActual = cancionActual;
	}

}
