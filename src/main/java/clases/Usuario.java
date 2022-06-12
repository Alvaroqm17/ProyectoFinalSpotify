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
 * funciones
 * 
 * @author Alvaro
 *
 */
public class Usuario {
	private String nombre;
	private String email;
	private String contraseña;


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
	 * @param nombre el nombre que debería existir ya en la BD
	 * @throws SQLException excepción lanzada si no se encuentra el nombre
	 * 
	 */
	

	/**
	 * Constructor que a partir de la clave primaria (nombre) Consulta en base de
	 * datos el usuario que ya tenga ese nombre. Si no existe, lanza un
	 * SQLException. Si existe, rellena el resto de variables internas a partir de
	 * los valores que le da el cursor de la consulta
	 * 
	 * @param nombre el nombre que deber�a existir ya en la BD
	 * @throws SQLException excepci�n lanzada si no se encuentra el nombre
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

	public Usuario() {

	}



	/**
	 * Comprobamos si una contraseña es valida o no.
	 * 
	 * @param pass
	 * @return
	 */
	private boolean contraseñaValida(String pass) {
		return !pass.isBlank();
	}

	private boolean emailVallido(String email) {
		return email.contains("@");
	}

	private boolean añoValido(short añoNacimiento) {
		return añoNacimiento < LocalDate.now().getYear();
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter de nombre persiste el nombre en la BD.
	 * 
	 * @param nombre
	 * @throws SQLException
	 */
	public void setNombre(String nombre) throws SQLException {

		// Primero intentamos el update, si no funciona en BD no se hace en java.
		Statement smt = UtilDB.conectarDB();
		// La consulta se debe de hacer modificando la variable especifica del setter y
		// haciendolo
		// solo donde la PK coincida.

		if (smt.executeUpdate("update usuario set nombre='" + nombre + "' where nombre='" + this.nombre + "'") > 0) {
			this.nombre = nombre;
		}
		UtilDB.desconectarBD();

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws SQLException, EmailIncorrectoException {
		if (!this.emailVallido(email)) {
			throw new EmailIncorrectoException("El email tiene que tener @.");
		}

		Statement smt = UtilDB.conectarDB();

		if (smt.executeUpdate("update usuario set email='" + email + "' where nombre='" + this.nombre + "'") > 0) {
			this.email = email;
		}
		UtilDB.desconectarBD();

	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) throws SQLException, ContraseñaIncorrectaException {
		if (contraseña.isBlank()) {
			throw new ContraseñaIncorrectaException("La contraseña no puede estar vacia.");
		}
		Statement smt = UtilDB.conectarDB();

		if (smt.executeUpdate(
				"update usuario set contrasenia='" + contraseña + "' where nombre='" + this.nombre + "'") > 0) {
			this.contraseña = contraseña;
		}
		UtilDB.desconectarBD();

	}

	/**
	 * elimina el usuario de la base de datos y lo pone a null en Java para que no
	 * haya desfase objeto-relacional. En caso de que no se pueda borrar de base de
	 * datos, el objeto java se queda como estaba.
	 * 
	 * @param u el usuario a eliminar.
	 * @return true si se ha eliminado, false si no se ha podido
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
