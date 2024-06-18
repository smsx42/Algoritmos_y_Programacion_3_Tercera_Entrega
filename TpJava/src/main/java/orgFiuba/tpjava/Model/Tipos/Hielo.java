package orgFiuba.tpjava.Model.Tipos;
import static orgFiuba.tpjava.Constantes.*;

public class Hielo extends Tipo {

    public Hielo(){

        super();
        this.nombre = TIPO_HIELO;
        this.color = ANSI_CELESTE;
        this.completarTablaEfectividadTipo();
        this.completarTablaEfectividadClima();
    }

    @Override
    public void completarTablaEfectividadTipo(){
        this.tablaEfectividadTipo.put(TIPO_AGUA, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_DRAGON, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_HIELO, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_PLANTA, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_TIERRA, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_VOLADOR, RELACION_FUERTE);
    }

    @Override
    public void completarTablaEfectividadClima() {
        this.tablaEfectividadClima.put(CLIMA_NEVADO, RELACION_FUERTE);
        this.tablaEfectividadClima.put(CLIMA_TORMENTA_DE_NIEVE, RELACION_FUERTE);
        this.tablaEfectividadClima.put(CLIMA_NORMAL, RELACION_NORMAL);

    }
}