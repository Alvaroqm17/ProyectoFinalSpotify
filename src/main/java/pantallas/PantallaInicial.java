package pantallas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import elemntosvisuales.BotonLista;
import elemntosvisuales.ElementoMusica;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInicial extends JPanel {
	private PantallaActual ventana;
	public PantallaInicial(PantallaActual v) {
		this.ventana=v;
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
		lblNewLabel.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 24));
		panelNorte.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));
		
		JButton crearPlayList = new JButton("+ Playlist");
		crearPlayList.setForeground(new Color(255, 255, 255));
		crearPlayList.setFont(new Font("Cascadia Mono", Font.PLAIN, 14));
		crearPlayList.setBackground(new Color(0, 0, 0));
		panelWest.add(crearPlayList);
		
		JButton irALibreria = new BotonLista("Libreria");
		panelWest.add(irALibreria);
		irALibreria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("libreria");
			}
		});
		
		
		
		
	}
}
