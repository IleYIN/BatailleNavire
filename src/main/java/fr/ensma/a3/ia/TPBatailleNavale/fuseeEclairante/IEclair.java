package fr.ensma.a3.ia.TPBatailleNavale.fuseeEclairante;

import fr.ensma.a3.ia.TPBatailleNavale.caze.ICase;
import fr.ensma.a3.ia.TPBatailleNavale.joueur.IJoueur;

public interface IEclair {
	public void aLEclair(IJoueur adverse, int posX, int posY);
	public void aLEclair(IJoueur adverse, ICase caze);
}
