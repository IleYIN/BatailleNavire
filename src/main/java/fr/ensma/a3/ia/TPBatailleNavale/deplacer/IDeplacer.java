package fr.ensma.a3.ia.TPBatailleNavale.deplacer;

import fr.ensma.a3.ia.TPBatailleNavale.AbsJoueur;

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
	public void deplacerX(AbsJoueur jouer, int x);
	public void deplacerY(AbsJoueur jouer, int y);
	public void pivoter(AbsJoueur joueur, int posX, int posY);

}
