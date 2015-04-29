package banco.conta.aluno;

import java.util.List;

public class Conta{
	//defina suas variáveis de classe//TODO
	
	// Construtor da classe conta
	public Conta(int numeroConta, float saldoInicial) {
		//inicialize suas variáveis//TODO
	}
	
	// Retorna o número da conta
    public int getNumeroConta() {
		return 0;//TODO
	}

	// Retorna o saldo atual da conta
    public float getSaldo() {
		return 0.0f;//TODO
	}

	// Deposita se valor não for negativo e atualiza o extrato em caso de sucesso no depósito
    public boolean depositar(float valor) {
		return false;//TODO
	}

	// Saca se saldo suficiente e o valor não for negativo e atualiza o extrato em caso de sucesso no saque
    public boolean sacar(float value) {
		return false;//TODO
	}
	
	// Saca de uma conta e deposita da conta
	public boolean transferir(Conta conta, float valor) {
		return false;//TODO
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
		return null;//TODO
	}

}
