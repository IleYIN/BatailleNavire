package fr.ensma.a3.ia.TPBatailleNavale.mvpGlobal;

import fr.ensma.a3.ia.TPBatailleNavale.joueur.Humain;
import fr.ensma.a3.ia.TPBatailleNavale.joueur.IJoueur;
import fr.ensma.a3.ia.TPBatailleNavale.joueur.Ordinateur;

public class ModelGlobal {
	
	private final IJoueur ordinateur;
	private final IJoueur humain;
	
	public ModelGlobal() {
		ordinateur = new Ordinateur();
		humain = new Humain();
	}

	public IJoueur getOrdinateur() {
		return ordinateur;
	}


	public IJoueur getHumain() {
		return humain;
	}
	
	public void randomInit() {
		ordinateur.initialiserRandomGrilleP();
		humain.initialiserRandomGrilleP();
	}

}
