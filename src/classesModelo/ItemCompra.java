package classesModelo;

public class ItemCompra {

	private Integer idItemCompra;
	private Servico servico;
	private int idCompra;
	private Double preco;
	private Double desconto;
	private Double quantidade;
	
	public ItemCompra() {}

	public ItemCompra(Integer idItemCompra, Servico servico, int idCompra, Double preco, Double desconto,
			Double quantidade) {
		super();
		this.idItemCompra = idItemCompra;
		this.servico = servico;
		this.idCompra = idCompra;
		this.preco = preco;
		this.desconto = desconto;
		this.quantidade = quantidade;
	}

	public ItemCompra(Servico servico, int idCompra, Double quantidade ) {
		this.servico = servico;
		this.idCompra = idCompra;
		this.quantidade = quantidade;
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

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public Integer getIdItemCompra() {
		return idItemCompra;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	@Override
	public String toString() {
		return "servico=" + servico + ", quantidade=" + quantidade;
	}

	
}
