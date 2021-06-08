package classesModelo;

public class EstacionamentoRotativo extends Servico {

	private Integer andar;
	private Double tempoPermanencia;
	
	public EstacionamentoRotativo() {}
	
	public EstacionamentoRotativo(Integer id, Double preco, Double desconto, Integer andar, Double tempoPermanencia) {
		super(id, preco, desconto);
		this.andar = andar;
		this.tempoPermanencia = tempoPermanencia;
	}

	public Integer getAndar() {
		return andar;
	}

	public void setAndar(Integer andar) {
		this.andar = andar;
	}

	public Double getTempoPermanencia() {
		return tempoPermanencia;
	}

	public void setTempoPermanencia(Double tempoPermanencia) {
		this.tempoPermanencia = tempoPermanencia;
	}
}
