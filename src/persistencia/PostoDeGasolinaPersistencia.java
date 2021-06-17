package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import classesModelo.PostoDeGasolina;

public class PostoDeGasolinaPersistencia {

	private Connection con;
	private PreparedStatement pstm;
	
	public void inserirPosto(PostoDeGasolina postoDeGasolina) {
		try {
			con = Conexao.getConnection();
			String sql = "INSERT INTO tb_posto_gasolina(pgas_CNPJ_pk, pgas_razao_social, pgas_nome_fantasia) VALUES(?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, postoDeGasolina.getCnpj());
			pstm.setString(2, postoDeGasolina.getRazaoSocial());
			pstm.setString(3, postoDeGasolina.getNomeFantasia());
			pstm.execute();
			pstm.close();
			Conexao.closeConnection();
		}catch (SQLException e) {
			System.out.println("erro no inserir posto : " + e.getMessage());
			
		}
	}
	
	public PostoDeGasolina verificarSeExisteCnpj(String cnpj) {
		PostoDeGasolina postoDeGasolina = null;
		try {
			con = Conexao.getConnection();
			String sql = "SELECT * FROM tb_posto_gasolina WHERE pgas_CNPJ_pk = " + cnpj;
			pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				postoDeGasolina = new PostoDeGasolina(rs.getString("pgas_CNPJ_pk"), rs.getString("pgas_razao_social"),
				rs.getString("pgas_nome_fantasia"));
			}
			Conexao.closeConnection();
			pstm.close();
		}catch (SQLException e ) {
			System.out.println("erro no verificar posto : " + e.getMessage());
						
		}
		return postoDeGasolina;
	}
	
	public List<PostoDeGasolina> listarPostos(){
		List<PostoDeGasolina> listaPosto = new ArrayList<PostoDeGasolina>();
		try {
			con = Conexao.getConnection();
			String sql = "Select * FROM tb_posto_gasolina";
			pstm = con.prepareStatement(sql);
			ResultSet rs  = pstm.executeQuery();
			
			while(rs.next()) {
				listaPosto.add(new PostoDeGasolina(rs.getString("pgas_CNPJ_pk"), rs.getString("pgas_razao_social"),
				rs.getString("pgas_nome_fantasia")));
				
			}
			pstm.execute();
			pstm.close();
			Conexao.closeConnection();
		}catch (SQLException e) {
			System.out.println("erro no listar posto : " + e.getMessage());
			
		}
		return listaPosto;
	}
	
public void deletarPosto(String cnpj) {
		
		String sql = "DELETE FROM tb_posto_gasolina WHERE pgas_CNPJ_pk =?";
		
		try {
			con = Conexao.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cnpj); 
			pstm.execute();
			pstm.close();
			Conexao.closeConnection();
		}catch(SQLException e) {
			System.out.println("erro no delete posto" + e.getMessage());
            
		}
	}
}
