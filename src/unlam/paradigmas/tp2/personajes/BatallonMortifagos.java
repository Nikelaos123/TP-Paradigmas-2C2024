package unlam.paradigmas.tp2.personajes;

import java.util.Set;

import unlam.paradigmas.tp2.personajes.mortifagos.Mortifago;

public class BatallonMortifagos extends Batallon<Mortifago> {

    // ctor aplicado al padre

    @Override
    public Set<Mortifago> getBatallon() {
        return combatientes;
    }

    // Igual al de arriba, posible eliminación
    public Set<Mortifago> getMortifagos() {
        return combatientes;
    }

    @Override
    public int getVivos() {
        int totalVivos = 0;

        for (Mortifago mortifago : combatientes) {
            if (mortifago.getVivo())
                totalVivos++;
        }

        return totalVivos;
    }

    @Override
    public boolean hayVivos() {

        for (Mortifago mortifago : combatientes) {
            if (mortifago.getVivo())
                return true;
        }

        return false;
    }

    @Override
    public boolean atacarEnGrupo(Batallon rivales) {
        if (getVivos() == 0)
            return false; // Se podría agregar un mensaje

        for (Mortifago mortifago : combatientes) {
            if (!mortifago.atacar(rivales))
                return false;
        }

        return true;
    }

    @Override
    public void generarBatallon() {
        while (combatientes.size() < this.cantidadCombatientes) {
            combatientes.add(new PersonajeFactory().crearMortifago());
        }
    }

    @Override
    public Mortifago getCombatiente(String nombre) {
        for (Mortifago mortifago : combatientes) {
            if (mortifago.getNombre().toLowerCase().equals(nombre))
                return mortifago;
        }

        return null;
    }

}
