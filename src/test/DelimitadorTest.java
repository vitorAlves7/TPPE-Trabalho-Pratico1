package test;
import static org.junit.Assert.*;

import exception.DelimitadorInvalidoException;
import main.Parser;
import org.junit.Before;
import org.junit.Test;

public class DelimitadorTest {

        private Parser parser;

    @Before
    public void setUp() throws Exception {
        this.parser = new Parser();
    }

    @Test
    public void testeLimitador1() throws DelimitadorInvalidoException {
        parser.defineLimitador(";");
        assertEquals(parser.getDelimitador(), ";"); //falsificação
    }

}