package excecoes;

public class ClienteExcecoes extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteExcecoes(String msg) {
		super(msg);
	}
}
