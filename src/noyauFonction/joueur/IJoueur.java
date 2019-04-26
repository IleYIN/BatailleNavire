package noyauFonction.joueur;

import java.util.List;
import java.util.Map;

import noyauFonction.caze.ICase;
import noyauFonction.fuseeEclairante.IEclair;
import noyauFonction.grille.IDeplacer;
import noyauFonction.grille.IGrilleM;
import noyauFonction.grille.IGrilleP;
import noyauFonction.navires.ENavire;
import noyauFonction.navires.typeNavire.INavire;

/**
 * interface joueur
 * 
 * pattern monteur ou builder
 * 
 * @author yinyiliang
 *
 */
public interface IJoueur extends IDeplacer, IEclair {
	
	public void addNavire(INavire nav, int posX, int posY, boolean ori);
	public void addRandomNavire(INavire nav);
	public void addRandomNavires(INavire... navs);
	public void initialiserRandomGrilleP();
//	public INavire getRandomNavireAttaque();
	public  Map<ENavire, List<INavire>> getLnavire();
	public void alAttaque(INavire nav, IJoueur adverse, ICase caze);
	public void alAttaque(INavire nav, IJoueur adverse, int posX, int posY);
	public String toString();
	public IGrilleM getGrillem();
	public IGrilleP getGrillep();
	public INavire getNavire(ENavire enav);
	public ICase getCase(int posX, int posY);
	
}
