package unlam.paradigmas.tp2.personajes;

import java.util.LinkedList;
import java.util.List;

import unlam.paradigmas.tp2.personajes.magos.Mago;


public abstract class Batallon<T> {

    protected List<T> combatientes;

    public Batallon() {
        super();
        combatientes = new LinkedList<T>();
    }

    public abstract List<T> getBatallon();

    public abstract int getVivos();

    public abstract void atacarEnGrupo(Batallon rivales);


}
