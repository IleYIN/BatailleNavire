package fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire;

import fr.ensma.a3.ia.TPBatailleNavale.Joueur;

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
	 * @param joueur le joueur
	 * @param posX   la position X de l'attaque
	 * @param posY   la position Y de l'attaque
	 * @param puiss  la puissance d'attaque
	 */
	public void aLAttaque(Joueur joueur, int posX, int posY, int puiss);

}
