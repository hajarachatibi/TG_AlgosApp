package Elements;

import Algorithmes.Algorithme;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Interfaces.Canvas;
import Interfaces.Principal;

public class Configuration {
    public static boolean pondere = true;
    public static boolean oriente = true;
    public static int taille_arret = 2;
    public static int taille_sommet = 15;
    public static Color coleur_arret = new Color (0,255,255);
    public static Color coleur_sommet = new Color (205,92,92);
    public static Color coleur_label = Color.white;
    public static Color coleur_parcour = Color.blue;
    public static long sleep_time = 1000;
    public static double default_cout = 1;
    public static Algorithme current_algo = null;
    public static boolean pondere_positive = true;
    
    private static ArrayList<Sommet> sommets_bkp;
    private static ArrayList<Arret> arrets_bkp;
    
    public static ArrayList<BufferedImage> images = new ArrayList<>();
    
    public static void restore(){

        Canvas.getInstance().deselectionne();
        Canvas.getInstance().getGraphe().getSommets().clear();
        Canvas.getInstance().getGraphe().getSommets().addAll(sommets_bkp);
        Canvas.getInstance().getGraphe().getArrets().clear();
        Canvas.getInstance().getGraphe().getArrets().addAll(arrets_bkp);
        Canvas.getInstance().repaint();
    }
    public static void backup() {
        Canvas.getInstance().deselectionne();
        sommets_bkp = new ArrayList<>();
        for(Sommet s:Canvas.getInstance().getGraphe().getSommets()){
            sommets_bkp.add(new Sommet(s));
        }
        arrets_bkp = new ArrayList<>();
        for(Arret ar:Canvas.getInstance().getGraphe().getArrets()){
            arrets_bkp.add(new Arret(ar, getCopie(ar.getSommetA()), getCopie(ar.getSommetB())));
        }
    }
    public static Sommet getCopie(Sommet o){
        for(Sommet s:sommets_bkp){
            if(s.getPosition_x()==o.getPosition_x() && s.getPosition_y()==o.getPosition_y())return s;
        }
        return null;
    }

    public static void resetImages(){
        images = new ArrayList<BufferedImage>();
    }
    static void addScreen(BufferedImage screenShot) {
        images.add(screenShot);
    }
    public static void checkAlgos(){

        boolean c1=false,c2=false,c3=false,c4=false,c5=false,c6=false,c7=false,c8=false;
        c1 = Canvas.getInstance()!=null;
        if(c1)c2 = Canvas.getInstance().getGraphe()!=null;
        if(c2)c3 = Canvas.getInstance().getGraphe().getSommets().size()>0;
        c4 = sommets_bkp!=null;
        if(c4)c5 = sommets_bkp.size()>0;
        if(c1)c6 = Canvas.getInstance().getSelectionne()!=null;
        if(c2)c7=Canvas.getInstance().getGraphe().getS()!=null;
        if(c2)c8=Canvas.getInstance().getGraphe().getP()!=null;
        Principal.btnmatrice.setEnabled(c1);
        Principal.btnBFS.setEnabled(c3 && c6);
        Principal.btnDFS.setEnabled(c3 && c6);
        Principal.btnWareshall.setEnabled(c1 && c2 && c3);
        Principal.btnPrim.setEnabled(c1 && c2 && c3);
        Principal.btnKruskal.setEnabled(c1 && c2 && c3);
        Principal.btnDijkstra.setEnabled(c1 && c2 && c3 && c6 && pondere_positive && oriente);
        Principal.btnBFord.setEnabled(c1 && c2 && c3 && c6 && pondere && oriente);
        Principal.btnresd.setEnabled(c7 && c8 && oriente && pondere);
        Principal.btnWP.setEnabled(c3);

    }
}
