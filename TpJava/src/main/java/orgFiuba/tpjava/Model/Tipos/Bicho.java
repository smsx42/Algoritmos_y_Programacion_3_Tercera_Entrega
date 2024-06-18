package orgFiuba.tpjava.Model.Tipos;
import static orgFiuba.tpjava.Constantes.*;

public class Bicho extends Tipo {

    public Bicho(){

        super();
        this.nombre = TIPO_BICHO;
        this.color = ANSI_VERDEOSCURO;
        this.completarTablaEfectividadTipo();
        this.completarTablaEfectividadClima();
    }

    @Override
    public void completarTablaEfectividadTipo(){
        this.tablaEfectividadTipo.put(TIPO_FANTASMA, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_FUEGO, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_LUCHA, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_PLANTA, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_PSIQUICO, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_VENENO, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_VOLADOR, RELACION_DEBIL);
    }

    public void completarTablaEfectividadClima(){
        this.tablaEfectividadClima.put(CLIMA_NORMAL, RELACION_NORMAL);

    }
}