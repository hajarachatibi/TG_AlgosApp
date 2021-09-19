package Algorithmes;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Elements.Arret;
import Elements.Configuration;
import Elements.Graphe;
import Elements.Sommet;
import Interfaces.Canvas;

public class Wireshall extends Algorithme{

    public Wireshall(Graphe g) {
        super("Wireshall", g);
    }

    @Override
    protected void preRun() {
        Configuration.resetImages();
        Canvas.getInstance().screenShot();
        Configuration.backup();
        Configuration.current_algo=this;
        trace.append("Algorithme: "+nom+" Debut\n");
        trace.append("--graphe de base: |V|= "+g.getV()+", |E|= "+g.getE()+", Densite= "+g.getDensite()+"\n");
        Canvas.getInstance().repaint();
        Canvas.getInstance().screenShot();
    }
    @Override
    public void run() {
        preRun();
        for (Sommet y : g.getSommets()) {
            try {
                Thread.sleep(Configuration.sleep_time);
            } catch (InterruptedException ex) {
                Logger.getLogger(Wireshall.class.getName()).log(Level.SEVERE, null, ex);
            }
            trace.append("--iteration: "+(++iteration)+"\n");
            ArrayList<Sommet> x = g.getVoisinsEntrants(y);
            ArrayList<Sommet> z = g.getVoisinsSortants(y);
            ArrayList<Arret> arrets_ajoutes = new ArrayList<>();
            for (Sommet xi : x) {
                for (Sommet zi : z) {
                    Arret ar = g.addArretWireshall(xi, zi);
                    if(ar!=null)arrets_ajoutes.add(ar);
                }
            }
            trace.append("    arrets ajoutes: "+arrets_ajoutes+"\n");
            Canvas.getInstance().repaint();
            Canvas.getInstance().screenShot();
        }
        postRun();
    }
    @Override
    protected void postRun() {
        trace.append("--graphe final: |V|= "+g.getV()+", |E|= "+g.getE()+", Densite= "+g.getDensite()+"\n");
        trace.append("Algorithme: "+nom+" Fin.\n");
        Canvas.getInstance().repaint();
        Canvas.getInstance().screenShot();
    }

    
    
}
