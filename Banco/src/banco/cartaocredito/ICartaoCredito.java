package banco.cartaocredito;

import java.util.List;

public interface ICartaoCredito {
	// Retorna o numero do cartão
	public int getNumeroCartao();
	
	// Retorna o limite do cartão 
	public float getLimite();
	
	// Retorna o limite restante do cartão
	public float getLimiteParaSaque();
	
	// Retorna o valor da fatura
	public float getValorFatura();
	
	// Realiza a retiurada de um determinado valor do limite. O valor é atualizado na fatura 
	public boolean solicitarCredito(float valor);
	
	// Realiza o pagamento total ou de parte da fatura
	public void pagarFatura(float valor);
	
	/* Retorna a fatura do cartẽo
	 * Ex.:
	 * Cartão inicia com limite: 100.0
	 * limiteParaSaque: 100.0
	 * fatura = [100.0]
	 * 
	 * solicitarCredito(30.0)
	 * limiteParaSaque: 70.0
	 * fatura = [30.0]
	 * 
	 * solicitarCredito(20.0)
	 * limiteParaSaque: 50.0
	 * fatura = [50.0]
	 */
	public List<Float> getExtrato();
}
