package orgFiuba.tpjava.View.ClimasView;

import orgFiuba.tpjava.Model.Climas.*;

public class ClimaFactory {

    public ClimaView createClimaView(Clima clima){

        if(clima.getClass() == ClimaTormentaHuracan.class){
            return new ClimaHuracanView(clima);
        }
        if(clima.getClass() == ClimaLLuvia.class){
            return new ClimaLLuviaView(clima);
        }

        if(clima.getClass() == ClimaNevado.class){
            return new ClimaNevadoView(clima);
        }
        if(clima.getClass() == ClimaNiebla.class){
            return new ClimaNieblaView(clima);
        }
        if(clima.getClass() == ClimaSoleado.class){
            return new ClimaSoleadoView(clima);
        }
        if(clima.getClass() == ClimaTormentaArena.class){
            return new ClimaTorementaArenaView(clima);
        }
        if (clima.getClass() == ClimaTormentaNevada.class){
            return new ClimaTormentaNevadaView(clima);
        }
        if (clima.getClass() == ClimaTormentaElectrica.class){
            return new ClimaTormentaDeRayosView(clima);
        }

        return new ClimaNormalView(clima);
    }
}
