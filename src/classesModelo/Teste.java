package classesModelo;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import classesNegocio.ClienteNegocio;
import classesNegocio.CombustivelNegocio;
import classesNegocio.ItemCompraNegocio;
import constantes.Ecombustivel;
import excecoes.ClienteExcecoes;




public class Teste {
		
	public static void main(String[] args) throws ParseException {
		//Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = sdf.parse("29/05/1980");
		ClienteNegocio cliNeg = new ClienteNegocio();
		/*List<Cliente> listaCli;
				
		ItemCompra it = new ItemCompra(new Combustivel( Ecombustivel.GAS_COMUM.getVenda(),
				10.00, Ecombustivel.GAS_COMUM.getDescricao(), 1, 10.00));
		ItemCompraNegocio icn = new ItemCompraNegocio();*/
		Cliente cli = new Cliente("Fulano", "22222222222", d, "fulano@fulano.com");
		try {
			//Cliente cli = new Cliente("Fulano", "11111111112", d, "m");
			//cliNeg.inserirCliente(cli);
			//cliNeg.deletarCliente(cli.getCpf());
			System.out.println(cliNeg.pesquisarCliente(cli.getCpf()));
			//System.out.println(cliNeg.pesquisarCliente(cli.getCpf()));
			//System.out.println(cliNeg.listarClientes());
		}catch (ClienteExcecoes e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
