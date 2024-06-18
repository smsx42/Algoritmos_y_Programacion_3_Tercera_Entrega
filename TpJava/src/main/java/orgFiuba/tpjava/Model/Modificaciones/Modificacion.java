package orgFiuba.tpjava.Model.Modificaciones;

import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipoDeModificacion")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ModificacionVida.class, name = "vida"),
        @JsonSubTypes.Type(value = ModificacionVelocidad.class, name = "velocidad"),
        @JsonSubTypes.Type(value = ModificacionAtaque.class, name = "ataque"),
        @JsonSubTypes.Type(value = ModificacionDefensa.class, name = "defensa"),
        @JsonSubTypes.Type(value = ModificacionEstado.class, name = "estado"),
})
public interface Modificacion {

    void modificar(Cualidades cualidades, int etapas);

    String obtenerNombreModificacion();
}
