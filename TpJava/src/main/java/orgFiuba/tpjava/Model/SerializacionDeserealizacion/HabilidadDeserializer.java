package orgFiuba.tpjava.Model.SerializacionDeserealizacion;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import orgFiuba.tpjava.Model.Estados.Estado;
import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import orgFiuba.tpjava.Model.Pokemones.*;
import orgFiuba.tpjava.Model.ServicioDeLecturasJson;
import orgFiuba.tpjava.Model.Tipos.Tipo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HabilidadDeserializer extends StdDeserializer<List<HabilidadIdsCustom>> {

    public HabilidadDeserializer() {
        this(null);
    }

    public HabilidadDeserializer(Class<Habilidad> t) {
        super(t);
    }

    @Override
    public List<HabilidadIdsCustom>  deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {

        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);

        List<HabilidadIdsCustom> habilidadesMap = new ArrayList<>();

        for(JsonNode habilidadesNode: node){
            String nombre = habilidadesNode.get("nombre").asText();
            int  id = habilidadesNode.get("id").asInt();
            String tipoDeHabilidad = habilidadesNode.get("tipoDeHabilidad").asText();
            int cantidad= habilidadesNode.get("cantidad").asInt();
            Habilidad unaHabilidad = null;

            switch (tipoDeHabilidad.toLowerCase()) {
                case "ataque":
                    int poder= habilidadesNode.get("poder").asInt();
                    String tipo= habilidadesNode.get("tipo").asText();
                    unaHabilidad = new HabilidadAtaque(nombre, Tipo.instanciarUnTipoDe(tipo),poder,cantidad);
                    break;
                case "estado":
                    String estado = habilidadesNode.get("estado").asText();
                    unaHabilidad = new HabilidadEstado(nombre,cantidad, Estado.instaciarUnEstadoDe(estado));
                    break;
                case "estadistica":
                    boolean propio = habilidadesNode.get("beneficio").asBoolean();
                    //Modificacion modificacion = codec.treeToValue(habilidadesNode.get("tipoDeModificacion"), Modificacion.class);
                    String  tipoDeModificacion = habilidadesNode.get("tipoDeModificacion").asText();

                    // Usa el método para obtener la instancia de Modificacion
                    Modificacion modificacion = ServicioDeLecturasJson.obtenerModificacion(tipoDeModificacion);
                    int etapas = habilidadesNode.get("etapas").asInt();
                    unaHabilidad = new HabilidadEstadistica(nombre,cantidad,propio,etapas,modificacion);
                    break;
                case "clima":
                    String clima = habilidadesNode.get("tipoDeClima").asText();
                    unaHabilidad = new HabilidadClima(nombre,clima,cantidad);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de habilidad no reconocido: " + tipoDeHabilidad);
            }
            habilidadesMap.add(new HabilidadIdsCustom(id,unaHabilidad));
        }

        return habilidadesMap;
    }
}