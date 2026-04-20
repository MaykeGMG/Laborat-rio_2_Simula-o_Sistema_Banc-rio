package sistema_bancario;

import java.util.Scanner;

public class menu {
	
	public void criarConta() {};
	
	public void realizarDeposito() {};
	
	public void realizarSaque() {};
	
	public void realizarTransferencia() {};
	
	public void listarContas() {};
	
	public void calcularTributos() {};
	
	public static void menu() {
		
		Scanner leitor = new Scanner(System.in);//declaração de um scner para entrada de dados
		
		int opcao;//variavel de escolha da funcionalidade
		
		do {
			opcao = leitor.nextInt();
			
			System.out.println("""
					================================
					1 - Criar Conta
					2 - Realizar Depósito
					3 - realizar Saque
					4 - Realizar Tranferência
					5 - Listar Contas
					6 - Calcular Tributos
					7 - Sair
					
					Selecione a opção que deseja:  
					""");
			
			switch (opcao) {
			case 1:
				
			case 2:
				
			case 3:
				
			case 4:
				
			case 5:
			
			case 6:
			
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
