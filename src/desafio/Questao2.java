package desafio;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * QUEST�O 02
 *
 * D�BORA SE INSCREVEU EM UMA REDE SOCIAL PARA SE MANTER EM CONTATO COM SEUS AMIGOS. 
 * A P�GINA DE CADASTRO EXIGIA O PREENCHIMENTO DOS CAMPOS DE NOME E SENHA, 
 * 
 * POR�M A SENHA PRECISA SER FORTE. 
 * O SITE CONSIDERA UMA SENHA FORTE QUANDO ELA SATISFAZ OS SEGUINTES CRIT�RIOS:
 * 
 * POSSUI NO M�NIMO 6 CARACTERES.
 * CONT�M NO M�NIMO 1 DIGITO.
 * CONT�M NO M�NIMO 1 LETRA EM MIN�SCULO.
 * CONT�M NO M�NIMO 1 LETRA EM MAI�SCULO.
 * CONT�M NO M�NIMO 1 CARACTERE ESPECIAL. OS CARACTERES ESPECIAIS S�O: !@#$%^&*()-+
 * 
 * D�BORA DIGITOU UMA STRING ALEAT�RIA NO CAMPO DE SENHA, 
 * POR�M ELA N�O TEM CERTEZA SE � UMA SENHA FORTE. 
 * PARA AJUDAR D�BORA, 
 * 
 * CONSTRUA UM ALGORITMO QUE INFORME: QUAL � O N�MERO M�NIMO DE CARACTERES QUE DEVEM SER 
 * ADICIONADOS PARA UMA STRING QUALQUER SER CONSIDERADA SEGURA.
 * 
 * @author LUIZ PAULO CALDAS
 *
 */
public class Questao2 {


	public void run() {

		/**
		 * INSTANCIAR LEITOR
		 */
		Scanner leitor2 = new Scanner(System.in);

		/**
		 * INTERA��O USUARIO. QUESTIONAR QUANTIDADE DE DEGRAUS
		 */
		System.out.println("Digite uma senha forte: ");
		String senhaForte = leitor2.next();

		/**
		 * FECHAR LEITOR
		 */
		leitor2.close();

		/**
		 * VALIDA SENHA
		 */	
		System.out.println( validaSenhaForte(senhaForte) );

	}


	public int validaSenhaForte(String senha) {
		
		int caracteresAchados = 0;
		
		// POSSUI NO M�NIMO 1 CARACTERES?
		if (senha.length() > 0) {

			// CONT�M NO M�NIMO 1 DIGITO?
			if(padraoValidacao("[0-9]",senha))
				caracteresAchados++;
			
			// N�O CONT�M NO M�NIMO 1 LETRA EM min�sculo?
			if(padraoValidacao("[a-z]",senha))
				caracteresAchados++;

			// N�O CONT�M NO M�NIMO 1 LETRA EM MAI�SCULO?
			if(padraoValidacao("[A-Z]",senha))
				caracteresAchados++;
			
			// CONT�M NO M�NIMO 1 CARACTERE ESPECIAL. OS CARACTERES ESPECIAIS S�O: !@#$%^&*()-+ 
			if(padraoValidacao("(?=.*[!@^#()$&%+\\-\\*]).{1,}",senha))
				caracteresAchados++;
			

		// QUANTIFIFCA CARACTERES NECESSARIOS PARA SENHA FORTE
		return totalCaracteresNecessario(senha.length(), caracteresAchados);
		
		
		} else {
			return 6;
		}
	}
	
	
	/**
	 * 
	 * @param senha
	 * @param index
	 * @return RETORNA VERDADEIRO SE CONT�M NO M�NIMO O QUE PROCURA
	 */
	public boolean padraoValidacao(String regex, String senha) {
		Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(senha);

		return matcher.find();
	}

	
	/**
	 * 
	 * @param tamanhoSenha
	 * @param caracteresAchados
	 * @return QUANTIDADE NECESSARIO PARA TORNAR UMA SENHA FORTE
	 */
	private int totalCaracteresNecessario(int tamanhoSenha, int caracteresAchados) {

		// DIGITOU IGUAL OU MAIOR QUE 6 CARACTERES:
		if (tamanhoSenha >= 6) {
			// SENHA FORTE (IDEAL)
			if (caracteresAchados == 4)
				return 0;

			// SENHA FRACA
			if(caracteresAchados < 4)
				return (4 - caracteresAchados);
		}
		
		
		// DIGITOU MENOS QUE 6 (PIOR CASO)
		int resultante = 6 - ((4 - caracteresAchados) + caracteresAchados);
		return resultante + (4 - caracteresAchados);
	}
	
}