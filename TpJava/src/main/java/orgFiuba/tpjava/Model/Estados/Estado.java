package orgFiuba.tpjava.Model.Estados;

import orgFiuba.tpjava.Model.Pokemones.Cualidades;
import com.fasterxml.jackson.annotation.JsonBackReference;

import static orgFiuba.tpjava.Constantes.*;

public abstract class Estado {

    protected String color;
    protected String nombre;
    @JsonBackReference
    protected Cualidades cualidades;
    protected boolean eliminarse =  false;

    public static Estado instaciarUnEstadoDe(String unEstado){
        return switch (unEstado) {
            case ESTADO_DORMIDO -> new EstadoDormido();
            case ESTADO_PARALIZADO -> new EstadoParalizado();
            case ESTADO_CONFUSO -> new EstadoConfuso();
            default -> new EstadoEnvenenado();
        };
    }
    public String getNombre() {
        return nombre;
    }

    public String getNombreConColor() {
        return this.color + this.getNombre() + "\u001B[0m";
    }


    public void setCualidades(Cualidades cualidades){

        this.cualidades = cualidades;}

    public boolean debeSerEliminado(){ return this.eliminarse;}
    public abstract boolean puedeAtacar();

    public void reiniciarAtributos(){
        this.eliminarse =  false;
    }
    public abstract void aplicarEfectoPasivoDeEstado();
}
