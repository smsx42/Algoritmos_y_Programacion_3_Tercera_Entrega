package orgFiuba.tpjava.Model.Pokemones;

import orgFiuba.tpjava.Model.Estados.Estado;
import orgFiuba.tpjava.Model.Estados.EstadoInhabilitado;
import orgFiuba.tpjava.Model.Estados.EstadoNormal;
import orgFiuba.tpjava.Model.Tipos.Tipo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.HashSet;
import java.util.Set;

import static orgFiuba.tpjava.Constantes.PORCENTAJE;
public class Cualidades {

    //Atributos:
    private double vidaMaxima;

    private double vidaActual;
    private int velocidad;
    private int defensa;
    private int ataque;

    private int nivel;

    private Tipo tipo;
    @JsonManagedReference
    @JsonIgnore
    private final Set<Estado> estados = new HashSet<>();


    //Metodos:

    public Cualidades(){

    }
    public Cualidades(double vida,int nivel ,int velocidad, int defensa, int ataque, String tipo){
        this.vidaMaxima = vida;
        this.vidaActual = vida;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
        this.nivel = nivel;
        this.tipo = Tipo.instanciarUnTipoDe(tipo);
        Estado unEstado = new EstadoNormal();
        unEstado.setCualidades(this);
        this.estados.add(unEstado);
    }

    public double getVidaMaxima() { return this.vidaMaxima ;}

    public int getVelocidad() {return this.velocidad;}

    public int getDefensa() {return this.defensa;}

    public int getAtaque() {return this.ataque;}

    public double getNivel() {
        return this.nivel;
    }

    public double getVida() {
        return this.vidaActual;
    }

    public Set<Estado> obtenerEstadosActuales() {
        return this.estados;
    }
    public  void agregarEstado(Estado unEstado){
        unEstado.reiniciarAtributos();
        unEstado.setCualidades(this);
        this.estados.add(unEstado);
    }

    public boolean atacarConEstadosActuales(){
        boolean puedeAtacarConSusEstados = this.estados.stream().allMatch(Estado::puedeAtacar);
        this.estados.removeIf(Estado::debeSerEliminado);
        return puedeAtacarConSusEstados;
    }

    public void aplicarEfectoPasivoDeEstadosActuales(){
        this.estados.forEach(Estado::aplicarEfectoPasivoDeEstado);
    }

    public Tipo getTipo() {return tipo;}

    public void aumentarVida(double vida){
        double vidaTotal = (this.vidaActual + vida);
        if(this.vidaActual != this.vidaMaxima) {
            if (vidaTotal > this.vidaMaxima) {
                this.vidaActual = this.vidaMaxima;
            } else {
                this.vidaActual += vida;
            }
        }
    }

    private void reduccionVida(double vida){
        double vidaTotal = (this.vidaActual - vida);
        if(vidaTotal < 0){
            this.vidaActual = 0;
        }
        else{ this.vidaActual -= vida;}
    }

    public void recibirDanio(double damageEnemigo){
        this.reduccionVida(damageEnemigo);
    }

    public void cambiarLosEstadosA(Estado unEstado) {
        this.estados.clear();
        this.agregarEstado(unEstado);
    }

    public boolean estaConsciente() {
        if(this.getVida() == 0){
            this.cambiarLosEstadosA(new EstadoInhabilitado());
            return false;
        }
        return true;
    }

    public void modificarVelocidad(int etapas){
        this.velocidad += (int) (this.velocidad * etapas * PORCENTAJE);
    }

    public void modificarDefensa(int etapas){
        this.defensa += (int) (this.defensa * etapas * PORCENTAJE);
    }

    public void modificarAtaque(int etapas){
        this.ataque += (int) (this.ataque * etapas * PORCENTAJE);
    }

    public double getPorcentajeVida() {
        return this.vidaActual / this.vidaMaxima;
    }
}
