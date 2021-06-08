package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classesModelo.Cliente;

public class ClientePersistencia {

	private Connection con;
	private PreparedStatement pstm;
	
	public Cliente verificarSeExisteId(String cpf) {
		Cliente cli = null;
		try {
			con = Conexao.getConnection();
			String sql = "SELECT * FROM cliente WHERE cpf = " + cpf;
			pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				cli = new Cliente(rs.getString("nome"), rs.getString("cpf"),
				rs.getDate("data"), rs.getString("email"));
			}
			Conexao.closeConnection();
			pstm.close();
		}catch (SQLException e ) {
			System.out.println("erro no verificar : " + e.getMessage());
						
		}
		return cli;
	}
	
	public void inserirCliente(Cliente cli) {
		try {
			con = Conexao.getConnection();
			String sql = "INSERT INTO cliente(cpf, nome, data, email) VALUES(?,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cli.getCpf());
			pstm.setString(2, cli.getNome());
			pstm.setTimestamp(3, new java.sql.Timestamp(cli.getDataNascimento().getTime()));
			pstm.setString(4, cli.getEmail());
			pstm.execute();
			pstm.close();
			Conexao.closeConnection();
		}catch (SQLException e) {
			System.out.println("erro no inserir : " + e.getMessage());
			
		}
	}
	
	public List<Cliente> listarClientes(){
		List<Cliente> listacli = new ArrayList<Cliente>();
		try {
			con = Conexao.getConnection();
			String sql = "Select * FROM cliente";
			pstm = con.prepareStatement(sql);
			ResultSet rs  = pstm.executeQuery();
			
			while(rs.next()) {
				listacli.add(new Cliente(rs.getString("nome"), rs.getString("cpf"),
				rs.getDate("data"), rs.getString("email")));
				
			}
			pstm.execute();
			pstm.close();
			Conexao.closeConnection();
		}catch (SQLException e) {
			System.out.println("erro no inserir : " + e.getMessage());
			
		}
		return listacli;
	}
	
	public void deletarCliente(String cpf) {
		
		String sql = "DELETE FROM cliente WHERE cpf =?";
		
		try {
			con = Conexao.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cpf); 
			pstm.execute();
			pstm.close();
			Conexao.closeConnection();
		}catch(SQLException e) {
			System.out.println("erro no delete " + e.getMessage());
            
		}
	}
}
