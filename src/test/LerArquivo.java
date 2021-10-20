package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exception.ArquivoNaoEncontradoException;
import main.Parser;

public class LerArquivo {

	private Parser parser;

	@Before
	public void start() throws Exception {
		parser = new Parser();
	}

	@Test
	public void testeAbrirArquivo1() throws ArquivoNaoEncontradoException {
		String path = "src/files/analysisTime.out";
		parser.lerArquivo(path);
		assertEquals(parser.getArquivo(path).getPath(), path);
	}

}