package noyauFonction.fuseeEclairante;

import noyauFonction.caze.ICase;
import noyauFonction.joueur.IJoueur;

public interface IEclair {
	public void aLEclair(IJoueur adverse, int posX, int posY);
	public void aLEclair(IJoueur adverse, ICase caze);
}
