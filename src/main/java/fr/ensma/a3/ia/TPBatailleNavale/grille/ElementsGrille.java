package fr.ensma.a3.ia.TPBatailleNavale.grille;

/**
 * les elements dans une grille, comme les navires et les pions
 * 
 */

public abstract class ElementsGrille implements IAfficher {
	private final String id;
	private final Grille maGrille;
	
	public ElementsGrille(String id, Grille maGrille) {
		this.id = id;
		this.maGrille = maGrille;
	}

	public String getId() {
		return id;
	}

	public Grille getMaGrille() {
		return maGrille;
	}
	
	
}
