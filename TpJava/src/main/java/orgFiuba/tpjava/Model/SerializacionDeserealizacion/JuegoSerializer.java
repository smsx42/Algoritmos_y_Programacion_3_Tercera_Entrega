package orgFiuba.tpjava.Model.SerializacionDeserealizacion;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import orgFiuba.tpjava.Model.Estados.Estado;
import orgFiuba.tpjava.Model.Exceptions.ItemNoEncontradoException;
import orgFiuba.tpjava.Model.Exceptions.PokemonNoEncontradoException;
import orgFiuba.tpjava.Model.Juego;
import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;
import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.ServicioDeLecturasJson;

import java.io.IOException;
import java.util.Map;

public class JuegoSerializer extends JsonSerializer<Juego> {

    public JuegoSerializer() {
        this(null);
    }

    public JuegoSerializer(Class<Juego> t) {
    }

    @Override
    public void serialize(Juego juego, JsonGenerator jgen, SerializerProvider provider) throws IOException {

        jgen.writeStartArray(); // Comienza la lista de jugadores

        // Serializa cada jugador en el juego
        try {
            escribirJugador(jgen, juego.getJugador1());
        } catch (PokemonNoEncontradoException e) {
            throw new RuntimeException(e);
        } catch (ItemNoEncontradoException e) {
            throw new RuntimeException(e);
        }

        try {
            escribirJugador(jgen, juego.getJugador2());
        } catch (PokemonNoEncontradoException e) {
            throw new RuntimeException(e);
        } catch (ItemNoEncontradoException e) {
            throw new RuntimeException(e);
        }

        jgen.writeEndArray(); // Termina la lista de jugadores
        //jgen.writeNumberField("",);

        //jgen.writeObjectField("estados",pokemon.getCualidades().obtenerEstadosActuales());

    }
    private void escribirJugador(JsonGenerator jgen, Jugador jugador) throws IOException, PokemonNoEncontradoException, ItemNoEncontradoException {
        jgen.writeStartObject(); // Comienza un objeto para un jugador
        jgen.writeStringField("nombre", jugador.getNombre());
        jgen.writeBooleanField("ganador", !jugador.esPerdedor());

        jgen.writeFieldName("items");
        jgen.writeStartObject();

        for (Map.Entry<String, Item> entry : jugador.getItems().entrySet()) {
            escribirItem(jgen, entry.getValue());
        }

        jgen.writeEndObject();


        jgen.writeFieldName("misPokemones");
        jgen.writeStartArray();
        for (Map.Entry<String, Pokemon> entry : jugador.getMisPokemones().entrySet()) {
            escribirPokemon(jgen, entry.getValue());
        }
        jgen.writeEndArray();
        jgen.writeEndObject();
    }
    private void escribirPokemon(JsonGenerator jgen, Pokemon pokemon) throws IOException, PokemonNoEncontradoException {
        jgen.writeStartObject();
        jgen.writeStringField("nombre", pokemon.getNombre()); // Suponiendo que hay un método getNombre en la clase Pokemon
        jgen.writeNumberField("id", ServicioDeLecturasJson.obtenerIdPokemonPorNombre(pokemon.getNombre()));
        jgen.writeNumberField("vidaRestante", pokemon.getCualidades().getVida());
        jgen.writeFieldName("estadosActuales");
        jgen.writeStartArray();
        for ( Estado unEstado : pokemon.getCualidades().obtenerEstadosActuales()) {
            jgen.writeString(unEstado.getNombre());
        }
        jgen.writeEndArray();

        jgen.writeEndObject();
    }
    private void escribirItem(JsonGenerator jgen, Item unItem) throws ItemNoEncontradoException, IOException {
        int idItem = ServicioDeLecturasJson.obtenerIdItemsPorNombre(unItem.getNombre());
        jgen.writeNumberField(String.valueOf(idItem),unItem.getCantidad());
    }


}
