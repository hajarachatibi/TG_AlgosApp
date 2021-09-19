package Elements;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

public class Sommet implements Comparable<Sommet> {
    private String label;
    private Color couleurLabel;
    private Color couleur;
    private int position_x;
    private int position_y;
    private boolean selected;
	

	
	public boolean isEqual(Sommet s)
	{
		if(this.position_x == s.position_x && this.position_y == s.position_y && this.label == s.label)
			return true;
		else
			return false;
	}

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Color getCouleurLabel() {
        return couleurLabel;
    }

    public void setCouleurLabel(Color couleurLabel) {
        this.couleurLabel = couleurLabel;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }
    
    public boolean getSelected(){
        return this.selected;
    }
    
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Sommet(Sommet o){
        this.label = o.label;
        this.couleurLabel = o.couleurLabel;
        this.couleur = o.couleur;
        this.position_x = o.position_x;
        this.position_y = o.position_y;
        this.selected = o.selected;
    }
    public Sommet(String label, Color couleurLabel, Color couleur, int position_x, int position_y) {
        this.label = label;
        this.couleurLabel = couleurLabel;
        this.couleur = couleur;
        this.position_x = position_x;
        this.position_y = position_y;
    }
    public Rectangle getBounds(){
        return new Rectangle(position_x-Configuration.taille_sommet, position_y-Configuration.taille_sommet, Configuration.taille_sommet*2, Configuration.taille_sommet*2);
    }
    
    
    public void draw(Graphics2D g2d){
        g2d.setColor(couleur);
        g2d.fillOval(position_x-Configuration.taille_sommet, position_y-Configuration.taille_sommet, Configuration.taille_sommet*2, Configuration.taille_sommet*2);
        if(selected){
            g2d.setColor(Color.CYAN);
            g2d.drawOval(position_x-(Configuration.taille_sommet+1), position_y-(Configuration.taille_sommet+1), Configuration.taille_sommet*2+2, Configuration.taille_sommet*2+2);
        }
        g2d.setColor(couleurLabel);
        int labelWidth = g2d.getFontMetrics().stringWidth(label);
        int labelHeight = g2d.getFontMetrics().getHeight();
        g2d.drawString(label, position_x-labelWidth/2, position_y+labelHeight/4);
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public int compareTo(Sommet o) {
        return this.label.compareTo(o.label);
    }
    
}
