package excecoes;

import java.sql.SQLException;

public class ConexaoExcecoes extends SQLException {

	private static final long serialVersionUID = 1L;

	public ConexaoExcecoes(String msg) {
		super(msg);
	}
}
