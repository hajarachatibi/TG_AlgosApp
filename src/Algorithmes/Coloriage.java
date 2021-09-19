package Algorithmes;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.imageio.ImageIO;

import Elements.Configuration;
import Elements.Sommet;
import Elements.Graphe;
import Interfaces.Canvas;
import Interfaces.Principal;

public class Coloriage implements Runnable {
	private Canvas cn; // La panel de mon graphe
	private ArrayList<Sommet> mesSommets; // Les sommets de mon graphe
	private ArrayList<Sommet> colored = new ArrayList<Sommet>(); // Les sommets coloriés
	private ArrayList<Sommet> nonColored = new ArrayList<Sommet>(); // Les sommets pas encore coloriés
	private Sommet first; // Le sommet ayant le plus grand degré
	private Random rand = new Random(); // Pour choix aléatoire des couleurs
	private int red = (int)(Math.random()*256);
	private int green = (int)(Math.random()*256);
	private int blue = (int)(Math.random()*256);
	
	// ------------------------ Constructeur ------------------------
	public Coloriage(Canvas cn)
	{
		this.cn = cn;
		mesSommets = cn.getGraphe().getSommets(); // Récupération des sommets du graphe
		nonColored.addAll(mesSommets); // On commence par tous les sommets (aucun sommet n'est colorié)
		Collections.sort(mesSommets, Collections.reverseOrder(new DegreeCompare())); // Trie des degrés des sommets par ordre décroissant
		/* DegreeCompare() : La classe de comparaison des degrés des sommets */
		first = mesSommets.get(0); // On récupère le sommet ayant le plus grand degré
		colored.add(first); // Ajout du sommet first à la table des sommets coloriés
		nonColored.removeAll(colored); // On enlève à chaque fois les sommets coloriés de la table des sommets non coloriés
	}
	
	// -------------- Fonction qui va se répéter à chaque étape --------------
	public void col(Sommet s)
	{
		s.setCouleur(new Color(red, green, blue));// Coloriage du sommet
		cn.repaint(); 
		for(Sommet v : mesSommets) // Pour chaque sommet du graphe
		{
			if(nonColored.contains(v)) // S'il n'est pas encore colorié (c'est-à-dire appartient à la table des sommets non coloriés encore)
			{
				if(!cn.getGraphe().getVoisins(s).contains(v)) // S'il n'appartient pas aux voisins du sommet s, (getSomSort() : la fonction qui retourne les voisins d'un sommet)
				{
					Color c= s.getCouleur();
					v.setCouleur(c); 
					cn.repaint();
					colored.add(v); 
					
				}
			}
		}
		nonColored.removeAll(colored); 
		try
		{
			Thread.sleep(800);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	// ------------------------ La fonction run() ------------------------
	@Override
	public void run() {
		int i = 0;
		col(first); 
		while(colored.size() < mesSommets.size()) 
		{
			for(Sommet s : mesSommets)
			{
				red = (int)(Math.random()*256);
				green = (int)(Math.random()*256);
				blue = (int)(Math.random()*256);
				if(nonColored.contains(s))
					col(s);
			}
		}

		try
		{
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
