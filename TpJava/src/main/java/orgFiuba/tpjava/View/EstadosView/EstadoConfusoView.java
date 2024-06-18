package orgFiuba.tpjava.View.EstadosView;

import orgFiuba.tpjava.Model.Estados.EstadoConfuso;

import static orgFiuba.tpjava.Constantes.ANSI_RESET;
import static orgFiuba.tpjava.Constantes.ANSI_VERDE;

public class EstadoConfusoView extends EstadoView{

    private EstadoConfuso estadoConfuso;

    public EstadoConfusoView(EstadoConfuso estadoConfuso){
        super(estadoConfuso);
        this.estadoConfuso = estadoConfuso;
    }

    public boolean mostrar(){

        if(this.estadoConfuso.getTurnosConfuso() >= this.estadoConfuso.getDuracionMaxima()){
            System.out.println(ANSI_VERDE + "El pokemon ya no esta confuso" + ANSI_RESET);
            return true;
        }
        if(this.estadoConfuso.isConfundido()){
            System.out.println(ANSI_VERDE + "El pokemon se hizo daño asi mismo!!! " + ANSI_RESET);
            System.out.println(ANSI_VERDE +"El daño es de " + this.estadoConfuso.getDanioPorConfusion() + ANSI_RESET);
        }
        return false;

    }

    public void mostrarEfectoPasivoDeEstado(){
        System.out.println("El pokemon esta confuso por " + this.estadoConfuso.getTurnosConfuso() + " turnos.");
    }
}
