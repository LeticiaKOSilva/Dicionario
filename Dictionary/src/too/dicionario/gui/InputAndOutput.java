package too.dicionario.gui;

import javax.swing.JOptionPane;

import too.dicionario.utilitarios.Constants;

/**
 * Classe responsável por uma interface GUI, que lê, retorna ou printa valores do programa.
 * @author Leticia
 */
public class InputAndOutput implements Constants{
	
	/**
	 * Exibe uma lista de opções para que o usuário escolha a opção desejada.
	 * @param title -> Título do programa.
	 * @param message -> Mensagem que será exibida ao usuário.
	 * @param opcoes -> Vetor de object com todas as opções a serem escolhidas.
	 * @return a escolha do usuário ou null representando que o usuário deseja sair do programa.
	 */
	public static Object inputOptions(String title,String message,Object[] options) {
		Object choice = JOptionPane.showInputDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		return choice;
	}
	
	/**
	 * Converte uma string em um número.
	 * @param choice -> valor que será convertido para o tipo inteiro.
	 * @return valor convertido em um inteiro ou 0 caso não seja possível fazer a conversão.
	 */
	public static int convertInt(String choice) {
		int convert = 0;
		
		try {
			convert = Integer.parseInt(choice);
		}catch(Exception exception) {
			msgError(TITLE,String.format("%s O valor fornecido não é um número !",
					ERROR_MESSAGE));
		}
		return convert;
	}
	
	/**
	 * Lê um valor inteiro.
	 * @param title -> Título do programa.
	 * @param message -> Mensagem que será exibida ao usuário.
	 * @return valor inteiro ou 0 caso o valor fornecido não seja um inteiro.
	 */
	public static int inputInt(String title,String message) {
		return convertInt(input(title,message));
	}
	
	/**
	 * Lê dados fornecidos pelo usuário.
	 * @param title -> Título do programa.
	 * @param message -> Mensagem que será exibida ao usuário.
	 * @return valor fornecido ou null caso nada tenha sido escolhido ou o usuário queira sair do programa.
	 */
	public static String input(String title,String message) {
		String choice = JOptionPane.showInputDialog(null,message,title,JOptionPane.QUESTION_MESSAGE);
		return choice;
	}
	
	/**
	 * Exibe na tela uma mensagem de erro para o usuário.
	 * @param title -> Título do programa.
	 * @param message -> Mensagem que será exibida ao usuário.
	 */
	public static void msgError(String title,String message) {
		JOptionPane.showMessageDialog(null, message, title,JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Exibe na tela uma mensagem de indicando o encerramento do programa para o usuário.
	 * @param title -> Título do programa.
	 * @param message -> Mensagem que será exibida ao usuário.
	 */
	public static void msgClose(String title,String message) {
		JOptionPane.showMessageDialog(null,message,title,JOptionPane.ERROR_MESSAGE);
	}
		
	/**
	 * Exibe na tela uma mensagem para o usuário.
	 * @param title -> Título do programa.
	 * @param message -> Mensagem que será exibida ao usuário.
	 */
	public static void output(String title,String message) {
		JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE);
	}

}//Class InputAndOutput
