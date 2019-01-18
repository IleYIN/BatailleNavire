package fr.ensma.a3.ia.TPBatailleNavale.deplacer;

import fr.ensma.a3.ia.TPBatailleNavale.grille.CaseNavire;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Navire;

/**
 * interface deplacer d'une navire
 * 
 * @author yinyiliang
 *
 */
public interface IDeplacer {

	/**
	 * Realiser le deplacement d'une navire
	 */
	public void deplacerX(Navire nav, int x);
	public void deplacerY(Navire nav, int y);
	public void pivoter(Navire nav, int posX, int posY);
	public void pivoter(Navire nav, CaseNavire cazeNav);

}
