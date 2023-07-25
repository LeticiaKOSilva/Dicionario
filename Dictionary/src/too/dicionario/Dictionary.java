package too.dicionario;

import java.util.ArrayList;
import java.util.List;
import static too.dicionario.utilitarios.Utilities.*;

/**
 * Classe responsável por criar uma lista de palavras que representaria um dicionário.
 * @author Leticia
 */
public class Dictionary {
	
	//Declaração de variáveis de classe como privadas
	private List<String>dictionary;
	private char separator;
	private int initialSize;
	
	public Dictionary() {
		this.separator = '#';
		this.initialSize = 0;
	}
	
	public Dictionary(char separator) {
		this.separator = separator;
	}
	
	public Dictionary(int initialSize) {
		this.initialSize = initialSize;
	}
	
	public Dictionary(int initialSize,char separator) {
		this.separator = separator;
		this.initialSize = initialSize;
		dictionary = new ArrayList<>();
	}
	
	public String toString() {
		return String.format("%c%s",separator,dictionary.toString());
	}
	
	public char getSeparator() {
		return separator;
	}
	
	public void setIncreaseInitialSize(int size) {
		this.initialSize = size;
	}
	
	public int getInitialSize() {
		return initialSize;
	}
	
	/**
	 * Adiciona a palavra no dicionário.
	 * @param word -> Palavra a ser adicionada no lista de palavras.
	 * @return true se a palavra foi adicionada no dicionário ou false se não
	 */
	public boolean addWord(String word) {
		if(checkTheStartingPosition(word.toLowerCase(),dictionary) >= 0)
			return false;
		else
			dictionary.add(String.format("%c%s ",separator,word.toLowerCase()));
		return true;
	}//addWord()
	
	/**
	 * Obtém o número de palavras do dicionário.
	 * @return número de palavras
	 */
	public int size() {
		return dictionary.size();
	}//size()
	
	/**
	 * Obtém uma lista de palavras do dicionário separadas pelo caractere separador que começam
	   com o caractere especificado.
	 * @param character -> caracter com a letra inicial a ser procurada na lista
	 * @return null se nenhuma palavra existir no dicionário.
	 */
	public String getWords(char character) {
		StringBuilder stringBuilder = new StringBuilder();
		//Convertendo a versaoString em um arry de Strings
		//String[] separacao = separaPalavras();
		
		//Loop para verificar se existe palavra com o mesmo intervalo
		for(String string : dictionary)
			if(string.startsWith(String.format("%c%s",separator,String.valueOf(character))))
				stringBuilder.append(String.format("\n%s",string));
		
		if(stringBuilder.isEmpty())
			return null;
		
		return stringBuilder.toString();
	}//getWords()
	
	/**
	 * Obtém uma lista de palavras do dicionário separadas pelo caractere separador que começam
	   com a substring especificada. 
	 * @param substring -> substring com pedaço de possível palavras que tenham na lista de palavras.
	 * @return null se nenhuma palavra existir no dicionário.
	 */
	public String getWords(String substring) {
		StringBuilder stringBuilder = new StringBuilder();
		//Convertendo a versaoString em um arry de Strings
		//String[] separacao = separaPalavras();
		
		//Loop para verificar se existe palavra com o mesmo intervalo
		for(String string : dictionary) 
			if(string.startsWith(String.format("%c%s",separator,substring.toLowerCase())))
				stringBuilder.append(String.format("\n%s",string));
		
		if(stringBuilder.isEmpty())
			return null;
		return stringBuilder.toString();
	}//getWords()
	
	/**
	 * Obtém uma lista com todas as palavras do dicionário separadas pelo caractere separador.
	 * @return null se nenhuma palavra existir no dicionário.
	 */
	public String list() {
		//String[] separacaoDicionario = separaPalavras();
		StringBuilder listB = new StringBuilder();
		
		if(dictionary.isEmpty())
			return null;
		
		for(var word : dictionary)
			listB.append(String.format("\n%s",word));
		return listB.toString();
	}//list()
	
	/**
	 * Pesquisa uma palavra no dicionário.
	 * @param word -> Palavra que será pesquisada na lista.
	 * @return true caso a palavra seja encontrada na lista e false caso não
	 */
	public boolean consultWord(String word) {
		String rewordedWord = String.format("%c%s ",separator,word);
		
		if(dictionary.size() <= 0)
			return false;
		
		for(String words : dictionary)
			if(words.equals(rewordedWord))
				return true;
		return false;
	}//consultWord()
	
	/**
	 * Altera uma palavra no dicionário substituindo por uma outra palavra.
	 * @param currentWord -> palavra que deve ser alterada.
	 * @param newWord -> palavra que irá substituir a antiga.
	 * @return true caso a palvra seja alterada a false caso não.
	 */
	public boolean changeWord(String currentWord, String newWord) {
		String wordA = String.format("%c%s ",separator,currentWord);
		int positionI = checkTheStartingPosition(wordA,dictionary);
		
		if(dictionary.size() <= 0)
			return false;
		
		if(positionI >= 0) {
			dictionary.set(positionI,String.format("%c%s ",separator,newWord));
			return true;
		}
		return false;
	}//changeWord()
	
	/**
	 * Exclui a palavra do dicionário.
	 * @param word -> palavra a ser removida na lista.
	 * @return true caso a palavra seja excluída e false caso não.
	 */
	public boolean RemoveWord(String word) {
		String wordR = String.format("%c%s ",separator,word);
		int positionI = checkTheStartingPosition(wordR,dictionary);
		if(positionI >= 0) {
			dictionary.remove(wordR);
			return true;
		}
		return false;
	}//RemoveWord()
	
}//class Dictionary
