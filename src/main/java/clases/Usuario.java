package clases;

public class Usuario extends ObjetoConNombre {
	
	private ListaCanciones playList;
	private Biblioteca biblioteca;
	private String contrase�a;
	
	

	public Usuario(String nombre, String contrase�a) {
		// TODO Auto-generated constructor stub
	}

	public ListaCanciones getPlayList() {
		return playList;
	}

	public void setPlayList(ListaCanciones playList) {
		this.playList = playList;
	}


	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

}
