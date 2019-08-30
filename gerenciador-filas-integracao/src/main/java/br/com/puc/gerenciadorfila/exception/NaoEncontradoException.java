package br.com.puc.gerenciadorfila.exception;

/**
* <p>
* 
* <strong>Descricao: </strong>
* Trabalho de Conclusao de Curso - Especializacao PUC MINAS<br>
* Curso: Arquitetura de Solucoes
* 
* @author Julivan Barbosa da Silva
**/
public class NaoEncontradoException extends RuntimeException {

	/** UID **/
	private static final long serialVersionUID = -4699874906409635349L;

	public NaoEncontradoException() {
		super();
	}

	public NaoEncontradoException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public NaoEncontradoException(final String message) {
		super(message);
	}
	
	public NaoEncontradoException(final Throwable cause) {
		super(cause);
	}
}
