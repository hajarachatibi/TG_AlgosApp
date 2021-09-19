package Algorithmes;

import java.util.Comparator;

import Elements.Graphe;
import Elements.Sommet;
import Interfaces.Canvas;
import Interfaces.Principal;

public class DegreeCompare implements Comparator<Sommet> {

	@Override
	public int compare(Sommet s1, Sommet s2) {
		int rt = 0;
		//Canvas cn = null;
		if(Canvas.getInstance().getGraphe().getVoisins(s1).size() <= Canvas.getInstance().getGraphe().getVoisins(s2).size())
			rt = -1;
		if(Canvas.getInstance().getGraphe().getVoisins(s1).size() >= Canvas.getInstance().getGraphe().getVoisins(s2).size())
			rt = 1;
		return rt;
	}

}
