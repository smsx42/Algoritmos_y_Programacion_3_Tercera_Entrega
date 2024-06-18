package orgFiuba.tpjava.Model.Estados;
import static orgFiuba.tpjava.Constantes.*;

public class EstadoEnvenenado extends Estado{

    private double danioVeneno;


    public EstadoEnvenenado(){
        this.nombre = ESTADO_ENVENENADO;
        this.color = ANSI_FONDO_VIOLETA + ANSI_BLANCO;
    }

    public double getDanioVeneno() {
        return danioVeneno;
    }

    @Override
    public boolean puedeAtacar(){
        return true;
    }


    @Override
    public void aplicarEfectoPasivoDeEstado() {
        this.danioVeneno = this.cualidades.getVidaMaxima() * PORCENTAJE_VENENO;
        this.cualidades.recibirDanio(this.danioVeneno);

    }
}
