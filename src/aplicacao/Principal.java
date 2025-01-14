package aplicacao;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("--------------");
			System.out.println("DADOS DA CONTA");
			System.out.println("--------------");
			System.out.println();
			System.out.print("N�mero da Conta: ");
			int numerodaconta = sc.nextInt();
			System.out.print("Titular da Conta(M�ximo de 10 caracteres): ");
			sc.nextLine();
			String titular = sc.nextLine();
			Conta conta = new Conta(numerodaconta, titular);//VERIFICA�A� DO TAMANHO DO NOME ACIMA DE 10 CARACTERES
			
			System.out.print("Deposito inicial acima de R$500,00: ");
			double deposito = sc.nextDouble();
			Conta conta1 = new Conta(numerodaconta, titular, deposito, 300.00);//VERIFICA��O DO DEPOSITO MAIOR QUE R$500,00 

			System.out.print("Deseja fazer alguma opera��o?(s/n) ");
			char y = sc.next().charAt(0);
			if (y == 's') {
				do {
					System.out.print("Digite 1 para deposito, 2 para saque ou 3 para consulta:");
					char x = sc.next().charAt(0);
					switch (x) {
					case '1':
						System.out.print("Valor do dep�sito:");
						double valor = sc.nextDouble();
						conta1.deposito(valor);
						break;
					case '2':
						System.out.print("Valor do saque:");
						valor = sc.nextDouble();
						conta1.saque(valor);//VERIFICA��O DOS LIMITES DE SALDO SUFICIENTE E LIMITE DE SAQUE
						break;
					case '3':
						System.out.println(conta1.toString());
						break;
					default:
						System.out.print("D�gito inv�lido");
						break;
					}
					System.out.print("Deseja fazer alguma opera��o?(s/n) ");
					y = sc.next().charAt(0);
				} while (y == 's');
			}

			System.out.print(conta.toString());
		}

		catch (ContaException e) {
			System.out.println(e.getMessage());
		}

	}
}
