package classesModelo;

public class Proprietario extends Pessoa {

	public Proprietario() {}

	public Proprietario(String nome, String cpf) {
		super(nome, cpf);
		
	}

	@Override
	public String toString() {
		return "Proprietario [getNome()=" + getNome() + ", getCpf()=" + getCpf() + "]";
	}
	
}
