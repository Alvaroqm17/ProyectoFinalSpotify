package pantallas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import elemntosvisuales.BotonLista;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

/**
 * Clase con interfaz grafica en la que se empieza tras hacer el login y es el punto de navegaciuon de la app, tambien permite el uso de la musica
 * @author Alvaro Quiñones Melero
 *
 */

public class PantallaInicial extends JPanel {
	private PantallaActual ventana;
	private AudioInputStream audioInputStream;
	private Clip clipMoey1;
	private Clip clipMoey2;
	private Clip clipMoey3;
	private Clip clipJoji1;
	private Clip clipJoji2;
	private Clip clipJoji3;
	
	/**
	 * Constructor de la pantalla que contiene la intefaz grafica con tods sus elementos asi como los botones de navegacion y de reproduccion y pausa para las canciones
	 * 
	 * @param v que utiliza para inicializar la pantalla y hacer posible la navegacion entre ellas
	 */


	public PantallaInicial(PantallaActual v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JPanel panelSur = new JPanel();
		panelSur.setBackground(Color.BLACK);
		add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new BorderLayout(0, 0));

		JPanel panelWest = new JPanel();
		panelWest.setBackground(Color.BLACK);
		add(panelWest, BorderLayout.WEST);

		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.BLACK);
		add(panelNorte, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Fanstasy Music");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		panelNorte.add(lblNewLabel);
		GridBagLayout gbl_panelWest = new GridBagLayout();
		gbl_panelWest.columnWidths = new int[] { 104, 0 };
		gbl_panelWest.rowHeights = new int[] { 25, 25, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelWest.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelWest.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelWest.setLayout(gbl_panelWest);

		JButton crearPlayList = new JButton("+ Playlist");
		crearPlayList.setForeground(new Color(255, 255, 255));
		crearPlayList.setFont(new Font("Cascadia Mono", Font.PLAIN, 14));
		crearPlayList.setBackground(new Color(0, 0, 0));
		GridBagConstraints gbc_crearPlayList = new GridBagConstraints();
		gbc_crearPlayList.fill = GridBagConstraints.HORIZONTAL;
		gbc_crearPlayList.insets = new Insets(0, 0, 5, 0);
		gbc_crearPlayList.gridx = 0;
		gbc_crearPlayList.gridy = 0;
		panelWest.add(crearPlayList, gbc_crearPlayList);
		crearPlayList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("crear");
			}
		});

		JButton irALibreria = new BotonLista("Libreria");
		GridBagConstraints gbc_irALibreria = new GridBagConstraints();
		gbc_irALibreria.insets = new Insets(0, 0, 5, 0);
		gbc_irALibreria.fill = GridBagConstraints.HORIZONTAL;
		gbc_irALibreria.gridx = 0;
		gbc_irALibreria.gridy = 1;
		panelWest.add(irALibreria, gbc_irALibreria);
		
		BotonLista irAMisCanciones = new BotonLista("Libreria");
		irAMisCanciones.setText("Mis canciones");
		GridBagConstraints gbc_irAMisCanciones = new GridBagConstraints();
		gbc_irAMisCanciones.insets = new Insets(0, 0, 5, 0);
		gbc_irAMisCanciones.gridx = 0;
		gbc_irAMisCanciones.gridy = 2;
		panelWest.add(irAMisCanciones, gbc_irAMisCanciones);
		irAMisCanciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("miscanciones");
			}
		});

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		scrollPane.setColumnHeaderView(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("Artista destacado!");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Cascadia Mono", Font.PLAIN, 17));
		panel_1.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(null);

		JLabel letrasMoey = new JLabel("MOAY");
		letrasMoey.setBounds(303, 26, 55, 23);
		letrasMoey.setFont(new Font("MV Boli", Font.BOLD, 14));
		letrasMoey.setForeground(Color.WHITE);
		panel_2.add(letrasMoey);
		irALibreria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("libreria");
			}
		});

		JButton moey1Pausa = new JButton("||");
		moey1Pausa.setBounds(17, 75, 41, 23);
		panel_2.add(moey1Pausa);
		moey1Pausa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				clipMoey1.stop();
				System.out.println("aa");
			}

		});

		JButton moey2Pausa = new JButton("||");
		moey2Pausa.setBounds(252, 75, 41, 23);
		panel_2.add(moey2Pausa);
		moey2Pausa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				clipMoey2.stop();
				System.out.println("aa");
			}

		});

		JButton moey3Pausa = new JButton("||");
		moey3Pausa.setBounds(491, 75, 41, 23);
		panel_2.add(moey3Pausa);
		moey3Pausa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				clipMoey3.stop();
				System.out.println("aa");
			}

		});

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(68, 75, 65, 65);
		lblNewLabel_4.setIcon(new ImageIcon(
				"D:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\cancionagustin.jpg"));
		lblNewLabel_4.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("\r\n");
		lblNewLabel_6.setBounds(303, 75, 69, 64);
		lblNewLabel_6.setIcon(
				new ImageIcon("D:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\monomoey.jpeg"));
		lblNewLabel_6.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_6);

		JLabel lblNewLabel_5 = new JLabel("\r\n");
		lblNewLabel_5.setBounds(542, 75, 69, 65);
		lblNewLabel_5.setIcon(new ImageIcon(
				"D:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\mu\u00F1ecomoey.jpeg"));
		lblNewLabel_5.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_5);

		JButton moey1Play = new JButton("\u25B6\uFE0E");
		moey1Play.setBounds(5, 109, 53, 23);
		panel_2.add(moey1Play);
		moey1Play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					audioInputStream = AudioSystem.getAudioInputStream(new File("./sonidos/backcar.wav"));
					clipMoey1 = AudioSystem.getClip();
					clipMoey1.open(audioInputStream);
					clipMoey1.start();
					System.out.println("aa");

				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		JButton moey2Play = new JButton("\u25B6\uFE0E");
		moey2Play.setBounds(240, 109, 53, 23);
		panel_2.add(moey2Play);
		moey2Play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					audioInputStream = AudioSystem.getAudioInputStream(new File("./sonidos/nukisashi.wav"));
					clipMoey2 = AudioSystem.getClip();
					clipMoey2.open(audioInputStream);
					clipMoey2.start();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		JButton moey3Play = new JButton("\u25B6\uFE0E");
		moey3Play.setBounds(479, 109, 53, 23);
		panel_2.add(moey3Play);
		moey3Play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					audioInputStream = AudioSystem.getAudioInputStream(new File("./sonidos/inmuneme.wav"));
					clipMoey3 = AudioSystem.getClip();
					clipMoey3.open(audioInputStream);
					clipMoey3.start();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		JLabel letrasJoji = new JLabel("Joji");
		letrasJoji.setBounds(313, 203, 33, 23);
		letrasJoji.setFont(new Font("MV Boli", Font.BOLD, 14));
		letrasJoji.setForeground(Color.WHITE);
		panel_2.add(letrasJoji);

		JButton jojiPlay1 = new JButton("\u25B6\uFE0E");
		jojiPlay1.setBounds(5, 287, 53, 23);
		panel_2.add(jojiPlay1);
		jojiPlay1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					audioInputStream = AudioSystem.getAudioInputStream(new File("./sonidos/ew.wav"));
					clipJoji1 = AudioSystem.getClip();
					clipJoji1.open(audioInputStream);
					clipJoji1.start();
					System.out.println("aa");

				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		JButton jojiPlay2 = new JButton("\u25B6\uFE0E");
		jojiPlay2.setBounds(240, 287, 53, 23);
		panel_2.add(jojiPlay2);
		jojiPlay2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					audioInputStream = AudioSystem.getAudioInputStream(new File("./sonidos/willhe.wav"));
					clipJoji2 = AudioSystem.getClip();
					clipJoji2.open(audioInputStream);
					clipJoji2.start();
					System.out.println("aa");

				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		

		JButton jojiPlay3 = new JButton("\u25B6\uFE0E");
		jojiPlay3.setBounds(479, 287, 53, 23);
		panel_2.add(jojiPlay3);
		jojiPlay3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					audioInputStream = AudioSystem.getAudioInputStream(new File("./sonidos/wantedu.wav"));
					clipJoji3 = AudioSystem.getClip();
					clipJoji3.open(audioInputStream);
					clipJoji3.start();
					System.out.println("aa");

				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(68, 245, 65, 65);
		lblNewLabel_7.setIcon(new ImageIcon(
				"D:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\jojiwillhe.jpg"));
		lblNewLabel_7.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("\r\n");
		lblNewLabel_8.setBounds(303, 245, 69, 65);
		lblNewLabel_8.setIcon(new ImageIcon(
				"D:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\jojinectar.jpg"));
		lblNewLabel_8.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("\r\n");
		lblNewLabel_9.setBounds(542, 245, 69, 65);
		lblNewLabel_9.setIcon(new ImageIcon(
				"D:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\jojiballads.jpg"));
		lblNewLabel_9.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_9);

		JButton pausaJoji1 = new JButton("||");
		pausaJoji1.setBounds(17, 245, 41, 23);
		panel_2.add(pausaJoji1);
		pausaJoji1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				clipJoji1.stop();
				System.out.println("aa");
			}

		});


		JButton pausaJoji2 = new JButton("||");
		pausaJoji2.setBounds(252, 245, 41, 23);
		panel_2.add(pausaJoji2);
		pausaJoji2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				clipJoji2.stop();
				System.out.println("aa");
			}

		});


		JButton pausaJoji3 = new JButton("||");
		pausaJoji3.setBounds(491, 245, 41, 23);
		panel_2.add(pausaJoji3);
		pausaJoji3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				clipJoji3.stop();
				System.out.println("aa");
			}

		});

		
		JLabel lblNewLabel_2 = new JLabel("In the back of my car");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(50, 151, 116, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nukisashi naranu");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(303, 150, 80, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_10 = new JLabel("Inmune to me");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_10.setBounds(542, 151, 65, 14);
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Will he");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_11.setBounds(87, 321, 46, 14);
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Ew");
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_12.setBounds(325, 321, 33, 14);
		panel_2.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Wanted u");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setBounds(552, 321, 46, 14);
		panel_2.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Puedes reproducir las canciones que quieras simultaneamente!!!");
		lblNewLabel_14.setBackground(Color.BLACK);
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setFont(new Font("Microsoft YaHei Light", Font.ITALIC, 12));
		lblNewLabel_14.setBounds(162, 357, 370, 14);
		panel_2.add(lblNewLabel_14);
		irALibreria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("libreria");
			}
		});
	}
}
