package fr.ensma.a3.ia.TPBatailleNavale.automateCase;

import fr.ensma.a3.ia.TPBatailleNavale.automateCase.etatsCase.ActionCaseNonPermiseException;

/**
 * l'interface d'etat d'une case
 * 
 * @author yinyiliang
 *
 */
public interface IEtatCase {

	public void subirAttaque() throws ActionCaseNonPermiseException;
	public void retournerEnNormal() throws ActionCaseNonPermiseException;
	public void toDetruit() throws ActionCaseNonPermiseException;;
}
