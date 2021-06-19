package classesNegocio;

import classesModelo.ItemCompra;


public abstract class ServicoNegocio {

	public abstract ItemCompra definirDesconto(ItemCompra itemCompra, String cpf); 
	public abstract double definirServico(int codigo);
	public abstract String definirServicoNome(int codigo);
}
