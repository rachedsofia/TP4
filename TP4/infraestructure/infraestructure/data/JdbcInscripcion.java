package infraestructure.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import domain.portsout.InfraestructureException;
import domain.portsout.Inscripciones;

public class JdbcInscripcion implements Inscripciones {
	private String url;
	private String user;
	private String password;

	public JdbcInscripcion(String url, String user, String password) {
		Objects.requireNonNull(url);
		Objects.requireNonNull(user);
		Objects.requireNonNull(password);

		this.url = url;
		this.user = user;
		this.password = password;
	}

	@Override
	public void registrar(String nombre, String numeroTelefono, String region) throws InfraestructureException {
		try {
			Connection dbConn = DriverManager.getConnection(url, user, password);

			PreparedStatement st = dbConn
					.prepareStatement("insert into participantes(nombre, telefono, region) values(?,?,?)");
			st.setString(1, nombre);
			st.setString(2, numeroTelefono);
			st.setString(3, region);
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			throw new InfraestructureException("El participante no se pudo inscribir");
		}
	}
}
