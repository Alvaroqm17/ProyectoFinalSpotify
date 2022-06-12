package pantallas;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import clases.Cancion;
import clases.ListaCanciones;
import elemntosvisuales.ElementoCancionesDisponibles;
import exceptions.CancionNoExisteException;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;

/**
 * Clase que permite cerar nuevas playlist y añadir canciones que se encuentren en la base de datos a la lista de canciones de la aplicacion
 * 
 * @author Alvaro Quiñones Melero
 *
 */

public class PantallaCrearPlaylist extends JPanel {

	private PantallaActual ventana;
	private JTextField nombreLista;
	private JTextField buscarCancion;
	
	/**
	 * Constructor de la pantalla que contiene la intefaz grafica con todos sus elementos que permite crear playlist y añadior canciones
	 * 
	 * @param v que utiliza para inicializar la pantalla y hacer posible la navegacion entre ellas
	 */
	
	public PantallaCrearPlaylist(PantallaActual v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.BLACK);
		add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Fantasy Music");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelNorte.add(lblNewLabel, BorderLayout.NORTH);

		JLabel lblNewLabel_1 = new JLabel("Crea tu playlist!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Cascadia Mono", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		panelNorte.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_4 = new JLabel("Canciones Disponibles!");
		lblNewLabel_4.setFont(new Font("Cascadia Mono", Font.ITALIC, 14));
		lblNewLabel_4.setForeground(Color.WHITE);
		panelNorte.add(lblNewLabel_4, BorderLayout.EAST);

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
		panelCentro.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(51, 147, 112, 17);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.BLACK);
		panelCentro.add(lblNewLabel_2);

		nombreLista = new JTextField();
		nombreLista.setBounds(179, 145, 144, 21);
		nombreLista.setFont(new Font("Cascadia Mono", Font.PLAIN, 12));
		panelCentro.add(nombreLista);
		nombreLista.setColumns(10);

		JButton crearPlayList = new JButton("Crear");
		
		crearPlayList.setBounds(433, 144, 112, 23);
		crearPlayList.setForeground(Color.WHITE);
		crearPlayList.setBackground(Color.BLACK);
		crearPlayList.setFont(new Font("Cascadia Mono", Font.PLAIN, 12));
		panelCentro.add(crearPlayList);
		
		crearPlayList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = nombreLista.getText();
				 try {
					new ListaCanciones(nombre);
					JOptionPane.showMessageDialog(ventana, "Vaya a la libreria para ver la playlist que ha creado!!",
							"Playlist añadadida",JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		JLabel lblNewLabel_3 = new JLabel("Buscar cancion\r\n");
		lblNewLabel_3.setBounds(51, 281, 118, 17);
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setForeground(Color.WHITE);
		panelCentro.add(lblNewLabel_3);

		buscarCancion = new JTextField();
		buscarCancion.setBounds(179, 280, 144, 20);
		panelCentro.add(buscarCancion);
		buscarCancion.setColumns(10);

		JButton añadirCancion = new JButton("A\u00F1adira a tu lista de canciones");
		añadirCancion.setBounds(366, 279, 245, 23);
		añadirCancion.setFont(new Font("Cascadia Mono", Font.PLAIN, 11));
		añadirCancion.setForeground(Color.WHITE);
		añadirCancion.setBackground(Color.BLACK);
		panelCentro.add(añadirCancion);
		añadirCancion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cancion = buscarCancion.getText().toUpperCase();
				
					try {
						 Cancion c =new Cancion(cancion);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CancionNoExisteException e1) {
						JOptionPane.showMessageDialog(ventana,
								"Esta cancion no esta dispo0n",
								"Error",
								JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
				
			}
		});
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(631, 11, 159, 423);
		panelCentro.add(scrollPane);
		
		JPanel listaCancionesDisponibles = new JPanel();
		listaCancionesDisponibles.setBackground(Color.BLACK);
		listaCancionesDisponibles.setForeground(Color.WHITE);
		scrollPane.setViewportView(listaCancionesDisponibles);
		listaCancionesDisponibles.setLayout(new BoxLayout(listaCancionesDisponibles, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_5 = new JLabel("Si no a\u00F1ade una de las canciones que aparece en la lista de la derecha no se a\u00F1adira");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Arial Black", Font.ITALIC, 11));
		lblNewLabel_5.setBounds(85, 350, 548, 14);
		panelCentro.add(lblNewLabel_5);
		ArrayList<Cancion> todos=Cancion.getTodas();
		for(int i=0;i<todos.size();i++) {
			listaCancionesDisponibles.add(new ElementoCancionesDisponibles(ventana,todos.get(i)));
		}

	}
}
