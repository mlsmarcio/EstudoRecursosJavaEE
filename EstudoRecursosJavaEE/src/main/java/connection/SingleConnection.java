package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	private static String banco = "jdbc:postgresql://localhost:5432/RecursosAvancados?autoReconnect=true";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;
	
	// AO INVOCAR ESSA CLASSE DE QUALQUER FORMA INVOCAR� O M�TODO CONECTAR()
	static {
		conectar();
	}

	
	public SingleConnection() {
		conectar();
	}


	private static void conectar() {
		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Falha na conex�o com o banco de dados");
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
}
