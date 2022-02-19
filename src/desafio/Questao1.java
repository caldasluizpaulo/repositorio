package desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * QUESTÃO 1
 * ESCREVA UM ALGORITMO QUE MOSTRE NA TELA UMA ESCADA.
 * DE TAMANHO N UTILIZANDO O CARACTERE * E ESPAÇOS. 
 * A BASE E ALTURA DA ESCADA DEVEM SER IGUAIS AO VALOR DE N. 
 * A ÚLTIMA LINHA NÃO DEVE CONTER NENHUM ESPAÇO.
 * 
 * @author LUIZ PAULO CALDAS
 *
 */
public class Questao1 {
	
	
	public void run() {

		/**
		 * INSTANCIAR LEITOR E CRIAR LISTA PARA DEGRAUS
		 */
		Scanner leitor = new Scanner(System.in);
		List<String> degraus = new ArrayList<>();

		/**
		 * INTERAÇÃO USUARIO. QUESTIONAR QUANTIDADE DE DEGRAUS
		 */
		System.out.print("Digite a quantidade de degraus: ");
		int quantidadeDegraus = leitor.nextInt();

		/**
		 * FECHAR LEITOR
		 */
		leitor.close();

		/**
		 * CRIAR DEGRAU E E ADICIONAR NA LISTA
		 */
		for (int i = 0; i < quantidadeDegraus; i++) {
			degraus.add(" ".repeat(quantidadeDegraus - i) + "*".repeat(i + 1));
		}

		/**
		 * IMPRIMIR ESCADA
		 */
		for (String d : degraus) {
			System.out.println(d);
		}

	}

}
