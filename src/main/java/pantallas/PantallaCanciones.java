package pantallas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import clases.Cancion;
import elemntosvisuales.ElementoCancionLista;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;

/**
 * Clase que muestra una lista con las canciones que se han añadido desde la pantalla CrearPlaylist
 * 
 * @author Alvaro Quiñones Melero
 *
 */

public class PantallaCanciones extends JPanel {
	private PantallaActual ventana;
	
	/**
	 * Constructor de la pantalla que contiene la intefaz grafica con tods sus elementos y un arrayList de la tabla canciones_añadidas de la base de datos
	 * 
	 * @param v que utiliza para inicializar la pantalla y hacer posible la navegacion entre ellas
	 */

	public PantallaCanciones(PantallaActual v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("Fantasy Music");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 24));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setForeground(Color.WHITE);
		add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JLabel lblNewLabel_1 = new JLabel("Tus canciones\u2192");
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Cascadia Mono", Font.ITALIC, 13));
		panel_1.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 112, 0 };
		gbl_panel_2.rowHeights = new int[] { 21, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JButton irAtras = new JButton("<");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_2.add(irAtras, gbc_btnNewButton);
		irAtras.setFont(new Font("Cascadia Mono", Font.PLAIN, 9));
		irAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("atras");
			}
		});

		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		JPanel listaCanciones = new JPanel();
		scrollPane.setViewportView(listaCanciones);
		listaCanciones.setLayout(new BoxLayout(listaCanciones, BoxLayout.Y_AXIS));
		
		ArrayList<Cancion> todos=Cancion.getTodos();
		for(int i=0;i<todos.size();i++) {
			listaCanciones.add(new ElementoCancionLista(ventana,todos.get(i)));
		}
	}

}
