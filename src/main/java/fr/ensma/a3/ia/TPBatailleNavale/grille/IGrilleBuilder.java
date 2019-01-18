package fr.ensma.a3.ia.TPBatailleNavale.grille;

import fr.ensma.a3.ia.TPBatailleNavale.deplacer.IDeplacer;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Navire;

/**
 * interface Grille
 * 
 * pattern monteur ou builder
 * 
 * @author yinyiliang
 *
 */
public interface IGrilleBuilder extends IDeplacer {
	
	public Grille getGrille();
	
	public void addNavire(Navire nav, int posX, int posY, boolean ori);
	public void addRandomNavire(Navire nav);
	
}
