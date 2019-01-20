package fr.ensma.a3.ia.TPBatailleNavale.automateCase.etatsCase;

import fr.ensma.a3.ia.TPBatailleNavale.automateCase.IGestionEtatCaseN;
/**
 * Case est detruit, soit niveau vie de la case est 0
 * 
 * @author yinyiliang
 *
 */
public class EnDetruit extends AbstractEtatCase {

	public EnDetruit(IGestionEtatCaseN aut) {
		super(aut);
	}

	@Override
	public void toDetruit() throws ActionCaseNonPermiseException {
		//rester en detruit
		monautom.setEtatCourant(monautom.getEnDetruit());
	}
}
