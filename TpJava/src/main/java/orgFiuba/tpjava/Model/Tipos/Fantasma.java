package orgFiuba.tpjava.Model.Tipos;
import static orgFiuba.tpjava.Constantes.*;

public class Fantasma extends Tipo {

    public Fantasma(){

        super();
        this.nombre = TIPO_FANTASMA;
        this.color = ANSI_VIOLETA;
        this.completarTablaEfectividadTipo();
        this.completarTablaEfectividadClima();
    }

    @Override
    public void completarTablaEfectividadTipo(){
        this.tablaEfectividadTipo.put(TIPO_FANTASMA, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_NORMAL, RELACION_NULA);
        this.tablaEfectividadTipo.put(TIPO_PSIQUICO, RELACION_FUERTE);
    }

    public void completarTablaEfectividadClima(){
        this.tablaEfectividadClima.put(CLIMA_NIEBLA, RELACION_FUERTE);
        this.tablaEfectividadClima.put(CLIMA_NORMAL, RELACION_NORMAL);

    }
}