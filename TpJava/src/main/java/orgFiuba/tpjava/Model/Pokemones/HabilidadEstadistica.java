package orgFiuba.tpjava.Model.Pokemones;

import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
@JsonTypeName("estadistica")
@JsonIgnoreProperties(ignoreUnknown = true)
public class HabilidadEstadistica extends Habilidad{

    private final boolean modificacionPropia;
    private final int etapas;

    private final Modificacion unaModificacion;
    @JsonCreator
    public HabilidadEstadistica(
            @JsonProperty("nombre") String nombre,
            @JsonProperty("cantidadDeUsos") int cantidadDeUsos,
            @JsonProperty("propio") boolean propio,
            @JsonProperty("etapas") int etapas,
            @JsonProperty("modificacion") Modificacion modificar){
        super(nombre,cantidadDeUsos);
        this.modificacionPropia = propio;
        this.unaModificacion = modificar;
        this.etapas = etapas;
    }

    public String obtenerNombreModificacion(){
            return this.unaModificacion.obtenerNombreModificacion();
    }

    public int getEtapas() {
        return etapas;
    }

    public boolean isModificacionPropia() {
        return modificacionPropia;
    }

    @Override
    public void usarHabilidad(Cualidades cualidadesPokemonEnemigo,Cualidades cualidadesPokemonPropio){
        this.cantidadDeUsos -= 1;
        if(this.modificacionPropia){
            this.unaModificacion.modificar(cualidadesPokemonPropio,this.etapas);
        } else {
            this.unaModificacion.modificar(cualidadesPokemonEnemigo,this.etapas);
        }
    }

    public String getModificacion() {
        return this.unaModificacion.obtenerNombreModificacion();
    }
}
