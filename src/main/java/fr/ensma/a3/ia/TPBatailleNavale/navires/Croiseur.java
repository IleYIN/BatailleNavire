package fr.ensma.a3.ia.TPBatailleNavale.navires;

import fr.ensma.a3.ia.TPBatailleNavale.Joueur;
import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.IAttaque;

public class Croiseur extends Navire {


	private static int numinstance;
	private static final int longueur = 4;
	
	public Croiseur(Joueur joueur,  int posX, int posY, EOrientation ori, IAttaque compoA) {
		super("Croiseur-"+ numinstance, joueur, posX,posY, longueur, ori, compoA);
		numinstance++;
	}
	
	public void afficher() {
		
	}
		
}
