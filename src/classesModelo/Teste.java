package classesModelo;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import classesNegocio.ClienteNegocio;
import classesNegocio.CombustivelNegocio;
import classesNegocio.CompraNegocio;
import classesNegocio.CriadorCombustivelNegocio;
import classesNegocio.CriadorItemCompraNegocio;
import classesNegocio.CriadorLavagemNegocio;
import classesNegocio.LavagemNegocio;
import constantes.Ecombustivel;
import constantes.Elavagem;
import excecoes.ClienteExcecoes;




public class Teste {
		
	public static void main(String[] args) throws ParseException {
		//Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = sdf.parse("29/05/1980");
		//ClienteNegocio cliNeg = new ClienteNegocio();
		//List<Cliente> listaCli;
		
		
		//Cliente cli = new Cliente("Fulano", "22222222222", d, "fulano@fulano.com");
		try {
			//Cliente cli = new Cliente("Fulano", "11111111112", d, "m");
			//cliNeg.inserirCliente(cli);
			//cliNeg.deletarCliente(cli.getCpf());
			//System.out.println(cliNeg.pesquisarCliente(cli.getCpf()));
			//System.out.println(cliNeg.pesquisarCliente(cli.getCpf()));
			//System.out.println(cliNeg.listarClientes());
			String cpf = "22222222222";
			
			ItemCompra it = new ItemCompra(new Combustivel( Ecombustivel.GAS_COMUM.getVenda(),
					10.00, Ecombustivel.GAS_COMUM.getDescricao(), 1, 10.00));
			
			ItemCompra it1 = new ItemCompra(new Lavagem(Elavagem.SIMPLES.getPreco(),
							10.00, Elavagem.SIMPLES.getDescricao()));
			CriadorItemCompraNegocio criadorItemCompraNegocio = new CriadorCombustivelNegocio();
			CompraNegocio cn = new CompraNegocio(criadorItemCompraNegocio);
			Compra compra = new Compra(d, 0.0, cpf);
			it = cn.definirItemCompra(it, cpf);
			
			CriadorItemCompraNegocio criadorItemCompraNegocio1 = new CriadorLavagemNegocio();
			CompraNegocio cn1 = new CompraNegocio(criadorItemCompraNegocio1);
			it1 = cn1.definirItemCompra(it1, cpf);
			
			compra.addItem(it);
			compra.addItem(it1);
			System.out.println(compra);
			/*CombustivelNegocio cn = new CombustivelNegocio();
			LavagemNegocio ln = new LavagemNegocio();
			it = cn.definirDesconto(it, "3a333333333");
			it1 = ln.definirDesconto(it1, "33333333333");
			Compra compra = new Compra(d, 0.0, "33333333333");
			compra.addItem(it);
			compra.addItem(it1);
			System.out.println(compra);*/
		}catch (ClienteExcecoes e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
