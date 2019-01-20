package fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire;

import fr.ensma.a3.ia.TPBatailleNavale.caze.ICase;
import fr.ensma.a3.ia.TPBatailleNavale.joueur.IJoueur;

/**
 * interface attaque d'une navire
 * 
 * @author yinyiliang
 *
 */
public interface IAttaque {

	/**
	 * Realiser l'attque d'une navire
	 * 
	 * @param le joueur 
	 * @param le joueur adverse
	 * @param posX   la position X de l'attaque
	 * @param posY   la position Y de l'attaque
	 * @param puiss  la puissance d'attaque
	 */
	public void aLAttaque(IJoueur joueur, IJoueur adversal, int posX, int posY, int puiss);
	public void aLAttaque(IJoueur joueur, IJoueur adversal, ICase caze, int puiss);

}
