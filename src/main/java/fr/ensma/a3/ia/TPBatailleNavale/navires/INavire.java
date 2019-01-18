package fr.ensma.a3.ia.TPBatailleNavale.navires;


import java.util.List;

import fr.ensma.a3.ia.TPBatailleNavale.AbsJoueur;
import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.IAttaque;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.IEtatNavire;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.IGestionEtatNavire;
import fr.ensma.a3.ia.TPBatailleNavale.grille.CaseNavire;

public interface INavire extends IEtatNavire, IGestionEtatNavire {

	public void aLAttaque(AbsJoueur joueur, int posX,int posY);
	public void setCompoAttaque(IAttaque att);
	public void setPuissanceAttaque(int puissanceAttaque);
	public void setNvieCase(int nvieCase);
	public void setLongueur(int longueur);
	public void setLcaseNav(List<CaseNavire> lcaseNav);
	public String toString();
}
