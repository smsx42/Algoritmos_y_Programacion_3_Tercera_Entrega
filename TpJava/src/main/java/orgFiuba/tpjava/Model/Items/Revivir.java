package orgFiuba.tpjava.Model.Items;

import com.fasterxml.jackson.annotation.JsonTypeName;
import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
@JsonTypeName("Revivir")
public class Revivir extends ItemsEstado {

    public Revivir(String nombre, int cantidad, Modificacion unaModificacion,String descripcion){
        super(nombre, cantidad,descripcion);
        this.unaModificacion = unaModificacion;
    }


    @Override
    public boolean aplicarItem(Cualidades cualidades) {

        boolean realizo = this.realizarUsadoRevivir(cualidades.obtenerEstadosActuales());
        this.unaModificacion.modificar(cualidades, (int) cualidades.getVidaMaxima());
        return realizo;
    }

}
