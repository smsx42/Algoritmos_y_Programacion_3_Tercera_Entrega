package orgFiuba.tpjava.Model.Items;

import com.fasterxml.jackson.annotation.JsonTypeName;
import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
@JsonTypeName("Hiper Pocion")
public class HiperPocion extends ItemsCuracion {

    public HiperPocion(String nombre, int cantidad, Modificacion unaModificacion,String descripcion){
        super(nombre, cantidad,descripcion);
        if (this.cantidad > 1) {
            this.cantidad = 1;
        }
        this.unaModificacion = unaModificacion;
    }

    @Override
    public boolean aplicarItem(Cualidades cualidades) {

        boolean realizo = realizarUsadoItemsDeCuracion(cualidades);
        this.unaModificacion.modificar(cualidades, 100);
        return realizo;
    }
}

