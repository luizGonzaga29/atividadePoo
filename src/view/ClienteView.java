package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteView frame = new ClienteView();
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
	public ClienteView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tela cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(244, 73, 174, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteCadastroView cdv = new ClienteCadastroView();
				cdv.setLocationRelativeTo(null);
				cdv.setVisible(true);
				cdv.setResizable(false);
				dispose();
			}
		});
		btnCadastro.setBounds(131, 211, 97, 25);
		contentPane.add(btnCadastro);
		
		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisaClienteView pcv = new PesquisaClienteView();
				pcv.setLocationRelativeTo(null);
				pcv.setVisible(true);
				pcv.setResizable(false);
				dispose();
			}
		});
		btnPesquisa.setBounds(262, 211, 97, 25);
		contentPane.add(btnPesquisa);
		
		JButton btnCompra = new JButton("Compra");
		btnCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CompraView cv = new CompraView();
				cv.setLocationRelativeTo(null);
				cv.setVisible(true);
				cv.setResizable(false);
				dispose();
			}
		});
		btnCompra.setBounds(418, 211, 97, 25);
		contentPane.add(btnCompra);
	}

}
