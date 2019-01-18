package fr.ensma.a3.ia.TPBatailleNavale.factory;

public enum EJoueur {
	Humain("Humain"),Oridnateur("Ordinateur");
	
	private String label;
	
	private EJoueur(String lab) {
		label = lab;
	}
	
	public String getLabel() {
		return label;
	}
}
