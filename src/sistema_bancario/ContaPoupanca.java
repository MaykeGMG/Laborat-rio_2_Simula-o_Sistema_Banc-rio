package sistema_bancario;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(double saldo, String titular) { //construtor
		super(saldo, titular); //construtor herdado da super classe
	}

	@Override
	public void sacar(double num) { //método de saque comum
		if (this.saldo < num) {
			System.out.printf("Saldo insuficiente!%n	Saldo atual: %.2fR$%n", this.saldo);
		}else {
			System.out.println("Saque efetuado!");
			this.saldo -= num;
		}

	}

	@Override
	public void transferencia(Conta destino, double valor) { //método de trnasferencia
		if(this.saldo >= valor) {
			sacar(valor);
			destino.depositar(valor);
			System.out.println("Transferência efetuada!");
		}else {
			System.out.printf("Saldo insuficiente para trnasferência!%n	Saldo atual: %.2fR$%n", this.saldo);
		}

	}

}
