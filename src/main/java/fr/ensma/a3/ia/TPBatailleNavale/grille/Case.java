package fr.ensma.a3.ia.TPBatailleNavale.grille;

/**
 * une case
 * 
 * @author yinyiliang
 *
 */
public abstract class Case implements IEstAttaque, IAfficher {
	
	private final int positionX;
	private final int positionY;
	
	public Case(final int positionX, final int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public int getPosX() {
		return positionX;
	}

	public int getPosY() {
		return positionY;
	}

	public boolean equals(Case obj) {
		return this.positionX == obj.getPosX() && this.positionY == obj.getPosY();
	}
	
	
}
