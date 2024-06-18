package orgFiuba.tpjava.Model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import orgFiuba.tpjava.Model.Exceptions.ItemNoEncontradoException;
import orgFiuba.tpjava.Model.Exceptions.PokemonNoEncontradoException;
import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Modificaciones.*;
import orgFiuba.tpjava.Model.Pokemones.Habilidad;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;
import orgFiuba.tpjava.Model.SerializacionDeserealizacion.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServicioDeLecturasJson {

    private static List<PokemonIdsCustom> pokemonsId = new ArrayList<>();
    private static List<ItemsIdsCustom> itemsId = new ArrayList<>();

    static public Map<Integer, Habilidad> lecturaHabilidadesJson(String habilidadesPath){
        try {
            File habilidadesFile = new File(habilidadesPath);
            ObjectMapper objectMapper2 = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addDeserializer(List.class, new HabilidadDeserializer());
            objectMapper2.registerModule(module);

            List<HabilidadIdsCustom> habilidades = objectMapper2.readValue(habilidadesFile, new TypeReference<List<HabilidadIdsCustom>>() {});

            Map<Integer, Habilidad> habilidadesID = habilidades.stream()
                    .collect(Collectors.toMap(HabilidadIdsCustom::getId, HabilidadIdsCustom::getUnaHabilida)); // ---> Lo tranformo en Hash para no usar Fors
            return habilidadesID;

        } catch (IOException e) {
            // Manejar la excepción adecuadamente
            return null;
        }
    }

    public static Map<Integer, Pokemon> lecturaPokemonJson(String pokemonsPath){
        try {
            File pokemonFile = new File(pokemonsPath);
            ObjectMapper objectMapperPokemon = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addDeserializer(PokemonIdsCustom.class, new PokemonDeserializer()); ///-> PokemonIds
            objectMapperPokemon.registerModule(module);

            List<PokemonIdsCustom> listaPokemon = objectMapperPokemon.readValue(pokemonFile,new TypeReference<List<PokemonIdsCustom>>() {});
            //System.out.println(listaPokemon);
            pokemonsId = listaPokemon;

            Map<Integer, Pokemon> pokemonID = listaPokemon.stream()
                    .collect(Collectors.toMap(PokemonIdsCustom::getId, PokemonIdsCustom::getUnPokemon));
            return pokemonID;

        } catch (IOException e) {
            return null;
        }
    }
    public static Map<Integer, Item> lecturaItemsJson(String itemsPath){
        try {
            File itemFile = new File(itemsPath);
            ObjectMapper objectMapperPokemon = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addDeserializer(ItemsIdsCustom.class, new ItemDeserializer()); ///-> PokemonIds
            objectMapperPokemon.registerModule(module);

            List<ItemsIdsCustom> listaItems = objectMapperPokemon.readValue(itemFile,new TypeReference<List<ItemsIdsCustom>>() {});
            itemsId = listaItems;


            Map<Integer, Item> itemID = listaItems.stream()
            .collect(Collectors.toMap(ItemsIdsCustom::getId, ItemsIdsCustom::getUnItem));
            return itemID;

        } catch (IOException e) {
            return null;
        }
    }

    public static Modificacion obtenerModificacion(String tipo) {
        switch (tipo) {
            case "velocidad":
                return new ModificacionVelocidad();
            case "ataque":
                return new ModificacionAtaque();
            case "defensa":
                return new ModificacionDefensa();
            case "vida":
                return new ModificacionVida();
            case "estado":
                return new ModificacionEstado();
            case "inhabilitado":
                return new ModificacionEstadoInhabilitado();
            default:
                throw new IllegalArgumentException("Tipo de modificación desconocido: " + tipo);
        }
    }


    public static int obtenerIdPokemonPorNombre(String unNombrePokemon) throws PokemonNoEncontradoException {
        List<PokemonIdsCustom> pokemonIdsCustoms = pokemonsId;
        for (PokemonIdsCustom unPokemonID : pokemonIdsCustoms ){
            if(unNombrePokemon.equals(unPokemonID.getUnPokemon().getNombre() )){
                return unPokemonID.getId();
            }
        }
        throw new PokemonNoEncontradoException("Pokemon no encontrado para serializar,con el nombre : " + unNombrePokemon);
    }

    public static int obtenerIdItemsPorNombre(String unNombreItem) throws ItemNoEncontradoException {
        List<ItemsIdsCustom> pokemonIdsCustoms = itemsId;
        for (ItemsIdsCustom unItemID : pokemonIdsCustoms ){
            if(unNombreItem.equals(unItemID.getUnItem().getNombre() )){
                return unItemID.getId();
            }
        }
        throw new ItemNoEncontradoException("Item no encontrado para serializar,con el nombre : " + unNombreItem);
    }
}
