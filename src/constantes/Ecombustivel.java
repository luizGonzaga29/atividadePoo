package constantes;

public enum Ecombustivel {

	ETANOL(1, 2.39, "Etanol"),
    GAS_COMUM(2, 3.49, "Gasolina Comum"),
    GAS_ADITIVADA(3, 3.69, "Gasolina Aditivada"),
    DIESEL(4, 2.89, "Diesel");
        
	private int codCombustivel;
    private double venda;
    private String descricao;
   
    private Ecombustivel(int codCombustivel, double venda, String descricao) {
        this.codCombustivel = codCombustivel;
      	this.venda = venda;
      	this.descricao = descricao;
    }

	public int getCodCombustivel() {
		return codCombustivel;
	}
	
	public double getVenda() {
		return venda;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
