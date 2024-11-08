package Clases.Basicas;

public abstract class Personaje {
    
    private String nombre;
    private double nivelMagia; //mana
    private double puntosVida;
    private double nivelDefensa;


    public abstract void mostrarHechizos ();

    public abstract void recibirDefensa (double puntosDefensa);

    public abstract void recibirSanacion (double puntosSanacion);

    public abstract void recibirDanio (double puntosDanio);


    //public void lanzarHechizo ();


}
