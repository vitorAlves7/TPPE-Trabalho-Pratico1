package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exception.LinhaOuColunaException;
import main.Parser;

public class FormatoTest {

	Parser parser;
	
	@Before
    public void setUp() throws Exception {
        this.parser = new Parser();
    }
	
	@Test
	public void retornaTruePassandoCaracterLouC() throws LinhaOuColunaException{
		String formatoSaida = "l";
		
		assertEquals(parser.verificaFormatoSaida(formatoSaida), true); 
	}
	
}
