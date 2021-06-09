package classesNegocio;

public class CriadorCombustivelNegocio extends CriadorItemCompraNegocio {

	@Override
	public ServicoNegocio criarServico() {
		
		return new CombustivelNegocio();
	}

}
