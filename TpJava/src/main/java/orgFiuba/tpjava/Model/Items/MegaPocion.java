package orgFiuba.tpjava.Model.Items;

import com.fasterxml.jackson.annotation.JsonTypeName;
import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
@JsonTypeName("Mega Pocion")
public class MegaPocion extends ItemsCuracion {

    public MegaPocion(String nombre, int cantidad, Modificacion unaModificacion,String descripcion){
        super(nombre, cantidad,descripcion);
        this.unaModificacion = unaModificacion;
    }

    @Override
    public boolean aplicarItem(Cualidades cualidades) {
        boolean realizo = this.realizarUsadoItemsDeCuracion(cualidades);
        this.unaModificacion.modificar(cualidades, 50);
        return realizo;
    }

}
