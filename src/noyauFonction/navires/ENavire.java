package noyauFonction.navires;

/**
 * pattern fabrique
 * 
 * @author tranv
 *
 */
public enum ENavire {
	
	ContreTorpilleur("ContreTorpilleur"), Croiseur("Croiseur"), 
	PorteAvion("PorteAvion"),SousMarin("SousMarin"),Torpilleur("Torpilleur"),
	Voilier("Voilier");
	
	
	
	private String label;
	
	private ENavire(String lab) {
		label = lab;
	}
	
	public String getLabel() {
		return label;
	}
}
