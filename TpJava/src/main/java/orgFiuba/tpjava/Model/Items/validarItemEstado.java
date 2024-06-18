package orgFiuba.tpjava.Model.Items;

import orgFiuba.tpjava.Model.Estados.Estado;

import java.util.Set;

public interface validarItemEstado{
    boolean realizarUsadoRevivir(Set<Estado> estadosActuales);
    boolean realizarUsadoCurarTodo(Set<Estado> estadosActuales);
}
