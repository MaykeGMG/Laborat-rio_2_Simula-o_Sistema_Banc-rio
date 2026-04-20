package sistema_bancario;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(double saldo, String titular) {
		super(saldo, titular);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sacar(double num) {
		if (this.saldo < num) {
			System.out.printf("Saldo insuficiente!%n	Saldo atual: %.2fR$%n", this.saldo);
		}else {
			System.out.println("Saque efetuado!");
			this.saldo -= num;
		}

	}

	@Override
	public void transferencia() {
		// TODO Auto-generated method stub

	}

}
