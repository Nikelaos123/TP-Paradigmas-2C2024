package Clases.Basicas;

public class Auror extends Mago implements Personaje{
    
    public Auror() {
        super();
        mana+= 200;
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
