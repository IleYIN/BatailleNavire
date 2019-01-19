package fr.ensma.a3.ia.TPBatailleNavale.automateCase.etatsCase;

import fr.ensma.a3.ia.TPBatailleNavale.automateCase.IEtatCaseN;
import fr.ensma.a3.ia.TPBatailleNavale.automateCase.IGestionEtatCaseN;

/**
 * etat d'une case
 * 
 * @author yinyiliang
 *
 */
public abstract class AbstractEtatCase implements IEtatCaseN {
	
	protected IGestionEtatCaseN monautom;

	public AbstractEtatCase(final IGestionEtatCaseN aut) {
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
