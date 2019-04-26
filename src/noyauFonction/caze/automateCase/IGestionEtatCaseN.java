package noyauFonction.caze.automateCase;

import noyauFonction.caze.automateCase.IEtatCaseN;

public interface IGestionEtatCaseN {

	public IEtatCaseN getEtatCourant();
	public void setEtatCourant(final IEtatCaseN etat);
	public IEtatCaseN getEnTouche();
	public IEtatCaseN getEnDetruit();
	public IEtatCaseN getEnNormal();
}
