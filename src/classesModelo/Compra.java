package classesModelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {

	private Integer idCompra;
	private Date dataCompra;
	private List<ItemCompra> itens;
	private Double total;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	private String cpf;
	
	public Compra() {}

	public Compra(Integer idCompra, Date dataCompra, Double total, String cpf) {
		this.idCompra = idCompra;
		this.dataCompra = dataCompra;
		this.total = total;
		this.cpf = cpf;
		this.itens = new ArrayList<ItemCompra>();
	}
	
	public Compra(Date dataCompra, Double total, String cpf) {
		this.dataCompra = dataCompra;
		this.total = total;
		this.cpf = cpf;
		this.itens = new ArrayList<ItemCompra>();
	}
	
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getIdCompra() {
		return idCompra;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	public void addItem(ItemCompra it) {
		this.total+=it.getServico().getPreco();
		this.itens.add(it);
	}
	
	public void removerItem(ItemCompra it) {
		this.itens.remove(it);
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ItemCompra selecionarItem(int pos) {
		ItemCompra it = itens.get(pos);
		return it;
	}

    public List<ItemCompra> resgatarItens(){
    	return this.itens;
    }	
	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + " valor total=" + total + ", dataCompra=" + sdf.format(dataCompra) + ", itens=" + itens + "]";
	}
	
	
}
