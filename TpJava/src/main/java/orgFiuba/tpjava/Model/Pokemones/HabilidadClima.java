package orgFiuba.tpjava.Model.Pokemones;

import orgFiuba.tpjava.Model.Climas.SistemaDeClima;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("clima")
public class HabilidadClima extends Habilidad {
    private final String clima;

    public HabilidadClima(String nombre, String clima, int cantidad){
        super(nombre,cantidad);
        this.clima = clima;
    }

    public String getClimaNombre() {
        return clima;
    }

    @Override
    public void usarHabilidad(Cualidades cualidadesPokemonEnemigo, Cualidades cualidadesPokemonPropio) {
        this.cantidadDeUsos--;
        SistemaDeClima.setClimaActual(clima);
    }
}
