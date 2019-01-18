package fr.ensma.a3.ia.TPBatailleNavale.grille;

import fr.ensma.a3.ia.TPBatailleNavale.navires.Navire;

/**
 * interface Grille
 * 
 * pattern monteur ou builder
 * 
 * @author yinyiliang
 *
 */
public interface IGrilleBuilder {
	
	public void addNavires(Navire... navires );
	public Grille getGrilleMemoire();
	public Grille getGrillePlacement();
	
}
