package pantallas;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Font;
import clases.Usuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class PantallaLogin extends JPanel {
	private PantallaActual ventana;
	private JTextField campoUsuario;
	private JPasswordField campoContraseña;

	public PantallaLogin(PantallaActual v) {
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		this.ventana = v;
		this.setLayout(null);

		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		labelUsuario.setForeground(Color.WHITE);
		labelUsuario.setBounds(249, 219, 101, 14);
		this.add(labelUsuario);

		JLabel labelContraseña = new JLabel("Contraseña");
		labelContraseña.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		labelContraseña.setForeground(Color.WHITE);
		labelContraseña.setBounds(249, 270, 101, 14);
		add(labelContraseña);

		JButton botonLogin = new JButton("Iniciar");
		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = campoUsuario.getText();
				String contraseña = new String(campoContraseña.getPassword());

				Usuario u = new Usuario(nombre, contraseña);
			}
		});
		botonLogin.setToolTipText("Inicia Sesión, cermuzo");
		botonLogin.setBounds(330, 329, 112, 23);
		add(botonLogin);

		JButton botonRegistro = new JButton("Registrarme");
		botonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("registro");
			}
		});
		botonRegistro.setBounds(626, 429, 140, 23);
		add(botonRegistro);

		campoUsuario = new JTextField();
		campoUsuario.setBounds(394, 210, 156, 23);
		add(campoUsuario);
		campoUsuario.setColumns(10);

		campoContraseña = new JPasswordField();
		campoContraseña.setEchoChar('$');
		campoContraseña.setBounds(394, 261, 159, 23);
		add(campoContraseña);

		JLabel labelInicioSesion = new JLabel("Iniciar Sesion");
		labelInicioSesion.setForeground(Color.WHITE);
		labelInicioSesion.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		labelInicioSesion.setBounds(314, 89, 159, 23);
		add(labelInicioSesion);

		JLabel lblNewLabel = new JLabel("Fantasy Music");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(207, 34, 358, 44);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(
				"D:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\iconousuario.jpg"));
		lblNewLabel_1.setBounds(330, 124, 80, 49);
		add(lblNewLabel_1);
		
	
	}
	
}
