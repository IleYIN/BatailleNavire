package noyauFonction.grille;

import noyauFonction.caze.CaseNavire;
import noyauFonction.navires.typeNavire.INavire;

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
	
	public void deplacerX(INavire nav, int x);
	public void deplacerY(INavire nav, int y);
	public void pivoter(INavire nav, int posX, int posY);
	public void pivoter(INavire nav, CaseNavire cazeNav);

}
