package infraestructure.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SetUpDataBase {
	private Conn conn;
	private Connection dbConn;

	public SetUpDataBase(String conn) {
		this.conn = new Conn(conn);
	}

	private void setupBaseDeDatos() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/tp4-participante";
		String user = "root";
		String password = "";
		this.dbConn = DriverManager.getConnection(url, user, password);
	}

}
