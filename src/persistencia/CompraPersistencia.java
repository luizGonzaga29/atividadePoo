package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import classesModelo.Compra;

public class CompraPersistencia {


	private Connection con;
	private PreparedStatement pstm;
	
	public void inserirCompra(Compra compra) {
		try {
			con = Conexao.getConnection();
			String sql = "INSERT INTO tb_compra(cpa_cli_CPF_pk_fk, cpa_data_compra) VALUES(?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, compra.getCpf());
			pstm.setTimestamp(2, new java.sql.Timestamp(compra.getDataCompra().getTime()));
			pstm.execute();
			pstm.close();
			Conexao.closeConnection();
		}catch (SQLException e) {
			System.out.println("erro no inserir compra : " + e.getMessage());
			
		}
	}
	
	public List<Compra> listarCompras(){
		List<Compra> listaCompra = new ArrayList<Compra>();
		try {
			con = Conexao.getConnection();
			String sql = "Select * FROM tb_compra";
			pstm = con.prepareStatement(sql);
			ResultSet rs  = pstm.executeQuery();
			
			while(rs.next()) {
				listaCompra.add(new Compra(rs.getInt("cpa_id_pk"), rs.getString("cpa_cli_CPF_pk_fk"),
				rs.getDate("cpa_data_compra")));
				
			}
			pstm.execute();
			pstm.close();
			Conexao.closeConnection();
		}catch (SQLException e) {
			System.out.println("erro no Listar compras : " + e.getMessage());
			
		}
		return listaCompra;
	}
	
	public List<Compra> listarComprasPeloCpf(String cpf){
		List<Compra> listaCompra = new ArrayList<Compra>();
		try {
			con = Conexao.getConnection();
			String sql = "Select * FROM tb_compra WHERE cpa_cli_CPF_pk_fk=" + cpf;
			pstm = con.prepareStatement(sql);
			ResultSet rs  = pstm.executeQuery();
			
			while(rs.next()) {
				listaCompra.add(new Compra(rs.getInt("cpa_id_pk"), rs.getString("cpa_cli_CPF_pk_fk"),
				rs.getDate("cpa_data_compra")));
				
			}
			pstm.execute();
			pstm.close();
			Conexao.closeConnection();
		}catch (SQLException e) {
			System.out.println("erro no Listar compras : " + e.getMessage());
			
		}
		return listaCompra;
	}
	
	public void deletarCompra(int id) {
		
		String sql = "DELETE FROM tb_compra WHERE cpa_id_pk =?";
		 
		try {
			con = Conexao.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id); 
			pstm.execute();
			pstm.close();
			Conexao.closeConnection();
		}catch(SQLException e) {
			System.out.println("erro no delete compra" + e.getMessage());
            
		}
		
	}
	
	public Compra verificarSeExisteId(int id) {
		Compra compra = null;
		try {
			String sql = "SELECT * FROM tb_compra WHERE cpa_id_pk =" + id;
			con = Conexao.getConnection();
			pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				compra = new Compra(rs.getInt("cpa_id_pk"), rs.getString("cpa_cli_CPF_pk_fk"),
						rs.getDate("cpa_data_compra"));
			}
			Conexao.closeConnection();
			pstm.close();
			rs.close();
		}catch(SQLException e) {
			System.out.println("erro no verificar compra" + e.getMessage());
            
		}
		return compra;
	}
}
