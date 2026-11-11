package cafetera;

import org.junit.Test;
import static org.junit.Assert.*;

public class AzucareroTest {

    @Test
    public void deberiaDevolverVerdaderoSiHaySuficienteAzucar() {
        Azucarero azucarero = new Azucarero(10);

        boolean resultado = azucarero.hasAzucar(5);
        assertEquals(true, resultado);

        resultado = azucarero.hasAzucar(10);
        assertEquals(true, resultado);
    }
    
        @Test
    public void deberiaDevolverFalsoSiNoHaySuficienteAzucar() {
        Azucarero azucarero = new Azucarero(10);

        boolean resultado = azucarero.hasAzucar(15);

        assertEquals(false, resultado);
    }
    
    @Test
public void deberiaRestarAzucarAlAzucarero() {
    Azucarero azucarero = new Azucarero(10);

    azucarero.giveAzucar(5);
    assertEquals(5, azucarero.getCantidadAzucar());

    azucarero.giveAzucar(2);
    assertEquals(3, azucarero.getCantidadAzucar());
}
}