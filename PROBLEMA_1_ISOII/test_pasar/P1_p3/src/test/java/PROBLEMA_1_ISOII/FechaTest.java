package PROBLEMA_1_ISOII;

import static org.junit.Assert.*;
import org.junit.Test;

public class FechaTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructor_anioNegativo_lanzaExcepcion() {
        new Fecha(-1);
    }

    @Test
    public void constructor_anioCero_seGuarda() {
        Fecha f = new Fecha(0);
        assertEquals(0, f.getAnio());
    }

    @Test
    public void constructor_anioUno_seGuarda() {
        Fecha f = new Fecha(1);
        assertEquals(1, f.getAnio());
    }

    @Test
    public void constructor_maxValue_seGuarda() {
        Fecha f = new Fecha(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, f.getAnio());
    }

    @Test
    public void esBisiesto_multiploDe4NoDe100_true() {
        assertTrue(new Fecha(2024).esBisiesto());
    }

    @Test
    public void esBisiesto_noMultiploDe4_false() {
        assertFalse(new Fecha(2023).esBisiesto());
    }

    @Test
    public void esBisiesto_sigloNoMultiploDe400_false() {
        assertFalse(new Fecha(1900).esBisiesto());
    }

    @Test
    public void esBisiesto_multiploDe400_true() {
        assertTrue(new Fecha(2000).esBisiesto());
    }

    @Test
    public void esBisiesto_valorLimite_3_false_y_4_true() {
        assertFalse(new Fecha(3).esBisiesto());
        assertTrue(new Fecha(4).esBisiesto());
    }

    @Test
    public void esBisiesto_400000_true() {
        assertTrue(new Fecha(400000).esBisiesto());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void constructor_minValue_lanzaExcepcion() {
        new Fecha(Integer.MIN_VALUE);
    }
    
    @Test
    public void esBisiesto_valorLimite_100_false_y_400_true() {
        assertFalse(new Fecha(100).esBisiesto());
        assertTrue(new Fecha(400).esBisiesto());
    }

    @Test
    public void esBisiesto_anioCero_true_porFormula() {
        assertTrue(new Fecha(0).esBisiesto());
    }
}
