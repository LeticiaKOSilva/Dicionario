package too.dicionario;

import static too.dicionario.gui.InputAndOutput.*;
import too.dicionario.utilitarios.Options;
import static too.dicionario.utilitarios.Utilities.*;
import too.dicionario.utilitarios.Constants;

/**
 * Classe responsável por executar o programa.
 * @author Leticia
 */
public class Main implements Constants {
	
	/**
	 * Método responsável pela inicialização do programa
	 */
	public static void main(String[] args) {
		new Main().callsMenu();
	}//main()
	
	
	private void callsMenu() {
		menu();
		System.exit(0);
	}//callsMenu()
	
	
	/**
	 * Cria um vetor de Object com as opções que o usuário poderá escolher.
	 * @return array do tipo object com as opções que podem ser escolhidas pelos usuários.
	 */
	private Object[] options() {
		Object [] option = {"Adicionar","Tamanho","Buscar palavra com letra",
							"Buscar palavra com letras","Listar palavras",
							"Consultar palavra","Alterar palavra","Excluir palavra"};
		return option;
	}//options()
	

	/**
	 * Solicita e valida os valores tamanho do tipo <code>int</code> e separador
	 * do tipo <code>String</code>, chamando um dos construtores da classe Dicionário.
	 * Depois solicita ao usuário que forneça as opção desejada, caso ele deseje sair
	 * manda-se um mensagem e o programa e encerrado
	 */
	private void menu() {
		Object choice;
		int size;
		String separator;
		
		size = inputInt(TITLE,SIZE);
		separator = input(TITLE,SEPARATOR);
		
		if(separator != null && !separator.isBlank() && size > 0) {
			Dictionary dictionary = new Dictionary(size, separator.charAt(0));
			
			do {
				choice = inputOptions(TITLE,INPUT_MESSAGE,options());
				
				if(choice != null)
					checkChoice(choice,dictionary);
//				else
//					msgClose(Constantes.TITULO,Constantes.MENSAGEM_SAIDA);
			}while(choice != null);
		}else
			msgClose(TITLE,EXIT_PROGRAM);
	}//menu()
	
	/**
	 * Verifica a funcionalidade escolhida pelo usuário.
	 * @param choice -> funcionalidade escolhida pelo usuário.
	 * @param dictionary -> Objeto do tipo Dictionary.
	 */
	private void checkChoice(Object choice,Dictionary dictionary) {
		
		String option = choice.toString().replaceAll(" ","").toUpperCase();
		
		switch(Options.valueOf(option)) {
				
			case ADICIONAR:
				add(dictionary);
			break;
			
			case TAMANHO:
				sizee(dictionary);
			break;
			
			case BUSCARPALAVRACOMLETRA:
				searchWordWithLetter(dictionary);
			break;
			
			case BUSCARPALAVRACOMLETRAS:
				searchWordWithLetters(dictionary);
			break;
			
			case LISTARPALAVRAS:
				listWords(dictionary);
			break;
			
			case CONSULTARPALAVRA:
				consultWord(dictionary);
			break;
			
			case ALTERARPALAVRA:
				changeWord(dictionary);
			break;
			
			case EXCLUIRPALAVRA:
				removeWord(dictionary);
			break;
		}
	}//checkChoice()
	
	/**
	 * Lê e exibe uma sequência de palavras que possuírem determinada sequência 
	 * @param dictionary -> Objeto do tipo Dictionary.
	 */
	private void searchWordWithLetters(Dictionary dictionary) {
		if(dictionary.size() <= 0)
			output(TITLE, EMPTY);
		else {
			String word = readWord(INPUTP_MESSAGE);
			
			if(validateString(word)) {
				String result = dictionary.getWords(word.toLowerCase());
				output(TITLE, validateString(result) ? result : "Não a palavras que começem com essa letra no dicionário!");
			}else
				output(TITLE,"Não a palavras que começem com essa letra no dicionário!");
		}
	}//searchWordWithLetters()
	
	
	/**
	 * Solicita e fornece os dados para a exclusão de uma palavra no dicionário.
	 * @param dictionary -> Objeto do tipo Dictionary.
	 */
	private void removeWord(Dictionary dictionary) {
		
		if(dictionary.size() <= 0)
			output(TITLE, EMPTY);
		else {
			String word = readWord(MESSAGE_DELETE);
			
			if(validateString(word))
				dictionary.RemoveWord(word.toLowerCase());
			else 
				output(TITLE,NON_EXISTENT_WORD);
		}
		
	}//removeWord()
	
