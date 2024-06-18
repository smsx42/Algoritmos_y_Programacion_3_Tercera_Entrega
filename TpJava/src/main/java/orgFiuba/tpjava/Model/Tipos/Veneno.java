package orgFiuba.tpjava.Model.Tipos;
import static orgFiuba.tpjava.Constantes.*;

public class Veneno extends Tipo {

    public Veneno(){
        super();
        this.nombre = TIPO_VENENO;
        this.color = ANSI_PURPURA;
        this.completarTablaEfectividadTipo();
        this.completarTablaEfectividadClima();
    }
    
    @Override
    public void completarTablaEfectividadTipo(){
        this.tablaEfectividadTipo.put(TIPO_BICHO, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_FANTASMA, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_PLANTA, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_ROCA, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_TIERRA, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_VENENO, RELACION_DEBIL);
    }

    @Override
    public void completarTablaEfectividadClima() {
        this.tablaEfectividadClima.put(CLIMA_NORMAL, RELACION_NORMAL);
    }
}


