package orgFiuba.tpjava.View.ClimasView;

import orgFiuba.tpjava.Model.Climas.Clima;
import orgFiuba.tpjava.View.PokemonesView.PokemonView;

public class SistemaDeClimaView {

    private ClimaView climaActualView;

    private ClimaFactory climaFactory;

    public SistemaDeClimaView(Clima climaActual){
        this.climaFactory = new ClimaFactory();
        this.climaActualView = climaFactory.createClimaView(climaActual);

    }

    public void setClimaActualView(Clima climaActual){
        this.climaActualView = climaFactory.createClimaView(climaActual);
    }
    public void mostrarEfectosClima(PokemonView pokemonView){

        climaActualView.mostrar(pokemonView);
    }
}
