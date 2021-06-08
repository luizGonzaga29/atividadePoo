package classesModelo;

public class Servico {

	private Integer id;
	private Double preco;
	private Double desconto;
	
	public Servico() {}
	
	public Servico(Integer id, Double preco, Double desconto) {
		super();
		this.id = id;
		this.preco = preco;
		this.desconto = desconto;
	}
	
	public Servico(Double preco, Double desconto) {
		super();
		this.preco = preco;
		this.desconto = desconto;
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
