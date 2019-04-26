package noyauFonction.caze.automateCase.etatsCase;

import noyauFonction.caze.automateCase.IGestionEtatCaseN;
import noyauFonction.caze.automateCase.etatsCase.ActionCaseNonPermiseException;
import noyauFonction.caze.automateCase.IEtatCaseN;

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
