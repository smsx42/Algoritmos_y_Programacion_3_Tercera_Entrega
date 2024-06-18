package orgFiuba.tpjava.Model.Tipos;
import static orgFiuba.tpjava.Constantes.*;


public class Normal extends Tipo {

    public Normal(){
        super();
        this.nombre = TIPO_NORMAL;
        this.color = ANSI_GRISCLARO;
        this.completarTablaEfectividadTipo();
        this.completarTablaEfectividadClima();
    }
    
    @Override
    public void completarTablaEfectividadTipo(){
        this.tablaEfectividadTipo.put(TIPO_FANTASMA, RELACION_NULA);
        this.tablaEfectividadTipo.put(TIPO_ROCA, RELACION_DEBIL);
    }

    @Override
    public void completarTablaEfectividadClima() {
        this.tablaEfectividadClima.put(CLIMA_NORMAL, RELACION_NORMAL);
    }
}


