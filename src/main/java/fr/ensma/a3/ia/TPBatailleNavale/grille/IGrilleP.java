package fr.ensma.a3.ia.TPBatailleNavale.grille;

import java.util.List;

import fr.ensma.a3.ia.TPBatailleNavale.navires.INavire;

/**
 * interface Grille
 * 
 * pattern monteur ou builder
 * 
 * @author yinyiliang
 *
 */
public interface IGrilleP extends IDeplacer, IGrille {
	
	public void addNavire(INavire nav, int posX, int posY, boolean ori);
	public void addRandomNavire(INavire nav);
	public void addRandomNavires(INavire... navs);
	public  List<INavire> getLnavire();
	
}
