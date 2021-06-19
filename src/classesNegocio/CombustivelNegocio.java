package classesNegocio;

import classesModelo.Combustivel;
import classesModelo.ItemCompra;
import constantes.Ecombustivel;
import excecoes.CompraExcecoes;


public class CombustivelNegocio extends ServicoNegocio {

	private ClienteNegocio cliNeg = new ClienteNegocio();
	private Combustivel combustivel;
	
	@Override
	public ItemCompra definirDesconto(ItemCompra itemCompra, String cpf) {
		combustivel = (Combustivel) itemCompra.getServico();
		double valor = combustivel.getPreco() * itemCompra.getQuantidade();
		valor = (cliNeg.pesquisarClienteNaCompra(cpf) == null) ? valor :
			valor - (valor * combustivel.getDesconto() / 100);
		combustivel.setPreco(valor);
		return itemCompra;
	}

	@Override
	public double definirServico(int codigo) {
		if(codigo < 1 || codigo > 4) {
			throw new CompraExcecoes("Código de combustível de ser entre 1 e 4");
		}
		switch (codigo) {
		case 1:
			return Ecombustivel.GAS_COMUM.getVenda();
		case 2:
			return Ecombustivel.GAS_ADITIVADA.getVenda();
		case 3:
			return Ecombustivel.DIESEL.getVenda();
		case 4:
			return Ecombustivel.ETANOL.getVenda();

		default:
			return 0.0;
		}
		
	}

	@Override
	public String definirServicoNome(int codigo) {
		switch (codigo) {
		case 1:
			return Ecombustivel.GAS_COMUM.getDescricao();
		case 2:
			return Ecombustivel.GAS_ADITIVADA.getDescricao();
		case 3:
			return Ecombustivel.DIESEL.getDescricao();
		case 4:
			return Ecombustivel.ETANOL.getDescricao();

		default:
			return "";
		}
	}
	
	
}
