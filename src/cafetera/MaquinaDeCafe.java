package cafetera;

public class MaquinaDeCafe {

    private Vaso vasosPequeno;
    private Vaso vasosMediano;
    private Vaso vasosGrande;
    private Cafetera cafetera;
    private Azucarero azucarero;

    public void setVasosPequeno(Vaso vasosPequeno) {
        this.vasosPequeno = vasosPequeno;
    }

    public void setVasosMediano(Vaso vasosMediano) {
        this.vasosMediano = vasosMediano;
    }

    public void setVasosGrande(Vaso vasosGrande) {
        this.vasosGrande = vasosGrande;
    }

    public void setCafetera(Cafetera cafetera) {
        this.cafetera = cafetera;
    }
    
    public void setAzucarero(Azucarero azucarero) {
    this.azucarero = azucarero;
}

    public Vaso getTipoDeVaso(String tipo) {
        if ("pequeno".equals(tipo)) {
            return vasosPequeno;
        }

        if ("mediano".equals(tipo)) {
            return vasosMediano;
        }

        if ("grande".equals(tipo)) {
            return vasosGrande;
        }

        return null;
    }

    public String getVasoDeCafe(Vaso vaso, int cantidadVasos,
                               int cantidadAzucar) {
        if (!vaso.hasVasos(cantidadVasos)) {
            return "No hay Vasos";
        }

        int cafeNecesario = vaso.getContenido() * cantidadVasos;

        if (!cafetera.hasCafe(cafeNecesario)) {
            return "No hay Cafe";
        }
        
        if (!azucarero.hasAzucar(cantidadAzucar)) {
    return "No hay Azucar";
}
    cafetera.giveCafe(cafeNecesario);
    vaso.giveVasos(cantidadVasos);
    azucarero.giveAzucar(cantidadAzucar);
        return "Felicitaciones";
    }
}