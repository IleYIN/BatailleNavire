package fr.ensma.a3.ia.TPBatailleNavale.navires;


import java.util.List;

import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.IAttaque;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.IEtatNavire;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.IGestionEtatNavire;
import fr.ensma.a3.ia.TPBatailleNavale.caze.CaseNavire;
import fr.ensma.a3.ia.TPBatailleNavale.joueur.IJoueur;

/**
 * interface d'une navire
 * 
 * @author yinyiliang
 *
 */
public interface INavire extends IEtatNavire, IGestionEtatNavire {

	public int getPosX();
	public void setPosX(int posX);
	
	public int getPosY();
	public void setPosY(int posX);
	
	public boolean isOri();
	public void setOri(boolean ori);
	
	public void aLAttaque(IJoueur joueur, IJoueur adverse, int posX,int posY);
	
	public IAttaque getCompoAttaque();
	public void setCompoAttaque(IAttaque att);
	
	public int getPuissanceAttaque();
	public void setPuissanceAttaque(int puissanceAttaque);
	
	public int getNvieCase();
	public void setNvieCase(int nvieCase);
	
	public int getLongueur();
	public void setLongueur(int longueur);
	
	public List<CaseNavire> getLcaseNav();
	public void setLcaseNav(List<CaseNavire> lcaseNav);
	
	public ENavire getEnav();
	
	public String toString();
	
	public void renouvelerEtatNavire();
}
