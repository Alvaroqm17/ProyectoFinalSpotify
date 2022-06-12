package elemntosvisuales;

import javax.swing.JPanel;

import clases.Cancion;
import pantallas.PantallaActual;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

/**
 * Clase en la que se crea una pantalla con un diseño definido para luego introducirla en la pantalla de canciones y alistarla segun las canciones añadidas a la
 * tabla de la base de datos
 * 
 * @author Alvaro Quiñones Melero
 *
 */

public class ElementoCancionLista extends JPanel{
	private PantallaActual ventana;
	private Cancion cancion;
	
	/**
	 * Constructor de la pantalla que contiene la intefaz grafica con todos sus elementos.
	 * 
	 * @param v que utiliza para inicializar la pantalla y hacer posible la navegacion entre ellas
	 * @param c que se utiliza para introducir el nombre de la playlist.
	 * 
	 */

	public ElementoCancionLista(PantallaActual v, Cancion c) {
		setBackground(Color.BLACK);
		this.ventana=v;
		this.cancion=c;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\iconocancion.jpg"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(this.cancion.getNombre());
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Cascadia Mono", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
	}

}
