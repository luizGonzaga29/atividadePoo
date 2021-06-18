package classesNegocio;


import java.util.List;


import classesModelo.PostoDeGasolina;

import excecoes.PostoDeGasolinaExcecoes;
import persistencia.PostoDeGasolinaPersistencia;

public class PostoDeGasolinaNegocio {

	private PostoDeGasolinaPersistencia postoDeGasolinaPersistencia = new PostoDeGasolinaPersistencia();
	
	public void verificarCnpj(String cnpj) {
		if(cnpj.length() != 14  || !cnpj.matches("^[0-9]*$")) {
			throw new PostoDeGasolinaExcecoes("Algo errado com o cnpj, o mesmo deve conter apenas 14 números");
		}
	}
	
	public void inserirPosto(PostoDeGasolina posto) {
		verificarCnpj(posto.getCnpj());
		if(postoDeGasolinaPersistencia.verificarSeExisteCnpj(posto.getCnpj()) != null) {
			throw new PostoDeGasolinaExcecoes("Posto já cadastrado!");
		}else{
			postoDeGasolinaPersistencia.inserirPosto(posto);
		}
	}
	
	public List<PostoDeGasolina> listarPostos(){
		List<PostoDeGasolina> listaPosto = postoDeGasolinaPersistencia.listarPostos();
		if(listaPosto.size() == 0) {
			throw new PostoDeGasolinaExcecoes("Não há postos cadastrados!");
		}else {
			return listaPosto;
		}
	}
	
	public PostoDeGasolina pesquisarPosto(String cnpj) {
		verificarCnpj(cnpj);
		PostoDeGasolina posto = postoDeGasolinaPersistencia.verificarSeExisteCnpj(cnpj);
		if(posto == null) {
			throw new PostoDeGasolinaExcecoes("Posto não cadastrado!");
		}else {
			return posto;
		}
	}
	
	public void deletarPosto(String cnpj) {
		verificarCnpj(cnpj);
		if(postoDeGasolinaPersistencia.verificarSeExisteCnpj(cnpj) != null) {
			postoDeGasolinaPersistencia.deletarPosto(cnpj);
		}else {
			throw new PostoDeGasolinaExcecoes("Não é possivel deletar posto não cadastrado!");
		}
	}
}
