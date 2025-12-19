package PROBLEMA_1_ISOII;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class mainTest {

    private InputStream originalIn;
    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;

    @Before
    public void setUp() {
        originalIn = System.in;
        originalOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    private String ejecutarMainConEntrada(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        main.main(new String[0]);
        return outContent.toString();
    }

    @Test
    public void main_anioBisiesto_imprimeBisiesto() {
        String salida = ejecutarMainConEntrada("2024\n");
        assertTrue("Salida esperada con 'bisiesto' pero fue: " + salida, salida.contains("es bisiesto"));
    }

    @Test
    public void main_anioNoBisiesto_imprimeNoBisiesto() {
        String salida = ejecutarMainConEntrada("2023\n");
        assertTrue("Salida esperada con 'no es bisiesto' pero fue: " + salida, salida.contains("no es bisiesto"));
    }

    @Test
    public void main_entradaNoNumerica_imprimeError() {
        String salida = ejecutarMainConEntrada("abc\n");
        assertTrue("Salida esperada con 'Error' pero fue: " + salida, salida.contains("Error:"));
    }

    @Test
    public void main_anioNegativo_imprimeError() {
        String salida = ejecutarMainConEntrada("-1\n");
        assertTrue("Se esperaba que imprimiera algún mensaje de error. Salida: " + salida,
                salida.trim().length() > 0);
    }
}
