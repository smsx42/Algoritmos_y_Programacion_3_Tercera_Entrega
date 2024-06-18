package orgFiuba.tpjava.Model.Tipos;
import static orgFiuba.tpjava.Constantes.*;

public class Electrico extends Tipo {

    public Electrico(){

        super();
        this.nombre = TIPO_ELECTRICO;
        this.color = ANSI_AMARILLO;
        this.completarTablaEfectividadTipo();
        this.completarTablaEfectividadClima();
    }

    @Override
    public void completarTablaEfectividadTipo(){
        this.tablaEfectividadTipo.put(TIPO_AGUA, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_DRAGON, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_ELECTRICO, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_PLANTA, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_TIERRA, RELACION_NULA);
        this.tablaEfectividadTipo.put(TIPO_VOLADOR, RELACION_FUERTE);
    }

    public void completarTablaEfectividadClima(){
        this.tablaEfectividadClima.put(CLIMA_TORMENTA_DE_RAYOS, RELACION_FUERTE);
        this.tablaEfectividadClima.put(CLIMA_NORMAL, RELACION_NORMAL);

    }


}