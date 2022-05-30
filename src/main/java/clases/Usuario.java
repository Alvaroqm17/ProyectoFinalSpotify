package clases;

public class Usuario extends ObjetoConNombre {

	private ListaCanciones playList;
	private Boolean espremium;
	private String contraseña;
	private Biblioteca biblioteca;
	
	

	public ListaCanciones getPlayList() {
		return playList;
	}

	public void setPlayList(ListaCanciones playList) {
		this.playList = playList;
	}

	public Boolean getEspremium() {
		return espremium;
	}

	public void setEspremium(Boolean espremium) {
		this.espremium = espremium;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

}
