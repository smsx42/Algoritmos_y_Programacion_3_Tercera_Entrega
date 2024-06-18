package orgFiuba.tpjava.Model.Items;

import orgFiuba.tpjava.Model.Estados.Estado;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;

import java.util.Set;

import static orgFiuba.tpjava.Constantes.ESTADO_INHABILITADO;

public abstract class ItemsEstado extends Item implements validarItemEstado {

    public ItemsEstado(String unNombre, int cantidad,String descripcion){
        super(unNombre,cantidad,descripcion);
    }

    public abstract boolean aplicarItem(Cualidades cualidades);

    @Override
    public boolean realizarUsadoCurarTodo(Set<Estado> estadosActuales){
        if(estadosActuales.stream().noneMatch(unEstado ->  unEstado.getNombre().equals(ESTADO_INHABILITADO))){
            this.cantidad --;
            return true;
        }
        return false;
    }
    @Override
    public boolean realizarUsadoRevivir(Set<Estado> estadosActuales){
        if(estadosActuales.stream().anyMatch(unEstado -> unEstado.getNombre().equals(ESTADO_INHABILITADO))){
            this.cantidad --;
            return true;
        }
        return false;
    }
    @Override
    public boolean esUnItemDeSoloCampoDeBatalla(){
        return true;
    }
}
