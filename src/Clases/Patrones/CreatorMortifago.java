package Clases.Patrones;

import java.util.Random;

import Clases.Basicas.Auror;
import Clases.Basicas.Comandante;
import Clases.Basicas.Estudiante;
import Clases.Basicas.Personaje;
import Clases.Basicas.Profesor;
import Clases.Basicas.Seguidor;

public class CreatorMortifago extends CreatorPersonaje{
    private static final int cantidadHijos = 2;
    

    @Override
    public Personaje crearPersonaje(){

        Random random = new Random();
        int numeroAleatorio = random.nextInt(cantidadHijos) + 1; 

        switch (numeroAleatorio) {
            case 1:
                return new Comandante();
                

            case 2:
                return new Seguidor();
                
            
        }

        return null;
    }


}
