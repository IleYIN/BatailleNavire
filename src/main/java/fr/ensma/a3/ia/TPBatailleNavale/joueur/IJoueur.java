package fr.ensma.a3.ia.TPBatailleNavale.joueur;

import java.util.Map;

import fr.ensma.a3.ia.TPBatailleNavale.caze.ICase;
import fr.ensma.a3.ia.TPBatailleNavale.grille.IDeplacer;
import fr.ensma.a3.ia.TPBatailleNavale.grille.IGrilleM;
import fr.ensma.a3.ia.TPBatailleNavale.grille.IGrilleP;
import fr.ensma.a3.ia.TPBatailleNavale.navires.ENavire;
import fr.ensma.a3.ia.TPBatailleNavale.navires.INavire;

/**
 * interface joueur
 * 
 * pattern monteur ou builder
 * 
 * @author yinyiliang
 *
 */
public interface IJoueur extends IDeplacer {
	
	public void addNavire(INavire nav, int posX, int posY, boolean ori);
	public void addRandomNavire(INavire nav);
	public void addRandomNavires(INavire... navs);
	public void initialiserRandomGrilleP();
//	public INavire getRandomNavireAttaque();
	public  Map<ENavire, INavire> getLnavire();
	public void alAttaque(INavire nav, IJoueur ordinateur, int posX, int posY);
	public String toString();
	public IGrilleM getGrillem();
	public IGrilleP getGrillep();
	public INavire getNavire(ENavire enav);
	public ICase getCase(int posX, int posY);
	public void estAttaque();
}