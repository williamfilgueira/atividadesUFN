package praticando06;

public class Main {

	public static void main(String[] args) {

		ContaCorrente conta = new ContaCorrente();

		conta.numero = "123456";
		conta.agencia = "1232";
		conta.especial = true;
		conta.valorEspecialUsado = 0;
		conta.limiteEspecial = 500;
		conta.saldo = -10;

		conta.consultarSaldo();
		boolean saqueEfetuado = conta.sacar(10);
		if (saqueEfetuado) {
			System.out.println("Saque efetuado com sucesso");
			conta.consultarSaldo();

		} else {
			System.out.println("Não foi possível realizar saque.");
		}

		conta.depositar(20);
		conta.consultarSaldo();
		
		if(conta.verificarUsoChequeEspecial()) {
			System.out.println("Está usando cheque especial");
		}else {
			System.out.println("Não está usando o cheque especial");
		}
		conta.depositar(50);
		conta.consultarSaldo();
		conta.sacar(60);
		conta.consultarSaldo();
		
		
		
	}

}
