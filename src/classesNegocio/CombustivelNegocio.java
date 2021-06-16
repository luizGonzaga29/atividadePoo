package classesNegocio;

import classesModelo.Combustivel;
import classesModelo.ItemCompra;


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
	
	
}
