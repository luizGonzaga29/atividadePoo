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
import excecoes.CompraExcecoes;




public class Teste {
		
	public static void main(String[] args) throws ParseException {
		//Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = new Date();
		ClienteNegocio cliNeg = new ClienteNegocio();
		List<Cliente> listaCli;
		String cpf = "11111111112";
		
		//Cliente cli = new Cliente("Fulano", "22222222222", d, "fulano@fulano.com");
		try {
			//listaCli = cliNeg.listarClientes();
			//System.out.println(cliNeg.pesquisarCliente("22222222222"));
			//cliNeg.deletarCliente("11111111112");
			//Cliente cli = new Cliente("Fulano", "11111111112", d, "m");
			//cliNeg.inserirCliente(cli);
			//cliNeg.deletarCliente(cli.getCpf());
			//System.out.println(cliNeg.pesquisarCliente(cli.getCpf()));
			//System.out.println(cliNeg.pesquisarCliente(cli.getCpf()));
			//System.out.println(cliNeg.listarClientes());
			/*String cpf = "38200759415";
			
			ItemCompra it = new ItemCompra(new Combustivel( Ecombustivel.GAS_COMUM.getVenda(),
					10.00,"comb" ,Ecombustivel.GAS_COMUM.getDescricao(), 1), 1, 10.00);
			
			ItemCompra it1 = new ItemCompra(new Lavagem(Elavagem.SIMPLES.getPreco(),
							10.00,"lav" ,Elavagem.SIMPLES.getDescricao()), 1, 2.00);
			
			CriadorItemCompraNegocio criadorItemCompraNegocio = new CriadorCombustivelNegocio();
			CompraNegocio cn = new CompraNegocio(criadorItemCompraNegocio);
			Compra compra = new Compra(d, 0.0, cpf);
			it = cn.definirItemCompra(it, cpf);
			
			CriadorItemCompraNegocio criadorItemCompraNegocio1 = new CriadorLavagemNegocio();
			CompraNegocio cn1 = new CompraNegocio(criadorItemCompraNegocio1);
			it1 = cn1.definirItemCompra(it1, cpf);
			
			compra.addItem(it);
			compra.addItem(it1);
			System.out.println(compra);*/
			/*CombustivelNegocio cn = new CombustivelNegocio();
			LavagemNegocio ln = new LavagemNegocio();
			it = cn.definirDesconto(it, "3a333333333");
			it1 = ln.definirDesconto(it1, "33333333333");
			Compra compra = new Compra(d, 0.0, "33333333333");
			compra.addItem(it);
			compra.addItem(it1);
			System.out.println(compra);*/
			//38200759415
			Compra compra = new Compra(d, cpf);
			CompraNegocio cn = new CompraNegocio();
			//cn.inserirCompra(compra);
			cn.deletarCompra(25);
			//System.out.println(cn.listarComprasPeloCpf(cpf));
		}catch (ClienteExcecoes e) {
			System.out.println(e.getMessage());
		}catch (CompraExcecoes e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
