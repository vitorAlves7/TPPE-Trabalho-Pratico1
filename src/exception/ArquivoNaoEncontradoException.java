package exception;

public class ArquivoNaoEncontradoException extends Exception {
	public ArquivoNaoEncontradoException(String mensagem) {
		super("O arquivo " + mensagem + " não foi encontrado");
	}
}
