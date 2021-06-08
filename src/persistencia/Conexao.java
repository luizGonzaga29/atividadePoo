package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





public class Conexao {

	private static Connection connection;
	
	public static Connection getConnection() {
		try {
			if (connection == null) {
				connection = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-04."
						+ "cleardb.com:3306/heroku_b77c3bbbbda8de6", "b5fcffc8514bc4", 
						"a226ffaf");
			}

		} catch (SQLException e) {
			//throw new ConexaoExcecoes("Algo errado com a conexão.");
			System.out.println("erro na conexao : " + e.getMessage());
		}
		return connection;
	}
	
	public static void closeConnection() {
		if(connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				//throw new ConexaoExcecoes("Conexão não pode ser fechada.");
				System.out.println("erro na conexao : " + e.getMessage());
			}
		}
	}

}
