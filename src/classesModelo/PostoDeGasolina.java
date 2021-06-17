package classesModelo;

public class PostoDeGasolina {

	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private Endereco enderecoPosto;
	
	public PostoDeGasolina() {}

	public PostoDeGasolina(String cnpj, String razaoSocial, String nomeFantasia ) {
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public Endereco getEnderecoPosto() {
		return enderecoPosto;
	}

	public void setEnderecoPosto(Endereco enderecoPosto) {
		this.enderecoPosto = enderecoPosto;
	}

	@Override
	public String toString() {
		return "PostoDeGasolina [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + "]";
	}
}
