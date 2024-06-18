package orgFiuba.tpjava.Model.SerializacionDeserealizacion;

import orgFiuba.tpjava.Model.Pokemones.Pokemon;

public class PokemonIdsCustom {
    private int id;
    private Pokemon unPokemon;

    public PokemonIdsCustom(int id, Pokemon unaPokemon) {
        this.id = id;
        this.unPokemon = unaPokemon;
    }

    public int getId() {return this.id ;}

    public Pokemon getUnPokemon() {return this.unPokemon;}

}
