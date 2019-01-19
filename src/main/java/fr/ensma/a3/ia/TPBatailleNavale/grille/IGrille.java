package fr.ensma.a3.ia.TPBatailleNavale.grille;

import java.util.List;

import fr.ensma.a3.ia.TPBatailleNavale.caze.Case;

public interface IGrille {

	public int getTaille();
	public void setCaze(int posX, int posY, Case caze);
	public Case getCaze(int posX, int posY);
	public List<Case> getLcaze();
	
}
