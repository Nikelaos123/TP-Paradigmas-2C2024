package unlam.paradigmas.tp2.personajes;

import java.util.List;

import unlam.paradigmas.tp2.personajes.magos.Mago;
import unlam.paradigmas.tp2.personajes.mortifagos.Mortifago;

public class BatallonMortifagos extends Batallon<Mortifago> {

    //ctor aplicado al padre


    @Override
    public List<Mortifago> getBatallon() {
        return combatientes;
    }

    //Igual al de arriba, posible eliminación
    public List<Mortifago> getMortifagos(){
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
    public void atacarEnGrupo(Batallon rivales) {
        if(getVivos() == 0)
            return; //Se podría agregar un mensaje

        for (Mortifago mortifago : combatientes) {
            mortifago.atacar(rivales);
        }
    }
    
}
