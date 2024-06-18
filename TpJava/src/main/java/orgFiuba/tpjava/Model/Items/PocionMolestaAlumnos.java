package orgFiuba.tpjava.Model.Items;

import com.fasterxml.jackson.annotation.JsonTypeName;
import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;
@JsonTypeName("Pocion MolestaAlumnos")
public class PocionMolestaAlumnos extends ItemsCuracion{
    public PocionMolestaAlumnos(String unNombre, int cantidad, Modificacion unModificacion,String descripcion) {
        super(unNombre, cantidad,descripcion);
        this.unaModificacion = unModificacion;
    }

    @Override
    public boolean aplicarItem(Cualidades cualidades) {
            boolean realizo = realizarUsadoItemsDeCuracion(cualidades);
            this.unaModificacion.modificar(cualidades, (int)Math.round(cualidades.getVidaMaxima()/3)); // --> 1/3 de la vida maxima del pokemon al que lo desea aplicar
            return realizo;
    }
}
