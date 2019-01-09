package fr.ensma.a3.ia.TPBatailleNavale.navires;

public enum EOrientation {

	horizontal(0), vertical(1);
	
	private int valeurOrientation;

	private EOrientation(int valeurOrientation) {
		this.valeurOrientation = valeurOrientation;
	}

	public int getValOri() {
		return valeurOrientation;
	}

}
