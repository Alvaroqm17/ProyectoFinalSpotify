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

public class PantallaInicial extends JPanel {
	private PantallaActual ventana;
	private AudioInputStream audioInputStream;
	private Clip clipMoey1;
	private Clip clipMoey2;
	private Clip clipMoey3;

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

		JLabel letrasMoey = new JLabel("MOEY");
		letrasMoey.setBounds(317, 30, 41, 23);
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
		moey1Pausa.setBounds(17, 86, 41, 23);
		panel_2.add(moey1Pausa);
		moey1Pausa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				clipMoey1.stop();
				System.out.println("aa");
			}

		});

		JButton moey2Pausa = new JButton("||");
		moey2Pausa.setBounds(252, 86, 41, 23);
		panel_2.add(moey2Pausa);
		moey2Pausa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				clipMoey2.stop();
				System.out.println("aa");
			}

		});

		JButton moey3Pausa = new JButton("||");
		moey3Pausa.setBounds(491, 86, 41, 23);
		panel_2.add(moey3Pausa);
		moey3Pausa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				clipMoey3.stop();
				System.out.println("aa");
			}

		});

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(68, 86, 65, 65);
		lblNewLabel_4.setIcon(new ImageIcon(
				"D:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\cancionagustin.jpg"));
		lblNewLabel_4.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("\r\n");
		lblNewLabel_6.setBounds(303, 86, 69, 64);
		lblNewLabel_6.setIcon(
				new ImageIcon("D:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\monomoey.jpeg"));
		lblNewLabel_6.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_6);

		JLabel lblNewLabel_5 = new JLabel("\r\n");
		lblNewLabel_5.setBounds(542, 86, 69, 65);
		lblNewLabel_5.setIcon(new ImageIcon(
				"D:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\mu\u00F1ecomoey.jpeg"));
		lblNewLabel_5.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_5);

		JButton moey1Play = new JButton("\u25B6\uFE0E");
		moey1Play.setBounds(10, 129, 53, 23);
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
		moey2Play.setBounds(240, 129, 53, 23);
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
		moey3Play.setBounds(479, 129, 53, 23);
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
		letrasJoji.setBounds(325, 214, 25, 23);
		letrasJoji.setFont(new Font("MV Boli", Font.BOLD, 14));
		letrasJoji.setForeground(Color.WHITE);
		panel_2.add(letrasJoji);

		JButton btnNewButton_1 = new JButton("\u25B6\uFE0E");
		btnNewButton_1.setBounds(10, 321, 53, 23);
		panel_2.add(btnNewButton_1);

		JButton btnNewButton_4 = new JButton("\u25B6\uFE0E");
		btnNewButton_4.setBounds(240, 321, 53, 23);
		panel_2.add(btnNewButton_4);

		JButton btnNewButton_4_1 = new JButton("\u25B6\uFE0E");
		btnNewButton_4_1.setBounds(479, 321, 53, 23);
		panel_2.add(btnNewButton_4_1);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(68, 287, 65, 65);
		lblNewLabel_7.setIcon(new ImageIcon(
				"D:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\jojiwillhe.jpg"));
		lblNewLabel_7.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("\r\n");
		lblNewLabel_8.setBounds(303, 287, 69, 65);
		lblNewLabel_8.setIcon(new ImageIcon(
				"D:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\jojinectar.jpg"));
		lblNewLabel_8.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("\r\n");
		lblNewLabel_9.setBounds(542, 287, 69, 65);
		lblNewLabel_9.setIcon(new ImageIcon(
				"D:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\jojiballads.jpg"));
		lblNewLabel_9.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_9);

		JButton btnNewButton_6_3 = new JButton("||");
		btnNewButton_6_3.setBounds(17, 287, 41, 23);
		panel_2.add(btnNewButton_6_3);

		JButton btnNewButton_6_4 = new JButton("||");
		btnNewButton_6_4.setBounds(252, 287, 41, 23);
		panel_2.add(btnNewButton_6_4);

		JButton btnNewButton_6_5 = new JButton("||");
		btnNewButton_6_5.setBounds(491, 287, 41, 23);
		panel_2.add(btnNewButton_6_5);
		irALibreria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("libreria");
			}
		});
	}
}
