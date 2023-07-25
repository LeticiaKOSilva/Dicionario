package too.dicionario.utilitarios;

import static too.dicionario.gui.InputAndOutput.*;

import java.util.List;

import too.dicionario.Dictionary;
import too.dicionario.gui.InputAndOutput;

/**
 * Classe responsável por criar funções utilitários que agregaram e ajudaram no andamento do programa.
 * @author Leticia
 */
public class Utilities implements Constants {
	
	/**
	 *Valida uma String verificando se ela é nula ou vazia.  
	 * @param word -> palavra a ser validada.
	 * @return true caso a palvra seja nula ou vazia ou false caso não.
	 */
	public static boolean validateString(String word) {
		return (word != null && !word.isBlank() ? true : false);
	}
	
	/**
	 * Solicita e fornece funcionalidades para que se pegue e retorne dados fornecidos pelo usuário. 
	 * @param message -> Mensagem a ser exibida pelo usuário.
	 * @return dado fornecido pelo usuário, null ou vazio caso nada seja selecionado.
	 */
	public static String readWord(String message) {
		String word;
		word = input(Constants.TITLE,message);
		return word;
	}
	
	/**
	 * Solicita e fornece dados para a mudança do tamanho da lista de palavras.
	 * @param dictionary -> lista de palavras.
	 * @return true em qualquer resultado.
	 */
	public static boolean modifySize(Dictionary dictionary) {
		int size;
		String response = InputAndOutput.input("Dicionario", "O tamanho escolhido para o dicionário chegou ao limite, deseja aumentar o tamanho?\n1-SIM \n2-NÃO:");
		
		if(response.equals("1")) {
			size = inputInt(Constants.TITLE,Constants.SIZE);
			if(size > 0) {
				dictionary.setIncreaseInitialSize(size);
				output("Dicionario", "Dicionário aumentado!");
			}else
				output("Dicionario", "Você forneceu um valor inválido");
		}
		return true;
	}
	
	/**
	 * Separa a lista de palavras sempre que encontrar um espaço.
	 * @param dictionary -> lista de palavras.
	 * @return um vetor do tipo String com todas as palavras.
	 */
	public static String[]separatesWords(List<String> dictionary){
		return dictionary.toString().split(" ");
	}
	
	/**
	 * Pesquisa na lista a posição de uma palavra.
	 * @param word -> palavra que será pesquisada na lista
	 * @param dictionary -> Objeto do tipo Dictionary.
	 * @return a posição ou -1 caso a palavra não seja encontrada.
	 */
	public static int checkTheStartingPosition(String word,List<String> dictionary) {
		return dictionary.indexOf(word);
	}
}//class Utilities
