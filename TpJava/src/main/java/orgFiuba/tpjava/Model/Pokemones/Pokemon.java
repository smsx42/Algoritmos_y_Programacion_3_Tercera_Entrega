package orgFiuba.tpjava.Model.Pokemones;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import orgFiuba.tpjava.Model.SerializacionDeserealizacion.PokemonSerializer;
import orgFiuba.tpjava.Model.Tipos.Tipo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(using = PokemonSerializer.class)
public class Pokemon {

    //Atributos:
    private final String nombre;
    private final String historia;
    private final Cualidades cualidades;

    private final Map<String, Habilidad> misHabilidades;

    //Metodos:
    public Pokemon(String nombre, int nivel,String tipo, String historia,double vidaMax,int velocidad,int defensa,int ataque){
        this.nombre = nombre;
        this.historia = historia;
        this.cualidades = new Cualidades(vidaMax,nivel,velocidad,defensa,ataque, tipo);
        this.misHabilidades = new HashMap<>();
    }

    public void aplicarEfectoPasivoPokemon(){
        this.cualidades.aplicarEfectoPasivoDeEstadosActuales(); // cambiarlo a aplicarEfectoPasivoEstadosActuales
    }
    public String getNombre() {return nombre;}
    public Map<String, Habilidad> getMisHabilidades() {
        return misHabilidades;
    }
    public Cualidades getCualidades() {return cualidades;}
    public int obtenerVelocidad() {return cualidades.getVelocidad();}
    public double obtenerVidaMaxima() {return this.cualidades.getVidaMaxima();}
    public String getHistoria() {
        return historia;
    }

    public void aniadirHabilidad(Habilidad unaHabilidad){
        this.misHabilidades.put(unaHabilidad.getNombre(), unaHabilidad);
    }

    public Habilidad seleccionarHabilidad(String unaHabilidad){
        return misHabilidades.get(unaHabilidad);
    }

    public boolean estaConsciente() {return this.cualidades.estaConsciente();}

    public void atacar(Pokemon pokemonEnemigoActual, String nombreDeHabilidad) {

        Habilidad unaHabilidad = this.seleccionarHabilidad(nombreDeHabilidad);
        if (this.cualidades.atacarConEstadosActuales()) {
            unaHabilidad.usarHabilidad(pokemonEnemigoActual.getCualidades(), this.cualidades);
            // lanzar evento de ataque
        }
    }

    public Tipo obtenerTipo() {return this.cualidades.getTipo(); }
}
