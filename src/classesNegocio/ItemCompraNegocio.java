package classesNegocio;


import classesModelo.Combustivel;
import classesModelo.ItemCompra;
import persistencia.ClientePersistencia;

public class ItemCompraNegocio {
	
	private ClientePersistencia cliNeg = new ClientePersistencia();

	public double calcularValor(ItemCompra it, String cpf) {
		Combustivel c = (Combustivel) it.getServico();
		double valor = c.getPreco() * c.getQtdLitros();
		valor = (cliNeg.verificarSeExisteId(cpf) == null) ? valor :
			valor - (valor * c.getDesconto() / 100);
		return valor;
	}
}
