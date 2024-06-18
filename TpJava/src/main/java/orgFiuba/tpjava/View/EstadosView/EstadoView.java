package orgFiuba.tpjava.View.EstadosView;
import orgFiuba.tpjava.Model.Estados.Estado;

public abstract class EstadoView {

    private Estado estado;

    public EstadoView(Estado estado){
        this.estado = estado;
    }

    public abstract boolean mostrar();

    public abstract void mostrarEfectoPasivoDeEstado();



}
