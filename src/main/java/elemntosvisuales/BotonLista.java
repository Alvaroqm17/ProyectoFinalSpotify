package elemntosvisuales;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

/**
 * Clase en la que se crea un boton con un diseño definido para luego usarlo al inicializar un boton y darle valores por defecto usado en la pantalla inicial
 * para navegar por las pantallas de la app.
 * 
 * @author Alvaro Quiñones Melero
 *
 */

public class BotonLista extends JButton {
	
	/**
	 * Constructor de la pantalla que contiene la intefaz grafica con todos sus elementos.
	 * 
	 * @param m que utiliza para pasar el nombre que queremos que aparezca en el boton desde la interfaz.
	 * 
	 */
	
	public BotonLista(String m) {
		super(m);
		estiloPorDefecto();
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(0, 0, 0));
				setFont(new Font("Cascadia Mono", Font.PLAIN, 14));
				setSize(152, 37);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				estiloPorDefecto();
			}
		});
	}

	private void estiloPorDefecto() {
		this.setBackground(new Color(0, 0, 0));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setFont(new Font("Cascadia Mono", Font.PLAIN, 14));
		this.setForeground(new Color(255, 255, 255));
		setSize(152, 37);
	}

}
