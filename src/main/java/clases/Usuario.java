package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import exceptions.ContraseñaIncorrectaException;
import exceptions.EmailIncorrectoException;
import exceptions.UsuarioNoExisteException;
import utilDB.UtilDB;


/**
 * DAO de usuario que hace que todas las operaciones CRUD dentro de sus
 * funciones.
 * 
 * @author Alvaro Quiñones Melero
 *
 */
public class Usuario {
	private String nombre;
	private String email;
	private String contraseña;

	 /**

     * Constructor de usuario que permite el registro de un nuevo usuario comprobando las excepciones

     * @param nombre del usuario, la contraseña del usuario, y el email.
     *
     * @exception SQLException, ContraseñaIncorrectaException, EmailIncorrectoException


     */

	public Usuario(String nombre, String contraseña, String email) throws SQLException, ContraseñaIncorrectaException, EmailIncorrectoException {
		super();
		if (contraseña.isBlank()) {
			throw new ContraseñaIncorrectaException("La contraseña no puede estar vacia.");
		}

		if (!this.emailVallido(email)) {
			throw new EmailIncorrectoException("El email tiene que tener @.");
		}

		Statement query = UtilDB.conectarDB();

		if (query.executeUpdate("insert into usuario values('" + nombre + "','" +contraseña + "','" + email+ "')") > 0) {
			this.nombre = nombre;
			this.setEmail(email);
			this.setContraseña(contraseña);

		} else {
			throw new SQLException("No se ha podido insertar el usuario.");
		}
		UtilDB.desconectarBD();
	}
	
	 /**

     * Constructor de usuario que permite el login para acceder a la aplicacion

     * @param nombre del usuario y la contraseña del usuario que han sido previamente registradas.
     *
     * @exception SQLException, ContraseñaIncorrectaException, UsuarioNoExisteException.


     */
	
	public Usuario(String nombre, String contraseña)
			throws SQLException, ContraseñaIncorrectaException, UsuarioNoExisteException {
		Scanner sc = new Scanner(System.in);
		Statement smt = UtilDB.conectarDB();
		ResultSet cursor = smt.executeQuery("select * from usuario where nombre='" + nombre + "'");

		if (cursor.next()) {
			this.contraseña = cursor.getString("contrasenia");

			if (!this.contraseña.equals(contraseña)) {
				UtilDB.desconectarBD();
				throw new ContraseñaIncorrectaException("La contraseña no es correcta.");
			}

			this.nombre = cursor.getString("nombre");
			this.email = cursor.getString("email");		
		} else {
			UtilDB.desconectarBD();
			throw new UsuarioNoExisteException("No existe el usuario en la BD.");
		}
		UtilDB.desconectarBD();
	}
	
	/**
	 * Constructor que a partir de la clave primaria (nombre) Consulta en base de
	 * datos el usuario que ya tenga ese nombre. Si no existe, lanza un
	 * SQLException. Si existe, rellena el resto de variables internas a partir de
	 * los valores que le da el cursor de la consulta
	 * 
	 * @param nombre el nombre que deber�a existir ya en la BD
	 * @throws SQLException excepcion lanzada si no se encuentra el nombre
	 * 
	 */
	protected Usuario(String nombre) throws SQLException {
		Statement query = UtilDB.conectarDB();
		ResultSet devuelveDatos = query.executeQuery("select * from usuario where nombre='" + nombre + "'");
		if (devuelveDatos.next()) {
			this.nombre = devuelveDatos.getString("nombre");
			email = devuelveDatos.getString("email");
			contraseña = devuelveDatos.getString("contrasenia");
		} else {
			UtilDB.desconectarBD();
			throw new SQLException("No se ha podido insertar el usuario");
		}
		UtilDB.desconectarBD();
	}
	
	 /**

     * Constructor de usuario que permite la declaracion de arrayList usado en la funcion getTodos.
     
     */

	public Usuario() {

	}



	/**
	 * Comprobamos si una contraseña es valida o no.
	 * 
	 * @param pass
	 * @return la contraseña 
	 */
	private boolean contraseñaValida(String pass) {
		return !pass.isBlank();
	}
	
	/**
	 * Comprobamos si una email es valida o no.
	 * 
	 * @param email
	 * @return email 
	 */

	private boolean emailVallido(String email) {
		return email.contains("@");
	}

	private boolean añoValido(short añoNacimiento) {
		return añoNacimiento < LocalDate.now().getYear();
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {	
			this.nombre = nombre;
		}
		

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws SQLException, EmailIncorrectoException {
		if (!this.emailVallido(email)) {
			throw new EmailIncorrectoException("El email tiene que tener @.");
		}
			this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) throws SQLException, ContraseñaIncorrectaException {
		if (contraseña.isBlank()) {
			throw new ContraseñaIncorrectaException("La contraseña no puede estar vacia.");
		}
			this.contraseña = contraseña;
	}

	/**
	 * elimina el usuario de la base de datos y lo pone a null en Java para que no
	 * haya desfase objeto-relacional. En caso de que no se pueda borrar de base de
	 * datos, el objeto java se queda como estaba.
	 * 
	 * @return Si no hay usuarios en la tabla, va a devolver un arraylist vacio distintas.
	 */


	public static ArrayList<Usuario> getTodos() {
		Statement smt = UtilDB.conectarDB();
		// Inicializamos un ArrayList para devolver.
		ArrayList<Usuario> ret = new ArrayList<Usuario>();

		try {
			ResultSet cursor = smt.executeQuery("select * from usuario");
			while (cursor.next()) {
				Usuario actual = new Usuario();

				actual.nombre = cursor.getString("nombre");
				actual.contraseña = cursor.getString("contrasenia");
				actual.email = cursor.getString("email");
				ret.add(actual);
			}
		} catch (SQLException e) {
			// Si la conuslta falla no hay nada que devolver.
			e.printStackTrace();
			return null;
		}
		// Si no hay usuarios en la tabla, va a devolver un arraylist vacio.
		// Si la consulta fue erronea se devuelve un arraylist null, que son cosas
		// distintas.
		UtilDB.desconectarBD();
		return ret;
	}
	

}
