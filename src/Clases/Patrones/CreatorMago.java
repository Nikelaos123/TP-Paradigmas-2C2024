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

    @Override
    public void mostrarHechizos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarHechizos'");
    }

    @Override
    public void recibirDefensa(double puntosDefensa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recibirDefensa'");
    }

    @Override
    public void recibirSanacion(double puntosSanacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recibirSanacion'");
    }

    @Override
    public void recibirDanio(double puntosDanio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recibirDanio'");
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