	/**
	 * Solicita e fornece os dados para a alteração de uma palavra no dicionário.
	 * @param dictionary -> Objeto do tipo Dictionary.
	 */
	private void changeWord(Dictionary dictionary) {
		
		if(dictionary.size() <= 0)
			output(TITLE, EMPTY);
		else {
			String word = readWord(CHANGE_MESSAGE),
					newWord = readWord(ADD_MESSAGE);
			
			if(validateString(word) && validateString(newWord)) {
				if(dictionary.changeWord(word.toLowerCase(), newWord.toLowerCase()))
					output(TITLE,CHANGED_WORD);
				else 
					msgError(TITLE,NON_EXISTENT_WORD);
			}else 
				msgError(TITLE,INVALID_DATA);
		}
	}//changeWord()
	
	/**
	 * Solicita e fornece os dados para que seja feita a consulta de uma palavra no dicionário.
	 * @param dictionary -> Objeto do tipo Dictionary.
	 */
	private void consultWord(Dictionary dictionary) {
		
		if(dictionary.size() <= 0)
			output(TITLE, EMPTY);
		else {
			String word = readWord(MESSAGE_CONSULT);
			
			if(validateString(word))
				if(dictionary.consultWord(word.toLowerCase()))
					output(TITLE,String.format("A palavra %s existe no dicionário",word));
				else
					msgError(TITLE,NON_EXISTENT_WORD);
			else 
				msgError(TITLE,INVALID_DATA);
		}
	}//consultWord()
	
	/**
	 * Printa a lista de palavras.
	 * @param dictionary -> Objeto do tipo Dictionary.
	 */
	private void listWords(Dictionary dictionary) {
		
		if(dictionary.size() <= 0)
			output(TITLE, EMPTY);
		else {
			String words = dictionary.list();
			
			if(validateString(words))
				output(TITLE,String.format("%s\n%s",LISTING_MESSAGE,words));
			else {
				msgError(TITLE,ANY_WORD);
				return;
			}
		}
	}//listWords()
	
	/**
	 * Solicita e fornece os dados para pesquisar palavras que comecem com determinado caracter.
	 * @param dictionary -> Objeto do tipo Dictionary.
	 */
	private void searchWordWithLetter(Dictionary dictionary) {
		
		if(dictionary.size() <= 0)
			output(TITLE, EMPTY);
		else {
			String word = readWord(INPUTL_MESSAGE);
			
			if(validateString(word)) {
				String result = dictionary.getWords(word.toLowerCase().charAt(0));
				output(TITLE, validateString(result) ? result : "Não a palavras que começem com essa letra no dicionário!");
			}else
				output(TITLE,"Não a palavras que começem com essa letra no dicionário!");
		}
	}//searchWordWithLetter()
	
	/**
	 * Solicita e printa o tamanho do dicionário.
	 * @param dictionary -> Objeto do tipo Dictionary.
	 */
	private static void sizee(Dictionary dictionary) {
		output(TITLE,String.format("%s%d",DICTIONARY_SIZE,dictionary.size()));
	}//sizee()
	
	/**
	 * Solicita e fornece os dados para que se possa adicionar uma nova palavra no dicionário.
	 * @param dictionary -> Objeto do tipo Dictionary.
	 * @return true caso tenha sido adicionado com sucesso e false caso não.
	 */
	private boolean add(Dictionary dictionary) {
		if(dictionary.getInitialSize() > dictionary.size()) {
			String word = readWord(INPUT_MESSAGE);

			if(validateString(word))
				dictionary.addWord(word);
			else 
				msgError(TITLE,INVALID_DATA);
		}else 
			modifySize(dictionary);
		return true;
	}//add()

}//class Main
