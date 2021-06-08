package classesModelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente extends Pessoa {

	private Date dataNascimento;
	private String email;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
	private Endereco enderecoCli;
	
	public Cliente() {}
	
	public Cliente(String nome, String cpf, Date dataNascimento, String email,Endereco endereco) {
		super(nome, cpf);
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.enderecoCli = endereco;
	}
	
	public Cliente(String nome, String cpf, Date dataNascimento, String email) {
		super(nome, cpf);
		this.dataNascimento = dataNascimento;
		this.email = email;
		
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String sexo) {
		this.email = sexo;
	}
	
	

	public Endereco getEnderecoCli() {
		return enderecoCli;
	}

	public void setEnderecoCli(Endereco enderecoCli) {
		this.enderecoCli = enderecoCli;
	}

	@Override
	public String toString() {
		return "Cliente [dataNascimento=" + sdf.format(dataNascimento) + ", email=" + email + ", Nome=" + getNome()
				+ ", Cpf=" + getCpf() + "]";
	}

	
}
