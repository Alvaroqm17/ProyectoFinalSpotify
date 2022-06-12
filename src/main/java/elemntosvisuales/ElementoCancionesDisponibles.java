package elemntosvisuales;

import javax.swing.JPanel;
import clases.Cancion;
import pantallas.PantallaActual;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;

/**
 * Clase en la que se crea una pantalla con un diseño definido para luego introducirla en la pantalla de crear playlists y alistar las canciones disponibles
 * 
 * @author Alvaro Quiñones Melero
 *
 */

public class ElementoCancionesDisponibles extends JPanel {
	private PantallaActual ventana;
	private Cancion cancion;
	
	/**
	 * Constructor de la pantalla que contiene la intefaz grafica con todos sus elementos.
	 * 
	 * @param v que utiliza para inicializar la pantalla y hacer posible la navegacion entre ellas
	 * @param c que se utiliza para introducir el nombre de la cancion.
	 * 
	 */
	
	public ElementoCancionesDisponibles(PantallaActual v,Cancion c) {
		setBackground(Color.BLACK);
		this.cancion=c;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel(this.cancion.getNombre());
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Cascadia Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 7;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
	}
	

}
