package noyauFonction.caze;

public abstract class Case implements ICase {
	
	private int positionX;
	private int positionY;
	
	public Case(final int positionX, final int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	
	public void setPosX(int positionX) {
		this.positionX = positionX;
	}

	public void setPosY(int positionY) {
		this.positionY = positionY;
	}


	public int getPosX() {
		return positionX;
	}

	public int getPosY() {
		return positionY;
	}
}
