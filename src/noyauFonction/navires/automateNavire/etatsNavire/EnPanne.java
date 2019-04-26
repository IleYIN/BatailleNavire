package noyauFonction.navires.automateNavire.etatsNavire;

import noyauFonction.navires.automateNavire.IGestionEtatNavire;
/**
 * Navire est en panne, 
 * soit toutes les caseNavire de cette navire sont touche ou detruit (mais pas tout detruit)
 * 
 * @author yinyiliang
 *
 */
public class EnPanne extends AbstractEtatNavire {

	public EnPanne(IGestionEtatNavire aut) {
		super(aut);
	}
	
	@Override
	public void retournerEnFonction() throws ActionNavireNonPermiseException {
		
		monautom.setEtatCourant(monautom.getEnFonction());
	}
	
	@Override
	public void estEnPanne() throws ActionNavireNonPermiseException {

		monautom.setEtatCourant(monautom.getEnPanne());
		//reste en panne mais pas detruit
	}

	
	@Override
	public void estEnDetruit() throws ActionNavireNonPermiseException {
	
		monautom.setEtatCourant(monautom.getEnDetruitNavire());
	}
	
}
