package orgFiuba.tpjava.View.PokemonesView;

import orgFiuba.tpjava.Model.Pokemones.Pokemon;

public class PokemonFactory {

    public PokemonView createPokemonView(Pokemon pokemon) {

        return new PokemonView(pokemon);
    }
}
