package sistema_bancario;

public class ContaCorrente extends Conta implements ITributavel{

	public ContaCorrente(double saldo, String titular) { //construtor
		super(saldo, titular); //construtor herdado da superclasse
	}

	@Override
	public void sacar(double num) { //método de saque com taxa
		if (this.saldo < num*1.05) {
			System.out.printf("Saldo insuficiente!%n	Saldo atual: %.2fR$%n	Valor necessário: %.2fR$%n", this.saldo, (num * 1.05));
		}else {
			System.out.println("Saque efetuado!\n");
			this.saldo -= num*1.05;
		}
	}

	@Override
	public void transferencia(Conta destino, double valor) { //método de transferencia considerando a mesma taxa do saque
		if(this.saldo >= valor*1.05) {
			sacar(valor);
			destino.depositar(valor);
			System.out.println("Transferência finalizada com sucesso!\n");
		}else {
			System.out.printf("Saldo insuficiente!%n	Saldo atual: %.2fR$%n	Valor necessário para esta trnasferência: %.2fR$%n", this.saldo, (valor * 1.05));
		}
	}
	
	@Override
	public void getInfo() {
		super.getInfo();
		System.out.println("Tipo - Conta Corrente\n");
	}

	@Override
	public double calculaTributo() { //método de cálculo de tributo da conta
		double tributo = 0;
		tributo = this.saldo * 0.01;
		return tributo;
	}

}
