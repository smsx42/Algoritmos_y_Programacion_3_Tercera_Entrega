package orgFiuba.tpjava.Model.SerializacionDeserealizacion;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import orgFiuba.tpjava.Model.Exceptions.PokemonNoEncontradoException;
import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;
import orgFiuba.tpjava.Model.ServicioDeLecturasJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static orgFiuba.tpjava.Constantes.RUTA_ITEMS_JSON;
import static orgFiuba.tpjava.Constantes.RUTA_POKEMONS_JSON;

public class PartidaDeserializer extends StdDeserializer<Jugador> {

    private static Map<Integer, Pokemon> datosPokemons = ServicioDeLecturasJson.lecturaPokemonJson(RUTA_POKEMONS_JSON);

    public PartidaDeserializer() {
        this(null);
    }

    public PartidaDeserializer(Class<Jugador> t) {
        super(t);
    }

    @Override
    public Jugador deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {

        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);

        String nombre = node.get("nombre").asText();
        Map<Integer, Integer> items = this.deserializeItems(node.get("items"));
        List<Integer> pokemonsID = this.deserializePokemons(node.get("pokemons"));
        Map<Integer, Item> datosItems =  ServicioDeLecturasJson.lecturaItemsJson(RUTA_ITEMS_JSON);
        Map<String,Item> mochilaDeItems = this.aniedienoItemsAMochila(items,datosItems);
        Map<String,Pokemon> mochilaDePokemons = new HashMap<>();
        try {
             mochilaDePokemons = this.aniadiendoPokemonsAMochila(pokemonsID,this.datosPokemons);
        } catch (PokemonNoEncontradoException e) {
            System.err.println("Error al añadir el Pokemon a la mochila del Jugador: " + e.getMessage());
        }

        return new Jugador(nombre,mochilaDePokemons,mochilaDeItems);
    }
    private Map<Integer,Integer> deserializeItems(JsonNode itemsNode) {
        Map<Integer, Integer> items = new HashMap<>();
        if (itemsNode != null && itemsNode.isObject()) {
            items = new ObjectMapper().convertValue(itemsNode, new TypeReference<Map<Integer, Integer>>() {});
        }

        return items;
    }
    private List<Integer> deserializePokemons(JsonNode pokemonsNode) {
        List<Integer> pokemons = new ArrayList<>();
        if (pokemonsNode != null && pokemonsNode.isArray()) {
            for (JsonNode pokemonIdNode : pokemonsNode) {
                pokemons.add(pokemonIdNode.asInt());
            }
        }
        return pokemons;
    }
    private Map<String, Item> aniedienoItemsAMochila(Map<Integer, Integer> items, Map<Integer, Item> datosItems) {
        Map<String, Item> mochilaItems = new HashMap<>();

        items.forEach((id, unaCantidad) -> {
            if (datosItems.containsKey(id)) {
                Item itemExistente = datosItems.get(id);
                itemExistente.setCantidad(unaCantidad);
                mochilaItems.put(itemExistente.getNombre(), itemExistente);
            }
        });

        return mochilaItems;
    }
    private Map<String,Pokemon> aniadiendoPokemonsAMochila(List<Integer> pokemonsID, Map<Integer,Pokemon> datosPokemon) throws PokemonNoEncontradoException {
        Map<String,Pokemon> mochilaDePokemon = new HashMap<>();
        for (Integer id : pokemonsID) {
            if (datosPokemon.containsKey(id)) {
                Pokemon unPokemon = datosPokemon.get(id);
                mochilaDePokemon.put(unPokemon.getNombre(), unPokemon);
            } else {
                throw new PokemonNoEncontradoException("Pokemon no encontrado para el ID: " + id);
            }
        }
        return mochilaDePokemon;
    }
}