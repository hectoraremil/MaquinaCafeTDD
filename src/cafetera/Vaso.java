package cafetera;

public class Vaso {

    private int cantidadVasos;
    private int contenido;

    public Vaso(int cantidadVasos, int contenido) {
        this.cantidadVasos = cantidadVasos;
        this.contenido = contenido;
    }

    public boolean hasVasos(int cantidad) {
        return cantidadVasos >= cantidad;
    }

    public void giveVasos(int cantidad) {
        cantidadVasos -= cantidad;
    }

    public int getCantidadVasos() {
        return cantidadVasos;
    }

    public int getContenido() {
        return contenido;
    }
}