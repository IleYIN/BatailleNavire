package fr.ensma.a3.ia.TPBatailleNavale.automateCase.etatsCase;

import fr.ensma.a3.ia.TPBatailleNavale.automateCase.IEtatCase;
import fr.ensma.a3.ia.TPBatailleNavale.automateCase.IGestionEtatCase;

/**
 * etat d'une case
 * 
 * @author yinyiliang
 *
 */
public abstract class AbstractEtatCase implements IEtatCase {
	
	protected IGestionEtatCase monautom;

	public AbstractEtatCase(final IGestionEtatCase aut) {
		monautom = aut;
	}
	
	public void subirAttaque() throws ActionCaseNonPermiseException {
		throw new ActionCaseNonPermiseException("Transition subirAttaque non tirable dans l'état " + toString() + "...");		
	}

	public void retournerEnNormal() throws ActionCaseNonPermiseException {
		throw new ActionCaseNonPermiseException("Transition rtournerEnNormal non tirable dans l'état " + toString() + "...");		
	}

	public void toDetruit() throws ActionCaseNonPermiseException {
		throw new ActionCaseNonPermiseException("Transition toDetruit non tirable dans l'état " + toString() + "...");			}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
}
