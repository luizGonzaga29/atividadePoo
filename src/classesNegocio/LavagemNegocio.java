package classesNegocio;


import classesModelo.ItemCompra;
import classesModelo.Lavagem;

import constantes.Elavagem;
import excecoes.CompraExcecoes;

public class LavagemNegocio extends ServicoNegocio {

	private ClienteNegocio cliNeg = new ClienteNegocio();
	private Lavagem lavagem;
	
	@Override
	public ItemCompra definirDesconto(ItemCompra itemCompra, String cpf) {
		lavagem = (Lavagem) itemCompra.getServico();
		double valor = lavagem.getPreco();
		valor = (cliNeg.pesquisarClienteNaCompra(cpf) == null) ? valor :
			valor - (valor * lavagem.getDesconto() / 100);
		lavagem.setPreco(valor);
		return itemCompra;
	}

	@Override
	public double definirServico(int codigo) {
		switch (codigo) {
		case 1:
			return Elavagem.SIMPLES.getPreco();
		case 2:
			return Elavagem.COMPLETA.getPreco();
		default:
			return 0.0;
		}
	}

	@Override
	public String definirServicoNome(int codigo) {
		if(codigo < 1 || codigo > 2) {
			throw new CompraExcecoes("Código de lavagem de ser entre 1 e 2");
		}
		switch (codigo) {
		case 1:
			return Elavagem.SIMPLES.getDescricao();
		case 2:
			return Elavagem.COMPLETA.getDescricao();
		default:
			return "";
		}
	}
}
