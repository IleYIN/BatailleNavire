package fr.ensma.a3.ia.TPBatailleNavale.navires;

/**
 * pattern fabrique
 * 
 * @author tranv
 *
 */
public enum ENavire {
	
	ContreTorpilleur("ContreTorpilleur"), Croiseur("Croiseur"), 
	PorteAvion("PorteAvion"),SousMarin("SousMarin"),Torpilleur("Torpilleur");
	
	private String label;
	
	private ENavire(String lab) {
		label = lab;
	}
	
	public String getLabel() {
		return label;
	}
}
