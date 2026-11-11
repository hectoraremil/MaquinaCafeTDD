package cafetera;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaquinaDeCafeTest {

    private Vaso vasosPequeno;
    private Vaso vasosMediano;
    private Vaso vasosGrande;
    private Cafetera cafetera;
    private Azucarero azucarero;
    private MaquinaDeCafe maquinaDeCafe;

    @Before
    public void prepararMaquina() {
        vasosPequeno = new Vaso(5, 10);
        vasosMediano = new Vaso(5, 20);
        vasosGrande = new Vaso(5, 30);
        cafetera = new Cafetera(50);
        azucarero = new Azucarero(20);
        maquinaDeCafe = new MaquinaDeCafe();

        maquinaDeCafe.setVasosPequeno(vasosPequeno);
        maquinaDeCafe.setVasosMediano(vasosMediano);
        maquinaDeCafe.setVasosGrande(vasosGrande);
        maquinaDeCafe.setCafetera(cafetera);
        maquinaDeCafe.setAzucarero(azucarero);
    }

    @Test
    public void deberiaDevolverVasoPequeno() {
        Vaso resultado = maquinaDeCafe.getTipoDeVaso("pequeno");
        assertEquals(vasosPequeno, resultado);
    }

    @Test
    public void deberiaDevolverVasoMediano() {
        Vaso resultado = maquinaDeCafe.getTipoDeVaso("mediano");
        assertEquals(vasosMediano, resultado);
    }

    @Test
    public void deberiaDevolverVasoGrande() {
        Vaso resultado = maquinaDeCafe.getTipoDeVaso("grande");
        assertEquals(vasosGrande, resultado);
    }

    @Test
    public void deberiaDevolverNoHayVasos() {
        String resultado = maquinaDeCafe.getVasoDeCafe(
            vasosPequeno, 10, 2
        );
        assertEquals("No hay Vasos", resultado);
    }

    @Test
    public void deberiaDevolverNoHayCafe() {
        maquinaDeCafe.setCafetera(new Cafetera(5));

        String resultado = maquinaDeCafe.getVasoDeCafe(
            vasosPequeno, 1, 2
        );
        assertEquals("No hay Cafe", resultado);
    }

    @Test
    public void deberiaDevolverNoHayAzucar() {
        maquinaDeCafe.setAzucarero(new Azucarero(2));

        String resultado = maquinaDeCafe.getVasoDeCafe(
            vasosPequeno, 1, 3
        );
        assertEquals("No hay Azucar", resultado);
    }

    @Test
    public void deberiaRestarCafeAlServir() {
        maquinaDeCafe.getVasoDeCafe(vasosPequeno, 1, 3);
        assertEquals(40, cafetera.getCantidadCafe());
    }

    @Test
    public void deberiaRestarVasosAlServir() {
        maquinaDeCafe.getVasoDeCafe(vasosPequeno, 1, 3);
        assertEquals(4, vasosPequeno.getCantidadVasos());
    }

    @Test
    public void deberiaRestarAzucarAlServir() {
        maquinaDeCafe.getVasoDeCafe(vasosPequeno, 1, 3);
        assertEquals(17, azucarero.getCantidadAzucar());
    }

    @Test
    public void deberiaDevolverFelicitacionesAlServir() {
        String resultado = maquinaDeCafe.getVasoDeCafe(
            vasosPequeno, 1, 3
        );
        assertEquals("Felicitaciones", resultado);
    }
}