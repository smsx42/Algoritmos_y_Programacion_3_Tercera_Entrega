package orgFiuba.tpjava.Model.Items;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import orgFiuba.tpjava.Model.Pokemones.Cualidades;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "nombre")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Pocion.class, name = "Pocion"),
        @JsonSubTypes.Type(value = MegaPocion.class, name = "Mega Pocion"),
        @JsonSubTypes.Type(value = HiperPocion.class, name = "Hiper Pocion"),
        @JsonSubTypes.Type(value = PocionMolestaAlumnos.class, name = "Pocion MolestaAlumnos"),
        @JsonSubTypes.Type(value = AtaqueX.class, name = "AtaqueX"),
        @JsonSubTypes.Type(value = DefensaX.class, name = "DefensaX"),
        @JsonSubTypes.Type(value = Revivir.class, name = "Revivir"),
        @JsonSubTypes.Type(value = PocionCuracionEstados.class, name = "Curar Todo"),
})
public abstract class Item {

    protected final String nombre;
    protected int cantidad;

    public String getDescripcion() {
        return descripcion;
    }

    protected final String descripcion;
    public Modificacion unaModificacion;

    public Item(String nombre, int cantidad,String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }
    public int getCantidad() {return cantidad;}

    public String getNombre() {return nombre;}

    public Modificacion getUnaModificacion() {
        return unaModificacion;
    }

    public void setCantidad(Integer unaCantidad) {
        this.cantidad = unaCantidad;
    }

    public abstract boolean aplicarItem(Cualidades cualidades);
    public abstract boolean esUnItemDeSoloCampoDeBatalla();

    public boolean realizarCasosDeApliacion(Cualidades cualidades){
        if (this.cantidad == 0) {
            return false;
        }
        else{
            return this.aplicarItem(cualidades);
        }
    }
}
