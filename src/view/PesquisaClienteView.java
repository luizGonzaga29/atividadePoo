package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JTable;
import javax.swing.border.EmptyBorder;


import classesModelo.Cliente;
import classesNegocio.ClienteNegocio;
import excecoes.ClienteExcecoes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.ListSelectionModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;



public class PesquisaClienteView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCpf;
	private JTextField txtCpfDel;
	private ClienteNegocio cliNeg = new ClienteNegocio();
	/**
	 * @wbp.nonvisual location=-109,544
	 */
	
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	
	public void preencherTabela() {
		ArrayList dados = new ArrayList();
		String[] colunas = new String[] {"Nome", "CPF", "Data Nascimento", "Email"};
		ClienteNegocio cliNeg = new ClienteNegocio();
		List<Cliente> listaCli = cliNeg.listarClientes();
		
		for(Cliente lista:listaCli) {
			dados.add(new Object[] {lista});
		}
		TabelaCliente tc = new TabelaCliente(dados, colunas);
		table.setModel(tc);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaClienteView frame = new PesquisaClienteView();
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
	public PesquisaClienteView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pequisar cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 13, 164, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Informe o cpf para pesquisa:");
		lblNewLabel_1.setBounds(12, 42, 178, 16);
		contentPane.add(lblNewLabel_1);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(202, 39, 116, 22);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnPesquisaPeloCpf = new JButton("Pesquisar");
		btnPesquisaPeloCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String resultado = cliNeg.pesquisarCliente(txtCpf.getText()) + "";
				JOptionPane.showMessageDialog(null, resultado,"Cliente",0);
				}catch (ClienteExcecoes e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Cliente",0);
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Cliente",0);
				}
			}
		});
		btnPesquisaPeloCpf.setBounds(353, 38, 123, 25);
		contentPane.add(btnPesquisaPeloCpf);
		
		JButton btnListarTodos = new JButton("Listar Clientes");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				List<Cliente> listaCli = cliNeg.listarClientes();
				String resultado = "";
				for(Cliente lista:listaCli) {
					resultado+= lista + "\n";
				}
				JOptionPane.showMessageDialog(null, resultado,"Clientes",0);
				}catch (ClienteExcecoes e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Clientes",0);
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Cliente",0);
				}
			}
		});
		btnListarTodos.setBounds(353, 86, 123, 25);
		contentPane.add(btnListarTodos);
		
		JLabel lblNewLabel_2 = new JLabel("Deletar Cliente pelo cpf:");
		lblNewLabel_2.setBounds(12, 137, 164, 16);
		contentPane.add(lblNewLabel_2);
		
		txtCpfDel = new JTextField();
		txtCpfDel.setBounds(202, 134, 116, 22);
		contentPane.add(txtCpfDel);
		txtCpfDel.setColumns(10);
		
		JButton btnNewButton = new JButton("Deletar cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				cliNeg.deletarCliente(txtCpfDel.getText());
				JOptionPane.showMessageDialog(null, "Cliente deletado","Clientes",0);
				}catch (ClienteExcecoes e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Clientes",0);
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Clientes",0);
				}
			}
		});
		btnNewButton.setBounds(353, 133, 123, 25);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteView cl = new ClienteView();
				cl.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(535, 38, 97, 25);
		contentPane.add(btnVoltar);
		
		
		
		
		table = new JTable();
		table.setBounds(67, 235, 1, 1);
		contentPane.add(table);
		preencherTabela();
		
		
		
		
		
	    
        
				
	}
}
