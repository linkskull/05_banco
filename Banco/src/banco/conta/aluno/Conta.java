package banco.conta.aluno;

import java.util.ArrayList;
import java.util.List;

public class Conta{
	private int numeroConta;
	private float saldo;
	private List<Float> extrato;
	
	// Construtor da classe conta
	public Conta(int numeroConta, float saldoInicial) {
		this.numeroConta = numeroConta;
		this.saldo = saldoInicial;
		extrato = new ArrayList<Float>();
		extrato.add(saldo);
	}
	
	// Retorna o número da conta
    public int getNumeroConta() {
		return numeroConta;
	}

	// Retorna o saldo atual da conta
    public float getSaldo() {
		return saldo;
	}

	// Deposita se valor não for negativo e atualiza o extrato em caso de sucesso no depósito
    public boolean depositar(float valor) {
		if(valor >= 0) {
			saldo += valor;
			extrato.add(saldo);
			return true;
		}
		return false;
	}

	// Saca se saldo suficiente e o valor não for negativo e atualiza o extrato em caso de sucesso no saque
    public boolean sacar(float value) {
		if(value >= 0 && value <= saldo) {
			saldo -= value;
			extrato.add(saldo);
			return true;
		}
		return false;
	}
	
	// Saca de uma conta e deposita da conta
	public boolean transferir(Conta conta, float valor) {
		if(sacar(valor))
			if(!conta.depositar(valor)) {
				depositar(valor);
				return false;
			} else {
				return true;
			}
		return false;
	}

	/* Retorna o relatório de transações da conta 
     * Ex.:
     * Conta inicia em 0.0
     * extrato = [0.0]
     * 
     * Depositou 20.0
     * extrato = [0.0, 20.0]
     * 
     * Sacou 10.0
     * extrato = [0.0, 20.0, 10.0]
     * 
     * Depositou 15.0
     * extrato = [0.0, 20.0, 10.0, 25.0]
     * 
     * Sacou 8.0
     * extrato = [0.0, 20.0, 10.0, 25.0, 17.0]
     * 
     * 0.0 e 17.0 são os valores de abertura e saldo final
     */
	public List<Float> getExtrato() {
		return extrato;
	}

}
