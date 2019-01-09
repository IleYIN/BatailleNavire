package fr.ensma.a3.ia.TPBatailleNavale.automateCase.etatsCase;

import fr.ensma.a3.ia.TPBatailleNavale.automateCase.IGestionEtatCase;

/**
 * Case est normal, soit niveau vie de la case est plein
 * 
 * @author yinyiliang
 *
 */

public class EnNormal extends AbstractEtatCase {

	public EnNormal(IGestionEtatCase aut) {
		super(aut);
	}
	
	
	@Override
	public void subirAttaque() throws ActionCaseNonPermiseException {
		
		monautom.setEtatCourant(monautom.getEnTouche());
	}
	
	@Override
	public void toDetruit() throws ActionCaseNonPermiseException {
		
		monautom.setEtatCourant(monautom.getEnDetruit());
	}
}
