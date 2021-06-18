package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import classesModelo.Cliente;
import classesNegocio.ClienteNegocio;
import excecoes.ClienteExcecoes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ClienteCadastroView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JFormattedTextField txtDataNasc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteCadastroView frame = new ClienteCadastroView();
					frame.setVisible(true);
					frame.setTitle("Cadastro");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClienteCadastroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 13, 190, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(12, 50, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1.setBounds(12, 90, 56, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setBounds(12, 133, 56, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Data de Nascimento:");
		lblNewLabel_1_3.setBounds(12, 174, 140, 16);
		contentPane.add(lblNewLabel_1_3);
		
		txtNome = new JTextField();
		txtNome.setBounds(155, 42, 116, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(155, 87, 116, 22);
		contentPane.add(txtCpf);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(155, 130, 116, 22);
		contentPane.add(txtEmail);
		
		
		txtDataNasc = new JFormattedTextField();
		txtDataNasc.setColumns(10);
		txtDataNasc.setBounds(155, 171, 116, 22);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		MaskFormatter formater = new MaskFormatter();
		try {
			formater.setMask("##/##/####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		formater.install(txtDataNasc);
		contentPane.add(txtDataNasc);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cliente cli = new Cliente(txtNome.getText(), txtCpf.getText(),
							formato.parse(txtDataNasc.getText()), txtEmail.getText());
					ClienteNegocio cn = new ClienteNegocio();
					cn.inserirCliente(cli);
					JOptionPane.showMessageDialog(null,"Cliente cadastrado!");
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Algo errado na data! " + e1.getMessage());
				}catch (ClienteExcecoes e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3.getMessage());
				}
			}
		});
		btnCadastrar.setBounds(174, 246, 97, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteView cl = new ClienteView();
				cl.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(12, 246, 97, 25);
		contentPane.add(btnVoltar);
		
	}

}
