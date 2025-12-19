package PROBLEMA_1_ISOII;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConsolaTest {

    private InputStream originalIn;

    @Before
    public void guardarSystemIn() {
        originalIn = System.in;
    }

    @After
    public void restaurarSystemIn() {
        System.setIn(originalIn);
    }

    private Consola consolaConInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        return new Consola();
    }

    @Test
    public void leerInt_10_devuelve10() {
        assertEquals(10, consolaConInput("10\n").leerInt("msg"));
    }

    @Test
    public void leerInt_0_devuelve0() {
        assertEquals(0, consolaConInput("0\n").leerInt("msg"));
    }

    @Test
    public void leerInt_negativo_devuelveNegativo() {
        assertEquals(-5, consolaConInput("-5\n").leerInt("msg"));
    }

    @Test
    public void leerInt_maxInt_ok() {
        assertEquals(Integer.MAX_VALUE, consolaConInput("2147483647\n").leerInt("msg"));
    }

    @Test
    public void leerInt_minInt_ok() {
        assertEquals(Integer.MIN_VALUE, consolaConInput("-2147483648\n").leerInt("msg"));
    }

    @Test(expected = NumberFormatException.class)
    public void leerInt_abc_excepcion() {
        consolaConInput("abc\n").leerInt("msg");
    }

    @Test(expected = NumberFormatException.class)
    public void leerInt_vacio_excepcion() {
        consolaConInput("\n").leerInt("msg");
    }

    @Test(expected = NumberFormatException.class)
    public void leerInt_espacios_excepcion() {
        consolaConInput("   \n").leerInt("msg");
    }

    @Test(expected = NumberFormatException.class)
    public void leerInt_numeroConLetras_excepcion() {
        consolaConInput("11sw\n").leerInt("msg");
    }

    @Test
    public void leerDouble_decimal_ok() {
        assertEquals(54.43, consolaConInput("54.43\n").leerDouble("msg"), 1e-9);
    }

    @Test
    public void leerDouble_entero_ok() {
        assertEquals(3.0, consolaConInput("3\n").leerDouble("msg"), 0.0);
    }

    @Test
    public void leerDouble_cero_ok() {
        assertEquals(0.0, consolaConInput("0.0\n").leerDouble("msg"), 0.0);
    }

    @Test
    public void leerDouble_maxDouble_ok() {
        assertEquals(Double.MAX_VALUE,
                consolaConInput("1.7976931348623157E308\n").leerDouble("msg"),
                0.0);
    }

    @Test(expected = NumberFormatException.class)
    public void leerDouble_abc_excepcion() {
        consolaConInput("abc\n").leerDouble("msg");
    }

    @Test(expected = NumberFormatException.class)
    public void leerDouble_vacio_excepcion() {
        consolaConInput("\n").leerDouble("msg");
    }

    @Test(expected = NumberFormatException.class)
    public void leerDouble_comaDecimal_excepcion() {
        consolaConInput("54,23\n").leerDouble("msg");
    }

    @Test
    public void leerCadena_texto_ok() {
        assertEquals("Hola", consolaConInput("Hola\n").leerCadena("msg"));
    }

    @Test
    public void leerCadena_vacia_ok() {
        assertEquals("", consolaConInput("\n").leerCadena("msg"));
    }

    @Test
    public void leerCadena_espacios_ok() {
        assertEquals("   ", consolaConInput("   \n").leerCadena("msg"));
    }
}

