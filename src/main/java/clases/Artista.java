package clases;

public class Artista extends Usuario{

	public Artista(String nombre, String contraseña) {
		super(nombre, contraseña);
		// TODO Auto-generated constructor stub
	}

	private Biblioteca discografia;

	public Biblioteca getDiscografia() {
		return discografia;
	}

	public void setDiscografia(Biblioteca discografia) {
		this.discografia = discografia;
	}

}
