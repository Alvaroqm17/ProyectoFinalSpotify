package pantallas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class PantallaLibreria extends JPanel {
	private PantallaActual ventana;
	public PantallaLibreria(PantallaActual v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.BLACK);
		add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Fantasy Music");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		panelNorte.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Libreria");
		lblNewLabel_1.setFont(new Font("Cascadia Mono", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelNorte.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JPanel panelWest = new JPanel();
		panelWest.setBackground(Color.BLACK);
		add(panelWest, BorderLayout.WEST);
		panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_2 = new JLabel("Playlists\u2192");
		lblNewLabel_2.setFont(new Font("Cascadia Mono", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelWest.add(lblNewLabel_2);
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(Color.BLACK);
		add(panelSur, BorderLayout.SOUTH);
		GridBagLayout gbl_panelSur = new GridBagLayout();
		gbl_panelSur.columnWidths = new int[]{81, 0};
		gbl_panelSur.rowHeights = new int[]{21, 0};
		gbl_panelSur.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelSur.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelSur.setLayout(gbl_panelSur);
		
		JButton volverAtras = new JButton("<");
		volverAtras.setForeground(Color.BLACK);
		volverAtras.setBackground(Color.WHITE);
		volverAtras.setFont(new Font("Cascadia Mono", Font.PLAIN, 10));
		GridBagConstraints gbc_volverAtras = new GridBagConstraints();
		gbc_volverAtras.fill = GridBagConstraints.HORIZONTAL;
		gbc_volverAtras.gridx = 0;
		gbc_volverAtras.gridy = 0;
		panelSur.add(volverAtras, gbc_volverAtras);
		volverAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("atras");
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		
		
	}

}
