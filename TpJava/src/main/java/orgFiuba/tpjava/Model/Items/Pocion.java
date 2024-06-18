package orgFiuba.tpjava.Model.Items;

import com.fasterxml.jackson.annotation.JsonTypeName;
import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
@JsonTypeName("Pocion")
public class Pocion extends ItemsCuracion {

    public Pocion(String nombre, int cantidad, Modificacion modificar,String descripcion){
        super(nombre, cantidad,descripcion);
        this.unaModificacion = modificar;
    }

    @Override
    public boolean aplicarItem(Cualidades cualidades){

        boolean realizo = realizarUsadoItemsDeCuracion(cualidades);
        this.unaModificacion.modificar(cualidades, 25);
        return realizo;
    }
}
