package fr.ensma.a3.ia.TPBatailleNavale.grille;

import fr.ensma.a3.ia.TPBatailleNavale.navires.Navire;

public class GrilleBuilder implements IGrilleBuilder {

	private Grille grilleMemoire;
	private Grille grillePlacement;
			
	
	public GrilleBuilder() {
		grilleMemoire = new GrilleMemoire();
		grillePlacement = new GrillePlacement();
	}
	
	
	public void addNavires(Navire... navires) {
		grillePlacement.addNavires(navires);
	}


	public Grille getGrilleMemoire() {
		return grilleMemoire;
	}


	public Grille getGrillePlacement() {
		return grillePlacement;
	}


}
