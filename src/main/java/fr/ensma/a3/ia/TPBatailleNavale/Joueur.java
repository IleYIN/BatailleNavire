package fr.ensma.a3.ia.TPBatailleNavale;

import fr.ensma.a3.ia.TPBatailleNavale.grille.Grille;
import fr.ensma.a3.ia.TPBatailleNavale.grille.GrilleMemoire;
import fr.ensma.a3.ia.TPBatailleNavale.grille.GrillePlacement;

/**
 * Joueur du jeu
 */
public abstract class Joueur {

	
	private final String id;
	private final Grille grilleMemoire;
	private final Grille grillePlacement;
	
	public Joueur(final String id) {
		this.id = id;
		grilleMemoire = new GrilleMemoire();
		grillePlacement = new GrillePlacement();
	}

	public String getId() {
		return id;
	}

	public Grille getGrilleMemoire() {
		return grilleMemoire;
	}

	public Grille getGrillePlacement() {
		return grillePlacement;
	}
	
	@Override
	public String toString() {
		return this.getId();
	}
	
}
