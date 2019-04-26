package noyauFonction.navires.automateNavire.etatsNavire;

import noyauFonction.navires.automateNavire.IGestionEtatNavire;


/**
 * Navire est detruit, soit toutes les caseNavire de cette navire sont detruit
 * 
 * @author yinyiliang
 *
 */
public class EnDetruitNavire extends AbstractEtatNavire {

	public EnDetruitNavire(IGestionEtatNavire aut) {
		super(aut);
	}
	
	@Override
	public void estEnDetruit() throws ActionNavireNonPermiseException {
		monautom.setEtatCourant(monautom.getEnDetruitNavire());
		//rester en detruit
	}
}
