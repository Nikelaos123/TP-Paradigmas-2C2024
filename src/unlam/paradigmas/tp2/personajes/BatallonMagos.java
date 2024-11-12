package unlam.paradigmas.tp2.personajes;

import java.util.Set;

import unlam.paradigmas.tp2.personajes.magos.*;

public class BatallonMagos extends Batallon<Mago> {

    // ctor aplicado al padre

    @Override
    public Set<Mago> getBatallon() {
        return combatientes;
    }

    // Igual al de arriba, posible eliminación
    public Set<Mago> getMagos() {
        return combatientes;
    }

    @Override
    public int getVivos() {
        int totalVivos = 0;

        for (Mago mago : combatientes) {
            if (mago.getVivo())
                totalVivos++;
        }

        return totalVivos;
    }

    @Override
    public boolean hayVivos() {

        for (Mago mago : combatientes) {
            if (mago.getVivo())
                return true;
        }

        return false;
    }

    @Override
    public boolean atacarEnGrupo(Batallon rivales) {
        if (getVivos() == 0)
            return false; // Se podría agregar un mensaje

        for (Mago mago : combatientes) {
            if (!mago.atacar(rivales))
                return false;
        }

        return true;
    }

    @Override
    public void generarBatallon() {
        while (combatientes.size() < this.cantidadCombatientes) {
            combatientes.add(new PersonajeFactory().crearMago());
        }
    }

    @Override
    public Mago getCombatiente(String nombre) {
        for (Mago mago : combatientes) {
            if (mago.getNombre().toLowerCase().equals(nombre))
                return mago;
        }

        return null;
    }

}
