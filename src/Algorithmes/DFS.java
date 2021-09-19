package Algorithmes;

import java.awt.Color;
import java.util.Iterator;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import Elements.Configuration;
import Elements.Graphe;
import Elements.Sommet;
import Interfaces.Canvas;

public class DFS extends Algorithme{
    private Stack<Sommet> m;
    private Sommet r;

    public DFS(Graphe g,Sommet r) {
        super("DFS", g);
        this.r = r;
    }

    

    @Override
    public void preRun() {
        Configuration.resetImages();
        Canvas.getInstance().screenShot();
        Configuration.backup();
        Configuration.current_algo=this;
        trace.append("Algorithme: "+nom+" Debut\n");
        m = new Stack<>();
        m.push(r);
        r.setCouleur(Configuration.coleur_parcour);
        Canvas.getInstance().repaint();
        Canvas.getInstance().screenShot();
    }
    public void dfs(Sommet s){
        try {
            Thread.sleep(Configuration.sleep_time);
        } catch (InterruptedException ex) {
            Logger.getLogger(BFS.class.getName()).log(Level.SEVERE, null, ex);
        }
        trace.append("--iteration: "+(++iteration)+"\n");
        m.push(s);
        trace.append("    M = "+m+"\n");
        s.setCouleur(Configuration.coleur_parcour);
        Canvas.getInstance().repaint();
        Canvas.getInstance().screenShot();
        for (Sommet t : g.getVoisins(s)) {
            if(!m.contains(t))dfs(t);
        }
    }

    @Override
    public void run() {
        preRun();
        for (Sommet t : g.getVoisins(r)) {
            if(!m.contains(t))dfs(t);
        }
        postRun();
    }

    @Override
    public void postRun() {
        trace.append("--graphe final: |V|= "+g.getV()+", |E|= "+g.getE()+", Densite= "+g.getDensite()+"\n");
        trace.append("Algorithme: "+nom+" Fin.\n");
        Canvas.getInstance().repaint();
        Canvas.getInstance().screenShot();
    }
}
