package orgFiuba.tpjava.View.ClimasView;

import orgFiuba.tpjava.Model.Climas.Clima;
import orgFiuba.tpjava.View.PokemonesView.PokemonView;

public class ClimaTormentaDeRayosView extends ClimaView{

    public ClimaTormentaDeRayosView(Clima clima){
        super(clima);
    }

    @Override
    public void mostrar(PokemonView pokemonView) {
        System.out.println(this.clima.getNombre() + ": Suma 10% al poder total del tipo Electrico y resta 3% de la vida al resto de los tipos.");
        mostrarAplicarEfecto(pokemonView);
        if(pokemonView.getTipoPokemon().verSiEsAbrasivo(this.clima.getNombre())){
            System.out.println("LA VIDA DEL POKEMON SE REDUCE UN 3%.");
        }
    }
}
