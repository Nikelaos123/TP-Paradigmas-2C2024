package Clases.Basicas;

public abstract class Mago {
    protected String nombre;
    protected double mana;
    protected double vida;
    protected double defensa;
    //protected LinkedList<Hechizo> hechizos;
    protected boolean vive;

    public Mago() {
        super();

        mana= 100;
    }
}
