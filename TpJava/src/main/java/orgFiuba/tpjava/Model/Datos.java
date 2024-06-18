package orgFiuba.tpjava.Model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import orgFiuba.tpjava.Model.Items.*;
import orgFiuba.tpjava.Model.Pokemones.*;
import orgFiuba.tpjava.Model.SerializacionDeserealizacion.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static orgFiuba.tpjava.Constantes.RUTA_PARTIDA_JSON;

public class Datos {

    //Atributos:
    private  Map<String, Pokemon> mochilaJugador1;
    private  Map<String, Pokemon> mochilaJugador2;
    private  Map<String, Item> itemsJugador1;
    private  Map<String, Item> itemsJugador2;

    private List<Jugador> listaJugadores;

    //Metodos:

    public Datos() {

        this.mochilaJugador1 = new HashMap<>();
        this.mochilaJugador2 = new HashMap<>();
        this.itemsJugador1 = new HashMap<>();
        this.itemsJugador2 = new HashMap<>();
        this.listaJugadores = new ArrayList<>();

        this.listaJugadores = this.lecturaJugadoresJson();
        this.InicializarJugador1();
        this.InicializarJugador2();
    }

    public Map<String, Item> getItemsJugador1() {
        return this.itemsJugador1;
    }

    public Map<String, Item> getItemsJugador2() {
        return this.itemsJugador2;
    }

    public Map<String, Pokemon> getMochilaJugador1() {
        return this.mochilaJugador1;
    }

    public Map<String, Pokemon> getMochilaJugador2() {
        return this.mochilaJugador2;
    }


    private List<Jugador> lecturaJugadoresJson(){
        try {
            File partidaFile = new File(RUTA_PARTIDA_JSON);
            ObjectMapper objectMapperPokemon = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addDeserializer(Jugador.class, new PartidaDeserializer()); ///-> PokemonIds
            objectMapperPokemon.registerModule(module);

            //System.out.println(listaDeJugadores);
            return objectMapperPokemon.readValue(partidaFile, new TypeReference<>() {
            });

        } catch (IOException e) {
            //return null;
        }
        return null;
    }
    private void InicializarJugador1(){
        this.mochilaJugador1 = this.listaJugadores.get(0).getMisPokemones();
        this.itemsJugador1 = this.listaJugadores.get(0).getItems();
    }
    private void InicializarJugador2(){
        this.mochilaJugador2 = this.listaJugadores.get(1).getMisPokemones();
        this.itemsJugador2 = this.listaJugadores.get(1).getItems();
    }

}
