package orgFiuba.tpjava.Model.Tipos;
import static orgFiuba.tpjava.Constantes.*;

public class Lucha extends Tipo {

    public Lucha(){
        super();
        this.nombre = TIPO_LUCHA;
        this.color = ANSI_NARANJA;
        this.completarTablaEfectividadTipo();
        this.completarTablaEfectividadClima();
    }

    @Override
    public void completarTablaEfectividadTipo(){
        this.tablaEfectividadTipo.put(TIPO_BICHO, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_FANTASMA, RELACION_NULA);
        this.tablaEfectividadTipo.put(TIPO_HIELO, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_NORMAL, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_PSIQUICO, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_ROCA, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_VENENO, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_VOLADOR, RELACION_DEBIL);
    }

    @Override
    public void completarTablaEfectividadClima() {
        this.tablaEfectividadClima.put(CLIMA_NORMAL, RELACION_NORMAL);
    }
}