package praticando06;

public class ContaCorrente {

	public String numero;
	public String agencia;
	boolean especial;
	double valorEspecialUsado;
	double limiteEspecial;
	double saldo;

	boolean sacar(double valorASacar) {

		if (saldo >= valorASacar) {
			saldo -= valorASacar;
			return true;
		} else {
			if (especial) {
				double limite = limiteEspecial + saldo;
				if (limite >= valorASacar) {
					saldo -= valorASacar;
					return true;
				} else {
					return false;
				}
			} else {
				return false;

			}
		}

	}
	
	void depositar(double valorDepositado) {
		saldo += valorDepositado;
	}
	
	void consultarSaldo() {
		System.out.println("Saldo atual da conta = "+ saldo);
	}
	
	boolean verificarUsoChequeEspecial() {
		return saldo < 0;
	}

}
