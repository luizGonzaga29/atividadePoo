package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classesModelo.Combustivel;
import classesModelo.Compra;
import classesModelo.ItemCompra;
import classesModelo.Lavagem;
import classesNegocio.ClienteNegocio;
import classesNegocio.CriadorCombustivelNegocio;
import classesNegocio.CriadorItemCompraNegocio;
import classesNegocio.CriadorLavagemNegocio;
import classesNegocio.ItemCompraNegocio;
import excecoes.ClienteExcecoes;
import excecoes.CompraExcecoes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.util.Date;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;

public class CompraView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodCombustivel;
	private JTextField txtCodLavagem;
	private JTextField txtQtdLitros;
	private JTextField txtCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompraView frame = new CompraView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CompraView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite o c\u00F3digo do servi\u00E7o:");
		lblNewLabel.setBounds(12, 13, 151, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Combust\u00EDvel:");
		lblNewLabel_1.setBounds(12, 42, 97, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Lavagem:");
		lblNewLabel_1_1.setBounds(12, 137, 97, 16);
		contentPane.add(lblNewLabel_1_1);
		
		txtCodCombustivel = new JTextField();
		txtCodCombustivel.setBounds(130, 42, 116, 22);
		contentPane.add(txtCodCombustivel);
		txtCodCombustivel.setColumns(10);
		
		txtCodLavagem = new JTextField();
		txtCodLavagem.setBounds(130, 134, 116, 22);
		contentPane.add(txtCodLavagem);
		txtCodLavagem.setColumns(10);
		
		txtQtdLitros = new JTextField();
		txtQtdLitros.setBounds(130, 89, 116, 22);
		contentPane.add(txtQtdLitros);
		txtQtdLitros.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade litros:");
		lblNewLabel_2.setBounds(12, 92, 106, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnCompra = new JButton("Finalizar Compra");
		btnCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String resultado = "";
					ClienteNegocio cliNeg = new ClienteNegocio();
					cliNeg.verificarCpf(txtCpf.getText());
					Compra compra = new Compra(new Date(), txtCpf.getText(), 0.0);
					CriadorItemCompraNegocio criadorItemCompraNegocio;
					ItemCompraNegocio itn;
					//ItemCompraNegocio itn1;
					if(!txtCodCombustivel.getText().equals("") && !txtQtdLitros.getText().equals("")) {
						int codCombustivel = Integer.parseInt(txtCodCombustivel.getText());
						double qtdLitros = Double.parseDouble(txtQtdLitros.getText());
						criadorItemCompraNegocio = new CriadorCombustivelNegocio();
						itn = new ItemCompraNegocio(criadorItemCompraNegocio);
						ItemCompra it = new ItemCompra(new Combustivel(itn.definirValor(codCombustivel), 10.00, itn.definirNome(codCombustivel)),
								1, qtdLitros);
						it = itn.definirItemCompra(it, txtCpf.getText());
						compra.addItem(it);
						resultado+=it;
					}
					
					if(!txtCodLavagem.getText().equals("")) {
						int codLavagem = Integer.parseInt(txtCodLavagem.getText());
						criadorItemCompraNegocio = new CriadorLavagemNegocio();
						itn = new ItemCompraNegocio(criadorItemCompraNegocio);
						ItemCompra it1 = new ItemCompra(new Lavagem(itn.definirValor(codLavagem), 10.00, itn.definirNome(codLavagem)), 1, 0.0);
						it1 = itn.definirItemCompra(it1, txtCpf.getText());
						compra.addItem(it1);
						resultado+=it1;
						
					}
					
					if(compra.resgatarItens().size() > 0) {
						JOptionPane.showMessageDialog(null, compra ,"Compra",0);
					}else {JOptionPane.showMessageDialog(null, "Não há itens na compra!","Compra",0);}
					
				}catch (InputMismatchException e1) {
					JOptionPane.showMessageDialog(null, "Apenas valores númericos!","Compra",0);
				}catch (ClienteExcecoes e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Compra",0);
				}catch (CompraExcecoes e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Compra",0);
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Compra",0);
				}
			}
		});
		btnCompra.setBounds(66, 220, 129, 25);
		contentPane.add(btnCompra);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteView cl = new ClienteView();
				cl.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(251, 220, 97, 25);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_3 = new JLabel("Gasolina Comum");
		lblNewLabel_3.setBounds(12, 288, 129, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Gasolina Aditivada");
		lblNewLabel_3_1.setBounds(12, 317, 129, 16);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Diesel");
		lblNewLabel_3_2.setBounds(12, 350, 129, 16);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Etanol");
		lblNewLabel_3_3.setBounds(12, 381, 129, 16);
		contentPane.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_4 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_4.setBounds(37, 259, 72, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Cod");
		lblNewLabel_4_1.setBounds(190, 258, 56, 16);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("1");
		lblNewLabel_4_1_1.setBounds(190, 288, 56, 16);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("2");
		lblNewLabel_4_1_1_1.setBounds(190, 317, 56, 16);
		contentPane.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("3");
		lblNewLabel_4_1_1_2.setBounds(190, 350, 56, 16);
		contentPane.add(lblNewLabel_4_1_1_2);
		
		JLabel lblNewLabel_4_1_1_3 = new JLabel("4");
		lblNewLabel_4_1_1_3.setBounds(190, 381, 56, 16);
		contentPane.add(lblNewLabel_4_1_1_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Lavagem comum");
		lblNewLabel_1_1_1.setBounds(12, 410, 97, 16);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Lavagem completa");
		lblNewLabel_1_1_1_1.setBounds(12, 439, 129, 16);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_4_1_1_4 = new JLabel("1");
		lblNewLabel_4_1_1_4.setBounds(190, 410, 56, 16);
		contentPane.add(lblNewLabel_4_1_1_4);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("2");
		lblNewLabel_4_1_1_1_1.setBounds(190, 439, 56, 16);
		contentPane.add(lblNewLabel_4_1_1_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("CPF");
		lblNewLabel_5.setBounds(384, 42, 56, 16);
		contentPane.add(lblNewLabel_5);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(452, 39, 116, 22);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
	}

}
