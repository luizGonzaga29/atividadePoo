package classesNegocio;

import classesModelo.Compra;
import classesModelo.ItemCompra;

public class CompraNegocio {

	
	
	public double somarTotal(Compra compra) {
		double total = 0.0;
		for(ItemCompra itens: compra.resgatarItens()) {
			total+=itens.getServico().getPreco();
		}
		return total;
	}
	
	/*public double aplicarDesconto(String cpf) {
		ClienteNegocio cliNeg = new ClienteNegocio();
		
	}*/
}
