package orgFiuba.tpjava.Model.Tipos;
import static orgFiuba.tpjava.Constantes.*;

public class Volador extends Tipo {

    public Volador(){
        super();
        this.nombre = TIPO_VOLADOR;
        this.color = ANSI_CELESTECLARO;
        this.completarTablaEfectividadTipo();
        this.completarTablaEfectividadClima();
    }
    
    @Override
    public void completarTablaEfectividadTipo(){
        this.tablaEfectividadTipo.put(TIPO_BICHO, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_ELECTRICO, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_LUCHA, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_PLANTA, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_ROCA, RELACION_DEBIL);
    }

    @Override
    public void completarTablaEfectividadClima() {
        this.tablaEfectividadClima.put(CLIMA_HURACAN, RELACION_FUERTE);
        this.tablaEfectividadClima.put(CLIMA_NORMAL, RELACION_NORMAL);
    }
}


