package sistema_bancario;

public abstract class Conta {
	
	private static int numeroContas = 1000; // atributo estático da classe para numero da conta
	
	protected int numConta;
	protected double saldo;
	protected String titular;

	public Conta(double saldo, String titular) { //construtor
		this.saldo = saldo;
		this.titular = titular;
		this.numConta = gerarNum();
	}
	
	private int gerarNum() { //método para atrubuir valor único da conta
		return ++numeroContas;
	}
	
	public void depositar(double valor) {// método de depósito
		this.saldo += valor;
		System.out.println("Depósito efetuado!");
	};
	
	public int getNumConta() { //getter do número da conta
		return this.numConta;
	}
	
	public void getInfo() { //exibir informações da conta
		System.out.printf("Informações da conta:%nNúmero da conta: %d%nTitular: %s%nSaldo: %.2fR$%n", this.numConta, this.titular, this.saldo);
	}
	
	//métodos abstratos
	public abstract void sacar(double num);
	
	public abstract void transferencia(Conta destino, double num);	

}
