package classesNegocio;

public class CriadorLavagemNegocio extends CriadorItemCompraNegocio {

	@Override
	public ServicoNegocio criarServico() {
		
		return new LavagemNegocio();
	}

}
