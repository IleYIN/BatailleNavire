package noyauFonction.grille;

import java.util.List;

import noyauFonction.caze.ICase;

public interface IGrille {

	public int getTaille();
	public void setCaze(int posX, int posY, ICase caze);
	public ICase getCaze(int posX, int posY);
	public List<ICase> getLcaze();
	
}
