package orgFiuba.tpjava.Model.Tipos;
import static orgFiuba.tpjava.Constantes.*;

public class Fuego extends Tipo {

    public Fuego(){

        super();
        this.nombre = TIPO_FUEGO;
        this.color = ANSI_ROJO;
        this.completarTablaEfectividadTipo();
        this.completarTablaEfectividadClima();
    }

    @Override
    public void completarTablaEfectividadTipo(){
        this.tablaEfectividadTipo.put(TIPO_AGUA, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_BICHO,RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_DRAGON, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_FUEGO, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_HIELO, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_PLANTA, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_ROCA, RELACION_DEBIL);
    }

    @Override
    public void completarTablaEfectividadClima() {
        this.tablaEfectividadClima.put(CLIMA_SOLEADO, RELACION_FUERTE);
        this.tablaEfectividadClima.put(CLIMA_NORMAL, RELACION_NORMAL);
    }
}
