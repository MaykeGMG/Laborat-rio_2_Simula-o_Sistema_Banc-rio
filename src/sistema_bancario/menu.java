package sistema_bancario;

import java.util.ArrayList;
import java.util.Scanner;

public class menu {
	
	static Scanner leitor = new Scanner(System.in);//scnner para entrada de dados
	static ArrayList<Conta> contas = new ArrayList<>();//arraylist para guardar lista de contas
	
	public static void realizarDeposito(int num, double valor) {
		
		if (valor <= 0) {							//testar valor negativo ou nulo
			System.out.println("Valor inválido!");
			return;
		}
		
		Conta c1 = buscarConta(num);		//buscar conta na lista
		
		if (c1 != null) {
			c1.depositar(valor);
		}else {
			System.out.printf("Não foi possível encontrar a conta %d%n", num);
		}
	};
	
	public static void realizarSaque(int num, double valor) {
		if (valor <= 0) {							//testar valor negativo ou nulo
			System.out.println("Valor inválido!");
			return;
		}
		
		Conta c1 = buscarConta(num);		//buscar conta na lista
		
		if (c1 != null) {
			c1.sacar(valor);
		}else {
			System.out.printf("Não foi possível encontrar a conta %d%n", num);
		}
	};
	
	public static Conta buscarConta(int num) { //método auxiliar par buscar a conta na lista pelo número
		for (Conta conta : contas) {
			if (conta.getNumConta() == num) {
				return conta;
			}
		}
		return null;
	}
	
	public static void realizarTransferencia(int num1, int num2, double valor) {
		if (valor <= 0) {
	        System.out.println("Valor inválido!");
	        return;
	    }

	    Conta origem = buscarConta(num1);
	    Conta destino = buscarConta(num2);

	    if (origem == null) {
	        System.out.printf("Conta de origem %d não encontrada!%n", num1);
	    } else if (destino == null) {
	        System.out.printf("Conta de destino %d não encontrada!%n", num2);
	    } else if (origem == destino) {
	        System.out.println("Não é possível transferir para a mesma conta!\n");
	    } else {
	        origem.transferencia(destino, valor);
	    }
	};
	
	public static void listarContas() {
		for (Conta conta : contas) {
			conta.getInfo();
		}
	};
	
	public static void calcularTributosTotal() {
		
		double total = 0;
		
		for (Conta conta : contas) {
			
			if (conta instanceof ITributavel) {
				total += ((ITributavel) conta).calculaTributo();
			}
		}
		
		System.out.printf("Total de tributos a recolher: %.2fR$%n%n", total);
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
							CRIAR NOVA CONTA
								
						Informe o nome do titular da nova conta:  
						""");
				String nome = leitor.nextLine(); //leitura do nome
				
				System.out.println("Informe o saldo:\n");
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
					System.out.println("Conta criada com sucesso!\n");
					novaConta.getInfo();
					break; //sair do laço while(true)
				}
				break; //sair/finalizar a opçao 1
				
			case 2:  //depositar
				System.out.println("""
						===============================
							DEPÓSITO
								
						Informe número conta:  
						""");
				int numDeposito = leitor.nextInt();
				
				System.out.println("Informe valor que deseja depositar: \n");
				double valorDeposito = leitor.nextDouble();
				leitor.nextLine();
				
				realizarDeposito(numDeposito, valorDeposito);
				break;//sair/finalizar a opçao 2
				
			case 3:  //sacar
				System.out.println("""
						===============================
							SAQUE
								
						Informe número conta:  
						""");
				int numSaque = leitor.nextInt();
				
				System.out.println("Informe valor que deseja sacar:\n");
				double valorSaque = leitor.nextDouble();
				leitor.nextLine();
				
				realizarSaque(numSaque, valorSaque);
				break;//sair/finalizar a opçao 3
				
			case 4: //transferir
				System.out.println("""
						===============================
							TRANSFRÊNCIA
								
						Informe número conta de origem:  
						""");
				int num1 = leitor.nextInt();
				
				System.out.println("Informe o número da conta de destino:\n");
				int num2 = leitor.nextInt();
				
				System.out.println("Informe valor que deseja Trnasferir:\n");
				double valorTransferencia = leitor.nextDouble();
				leitor.nextLine();
				
				realizarTransferencia(num1, num2, valorTransferencia);
				break;//sair/finalizar a opçao 4
				
			case 5: //impimir liesta de contas
				System.out.println("""
						===============================
							LISTA DE CONTAS  
						""");
				
				listarContas();
				break;//sair/finalizar a opçao 5
				
			case 6: // calcular soma de tributos das contas
				System.out.println("""
						===============================
						  TOTAL DE TRIBUTOS A RECOLHER
								
						Informe número conta de origem:  
						""");
				calcularTributosTotal();
				break;//sair/finalizar a opçao 6
				
			case 7:
				System.out.println("Encerrando aplicação.\n");
				break;//sair/finalizar menu
				
			default:
				System.out.println("Opção inválida");
		        break;
			}
		} while (opcao != 7);
	}
	
}
