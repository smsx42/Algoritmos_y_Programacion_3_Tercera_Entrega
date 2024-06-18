package orgFiuba.tpjava.Model.Items;

import com.fasterxml.jackson.annotation.JsonTypeName;
import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
@JsonTypeName("Curar Todo")
public class PocionCuracionEstados extends ItemsEstado {
    public PocionCuracionEstados(String nombre, int cantidad, Modificacion unaModificacion,String descripcion){

        super(nombre, cantidad,descripcion);
        this.unaModificacion = unaModificacion;
    }
    @Override
    public boolean aplicarItem(Cualidades cualidades) {

        boolean realizo = this.realizarUsadoCurarTodo(cualidades.obtenerEstadosActuales());
        this.unaModificacion.modificar(cualidades, 1);
        return realizo;
    }

}
