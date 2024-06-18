package orgFiuba.tpjava.View.EstadosView;

import orgFiuba.tpjava.Model.Estados.EstadoDormido;

import static orgFiuba.tpjava.Constantes.ANSI_RESET;
import static orgFiuba.tpjava.Constantes.ANSI_VERDE;

public class EstadoDormidoView extends EstadoView{

    private EstadoDormido estadoDormido;

    public EstadoDormidoView(EstadoDormido estadoDormido){
        super(estadoDormido);
        this.estadoDormido = estadoDormido;
    }

    public boolean mostrar(){


        if (this.estadoDormido.getTurnosDormido() >= this.estadoDormido.getDuracionMaxima() || this.estadoDormido.getSuerteDespertar() <=  this.estadoDormido.getProbabilidadDeDespertar()){
            System.out.println(ANSI_VERDE + "El pokemon se despertó!" + ANSI_RESET);
            return true;
        } else {
            System.out.println(ANSI_VERDE + "El pokemon esta dormido por " + (this.estadoDormido.getDuracionMaxima() - this.estadoDormido.getTurnosDormido()) + " turnos." + ANSI_RESET);
            return false;
        }

    }

    public void mostrarEfectoPasivoDeEstado(){
    }
}
