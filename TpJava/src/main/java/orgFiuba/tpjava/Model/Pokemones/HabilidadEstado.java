package orgFiuba.tpjava.Model.Pokemones;

import orgFiuba.tpjava.Model.Estados.Estado;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonTypeName("estado")
@JsonIgnoreProperties
public class HabilidadEstado extends Habilidad{

    private final Estado estado;
    @JsonCreator
    public HabilidadEstado(
            @JsonProperty("nombre") String nombre,
            @JsonProperty("cantidad") int cantidad,
            @JsonProperty("estado") Estado estado) {
        super(nombre, cantidad);
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    @Override
    public void usarHabilidad(Cualidades cualidadesPokemonEnemigo,Cualidades cualidadesPokemonPropio) {
        this.cantidadDeUsos --;
        cualidadesPokemonEnemigo.agregarEstado(this.estado);
    }
}
