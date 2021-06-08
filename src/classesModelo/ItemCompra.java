package classesModelo;

public class ItemCompra {

	private Integer idItemCompra;
	private Servico servico;
	
	public ItemCompra() {}

	public ItemCompra(Integer idItemCompra, Servico servico) {
		this.idItemCompra = idItemCompra;
		this.servico = servico;
	}
	
	public ItemCompra(Servico servico) {
		this.servico = servico;
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
		return "ItemCompra [idItemCompra=" + idItemCompra + ", servico=" + servico + "]";
	}
}
