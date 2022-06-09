package pantallas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import elemntosvisuales.BotonLista;
import elemntosvisuales.ElementoMusica;
import interfaz.ImplementarSonido;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;

public class PantallaInicial extends JPanel implements ImplementarSonido {
	private PantallaActual ventana;
	private AudioInputStream audioInputStream;
	private Clip clip;

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

		JLabel lblNewLabel_1 = new JLabel("Artista destacado!");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Cascadia Mono", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_2.add(panel_3, BorderLayout.NORTH);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_2.add(panel_4, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		JLabel lblNewLabel_2 = new JLabel("MOEY");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 0;
		panel_4.add(lblNewLabel_2, gbc_lblNewLabel_2);
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 12));
		lblNewLabel_2.setForeground(Color.WHITE);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBackground(Color.BLACK);
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 4;
		gbc_lblNewLabel_6.gridy = 1;
		panel_4.add(lblNewLabel_6, gbc_lblNewLabel_6);

		JButton moey1 = new JButton("\u25B6");
		moey1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					audioInputStream = AudioSystem.getAudioInputStream(new File("./sonidos/backcar.wav"));
					clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
					System.out.println("aa");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		JButton botonpausa = new JButton("||");
		GridBagConstraints gbc_botonpausa = new GridBagConstraints();
		gbc_botonpausa.insets = new Insets(0, 0, 5, 5);
		gbc_botonpausa.gridx = 1;
		gbc_botonpausa.gridy = 5;
		panel_4.add(botonpausa, gbc_botonpausa);
		botonpausa.addMouseListener(new MouseAdapter() {
			@Override
		public void mouseClicked(MouseEvent e) {

				clip.stop();
				System.out.println("aa");
			}

		});

		GridBagConstraints gbc_moey1 = new GridBagConstraints();
		gbc_moey1.insets = new Insets(0, 0, 5, 5);
		gbc_moey1.gridx = 1;
		gbc_moey1.gridy = 3;
		panel_4.add(moey1, gbc_moey1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(
				"E:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\cancionagustin.jpg"));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 4;
		panel_4.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\quino\\Downloads\\WhatsApp Image 2022-06-08 at 11. (1).jpg"));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 4;
		panel_4.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\quino\\Downloads\\WhatsApp Image 2022-06-08 at 11..jpg"));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 6;
		gbc_lblNewLabel_5.gridy = 4;
		panel_4.add(lblNewLabel_5, gbc_lblNewLabel_5);

		JButton moey2 = new JButton("\u25B6");
		GridBagConstraints gbc_moey2 = new GridBagConstraints();
		gbc_moey2.insets = new Insets(0, 0, 5, 5);
		gbc_moey2.gridx = 4;
		gbc_moey2.gridy = 5;
		panel_4.add(moey2, gbc_moey2);

		JButton moey3 = new JButton("\u25B6");
		moey3.setForeground(Color.BLACK);
		GridBagConstraints gbc_moey3 = new GridBagConstraints();
		gbc_moey3.insets = new Insets(0, 0, 5, 0);
		gbc_moey3.gridx = 6;
		gbc_moey3.gridy = 5;
		panel_4.add(moey3, gbc_moey3);

		JLabel lblNewLabel_7 = new JLabel("Joji");
		lblNewLabel_7.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblNewLabel_7.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 4;
		gbc_lblNewLabel_7.gridy = 8;
		panel_4.add(lblNewLabel_7, gbc_lblNewLabel_7);

		JButton btnNewButton_3 = new JButton("\u25B6");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 10;
		panel_4.add(btnNewButton_3, gbc_btnNewButton_3);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(
				"E:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\jojiwillhe.jpg"));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 2;
		gbc_lblNewLabel_8.gridy = 11;
		panel_4.add(lblNewLabel_8, gbc_lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(
				"E:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\jojiballads.jpg"));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 4;
		gbc_lblNewLabel_9.gridy = 11;
		panel_4.add(lblNewLabel_9, gbc_lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(
				"E:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\jojinectar.jpg"));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_10.gridx = 6;
		gbc_lblNewLabel_10.gridy = 11;
		panel_4.add(lblNewLabel_10, gbc_lblNewLabel_10);

		JButton btnNewButton = new JButton("");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 12;
		panel_4.add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_4 = new JButton("\u25B6");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 4;
		gbc_btnNewButton_4.gridy = 13;
		panel_4.add(btnNewButton_4, gbc_btnNewButton_4);

		JButton btnNewButton_5 = new JButton("\u25B6");
		btnNewButton_5.setBackground(new Color(240, 240, 240));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 6;
		gbc_btnNewButton_5.gridy = 13;
		panel_4.add(btnNewButton_5, gbc_btnNewButton_5);
		irALibreria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("libreria");
			}
		});
	}
}
