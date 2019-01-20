package fr.ensma.a3.ia.TPBatailleNavale.joueur;

import java.util.Map;
import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.caze.CaseNavire;
import fr.ensma.a3.ia.TPBatailleNavale.caze.ICase;
import fr.ensma.a3.ia.TPBatailleNavale.grille.GrilleMemoire;
import fr.ensma.a3.ia.TPBatailleNavale.grille.GrillePlacement;
import fr.ensma.a3.ia.TPBatailleNavale.grille.IGrilleM;
import fr.ensma.a3.ia.TPBatailleNavale.grille.IGrilleP;
import fr.ensma.a3.ia.TPBatailleNavale.navires.ContreTorpilleur;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Croiseur;
import fr.ensma.a3.ia.TPBatailleNavale.navires.ENavire;
import fr.ensma.a3.ia.TPBatailleNavale.navires.INavire;
import fr.ensma.a3.ia.TPBatailleNavale.navires.PorteAvion;
import fr.ensma.a3.ia.TPBatailleNavale.navires.SousMarin;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Torpilleur;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Voilier;

/**
 * Joueur du jeu
 */
public abstract class AbsJoueur implements IJoueur{

	private final IGrilleP grillep;
	private final IGrilleM grillem;
	private final static Logger LOGGER = Logger.getLogger(AbsJoueur.class.getName());

	public AbsJoueur() {
		grillep = new GrillePlacement();
		grillem = new GrilleMemoire();

		//initialer les deux voiliers
		grillep.addRandomNavires(new Voilier(), new Voilier());

	}


	public IGrilleP getGrillep() {
		return grillep;
	}


	public IGrilleM getGrillem() {
		return grillem;
	}

	public void addRandomNavire(INavire nav) {
		grillep.addRandomNavire(nav);
	}

	public void initialiserRandomGrilleP() {
		grillep.addRandomNavires((INavire)new PorteAvion(), 
				(INavire)new Croiseur(),
				(INavire)new ContreTorpilleur(),
				(INavire)new SousMarin(),
				(INavire)new Torpilleur());
	}

	public void addNavire(INavire nav, int posX, int posY, boolean ori) {
		grillep.addNavire(nav, posX, posY, ori);

	}
	public void addRandomNavires(INavire... navs) {
		grillep.addRandomNavires(navs);

	}
	public Map<ENavire, INavire> getLnavire() {
		return grillep.getLnavire();
	}
	public void deplacerX(INavire nav, int x) {
		grillep.deplacerX(nav, x);

	}
	public void deplacerY(INavire nav, int y) {
		grillep.deplacerY(nav, y);
	}
	public void pivoter(INavire nav, int posX, int posY) {
		grillep.pivoter(nav, posX, posY);

	}
	public void pivoter(INavire nav, CaseNavire cazeNav) {
		grillep.pivoter(nav, cazeNav);
	}


	//	public INavire getRandomNavireAttaque() {
	//		return grillep.getRandomNavireAttaque();
	//	}
	//	
	public void alAttaque(INavire nav, IJoueur adverse, int posX, int posY) {
		LOGGER.info(this.toString()+" utilise "+nav.toString()+ " pour attaquer ");
		nav.aLAttaque(this, adverse, posX, posY);
	}

	//	public void estAttaque() {
	//		for(INavire nav : grillep.getLnavire()) {
	//			nav.renouvelerEtatNavire();
	//		}
	//	}

	public void estAttaque() {
		for(INavire nav : grillep.getLnavire().values()) {
			nav.renouvelerEtatNavire();
		}
	}
	
	public INavire getNavire(ENavire enav) {
		return grillep.getNavire(enav);
	}
	
	public ICase getCase(int posX, int posY) {
		return grillep.getCaze(posX, posY);
	}
	
	@Override
	public String toString() {
		return "Joueur-";
	}
}
