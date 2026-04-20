package sistema_bancario;

public class ContaCorrente extends Conta implements ITributavel{

	public ContaCorrente(double saldo, String titular) {
		super(saldo, titular);
	}

	@Override
	public void sacar(double num) {
		if (this.saldo < num*1.05) {
			System.out.printf("Saldo insuficiente!%n	Saldo atual: %.2fR$%n	Valor necessário: %.2fR$%n", this.saldo, (num * 1.05));
		}else {
			this.saldo -= num*1.05;
		}
	}

	@Override
	public void transferencia() {

	}

	@Override
	public double calculaTributo() {
		double tributo = 0;
		tributo = this.saldo * 0.01;
		return tributo;
	}

}
