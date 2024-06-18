package orgFiuba.tpjava.Model.Items;


import orgFiuba.tpjava.Model.Pokemones.Cualidades;

public abstract class ItemsEstadistica extends Item implements validarItemEstadistica{

    public ItemsEstadistica(String unNombre, int cantidad,String descripcion){
        super(unNombre,cantidad,descripcion);
    }

    public abstract boolean aplicarItem(Cualidades cualidades);

    @Override
    public boolean realizarUsadoItemsDeEstadisitcas(Cualidades cualidades){
        if(cualidades.getVida() != 0){
            this.cantidad --;
            return true;
        }
        return false;
    }

    @Override
    public boolean esUnItemDeSoloCampoDeBatalla(){
        return false;
    }
}
