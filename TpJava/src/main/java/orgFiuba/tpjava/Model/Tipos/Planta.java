package orgFiuba.tpjava.Model.Tipos;
import static orgFiuba.tpjava.Constantes.*;

public class Planta extends Tipo {

    public Planta(){
        super();
        this.nombre = TIPO_PLANTA;
        this.color = ANSI_VERDECLARO;
        this.completarTablaEfectividadTipo();
        this.completarTablaEfectividadClima();
    }
    
    @Override
    public void completarTablaEfectividadTipo(){
        this.tablaEfectividadTipo.put(TIPO_AGUA, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_BICHO, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_DRAGON, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_FUEGO, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_ROCA, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_TIERRA, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_VENENO, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_VOLADOR, RELACION_DEBIL);
    }

    @Override
    public void completarTablaEfectividadClima() {
        this.tablaEfectividadClima.put(CLIMA_LLUVIA, RELACION_FUERTE);
        this.tablaEfectividadClima.put(CLIMA_NORMAL, RELACION_NORMAL);
    }
}
