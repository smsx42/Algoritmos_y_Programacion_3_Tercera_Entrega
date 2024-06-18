package orgFiuba.tpjava.View.PokemonesView;

import orgFiuba.tpjava.Model.Pokemones.Cualidades;

public class CualidadesFactory {

    public CualidadesView createCualidadesView(Cualidades cualiades) {

        return new CualidadesView(cualiades);
    }
}
