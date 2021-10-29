package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import exception.ArquivoNaoEncontradoException;
import exception.DelimitadorInvalidoException;
import exception.LinhaOuColunaException;



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

	public File getArquivo() {
		return file;
	}

	public void defineLimitador(String delimitador) throws DelimitadorInvalidoException {
		if(delimitador.length() != 1) {
			throw new DelimitadorInvalidoException("O delimitador deve ser um único caractere.");
		}
		else {
			this.delimitador = delimitador;
		}
	}

	public String getDelimitador() {
		return this.delimitador;
	}
	
	public void abrirArquivoSaida(String path) throws IOException {
		//Falsifica��o
	}

	public File getArquivoSaida() {
		return new File("output.out"); //Falsifica��o
	}
	
	public String readFile(String path, Charset encoding) throws IOException {
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
	
	public boolean verificaFormatoSaida(String formatoSaida) throws LinhaOuColunaException{
		if (formatoSaida.equals("l") || formatoSaida.equals("L") || formatoSaida.equals("c") || formatoSaida.equals("C")) {
			return true;
		} else {
			throw new LinhaOuColunaException("Escolha um caracter válido.");
		}
	}
	
	public void escreverNoArquivo(String formatoSaida, String[] dadosArquivo, String delimitador) throws LinhaOuColunaException, IOException {
		try {
			verificaFormatoSaida(formatoSaida);
			
			if (formatoSaida.equals("l") || formatoSaida.equals("L")) {
				apresentarPorLinha(dadosArquivo, delimitador);
			} else if (formatoSaida.equals("c") || formatoSaida.equals("C")) {
				apresentarPorColuna(dadosArquivo, delimitador);
			}
		} catch (Error e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	private void apresentarPorLinha(String[] dadosArquivo, String delimitador) throws IOException {			
		FileWriter myWriter = new FileWriter("filename");

		int i = 0;
		
		try {
			for(String caracter : dadosArquivo) { 
				if(String.valueOf("-").equals(new String(new char[]{caracter.charAt(0)}))) {
					if(i != 0)
						myWriter.write("\n");
					caracter = String.valueOf(++i);
				}
				
				myWriter.write(caracter);
				myWriter.write(delimitador);
			}
			myWriter.close();
			System.out.println("Arquivo escrito com sucesso");
		} catch (IOException e) {
	      System.out.println("Um erro ocorreu.");
	      e.printStackTrace();
	    }
		
	}
	
	private void apresentarPorColuna(String[] dadosArquivo, String delimitador) throws IOException {
//		FileWriter myWriter = new FileWriter("filename.txt");
		System.out.println(file.getName());
	}
	
}