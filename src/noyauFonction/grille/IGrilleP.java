package noyauFonction.grille;

import java.util.List;
import java.util.Map;

import noyauFonction.bombe.Bombe;
import noyauFonction.caze.ICase;
import noyauFonction.navires.ENavire;
import noyauFonction.navires.typeNavire.INavire;

/**
 * interface Grille
 * 
 * pattern monteur ou builder
 * 
 * @author yinyiliang
 *
 */
public interface IGrilleP extends IDeplacer, IGrille {
	
	public void deleteAllRandomNavires();
	public void addNavire(INavire nav, int posX, int posY, boolean ori);
	public void addNavire(INavire nav, ICase caze, boolean ori);
	public void addRandomNavire(INavire nav);
	public void addRandomNavires(INavire... navs);
//	public INavire getRandomNavireAttaque();
	public  Map<ENavire, List<INavire>> getMapnavire();
	public void setBombe(Bombe bombe);
	public Bombe getBombe();
	public void explodeBombe();
	public INavire getNavire(ENavire enav);
	public INavire getNavire(ENavire enav,int i);
	public void estAttaque();
}
