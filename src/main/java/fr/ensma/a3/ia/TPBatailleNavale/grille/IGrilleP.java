package fr.ensma.a3.ia.TPBatailleNavale.grille;

import java.util.List;
import java.util.Map;

import fr.ensma.a3.ia.TPBatailleNavale.bombe.Bombe;
import fr.ensma.a3.ia.TPBatailleNavale.caze.ICase;
import fr.ensma.a3.ia.TPBatailleNavale.navires.ENavire;
import fr.ensma.a3.ia.TPBatailleNavale.navires.INavire;

/**
 * interface Grille
 * 
 * pattern monteur ou builder
 * 
 * @author yinyiliang
 *
 */
public interface IGrilleP extends IDeplacer, IGrille {
	
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
