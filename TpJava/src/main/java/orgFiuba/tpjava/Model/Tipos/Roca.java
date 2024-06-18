package orgFiuba.tpjava.Model.Tipos;
import static orgFiuba.tpjava.Constantes.*;

public class Roca extends Tipo {

    public Roca(){
        super();
        this.nombre = TIPO_ROCA;
        this.color = ANSI_MARRONOSCURO;
        this.completarTablaEfectividadTipo();
        this.completarTablaEfectividadClima();
    }
    
    @Override
    public void completarTablaEfectividadTipo(){
        this.tablaEfectividadTipo.put(TIPO_BICHO, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_FUEGO, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_HIELO, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_LUCHA, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_TIERRA, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_VOLADOR, RELACION_FUERTE);
    }

    @Override
    public void completarTablaEfectividadClima() {
        this.tablaEfectividadClima.put(CLIMA_TORMENTA_DE_ARENA, RELACION_FUERTE);
        this.tablaEfectividadClima.put(CLIMA_NORMAL, RELACION_NORMAL);
    }
}


