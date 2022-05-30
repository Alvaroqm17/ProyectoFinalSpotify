package clases;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ListaCanciones extends ObjetoConNombre{

	
	private ArrayList<Cancion> cancion;

	public ArrayList<Cancion> getCancion() {
		return cancion;
	}

	public void setCancion(ArrayList<Cancion> cancion) {
		this.cancion = cancion;
	}

	public ListaCanciones(ArrayList<Cancion> cancion) {
		super();
		this.cancion = cancion;
	}

	public ListaCanciones() {
		
	}
	
	
}
