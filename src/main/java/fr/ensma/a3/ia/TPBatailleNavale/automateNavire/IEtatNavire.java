package fr.ensma.a3.ia.TPBatailleNavale.automateNavire;

import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.etatsNavire.ActionNavireNonPermiseException;

/**
 * l'interface d'etat d'une navire
 * 
 * @author yinyiliang
 *
 */
public interface IEtatNavire {

	public void estEnPanne() throws ActionNavireNonPermiseException;
	public void retournerEnFonction() throws ActionNavireNonPermiseException;
	public void estEnDetruit() throws ActionNavireNonPermiseException;;
}
