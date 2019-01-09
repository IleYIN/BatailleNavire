package fr.ensma.a3.ia.TPBatailleNavale.navires;

import fr.ensma.a3.ia.TPBatailleNavale.Joueur;
import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.IAttaque;

public class Torpilleur extends Navire {


	private static int numinstance;
	private static final int longueur = 2;
	
	public Torpilleur(Joueur joueur, int posX, int posY, EOrientation ori, IAttaque compoA) {
		super("Torpilleur-"+ numinstance, joueur, posX, posY, longueur, ori, compoA);
		numinstance++;
	}
	
	public void afficher() {
		
	}


}
