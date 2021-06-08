package classesModelo;

public class Lavagem extends Servico{

	private String tipoLavagem;
	
	public Lavagem() {}
	
	public Lavagem(Integer id, Double preco, Double desconto, String tipoLavagem) {
		super(id, preco, desconto);
		this.tipoLavagem = tipoLavagem;
	}

	public String getTipoLavagem() {
		return tipoLavagem;
	}

	public void setTipoLavagem(String tipoLavagem) {
		this.tipoLavagem = tipoLavagem;
	}
}
