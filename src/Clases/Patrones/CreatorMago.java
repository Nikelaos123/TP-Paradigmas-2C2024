package Clases.Patrones;
import Clases.Basicas.*;

import java.util.Random;

import Clases.Basicas.Personaje;

public class CreatorMago extends CreatorPersonaje{
    
    private static final int cantidadHijos = 3;

    @Override
    public Personaje crearPersonaje(){

        Random random = new Random();
        int numeroAleatorio = random.nextInt(cantidadHijos) + 1; 

        switch (numeroAleatorio) {
            case 1:
                return new Profesor();
                

            case 2:
                return new Estudiante();
                
            
            case 3:
                return new Auror();
        }

        return null;
    }



}

// class FabricaGuerrero extends FabricaPersonajes {
//     @Override
//     public Personaje crearPersonaje() {
//         return new Guerrero();
//     }
// }

// class FabricaMago extends FabricaPersonajes {
//     @Override
//     public Personaje crearPersonaje() {
//         return new Mago();
//     }
// }