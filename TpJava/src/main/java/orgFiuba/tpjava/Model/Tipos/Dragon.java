package orgFiuba.tpjava.Model.Tipos;
import static orgFiuba.tpjava.Constantes.*;

public class Dragon extends Tipo {

    public Dragon(){

        super();
        this.nombre = TIPO_DRAGON;
        this.color = ANSI_VIOLETAOSCURO;
        this.completarTablaEfectividadTipo();
        this.completarTablaEfectividadClima();
    }

    @Override
    public void completarTablaEfectividadTipo(){
        this.tablaEfectividadTipo.put(TIPO_DRAGON,RELACION_FUERTE);
    }

    public void completarTablaEfectividadClima(){
        this.tablaEfectividadClima.put(CLIMA_NORMAL, RELACION_NORMAL);

    }


}