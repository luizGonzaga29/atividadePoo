package classesNegocio;

import java.util.List;


import classesModelo.Compra;

import excecoes.CompraExcecoes;
import persistencia.CompraPersistencia;


public class CompraNegocio {

	private ClienteNegocio cliNeg = new ClienteNegocio();
	private CompraPersistencia compraPers = new CompraPersistencia();
		
	public void inserirCompra(Compra compra) {
		cliNeg.verificarCpf(compra.getCpf());
		cliNeg.pesquisarCliente(compra.getCpf());
		compraPers.inserirCompra(compra);
	}
	
	public List<Compra> listarCompras(){
		List<Compra> listaCompra = compraPers.listarCompras();
		if(listaCompra.size() == 0) {
			throw new CompraExcecoes("Não há compras cadastradas!");
		}else {
			return listaCompra;
		}
	}
	public List<Compra> listarComprasPeloCpf(String cpf){
		cliNeg.verificarCpf(cpf);
		List<Compra> listaCompra = compraPers.listarComprasPeloCpf(cpf);
		if(listaCompra.size() == 0) {
			throw new CompraExcecoes("Não há compras cadastradas para esse cpf!");
		}else {
			return listaCompra;
		}
	}
	
	public void deletarCompra(int id) {
		if(compraPers.verificarSeExisteId(id) == null) {
			throw new CompraExcecoes("Não a compra com esse id");
		}
		compraPers.deletarCompra(id); 
		
	}
	
	
}
