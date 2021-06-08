package classesModelo;

public class EstacionamentoMensal extends Servico {

	private Integer andar;
	
	public EstacionamentoMensal() {}

	public EstacionamentoMensal(Integer id, Double preco, Double desconto, Integer andar) {
		super(id, preco, desconto);
		this.andar = andar;
	}

	public Integer getAndar() {
		return andar;
	}

	public void setAndar(Integer andar) {
		this.andar = andar;
	}
}
