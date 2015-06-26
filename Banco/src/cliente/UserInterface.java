package cliente;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import aluno.Conta;

public class UserInterface extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane textPane;
	private Conta conta;
	Component parent;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Criando o a janela
	 */
	public UserInterface() {
		conta = new Conta(1234, 100.0f);
		parent = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnSacar);
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { sacar(); }
		});
		
		JButton btnDeposito = new JButton("Depositar");
		btnDeposito.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnDeposito);
		btnDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { depositar(); }
		});
		
		JButton btnSaldo = new JButton("Ver Saldo");
		btnSaldo.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnSaldo);
		btnSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { verSaldo(); }
		});
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		contentPane.add(textPane);
		
		// Atualizando o extrato em tela
		atualizarExtrato();
	}
	
	public void sacar() {
		String res = JOptionPane.showInputDialog("Digite o valor do saque");
		
		try {
			float valor = Float.parseFloat(res);
			if(conta.sacar(valor))
				JOptionPane.showMessageDialog(parent, "Saque realizado!");
			else if (conta.getSaldo() < valor)
				JOptionPane.showMessageDialog(parent, "Saldo insuficiente!");
			else 
				JOptionPane.showMessageDialog(parent, "Valor inválido!");
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(parent, "Valor inválido!");
		}
		
		// Atualizando o extrato em tela
		atualizarExtrato();
	}
	
	public void depositar() {
		String res = JOptionPane.showInputDialog("Digite o valor do depósito");
		
		try {
			float valor = Float.parseFloat(res);
			if(conta.depositar(valor))
				JOptionPane.showMessageDialog(parent, "Depósito realizado!");
			else 
				JOptionPane.showMessageDialog(parent, "Valor inválido!");
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(parent, "Valor inválido!");
		}
		
		// Atualizando o extrato em tela
		atualizarExtrato();
	}
	
	public void verSaldo() {
		JOptionPane.showMessageDialog(parent, "Seu saldo é: R$ " + String.format("%.2f", conta.getSaldo()));
	}
	
	public void atualizarExtrato() {
		String extrato = "Extrato:\n";
		
		List<Float> ex = conta.getExtrato();
		for(Float f: ex)
			extrato += String.format("%.2f", f) + "\n";
		
		textPane.setText(extrato);
	}
}
