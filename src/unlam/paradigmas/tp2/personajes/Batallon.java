package unlam.paradigmas.tp2.personajes;

import java.util.LinkedList;
import java.util.List;



public abstract class Batallon<T> {

    protected List<T> combatientes;

    public Batallon() {
        super();
        combatientes = new LinkedList<T>();
    }

    public void agregar(T combatiente) {
        combatientes.add(combatiente);
    }
    
    public abstract List<T> getBatallon();

    public int getTotalCombatientes() {
        return combatientes.size();
    }
    
    public abstract int getVivos();
    public abstract boolean hayVivos();

    public abstract void atacarEnGrupo(Batallon<T> rivales);

    public T getCombatiente(int index) {
        if(index > combatientes.size())
            throw new RuntimeException("El indice sobresale de la cantidad de combatientes");

        return combatientes.get(index);
    }

    


}
