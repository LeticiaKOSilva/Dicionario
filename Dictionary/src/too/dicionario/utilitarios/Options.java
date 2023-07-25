package too.dicionario.utilitarios;

/**
 * Enum com todas as funcionalidades que o usuário possa escolher.
 * @author Leticia
 */
public enum Options {
	
	ADICIONAR("Adicionar"),
	TAMANHO("Tamanho"),
	BUSCARPALAVRACOMLETRA("Buscar palavra com letra"),
	BUSCARPALAVRACOMLETRAS("Buscar palavra com letras"),
	LISTARPALAVRAS("Listar palavras"),
	CONSULTARPALAVRA("Consultar palavra"),
	ALTERARPALAVRA("Alterar palavra"),
	EXCLUIRPALAVRA("Excluir palavra");
	
	private String option;
	
	Options(String option) {
		setOption(option);
	}
	
	public void setOption(String option) {
		this.option = option;
	}
	
	public String getOption() {
		return option;
	}
	
	public String toString() {
		return option;
	}
}//Enum Options
