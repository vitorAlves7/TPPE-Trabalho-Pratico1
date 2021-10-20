package main;

import java.io.File;
import java.io.IOException;

import exception.ArquivoNaoEncontradoException;
import exception.DelimitadorInvalidoException;

public class Parser {

	private File file;
	private String delimitador;

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

	public void defineLimitador(String delimitador) throws DelimitadorInvalidoException {
		if(delimitador.length() != 1) {
			throw new DelimitadorInvalidoException("O delimitador deve ser um unico caractere.");
		}
		else {
			this.delimitador = delimitador;
		}
	}

	public String getDelimitador() {
		return ";";
	}
	
	public void abrirArquivoSaida(String path) throws IOException {
		//Falsificação
	}

	public File getArquivoSaida() {
		return new File("output.out"); //Falsificação
	}
	
}