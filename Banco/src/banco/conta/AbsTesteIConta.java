package banco.conta;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class AbsTesteIConta {
	
	public abstract IConta getInstance(int numeroConta, float saldoInicial);
	
	@Test
	public void testGetNumeroConta() {
		IConta conta = getInstance(7685, 100.0f);
		
		assertTrue(conta.getNumeroConta() == 7685);
	}
	
	@Test
	public void testSaldo() {
		IConta conta = getInstance(7685, 100.0f);
		
		assertTrue(conta.getSaldo() == 100.0);
	}
	
	@Test
	public void testDeposito() {
		IConta conta = getInstance(7685, 100.0f);
		
		assertFalse(conta.depositar(-10));
		assertTrue(conta.depositar(10));
	}
	
	@Test
	public void testSacar() {
		IConta conta = getInstance(7685, 100.0f);
		
		assertFalse(conta.sacar(-1));
		assertFalse(conta.sacar(101));
		assertTrue(conta.sacar(10));
	}
	
	@Test
	public void testGetExtrato() {
		IConta conta = getInstance(7685, 100.0f);

		assertFalse(conta.sacar(-50));
		assertTrue(conta.sacar(50));
		assertTrue(conta.getSaldo() == 50.0);
		assertFalse(conta.depositar(-50));
		assertTrue(conta.depositar(50));
		assertTrue(conta.getSaldo() == 100);
		assertTrue(conta.sacar(10));
		assertTrue(conta.getSaldo() == 90);
		assertTrue(conta.depositar(5.5f));
		assertTrue(conta.getSaldo() == 95.5);
		
		List<Float> extrato = new ArrayList<Float>();
		extrato.add(100f);
		extrato.add(50f);
		extrato.add(100f);
		extrato.add(90f);
		extrato.add(95.5f);
		
		assertTrue(conta.getExtrato().equals(extrato));
	}
	
}
