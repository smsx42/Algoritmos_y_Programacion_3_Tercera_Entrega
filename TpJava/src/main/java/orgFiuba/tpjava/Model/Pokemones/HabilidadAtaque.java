package orgFiuba.tpjava.Model.Pokemones;

import orgFiuba.tpjava.Model.Tipos.Tipo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import orgFiuba.tpjava.Model.ServicioDeRandoms;

import static orgFiuba.tpjava.Constantes.*;
@JsonTypeName("ataque")
@JsonIgnoreProperties(ignoreUnknown = true)
public class HabilidadAtaque extends Habilidad {
    private final Tipo tipo;
    private final int poder;

    private double danioRealizado;
    @JsonCreator
    public HabilidadAtaque(
            @JsonProperty("nombre") String nombre,
            @JsonProperty("tipo") Tipo tipo,
            @JsonProperty("poder") int poder,
            @JsonProperty("cantidad") int cantidad){
        super(nombre,cantidad);
        this.tipo = tipo;
        this.poder = poder;
        this.danioRealizado = 0;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public int getPoder() {
        return poder;
    }

    public double getDanioRealizado() {
        return danioRealizado;
    }

    private double potenciaDeDanio(Tipo tipoPokemon){
        return this.tipo.calcularMultiplicadorDeDanio(tipoPokemon);
    }

    private double calculoAtaqueSegunTipo(Tipo tipoDeUnPokemonPropio, Tipo unTipoPokemonEnemigo) {

        double efectividadTipo = this.potenciaDeDanio(unTipoPokemonEnemigo);
        double mismoTipo = tipoDeUnPokemonPropio.calcularBonusDelMismoTipo(this.tipo);

        double random = ServicioDeRandoms.obtenerRandomParaHabilidadAtaqueCalculoAtaqueSegunTipo();

        return efectividadTipo * mismoTipo * random;
    }

    private double calculoCritico() {
        int resultado = ServicioDeRandoms.obtenerRandomParaHabilidadAtaqueCalculoCritico();
        if (resultado < PROBABILIDAD_CRITICO) {
            return NO_CRITICO;
        }
        return CRITICO;
    }

    private double calculoAtaqueSegunEstadisticas(Cualidades cualidadesPropio, Cualidades cualidadesEnemigo) {
        double ataque = cualidadesPropio.getAtaque();
        double defensa = cualidadesEnemigo.getDefensa();
        double critico = this.calculoCritico();
        double nivel = cualidadesPropio.getNivel();

        return (2.0*nivel* (double) this.poder *ataque*critico/(defensa*5.0)+2.0)/50.0;
    }

        private double atacar(Cualidades cualidadesPokemonPropio, Cualidades cualidadesPokemonEnemigo){
        double danioEstadisticas = this.calculoAtaqueSegunEstadisticas(cualidadesPokemonPropio,cualidadesPokemonEnemigo);
        double danioTipo = this.calculoAtaqueSegunTipo(cualidadesPokemonPropio.getTipo(),cualidadesPokemonEnemigo.getTipo());
        return danioEstadisticas * danioTipo;
    }

    @Override
    public void usarHabilidad(Cualidades cualidadesPokemonEnemigo,Cualidades cualidadesPokemonPropio){
        this.cantidadDeUsos -= 1;
        double danio = Math.round(this.atacar(cualidadesPokemonPropio,cualidadesPokemonEnemigo));
        this.danioRealizado = danio;
        cualidadesPokemonEnemigo.recibirDanio(danio);
    }
}
