package orgFiuba.tpjava.Model.SerializacionDeserealizacion;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

import java.io.IOException;

public class PokemonSerializer extends StdSerializer<Pokemon> {

    public PokemonSerializer() {
        this(null);
    }

    public PokemonSerializer(Class<Pokemon> t) {
        super(t);
    }

    @Override
    public void serialize(Pokemon pokemon, JsonGenerator jgen, SerializerProvider provider) throws IOException {

        jgen.writeStartObject();
        jgen.writeNumberField("vida",pokemon.getCualidades().getVida());

        jgen.writeObjectField("estados",pokemon.getCualidades().obtenerEstadosActuales());

    }


}
