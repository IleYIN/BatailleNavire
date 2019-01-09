package fr.ensma.a3.ia.TPBatailleNavale.automateNavire.etatsNavire;

import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.IEtatNavire;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.IGestionEtatNavire;

/**
 * etat d'une navire
 * 
 * 
 * @author yinyiliang
 *
 */
public abstract class AbstractEtatNavire implements IEtatNavire {
	
	protected IGestionEtatNavire monautom;

	public AbstractEtatNavire(final IGestionEtatNavire aut) {
		monautom = aut;
	}
	
	public void estEnPanne() throws ActionNavireNonPermiseException {
		throw new ActionNavireNonPermiseException("Transition estEnPanne non tirable dans l'état " + toString() + "...");		
	}

	public void retournerEnFonction() throws ActionNavireNonPermiseException {
		throw new ActionNavireNonPermiseException("Transition retourneEnfonction non tirable dans l'état " + toString() + "...");		
	}

	public void estEnDetruit() throws ActionNavireNonPermiseException {
		throw new ActionNavireNonPermiseException("Transition estEnDetruit non tirable dans l'état " + toString() + "...");			}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
}
