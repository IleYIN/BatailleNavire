package noyauFonction.caze.automateCase.etatsCase;

import noyauFonction.caze.automateCase.IGestionEtatCaseN;


/**
 * Case est touche, soit niveau vie de la case n'est pas plein, mais plus grand que 0
 * 
 * @author yinyiliang
 *
 */
public class EnTouche extends AbstractEtatCase {

	public EnTouche(IGestionEtatCaseN aut) {
		super(aut);
	}
	
	@Override
	public void retournerEnNormal() throws ActionCaseNonPermiseException {
		
		monautom.setEtatCourant(monautom.getEnNormal());
	}
	
	@Override
	public void subirAttaque() throws ActionCaseNonPermiseException {
		
		monautom.setEtatCourant(monautom.getEnTouche());
		//reste en touche mais pas detruit
	}
	
	@Override
	public void toDetruit() throws ActionCaseNonPermiseException {
	
		monautom.setEtatCourant(monautom.getEnDetruit());
	}
	
}
