package orgFiuba.tpjava.Model.Tipos;
import static orgFiuba.tpjava.Constantes.*;

public class Tierra extends Tipo {

    public Tierra(){
        super();
        this.nombre = TIPO_TIERRA;
        this.color = ANSI_MARRON;
        this.completarTablaEfectividadTipo();
        this.completarTablaEfectividadClima();
    }
    
    @Override
    public void completarTablaEfectividadTipo(){
        this.tablaEfectividadTipo.put(TIPO_BICHO, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_ELECTRICO, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_FUEGO, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_PLANTA, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_ROCA, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_VENENO, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_VOLADOR, RELACION_NULA);
    }

    @Override
    public void completarTablaEfectividadClima() {
        this.tablaEfectividadClima.put(CLIMA_TORMENTA_DE_ARENA, RELACION_FUERTE);
        this.tablaEfectividadClima.put(CLIMA_NORMAL, RELACION_NORMAL);
    }
}


