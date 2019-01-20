package fr.ensma.a3.ia.TPBatailleNavale.automateNavire.etatsNavire;

import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.IGestionEtatNavire;
/**
 * Navire est en fonction, 
 * soit il y a au moins une caseNavire de cette navire n'est pas encore touche
 * 
 * @author yinyiliang
 *
 */
public class EnFonction extends AbstractEtatNavire {

	public EnFonction(IGestionEtatNavire aut) {
		super(aut);
	}


	@Override
	public void estEnPanne() throws ActionNavireNonPermiseException {

		monautom.setEtatCourant(monautom.getEnPanne());
	}

	@Override
	public void estEnDetruit() throws ActionNavireNonPermiseException {
		monautom.setEtatCourant(monautom.getEnDetruitNavire());
	}

}
