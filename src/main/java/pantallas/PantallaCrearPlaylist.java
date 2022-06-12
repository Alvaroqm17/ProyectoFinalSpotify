package pantallas;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
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
import elemntosvisuales.ElementoPlayList;
import exceptions.CancionNoExisteException;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
							"Playlist aņadadida",JOptionPane.PLAIN_MESSAGE);
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

		JButton aņadirCancion = new JButton("A\u00F1adira a tu lista de canciones");
		aņadirCancion.setBounds(366, 279, 245, 23);
		aņadirCancion.setFont(new Font("Cascadia Mono", Font.PLAIN, 11));
		aņadirCancion.setForeground(Color.WHITE);
		aņadirCancion.setBackground(Color.BLACK);
		panelCentro.add(aņadirCancion);
		aņadirCancion.addMouseListener(new MouseAdapter() {
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
		ArrayList<Cancion> todos=Cancion.getTodas();
		for(int i=0;i<todos.size();i++) {
			listaCancionesDisponibles.add(new ElementoCancionesDisponibles(ventana,todos.get(i)));
		}

	}
}
