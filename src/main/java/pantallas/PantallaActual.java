package pantallas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Usuario;

public class PantallaActual extends JFrame {
	private JPanel pantallaActual;
	protected Usuario usuarioLogado;

	public PantallaActual() {
		this.setSize(800, 500);
		this.setLocationRelativeTo(null); // Te pone la ventana en el centro de la pantalla
		this.setIconImage(new ImageIcon("./imagenes/iconoprograma.jpg").getImage());
		this.setTitle("Fantasy Music");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pantallaActual = new PantallaLogin(this);
		this.setContentPane(pantallaActual);
		this.setVisible(true);
	}

	public void cambiarAPantalla(String nombrePantalla) {
		// Primero la ponemos invisible y la eliminamos
		this.pantallaActual.setVisible(false);
		this.pantallaActual = null;

		switch (nombrePantalla) {
		case "pantallaLogin":
			this.pantallaActual = new PantallaLogin(this);
			break;
		case "registro":
			this.pantallaActual = new PantallaRegistro(this);
			break;
		case "pantallaInicial":
			this.pantallaActual = new PantallaInicial(this);
			break;
		case "libreria":
			this.pantallaActual = new PantallaLibreria(this);
			break;
		case "atras":
			this.pantallaActual = new PantallaInicial(this);
			break;
		case "crear":
			this.pantallaActual = new PantallaCrearPlaylist(this);
			break;

		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
	}

}
