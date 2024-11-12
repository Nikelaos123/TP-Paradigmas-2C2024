package unlam.paradigmas.tp2.personajes;

import java.util.Set;
import java.util.HashSet;

public abstract class Batallon<T> {

    // protected List<T> combatientes;
    protected Set<T> combatientes;
    // protected static final int CANTIDAD_COMBATIENTES = 5;
    protected int cantidadCombatientes = 5;

    public Batallon() {
        super();
        // combatientes = new LinkedList<T>();
        combatientes = new HashSet<T>();
    }

    public Batallon(int cantidadCombatientes) {
        super();
        // combatientes = new LinkedList<T>();
        combatientes = new HashSet<T>();
        this.cantidadCombatientes = cantidadCombatientes;
    }

    public void agregar(T combatiente) {
        combatientes.add(combatiente);
    }

    public abstract void agregar();

    public abstract Set<T> getBatallon();

    public int getTotalCombatientes() {
        return combatientes.size();
    }

    public int getMaxCombatientes() {
        return this.cantidadCombatientes;
    }

    public abstract int getVivos();

    public abstract boolean hayVivos();

    public abstract void atacarEnGrupo(Batallon<T> rivales);

}
