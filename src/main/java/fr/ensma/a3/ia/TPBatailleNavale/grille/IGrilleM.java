package fr.ensma.a3.ia.TPBatailleNavale.grille;

import fr.ensma.a3.ia.TPBatailleNavale.caze.Case;

/**
 * interface Grille
 * 
 * pattern monteur ou builder
 * 
 * @author yinyiliang
 *
 */
public interface IGrilleM extends IGrille {
	
	public void addPion(Case caze, boolean tir);
	public void addPion(int posX, int posY, boolean tir);
	
}
