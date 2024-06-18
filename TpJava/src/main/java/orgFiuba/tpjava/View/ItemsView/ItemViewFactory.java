package orgFiuba.tpjava.View.ItemsView;
import orgFiuba.tpjava.Model.Items.*;

public class ItemViewFactory {

    public ItemView createItemView(Item item) {
        if (item.getClass() == AtaqueX.class) {
            return new AtaqueXView(item);
        }
        if (item.getClass() == DefensaX.class) {
            return new DefensaXView(item);
        }
        if (item.getClass() == Pocion.class) {
            return new PocionView(item);
        }
        if (item.getClass() == HiperPocion.class) {
            return new HiperPocionView(item);
        }
        if (item.getClass() == MegaPocion.class) {
            return new MegaPocionView(item);
        }
        if (item.getClass() == PocionCuracionEstados.class) {
            return new PocionCuracionEstadosView(item);
        }
        if (item.getClass() == Revivir.class) {
            return new RevivirView(item);
        }
        return new PocionMolestaAlumnoView(item);
    }
}
