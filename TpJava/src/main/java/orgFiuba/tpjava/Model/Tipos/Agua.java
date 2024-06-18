package orgFiuba.tpjava.Model.Tipos;
import static orgFiuba.tpjava.Constantes.*;


public class Agua extends Tipo {

    public Agua(){
        super();
        this.nombre = TIPO_AGUA;
        this.color = ANSI_AZULFUERTE;
        this.completarTablaEfectividadTipo();
        this.completarTablaEfectividadClima();
    }

    @Override
    public void completarTablaEfectividadTipo(){
        this.tablaEfectividadTipo.put(TIPO_AGUA, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_DRAGON, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_FUEGO, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_PLANTA, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_ROCA, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_TIERRA, RELACION_FUERTE);
    }
    public void completarTablaEfectividadClima(){
        this.tablaEfectividadClima.put(CLIMA_LLUVIA, RELACION_FUERTE);
        this.tablaEfectividadClima.put(CLIMA_NORMAL, RELACION_NORMAL);

    }
}