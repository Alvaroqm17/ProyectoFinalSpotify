package clases;

import java.util.ArrayList;

public class Biblioteca extends ListaCanciones{

	private ArrayList<ListaCanciones> listaCanciones;

	public Biblioteca(ArrayList<ListaCanciones> listaCanciones) {
		super();
		this.listaCanciones = listaCanciones;
	}
	
	public ArrayList<ListaCanciones> getListaCanciones() {
		return listaCanciones;
	}

	public void setListaCanciones(ArrayList<ListaCanciones> listaCanciones) {
		this.listaCanciones = listaCanciones;
	}

}
