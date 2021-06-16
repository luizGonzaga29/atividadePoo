package classesNegocio;

import classesModelo.ItemCompra;

public class ItemCompraNegocio {

private CriadorItemCompraNegocio criadorItemCompraNegocio;
	
	public ItemCompraNegocio(CriadorItemCompraNegocio criadorItemCompraNegocio) {
		this.criadorItemCompraNegocio = criadorItemCompraNegocio;	
	}
	
	public ItemCompra definirItemCompra(ItemCompra itemCompra, String cpf) {
		return criadorItemCompraNegocio.criarServico().definirDesconto(itemCompra, cpf);
	}
}
