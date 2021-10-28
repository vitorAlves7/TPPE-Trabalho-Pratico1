import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import exception.ArquivoNaoEncontradoException;
import exception.DelimitadorInvalidoException;
import exception.LinhaOuColunaException;
import main.Parser;

public class main {

	public static void main(String[] args) throws ArquivoNaoEncontradoException, IOException, DelimitadorInvalidoException, LinhaOuColunaException {
		Parser p = new Parser();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Informe o delimitador: ");
		String delimitador = scanner.next();
		p.defineLimitador(delimitador);
		
		System.out.println("Informe o formato da saída ('l' para linha ou 'c' para coluna): ");
		String formatoSaida = scanner.next();
		
		p.lerArquivo("src/files/analysisTime.out");
		
		String conteudoArquivo = p.readFile(p.getArquivo().getPath(), StandardCharsets.UTF_8);
		String[] conteudoArquivoArray = conteudoArquivo.split("\\r?\\n");

		p.escreverNoArquivo(formatoSaida, conteudoArquivoArray, p.getDelimitador());
	}

}
