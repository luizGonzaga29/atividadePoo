package classesModelo;

public class Combustivel extends Servico {
	
	private String tipoDeCombustivel;
	private Integer bomba;
	
	public Combustivel() {}
	
	public Combustivel(Integer id, Double preco, Double desconto, String tipoServico, String tipoDeCombustivel,
			Integer bomba) {
		super(id, preco, desconto, tipoServico);
		this.tipoDeCombustivel = tipoDeCombustivel;
		this.bomba = bomba;
		
	}
	
	public Combustivel(Double preco, Double desconto, String tipoServico, String tipoDeCombustivel,
			Integer bomba ) {
		super(preco, desconto, tipoServico);
		this.tipoDeCombustivel = tipoDeCombustivel;
		this.bomba = bomba;
		
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

	
	@Override
	public String toString() {
		return "Combustivel [tipoDeCombustivel=" + tipoDeCombustivel + ", bomba=" + bomba  
				+ ", getId()=" + getId() + ", getPreco()=" + getPreco() + ", getDesconto()=" + getDesconto() + "]";
	}
	
	

}
