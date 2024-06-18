package orgFiuba.tpjava.Model.Estados;

import orgFiuba.tpjava.Model.ServicioDeRandoms;

import static orgFiuba.tpjava.Constantes.*;

public class EstadoConfuso extends Estado{

    private int turnosConfuso;
    private final int duracionMaxima;
    private boolean confundido;
    private double danioPorConfusion;


    public EstadoConfuso(){
        this.nombre = ESTADO_CONFUSO;
        this.duracionMaxima = 3;
        this.turnosConfuso = 0;
        this.color = ANSI_FONDO_ROJO + ANSI_NEGRO;
    }

    public int getTurnosConfuso() {
        return turnosConfuso;
    }

    public int getDuracionMaxima() {
        return duracionMaxima;
    }

    public boolean isConfundido() {
        return confundido;
    }

    public double getDanioPorConfusion() {
        return danioPorConfusion;
    }

    @Override
    public boolean puedeAtacar(){

        if(this.turnosConfuso >= this.duracionMaxima){
            this.turnosConfuso = 0;
            this.eliminarse = true;
            return true;
        }
        this.turnosConfuso++;

        double probabilidad = ServicioDeRandoms.obtenerRandomParaEstadoPuedeAtacar();
        this.confundido = probabilidad <= PROBABILIDAD_DE_HERIRSE;

        if(confundido){
            this.danioPorConfusion = PORCENTAJE_DANIO_CONFUSO * this.cualidades.getVidaMaxima();
            this.cualidades.recibirDanio(danioPorConfusion);
            return false;
        } else return true;
    }

    @Override
    public void aplicarEfectoPasivoDeEstado(){
    }
}
