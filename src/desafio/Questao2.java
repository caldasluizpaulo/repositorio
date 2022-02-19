package desafio;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * QUESTÃO 02
 *
 * DÉBORA SE INSCREVEU EM UMA REDE SOCIAL PARA SE MANTER EM CONTATO COM SEUS AMIGOS. 
 * A PÁGINA DE CADASTRO EXIGIA O PREENCHIMENTO DOS CAMPOS DE NOME E SENHA, 
 * 
 * PORÉM A SENHA PRECISA SER FORTE. 
 * O SITE CONSIDERA UMA SENHA FORTE QUANDO ELA SATISFAZ OS SEGUINTES CRITÉRIOS:
 * 
 * POSSUI NO MÍNIMO 6 CARACTERES.
 * CONTÉM NO MÍNIMO 1 DIGITO.
 * CONTÉM NO MÍNIMO 1 LETRA EM MINÚSCULO.
 * CONTÉM NO MÍNIMO 1 LETRA EM MAIÚSCULO.
 * CONTÉM NO MÍNIMO 1 CARACTERE ESPECIAL. OS CARACTERES ESPECIAIS SÃO: !@#$%^&*()-+
 * 
 * DÉBORA DIGITOU UMA STRING ALEATÓRIA NO CAMPO DE SENHA, 
 * PORÉM ELA NÃO TEM CERTEZA SE É UMA SENHA FORTE. 
 * PARA AJUDAR DÉBORA, 
 * 
 * CONSTRUA UM ALGORITMO QUE INFORME: QUAL É O NÚMERO MÍNIMO DE CARACTERES QUE DEVEM SER 
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
		 * INTERAÇÃO USUARIO. QUESTIONAR QUANTIDADE DE DEGRAUS
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
		
		// POSSUI NO MÍNIMO 1 CARACTERES?
		if (senha.length() > 0) {

			// CONTÉM NO MÍNIMO 1 DIGITO?
			if(padraoValidacao("[0-9]",senha))
				caracteresAchados++;
			
			// NÃO CONTÉM NO MÍNIMO 1 LETRA EM minúsculo?
			if(padraoValidacao("[a-z]",senha))
				caracteresAchados++;

			// NÃO CONTÉM NO MÍNIMO 1 LETRA EM MAIÚSCULO?
			if(padraoValidacao("[A-Z]",senha))
				caracteresAchados++;
			
			// CONTÉM NO MÍNIMO 1 CARACTERE ESPECIAL. OS CARACTERES ESPECIAIS SÃO: !@#$%^&*()-+ 
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
	 * @return RETORNA VERDADEIRO SE CONTÉM NO MÍNIMO O QUE PROCURA
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