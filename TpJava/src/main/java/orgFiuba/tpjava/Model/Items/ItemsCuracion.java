package orgFiuba.tpjava.Model.Items;

import orgFiuba.tpjava.Model.Pokemones.Cualidades;

public abstract class ItemsCuracion extends Item implements validarItemCuracion{

    public ItemsCuracion(String unNombre,int cantidad,String descripcion){
        super(unNombre,cantidad,descripcion);
    }

    public abstract boolean aplicarItem(Cualidades cualidades);

    @Override
    public boolean realizarUsadoItemsDeCuracion(Cualidades cualidades){
        if(cualidades.getVida() != 0 && cualidades.getVida() != cualidades.getVidaMaxima()){
            this.cantidad --;
            return true;
        }
        return false;
    }

    @Override
    public boolean esUnItemDeSoloCampoDeBatalla(){return true;}
}
