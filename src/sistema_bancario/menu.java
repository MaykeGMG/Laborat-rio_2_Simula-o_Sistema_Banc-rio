package sistema_bancario;

import java.util.ArrayList;
import java.util.Scanner;

public class menu {
	
	static Scanner leitor = new Scanner(System.in);//scnner para entrada de dados
	static ArrayList<Conta> contas = new ArrayList<>();//arraylist para guardar lista de contas
	
	public static void realizarDeposito(int num, double valor) {
		for (Conta conta : contas) { 			//percorrer lista de contas
			if (conta.getNumConta() == num) {	//procurar conta pelo número
				conta.depositar(valor);
			}else {
				System.out.printf("Não foi possível encontrar a conta %d%n", num);
			}
		}
	};
	
	public static void realizarSaque() {
		
	};
	
	public static void realizarTransferencia() {
		
	};
	
	public static void listarContas() {
		
	};
	
	public static void calcularTributosTotal() {
		
	};
	
	public static void menu() {
		
		
		int opcao;//variavel de escolha da funcionalidade
		
		do { 							//loop do menu
			
			System.out.println("""
					================================
					1 - Criar Conta
					2 - Realizar Depósito
					3 - realizar Saque
					4 - Realizar Tranferência
					5 - Listar Contas
					6 - Calcular Total de Tributos
					7 - Sair
					
					Selecione a opção que deseja:  
					""");
			opcao = leitor.nextInt();
			leitor.nextLine();  //limpar o \n do buffer
			
			switch (opcao) {
			
			case 1:  // criar conta
				System.out.println("""
						===============================
							Criar Nova Conta
								
						Informe o nome do titular da nova conta:  
						""");
				String nome = leitor.nextLine(); //leitura do nome
				
				System.out.println("Informe o saldo:  ");
				double saldo = leitor.nextDouble(); //leitura do saldo
				
				System.out.println("""
						informe o tipo da conta
						Conta Corrente - 1
						Conta Poupança - 2
						
						""");
				while (true) {
					
					int tipo = leitor.nextInt(); //leitura do tipo de conta
					leitor.nextLine();
					
					Conta novaConta = null; //instanciando objeto da conta 
					
					if (tipo == 1) {
						novaConta = new ContaCorrente(saldo, nome); //criando objeto da conta corrente
					}else if(tipo == 2) {
						novaConta = new ContaPoupanca(saldo, nome); //criando objeto da conta poupança
					}else {
						System.out.println("Valor invpalido!");
						continue;
					}
					
					contas.add(novaConta); //adiciona objeto ao arraylist
					System.out.println("Conta criada com sucesso!");
					break; //sair do laço while(true)
				}
				break; //sair/finalizar a opçao 1
				
			case 2:  //depositar
				System.out.println("""
						===============================
							Depositar
								
						Informe o nome do titular da nova conta:  
						""");
				int num = leitor.nextInt();
				
				System.out.println("Informe o numero da conta em que deseja realizar o depósito");
				double valor = leitor.nextDouble();
				leitor.nextLine();
				
				realizarDeposito(num, valor);
			case 3:
				realizarSaque();
			case 4:
				realizarTransferencia();
			case 5:
				listarContas();
			case 6:
				calcularTributosTotal();
			case 7:
				System.out.println("Fechando.");
				break;
			default:
				System.out.println("Opção inválida");
		        break;
			}
		} while (opcao != 7);
	}
	
}
