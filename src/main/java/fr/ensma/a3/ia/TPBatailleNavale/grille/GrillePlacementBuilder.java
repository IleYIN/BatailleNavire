package fr.ensma.a3.ia.TPBatailleNavale.grille;

import fr.ensma.a3.ia.TPBatailleNavale.navires.Navire;

public class GrillePlacementBuilder implements IGrilleBuilder {

	private GrillePlacement grillePlacement;
			
	
	public GrillePlacementBuilder() {
		grillePlacement = new GrillePlacement();
	}

	public void deplacerX(Navire nav, int x) {
		grillePlacement.deplacerX(nav, x);
		
	}

	public void deplacerY(Navire nav, int y) {
		grillePlacement.deplacerY(nav, y);
		
	}

	public void pivoter(Navire nav, int posX, int posY) {
		grillePlacement.pivoter(nav, posX, posY);
	}
	

	public void pivoter(Navire nav, CaseNavire cazeNav) {
		grillePlacement.pivoter(nav, cazeNav);
	}


	public void addNavire(Navire nav, int posX, int posY, boolean ori) {
		grillePlacement.addNavire(nav, posX, posY, ori);
	}

	public void addRandomNavire(Navire nav) {
		grillePlacement.addRandomNavire(nav);
	}

	public Grille getGrille() {
		return grillePlacement;
	}


}
