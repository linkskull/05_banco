package banco.conta.aluno;

import java.util.ArrayList;
import java.util.List;

import banco.conta.IConta;

public class CConta implements IConta {
	private int numeroConta;
	private float saldo;
	private List<Float> extrato;
	
	public CConta(int numeroConta, float saldoInicial) {
		this.numeroConta = numeroConta;
		this.saldo = saldoInicial;
		extrato = new ArrayList<Float>();
		extrato.add(saldo);
	}
	
	@Override
	public int getNumeroConta() {
		return numeroConta;
	}

	@Override
	public float getSaldo() {
		return saldo;
	}

	@Override
	public boolean depositar(float valor) {
		if(valor >= 0) {
			saldo += valor;
			extrato.add(saldo);
			return true;
		}
		return false;
	}

	@Override
	public boolean sacar(float value) {
		if(value >= 0 && value <= saldo) {
			saldo -= value;
			extrato.add(saldo);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean transferir(IConta conta, float valor) {
		if(sacar(valor))
			if(!conta.depositar(valor)) {
				depositar(valor);
				return false;
			} else {
				return true;
			}
		return false;
	}

	@Override
	public List<Float> getExtrato() {
		return extrato;
	}

}
