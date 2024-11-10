package unlam.paradigmas.tp2.personajes;

import java.util.LinkedList;
import java.util.List;

import unlam.paradigmas.tp2.personajes.magos.*;
import unlam.paradigmas.tp2.personajes.mortifagos.*;

public class batallonMagos extends Batallon<Mago>{

    
    //ctor aplicado al padre


    @Override
    public List<Mago> getBatallon() {
        return combatientes;
    }

    //Igual al de arriba, posible eliminación
    public List<Mago> getMagos(){
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
    public void atacarEnGrupo(Batallon rivales) {
        if(getVivos() == 0)
            return; //Se podría agregar un mensaje


        
        for (Mago mago : combatientes) {
            mago.atacar(rivales);
        }
    }

    

    
}
