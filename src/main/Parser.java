package main;

import java.io.File;
import exception.ArquivoNaoEncontradoException;

public class Parser {

	private File file;

	public void lerArquivo(String path) throws ArquivoNaoEncontradoException {
		File file = new File(path);
		if(file.exists()) {
			this.file = file;
		}
		else {
			throw new ArquivoNaoEncontradoException(path);
		}
	}

	public File getArquivo(String path) {
		return file;
	}
	
}