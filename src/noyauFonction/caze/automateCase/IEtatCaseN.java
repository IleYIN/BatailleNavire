package noyauFonction.caze.automateCase;

import noyauFonction.caze.automateCase.etatsCase.ActionCaseNonPermiseException;

public interface IEtatCaseN {

	public void subirAttaque() throws ActionCaseNonPermiseException;
	public void retournerEnNormal() throws ActionCaseNonPermiseException;
	public void toDetruit() throws ActionCaseNonPermiseException;
}
