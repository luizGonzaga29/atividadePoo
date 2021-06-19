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
	
	public double definirValor(int cod) {
		return criadorItemCompraNegocio.criarServico().definirServico(cod);
	}
	
	public String definirNome(int cod) {
		return criadorItemCompraNegocio.criarServico().definirServicoNome(cod);
	}
}
