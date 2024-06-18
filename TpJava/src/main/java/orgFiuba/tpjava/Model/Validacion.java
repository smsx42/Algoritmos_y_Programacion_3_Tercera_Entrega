package orgFiuba.tpjava.Model;

import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Pokemones.Habilidad;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

import java.util.Map;

public class Validacion {

    public boolean estaContenidoHabilidad(String nombreHabilidad, Map<String, Habilidad> habilidades){
        return habilidades.containsKey(nombreHabilidad);
    }
    public boolean estaContenidoPokemon(String nombrePokemon,Map<String, Pokemon> misPokemones){
        return misPokemones.containsKey(nombrePokemon);
    }
    public boolean estaContenidoItem(String nombreItem,Map<String, Item> misItems){
        return misItems.containsKey(nombreItem);
    }
}
