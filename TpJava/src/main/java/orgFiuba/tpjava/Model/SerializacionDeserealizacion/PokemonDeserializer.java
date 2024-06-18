package orgFiuba.tpjava.Model.SerializacionDeserealizacion;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import orgFiuba.tpjava.Model.Exceptions.HabilidadNoEncontradaException;
import orgFiuba.tpjava.Model.Pokemones.Habilidad;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;
import orgFiuba.tpjava.Model.ServicioDeLecturasJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static orgFiuba.tpjava.Constantes.RUTA_HABILIDADES_JSON;

public class PokemonDeserializer extends StdDeserializer<PokemonIdsCustom> {

    private static Map<Integer, Habilidad> habilidades = ServicioDeLecturasJson.lecturaHabilidadesJson(RUTA_HABILIDADES_JSON);

    public PokemonDeserializer() {
        this(null);
    }

    public PokemonDeserializer(Class<Pokemon> t) {
        super(t);
    }

    @Override
    public PokemonIdsCustom deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {

        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);

        String nombre = node.get("nombre").asText();
        String historia = node.get("historia").asText();
        int id = node.get("id").asInt();
        int nivel = node.get("nivel").asInt();
        String tipo = node.get("tipo").asText();
        double vida = node.get("vidaMaxima").asDouble();
        int velocidad = node.get("velocidad").asInt();
        int defensa = node.get("defensa").asInt();
        int ataque = node.get("ataque").asInt();
        List<Integer> habilidadesID = deserializeHabilidades(node.get("habilidades"));
        Pokemon pokemon = new Pokemon(nombre,nivel,tipo,historia,vida ,velocidad,defensa,ataque);
        try {
            this.compararYAnadirHabilidades(pokemon, habilidadesID, PokemonDeserializer.habilidades);
        } catch (HabilidadNoEncontradaException e) {
            System.err.println("Error al añadir habilidades al Pokemon: " + e.getMessage());
        }

        return new PokemonIdsCustom(id,pokemon);
    }
    private List<Integer> deserializeHabilidades(JsonNode habilidadesNode) {
        List<Integer> habilidades = new ArrayList<>();
        if (habilidadesNode != null && habilidadesNode.isArray()) {
            for (JsonNode habilidadNode : habilidadesNode) {
                habilidades.add(habilidadNode.asInt());
            }
        }
        return habilidades;
    }
    private void compararYAnadirHabilidades(Pokemon pokemon, List<Integer> habilidadesID, Map<Integer, Habilidad> habilidadesMap)
            throws HabilidadNoEncontradaException {
        for (Integer id : habilidadesID) {
            if (habilidadesMap.containsKey(id)) {
                Habilidad habilidad = habilidadesMap.get(id);
                pokemon.aniadirHabilidad(habilidad);
            } else {
                throw new HabilidadNoEncontradaException("Habilidad no encontrada para el ID: " + id);
            }
        }
    }
}