package desafio;

import java.util.Scanner;

public class DesafioApp {

	public static void main(String[] args) {
		
		System.out.println("DESAFIO DE PROGRAMAÇÃO - ACADEMIA CAPGEMINI");
		System.out.println(" ***** SEJA BEM VINDO *****");
		System.out.println("");
		System.out.println("QUESTÃO 1 :: DIGITE 1 PARA ACESSAR");
		System.out.println("QUESTÃO 2 :: DIGITE 2 PARA ACESSAR");
		
		/**
		 * INSTANCIAR LEITOR DO FRONT DA APLICACÃO
		 */
		Scanner scanner = new Scanner(System.in);
		
		/**
		 * INTERAÇÃO COM USUARIO.
		 */
		int numeroQuestao = scanner.nextInt();
		
		/**
		 * FECHAR LEITOR
		 */

		

		if(numeroQuestao == 1) {
			Questao1 questao1 = new Questao1();
			questao1.run();
		}
		
		
		if(numeroQuestao == 2) {
			Questao2 questao2 = new Questao2();
			questao2.run();
			
		}

		/**
		 * FECHAR SCANNER
		 */
		scanner.close();
	}

}
