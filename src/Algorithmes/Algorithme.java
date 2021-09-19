package Algorithmes;

import Elements.Configuration;
import Elements.Graphe;


public abstract class Algorithme implements Runnable{
    protected String nom;
    protected Graphe g;
    protected int iteration;
    protected StringBuffer trace;
    

    public Algorithme(String nom, Graphe g) {
        this.nom = nom;
        this.g = g;
        trace = new StringBuffer();
    }  

    public String getNom() {
        return nom;
    }
    
    protected abstract void preRun();
    protected abstract void postRun();
    
    public StringBuffer getTrace() {
        return trace;
    }

    public void setTrace(StringBuffer trace) {
        this.trace = trace;
    }

}
