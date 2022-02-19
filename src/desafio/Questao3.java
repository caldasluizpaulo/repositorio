package desafio;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * QUESTÃO 03
 * DUAS PALAVRAS PODEM SER CONSIDERADAS ANAGRAMAS DE SI MESMAS 
 * SE AS LETRAS DE UMA PALAVRA PODEM SER REALOCADAS PARA FORMAR A OUTRA PALAVRA. 
 * 
 * DADA UMA STRING QUALQUER, DESENVOLVA UM ALGORITMO QUE 
 * ENCONTRE O NÚMERO DE PARES DE SUBSTRINGS QUE SÃO ANAGRAMAS.
 * 
 * @author LUIZ PAULO CALDAS
 *
 */
public class Questao3 {


		public void run() {
			
			/**
			 * INSTANCIAR LEITOR
			 */
			Scanner leitor3 = new Scanner(System.in);

			/**
			 * INTERAÇÃO USUARIO.
			 */
			System.out.println("Digite um texto para buscar pares do anagrama: ");
			String textoAnagrama = leitor3.next();

			/**
			 * FECHAR LEITOR
			 */
			leitor3.close();

			/**
			 * GERAR PARES DO ANAGRAMA
			 */	
			gerarAnagrama(textoAnagrama);
			
		}

		/**
		 * 
		 * @param s
		 */
		static void gerarAnagrama(String textoAnagrama){
			
			int quantidadeDepares = 0;
			
			// MAPA DE VALORES
			HashMap<String, Integer> map = new HashMap<>();

			// VERIFICA CADA POSIÇÃO DO TEXTO COM PROXIMO
			for(int i = 0; i < textoAnagrama.length(); i++){
				
				for(int j = i; j < textoAnagrama.length(); j++){
				
					// OBTER A POSICAO ATUAL DO TEXTO ATÉ A PROXIMA POSICAO E GUARDAR NO VETOR
					char[] textoVetor = textoAnagrama.substring(i, j+1).toCharArray();
					
					// ORDENAR VETOR GERADO
					Arrays.sort(textoVetor);
					
					// GERAR NOVO TEXTO PARA SER COMPARADO
					String novoTexto = new String(textoVetor);
					
					//VERIFICA SE CONTEM UMA CHAVE COM O NOVO TEXTO
					if (map.containsKey(novoTexto))
						map.put(novoTexto, map.get(novoTexto)+1);
					else
						map.put(novoTexto, 1);
				}
			}
			
			
			// REALIZA BUSCA DO ANAGRAMA PELA CHAVE
			for(String key: map.keySet()){
				int n = map.get(key);
				// REALIZA CALCULO DE PARES
				quantidadeDepares += (n * (n-1))/2;
			}
			
			// IMPRIMIR QUANTIDADE DE PARES DE ANAGRAMAS
			System.out.println(quantidadeDepares);
		}
	}
