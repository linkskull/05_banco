package banco.conta;

import java.util.List;

public interface IConta {
	// Retorna o número da conta
    public int getNumeroConta();

    // Retorna o saldo atual da conta
    public float getSaldo();

    // Deposita se valor não for negativo e atualiza o extrato em caso de sucesso no depósito
    public boolean depositar(float valor);

    // Saca se saldo suficiente e o valor não for negativo e atualiza o extrato em caso de sucesso no saque
    public boolean sacar(float value);
    
    // Saca de uma conta e deposita da conta
    public boolean transferir(IConta conta, float valor);

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
    List<Float> getExtrato();
}
