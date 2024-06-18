package orgFiuba.tpjava.Model.Pokemones;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipoDeHabilidad")
@JsonSubTypes({
        @JsonSubTypes.Type(value = HabilidadAtaque.class, name = "ataque"),
        @JsonSubTypes.Type(value = HabilidadEstado.class, name = "estado"),
        @JsonSubTypes.Type(value = HabilidadEstadistica.class, name = "estadistica"),
        @JsonSubTypes.Type(value = HabilidadEstadistica.class, name = "clima")
})
public abstract class Habilidad {

    protected final String nombre;

    protected int cantidadDeUsos;

    public Habilidad(String nombre, int cantidad){
        this.nombre = nombre;
        this.cantidadDeUsos = cantidad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public abstract void usarHabilidad(Cualidades cualidadesPokemonEnemigo,Cualidades cualidadesPokemonPropio);

    public int getCantidadDeUsos() {
        return cantidadDeUsos;
    }
}
