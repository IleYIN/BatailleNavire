package fr.ensma.a3.ia.TPBatailleNavale.grille;

/**
 * les elements dans une grille, comme les navires et les pions
 * 
 */

public abstract class ElementsGrille implements IAfficher {
	protected final String id;
	
	public ElementsGrille(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
