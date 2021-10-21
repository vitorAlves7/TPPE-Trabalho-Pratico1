import java.io.IOException;
import java.nio.charset.StandardCharsets;

import exception.ArquivoNaoEncontradoException;
import exception.DelimitadorInvalidoException;
import exception.LinhaOuColunaException;
import main.Parser;

public class main {

	public static void main(String[] args) throws ArquivoNaoEncontradoException, IOException, DelimitadorInvalidoException, LinhaOuColunaException {
		Parser p = new Parser();
		
		p.lerArquivo("src/files/analysisTime.out");
		p.defineLimitador(";");
		
		String conteudoArquivo = p.readFile(p.getArquivo().getPath(), StandardCharsets.UTF_8);
		String[] conteudoArquivoArray = conteudoArquivo.split("\\r?\\n");
//		int i = 0;
//		System.out.println(conteudoArquivoArray[0]);
		
//		char[] arrayConteudoArquivo = conteudoArquivo.toCharArray();
		
//		
//		for(String caracter : conteudoArquivoArray) { 
//			
////			System.out.println(String.valueOf(caracter.charAt(0)));
//			if(String.valueOf("-").equals(new String(new char[]{caracter.charAt(0)}))) {
////				System.out.println(++i + p.getDelimitador());
//				if(i != 0)
//					System.out.println();
//				caracter = String.valueOf(++i);
//			}
//			
//			System.out.print(caracter);
//			System.out.print(p.getDelimitador());
//		}
//		p.linhaOuColuna("l", conteudoArquivoArray, p.getDelimitador());
		p.linhaOuColuna("c", conteudoArquivoArray, p.getDelimitador());

	}

}
