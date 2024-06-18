package orgFiuba.tpjava.Model.Tipos;
import static orgFiuba.tpjava.Constantes.*;

public class Psiquico extends Tipo {

    public Psiquico() {
        super();
        this.nombre = TIPO_PSIQUICO;
        this.color = ANSI_ROSACLARO;
        this.completarTablaEfectividadTipo();
        this.completarTablaEfectividadClima();
    }

    @Override
    public void completarTablaEfectividadTipo() {
        this.tablaEfectividadTipo.put(TIPO_LUCHA, RELACION_FUERTE);
        this.tablaEfectividadTipo.put(TIPO_PSIQUICO, RELACION_DEBIL);
        this.tablaEfectividadTipo.put(TIPO_VENENO, RELACION_FUERTE);
    }

    @Override
    public void completarTablaEfectividadClima() {
        this.tablaEfectividadClima.put(CLIMA_NIEBLA, RELACION_FUERTE);
        this.tablaEfectividadClima.put(CLIMA_NORMAL, RELACION_NORMAL);
    }
}


