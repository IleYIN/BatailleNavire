package noyauFonction.caze.automateCase.etatsCase;

import noyauFonction.caze.automateCase.IGestionEtatCaseN;

/**
 * Case est normal, soit niveau vie de la case est plein
 * 
 * @author yinyiliang
 *
 */

public class EnNormal extends AbstractEtatCase {

	public EnNormal(IGestionEtatCaseN aut) {
		super(aut);
	}	
	
	@Override
	public void subirAttaque() throws ActionCaseNonPermiseException {
		// If a normal case "is attacked", we call it's being "touched"
		monautom.setEtatCourant(monautom.getEnTouche());
	}
	
	@Override
	public void toDetruit() throws ActionCaseNonPermiseException {
		// If a normal case's suffered "fatal damage", it's being "destroyed"
		monautom.setEtatCourant(monautom.getEnDetruit());
	}
}
