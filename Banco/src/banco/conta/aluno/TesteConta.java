package banco.conta.aluno;

import banco.conta.AbsTesteIConta;
import banco.conta.IConta;

public class TesteConta extends AbsTesteIConta {

	@Override
	public IConta getInstance(int numeroConta, float saldoInicial) {
		return new CConta(numeroConta, saldoInicial);
	}

}
