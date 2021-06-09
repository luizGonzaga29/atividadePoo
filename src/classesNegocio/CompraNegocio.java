package classesNegocio;

import classesModelo.ItemCompra;

public class CompraNegocio {

	private CriadorItemCompraNegocio criadorItemCompraNegocio;
	
	public CompraNegocio(CriadorItemCompraNegocio criadorItemCompraNegocio) {
		this.criadorItemCompraNegocio = criadorItemCompraNegocio;	
	}
	
	public ItemCompra definirItemCompra(ItemCompra itemCompra, String cpf) {
		return criadorItemCompraNegocio.criarServico().definirDesconto(itemCompra, cpf);
	}
}
