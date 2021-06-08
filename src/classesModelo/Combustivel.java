package classesModelo;

public class Combustivel extends Servico {
	
	private String tipoDeCombustivel;
	private Integer bomba;
	private Double qtdLitros;
	
	public Combustivel() {}
	
	public Combustivel(Integer id, Double preco, Double desconto, String tipoDeCombustivel, Integer bomba, Double qtdLitros) {
		super(id, preco, desconto);
		this.tipoDeCombustivel = tipoDeCombustivel;
		this.bomba = bomba;
		this.qtdLitros = qtdLitros;
	}
	
	public Combustivel(Double preco, Double desconto, String tipoDeCombustivel, Integer bomba, Double qtdLitros) {
		super(preco, desconto);
		this.tipoDeCombustivel = tipoDeCombustivel;
		this.bomba = bomba;
		this.qtdLitros = qtdLitros;
	}

	public String getTipoDeCombustivel() {
		return tipoDeCombustivel;
	}

	public void setTipoDeCombustivel(String tipoDeCombustivel) {
		this.tipoDeCombustivel = tipoDeCombustivel;
	}

	public Integer getBomba() {
		return bomba;
	}

	public void setBomba(Integer bomba) {
		this.bomba = bomba;
	}

	public Double getQtdLitros() {
		return qtdLitros;
	}

	public void setQtdLitros(Double qtdLitros) {
		this.qtdLitros = qtdLitros;
	}

	@Override
	public String toString() {
		return "Combustivel [tipoDeCombustivel=" + tipoDeCombustivel + ", bomba=" + bomba + ", qtdLitros=" + qtdLitros
				+ ", getId()=" + getId() + ", getPreco()=" + getPreco() + ", getDesconto()=" + getDesconto() + "]";
	}
	
	

}
