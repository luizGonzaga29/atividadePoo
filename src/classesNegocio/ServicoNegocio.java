package classesNegocio;

import classesModelo.ItemCompra;


public abstract class ServicoNegocio {

	public abstract ItemCompra definirDesconto(ItemCompra itemCompra, String cpf); 
}
