package orgFiuba.tpjava.View.ModificacionesView;

import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;

public abstract class ModificacionView{

    protected Modificacion unaModificacion;

    public ModificacionView(Modificacion unaModificacion){
        this.unaModificacion = unaModificacion;
    }

    public abstract void mostrar(Cualidades unaCualidad);

}
