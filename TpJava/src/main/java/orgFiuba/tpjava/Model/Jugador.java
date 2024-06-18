package orgFiuba.tpjava.Model;

import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

import java.util.Map;
import java.util.Objects;

public class Jugador {

    //Atributos:
    private String nombre;
    private final Map<String, Pokemon> misPokemones;
    private final Map<String, Item> items;
    private Pokemon pokemonActual;
    private Jugador adversario;
    private boolean atacante;
    private boolean esPerdedor;

    // Metodos:

    public Jugador(String nombre, Map<String, Pokemon> misPokemones, Map<String, Item> items) {
        this.nombre = nombre;
        this.misPokemones = misPokemones;
        this.items = items;
        this.atacante = false;
        this.esPerdedor = false;
    }

    public Map<String, Pokemon> getMisPokemones() {
        return misPokemones;
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public Pokemon getPokemonActual() {
        return pokemonActual;
    }

    public Pokemon getPokemon(String nombrePokemon) {
        return misPokemones.get(nombrePokemon);
    }

    public String getNombre() {return nombre;}

    public Jugador getAdversario() { return adversario; }

    public Map<String, Item> getItem(){
        return items;
    }

    public String getNombrePokemonActual(){
        return this.pokemonActual.getNombre();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAtacante(boolean atacante) {
        this.atacante = atacante;
    }

    public void setPokemonActual(Pokemon pokemonActual) {this.pokemonActual = pokemonActual;}

    public void actualizarPokemon(Pokemon pokemon){
        this.misPokemones.replace(pokemon.getNombre(), pokemon);
    }

    public void setAdversario(Jugador unEnemigo) {
        this.adversario = unEnemigo;
    }

    public boolean verficarEstadoPokemonActual(){
        return this.pokemonActual.getCualidades().estaConsciente();
    }

    public boolean isAtacante() {
        return atacante;
    }

    public boolean perdio() {
        return (this.misPokemones.values().stream().noneMatch(Pokemon::estaConsciente) ||
        this.esPerdedor);
    }

    public void perder() {
        this.esPerdedor = true;
    }

    public boolean esPerdedor(){
        return this.esPerdedor;
    }

    private Pokemon seleccionarPokemon(String unPokemon) {
        return this.misPokemones.get(unPokemon);
    }

    public void aplicarEfectoPasivo() {
        this.pokemonActual.aplicarEfectoPasivoPokemon();
    }

    public Item elegirItem(String nombreItem){
        return this.items.get(nombreItem);
    }

    public boolean elegirPokemon(String unPokemon) {
        if (this.seleccionarPokemon(unPokemon) == null) {
            return false;
        }
        else if (!this.seleccionarPokemon(unPokemon).estaConsciente()) {
            return false;
        }
        else if(this.pokemonActual != null){
            if(Objects.equals(unPokemon, pokemonActual.getNombre())) {
                return false;
            }
        }
        this.pokemonActual = this.seleccionarPokemon(unPokemon);
        return true;
    }

    public void atacarJugador(Jugador jugadorAdversario, String nombreHabilidad){

        pokemonActual.atacar(jugadorAdversario.getPokemonActual(), nombreHabilidad);
        setAtacante(false);
    }

    public boolean usarItem(String nombrePokemon, Item itemAplicable){
        if (itemAplicable.realizarCasosDeApliacion(misPokemones.get(nombrePokemon).getCualidades())){
            this.setAtacante(false);
            return true;
        }
        return false;
    }

    public boolean validarHabilidadPokemon(String nombreHabilidad){
        Validacion validacion = new Validacion();
        return validacion.estaContenidoHabilidad(nombreHabilidad,this.pokemonActual.getMisHabilidades());
    }

    public boolean validadorClaveItems(String nombreItem){
        Validacion validacion = new Validacion();
        return validacion.estaContenidoItem(nombreItem,this.items);
    }

    public boolean validadorClavePokemones(String nombrePokemon){
        Validacion validacion = new Validacion();
        return validacion.estaContenidoPokemon(nombrePokemon,this.misPokemones);
    }
}


