package fr.ensma.a3.ia.TPBatailleNavale.automateCase.etatsCase;

import fr.ensma.a3.ia.TPBatailleNavale.automateCase.IGestionEtatCase;


/**
 * Case est touche, soit niveau vie de la case n'est pas plein, mais plus grand que 0
 * 
 * @author yinyiliang
 *
 */
public class EnTouche extends AbstractEtatCase {

	public EnTouche(IGestionEtatCase aut) {
		super(aut);
	}
	
	@Override
	public void retournerEnNormal() throws ActionCaseNonPermiseException {
		
		monautom.setEtatCourant(monautom.getEnNormal());
	}
	
	@Override
	public void toDetruit() throws ActionCaseNonPermiseException {
	
		monautom.setEtatCourant(monautom.getEnDetruit());
	}
	
}
