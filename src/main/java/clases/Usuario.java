package clases;

public class Usuario extends ObjetoConNombre {

	private ListaCanciones playList;
	private Boolean espremium;
	private String contrase�a;
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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

}
