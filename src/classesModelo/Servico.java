package classesModelo;

public class Servico {

	private Integer id;
	private Double preco;
	private Double desconto;
	private String tipoServico;
	
	public Servico() {}
	
	public Servico(Integer id, Double preco, Double desconto ,String tipoServico) {
		super();
		this.id = id;
		this.preco = preco;
		this.desconto = desconto;
		this.tipoServico = tipoServico;
	}
	
	public Servico(Double preco, Double desconto, String tipoServico) {
		super();
		this.preco = preco;
		this.desconto = desconto;
		this.tipoServico = tipoServico;
	}
	
	public Servico(Integer id, Double preco, Double desconto) {
		super();
		this.preco = preco;
		this.desconto = desconto;
		this.id = id;
	}
	
	
	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public Integer getId() {
		return this.id;
	}
	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
}
