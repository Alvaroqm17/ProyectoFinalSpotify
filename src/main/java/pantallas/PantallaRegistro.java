package pantallas;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.SwingConstants;
import clases.Usuario;
import exceptions.ContraseñaIncorrectaException;
import exceptions.EmailIncorrectoException;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Canvas;

/**
 * Clase que registra un nuevo usuario insertandolo en la base de datos haciendo asi posible su login.
 * 
 * @author Alvaro Quiñones Melero
 *
 */
public class PantallaRegistro extends JPanel {
	private PantallaActual ventana;
	private JTextField usuarioRegistro;
	private JTextField emailRegistro;
	private JPasswordField contraseñaRegistro;
	
	/**
	 * Constructor de la pantalla que contiene la intefaz grafica con tods sus elementos y hace posible el login de usuarios ya registrados
	 * 
	 * @param v que utiliza para inicializar la pantalla y hacer posible el registro de nuevos usuarios
	 */

	public PantallaRegistro(PantallaActual v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Fantasy Music");
		lblNewLabel.setFont(new Font("Cascadia Mono", Font.ITALIC, 24));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Registrate");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(296, 47, 188, 31);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(
				"D:\\Programacion\\ProyectoFinalSpotify\\ProyectoFinalSpotify\\imagenes\\iconousuario.jpg"));
		lblNewLabel_2.setBounds(350, 77, 90, 68);
		panel_1.add(lblNewLabel_2);

		usuarioRegistro = new JTextField();
		usuarioRegistro.setBounds(400, 198, 134, 20);
		panel_1.add(usuarioRegistro);
		usuarioRegistro.setColumns(10);

		emailRegistro = new JTextField();
		emailRegistro.setBounds(398, 241, 136, 20);
		panel_1.add(emailRegistro);
		emailRegistro.setColumns(10);

		JLabel usuario = new JLabel("Usuario");
		usuario.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		usuario.setForeground(Color.WHITE);
		usuario.setBounds(261, 199, 75, 14);
		panel_1.add(usuario);

		JLabel email = new JLabel("Email");
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		email.setBounds(261, 244, 75, 14);
		panel_1.add(email);

		JLabel contraseña = new JLabel("Contrase\u00F1a");
		contraseña.setForeground(Color.WHITE);
		contraseña.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contraseña.setBounds(261, 288, 75, 14);
		panel_1.add(contraseña);

		JButton boronCrearUsuario = new JButton("Crear Usuario");
		boronCrearUsuario.setBounds(326, 367, 134, 23);
		panel_1.add(boronCrearUsuario);

		contraseñaRegistro = new JPasswordField();
		contraseñaRegistro.setBounds(400, 287, 134, 20);
		contraseñaRegistro.setEchoChar('*');
		panel_1.add(contraseñaRegistro);
		
		JButton volverAtras = new JButton("<");
		volverAtras.setFont(new Font("Cascadia Mono", Font.PLAIN, 10));
		volverAtras.setBounds(0, 400, 42, 20);
		panel_1.add(volverAtras);
		volverAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("pantallaLogin");
			}
		});
		
		boronCrearUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String email = emailRegistro.getText();
				String nombre = usuarioRegistro.getText();
				String contraseña = new String(contraseñaRegistro.getPassword());

				try {
				 Usuario u = new Usuario(nombre, contraseña, email);
				 if(u!=null) {
					 JOptionPane.showMessageDialog(ventana, "Registro completado con exito",
								"Registro completado",JOptionPane.PLAIN_MESSAGE);
						ventana.cambiarAPantalla("pantallaLogin"); 
				 }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ContraseñaIncorrectaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (EmailIncorrectoException e1) {
					JOptionPane.showMessageDialog(ventana,
							"El email introducido no es valido. Recuerde usar @",
							"Error",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}			
			}

		});
	}
}
