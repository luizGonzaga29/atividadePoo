package classesNegocio;


import classesModelo.ItemCompra;
import classesModelo.Lavagem;

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
}
