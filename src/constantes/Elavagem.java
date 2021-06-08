package constantes;

public enum Elavagem {

	SIMPLES(1, 30.00, "Simples"),
    ESPECIAL(2, 45.00, "Especial");
	
	private int codLavagem;
    private double preco;
    private String descricao;
    
	private Elavagem(int codLavagem, double preco, String descricao) {
		this.codLavagem = codLavagem;
		this.preco = preco;
		this.descricao = descricao;
	}

	public int getCodLavagem() {
		return codLavagem;
	}

	public double getPreco() {
		return preco;
	}

	public String getDescricao() {
		return descricao;
	}
}
