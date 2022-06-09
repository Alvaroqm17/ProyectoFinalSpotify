package pantallas;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import clases.ListaCanciones;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaCrearPlaylist extends JPanel {

	private PantallaActual ventana;
	private JTextField nombreLista;
	private JTextField buscarCancion;

	public PantallaCrearPlaylist(PantallaActual v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.BLACK);
		add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Fantasy Music");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelNorte.add(lblNewLabel, BorderLayout.NORTH);

		JLabel lblNewLabel_1 = new JLabel("Crea tu playlist!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Cascadia Mono", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		panelNorte.add(lblNewLabel_1, BorderLayout.SOUTH);

		JPanel panelWest = new JPanel();
		panelWest.setBackground(Color.BLACK);
		add(panelWest, BorderLayout.WEST);

		JPanel panelSur = new JPanel();
		panelSur.setBackground(Color.BLACK);
		add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new BoxLayout(panelSur, BoxLayout.X_AXIS));

		JButton volverAtras = new JButton("<");
		volverAtras.setFont(new Font("Cascadia Mono", Font.PLAIN, 10));
		panelSur.add(volverAtras);
		volverAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("atras");
			}
		});

		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(Color.BLACK);
		add(panelCentro, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentro = new GridBagLayout();
		gbl_panelCentro.columnWidths = new int[] { 0, 23, 82, 23, 73, 0, 54, 0 };
		gbl_panelCentro.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelCentro.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelCentro.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelCentro.setLayout(gbl_panelCentro);

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Cascadia Mono", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.BLACK);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 1;
		panelCentro.add(lblNewLabel_2, gbc_lblNewLabel_2);

		nombreLista = new JTextField();
		nombreLista.setFont(new Font("Cascadia Mono", Font.PLAIN, 12));
		GridBagConstraints gbc_nombreLista = new GridBagConstraints();
		gbc_nombreLista.insets = new Insets(0, 0, 5, 5);
		gbc_nombreLista.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreLista.gridx = 4;
		gbc_nombreLista.gridy = 1;
		panelCentro.add(nombreLista, gbc_nombreLista);
		nombreLista.setColumns(10);

		JButton crearPlayList = new JButton("Crear");
		crearPlayList.setForeground(Color.WHITE);
		crearPlayList.setBackground(Color.BLACK);
		crearPlayList.setFont(new Font("Cascadia Mono", Font.PLAIN, 12));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 1;
		panelCentro.add(crearPlayList, gbc_btnNewButton);
		
		crearPlayList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = nombreLista.getText();
				 try {
					new ListaCanciones(nombre);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		JLabel lblNewLabel_3 = new JLabel("Buscar cancion\r\n");
		lblNewLabel_3.setFont(new Font("Cascadia Mono", Font.PLAIN, 14));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 3;
		panelCentro.add(lblNewLabel_3, gbc_lblNewLabel_3);

		buscarCancion = new JTextField();
		GridBagConstraints gbc_buscarCancion = new GridBagConstraints();
		gbc_buscarCancion.insets = new Insets(0, 0, 5, 5);
		gbc_buscarCancion.fill = GridBagConstraints.HORIZONTAL;
		gbc_buscarCancion.gridx = 4;
		gbc_buscarCancion.gridy = 3;
		panelCentro.add(buscarCancion, gbc_buscarCancion);
		buscarCancion.setColumns(10);

		JButton añadirCancion = new JButton("A\u00F1adir");
		añadirCancion.setFont(new Font("Cascadia Mono", Font.PLAIN, 12));
		añadirCancion.setForeground(Color.WHITE);
		añadirCancion.setBackground(Color.BLACK);
		GridBagConstraints gbc_añadirCancion = new GridBagConstraints();
		gbc_añadirCancion.insets = new Insets(0, 0, 5, 5);
		gbc_añadirCancion.gridx = 5;
		gbc_añadirCancion.gridy = 3;
		panelCentro.add(añadirCancion, gbc_añadirCancion);

	}

}
