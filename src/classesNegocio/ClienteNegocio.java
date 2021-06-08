package classesNegocio;


import java.util.List;

import classesModelo.Cliente;
import excecoes.ClienteExcecoes;

import persistencia.ClientePersistencia;

public class ClienteNegocio {
	
	private ClientePersistencia cliPers = new ClientePersistencia();
		
	public void inserirCliente(Cliente cli) {
		verificarCpf(cli.getCpf());
		if(cliPers.verificarSeExisteId(cli.getCpf()) != null) {
			throw new ClienteExcecoes("Cliente já cadastrado!");
		}else{
			cliPers.inserirCliente(cli);
		}
	}
	
	public List<Cliente> listarClientes(){
		List<Cliente> listaCli = cliPers.listarClientes();
		if(listaCli.size() == 0) {
			throw new ClienteExcecoes("Não há clientes cadastrados!");
		}else {
			return listaCli;
		}
	}
	
	public void deletarCliente(String cpf) {
		verificarCpf(cpf);
		if(cliPers.verificarSeExisteId(cpf) != null) {
			cliPers.deletarCliente(cpf);
		}else {
			throw new ClienteExcecoes("Não é possivel deletar cliente não cadastrado!");
		}
	}
	
	public Cliente pesquisarCliente(String cpf) {
		verificarCpf(cpf);
		Cliente cli = cliPers.verificarSeExisteId(cpf);
		if(cli == null) {
			throw new ClienteExcecoes("Cliente não cadastrado!");
		}else {
			return cli;
		}
	}
	
	public void verificarCpf(String cpf) {
		if(cpf.length() != 11  || !cpf.matches("^[0-9]*$")) {
			throw new ClienteExcecoes("Algo errado com o cpf");
		}
	}
}
