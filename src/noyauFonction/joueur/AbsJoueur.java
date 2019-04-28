package noyauFonction.joueur;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import noyauFonction.caze.CaseNavire;
import noyauFonction.caze.ICase;
import noyauFonction.grille.GrilleMemoire;
import noyauFonction.grille.GrillePlacement;
import noyauFonction.grille.IGrilleM;
import noyauFonction.grille.IGrilleP;
import noyauFonction.navires.typeNavire.ContreTorpilleur;
import noyauFonction.navires.typeNavire.Croiseur;
import noyauFonction.navires.ENavire;
import noyauFonction.navires.attaquesNavire.AttaqueClassique;
import noyauFonction.navires.attaquesNavire.AttaqueEnCroix;
import noyauFonction.navires.typeNavire.INavire;
import noyauFonction.navires.typeNavire.PorteAvion;
import noyauFonction.navires.typeNavire.SousMarin;
import noyauFonction.navires.typeNavire.Torpilleur;
import noyauFonction.navires.typeNavire.Voilier;

/**
 * Joueur du jeu
 */
public abstract class AbsJoueur implements IJoueur{

	private IGrilleP grillep;
	private IGrilleM grillem;
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
	
	/*
	 * Duc's code here
	 * Every time we run addRandomNavires(),
	 * we must delete old placed navires first
	 */
//	private void deleteAllRandomNavires() {
//		for(int i=0; i<10; i++) {
//			for(int j=0; j<10; j++) {
//				CaseMer caseM = new CaseMer(i, j);
//				getGrillep().setCaze(i, j, caseM);
//			}
//		}
//	}
	/*Yin: 
	 * 
	addRandomNavires will only be used at the beginning of each game,
	and when one player is created, it will add randomly two voiliers directly,
	it doesn't need delete anything since the player hasn't placed anything in the grille.
	And if you wanna clean the grille and start a new game, you must assure not only all cases are caseMer,
	but also listNavire(HashMap Navire) has been cleaned. So to my opinion the simple way is,
	to create two new grilles and abandon the former ones as the function reset below.
	If you want to restart a game, both players have to use this function to reset.
	*/
//	public void resetGame() {
//		grillep = new GrillePlacement();
//		grillem = new GrilleMemoire();
//
//		//initialer les deux voiliers
//		grillep.addRandomNavires(new Voilier(), new Voilier());
//	}

	public void addRandomNavire(INavire nav) {
		grillep.addRandomNavire(nav);
	}

	public void initialiserRandomGrilleP() {
		ENavire ePorteAvion = ENavire.PorteAvion;
		ENavire eCroiseur = ENavire.Croiseur;
		ENavire eContreTorpilleur = ENavire.ContreTorpilleur;
		ENavire eTorpilleur = ENavire.Torpilleur;
		ENavire eSousMarin = ENavire.SousMarin;
		if(this.getGrillep().getMapnavire().keySet().contains(ePorteAvion) &&
				this.getGrillep().getMapnavire().keySet().contains(eCroiseur) &&
				this.getGrillep().getMapnavire().keySet().contains(eContreTorpilleur) &&
				this.getGrillep().getMapnavire().keySet().contains(eTorpilleur) &&
				this.getGrillep().getMapnavire().keySet().contains(eSousMarin)) {
			this.getGrillep().deleteAllRandomNavires();
		}		
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
	public Map<ENavire, List<INavire>> getLnavire() {
		return grillep.getMapnavire();
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


//		public INavire getRandomNavireAttaque() {
//			return grillep.getRandomNavireAttaque();
//		}
		
	public void alAttaque(INavire nav, IJoueur adverse, int posX, int posY) {
		LOGGER.info(this.toString()+" utilise "+nav.toString()+ " pour attaquer ");
		nav.aLAttaque(this, adverse, posX, posY);
	}

	
	public void alAttaque(INavire nav, IJoueur adverse, ICase caze) {
		alAttaque(nav, adverse, caze.getPosX(), caze.getPosY());
	}
	
	public void alAttaqueRandom(IJoueur adverse) {
		int posX, posY;
		posX = (int) (Math.random() * 10);
		posY = (int) (Math.random() * 10);
		
		//to choose randomly type of attack
		int trueOrFalse;
		trueOrFalse = (int) (Math.random() * 2);
		
		INavire nav;
		nav = this.getRandomNavire();
		
		if (trueOrFalse == 1) {
			nav.setCompoAttaque(new AttaqueClassique());
		} else {
			nav.setCompoAttaque(new AttaqueEnCroix());
		}
		
		alAttaque(nav, adverse, posX, posY);
	}
	
	//	public void estAttaque() {
	//		for(INavire nav : grillep.getLnavire()) {
	//			nav.renouvelerEtatNavire();
	//		}
	//	}

	
	
	
	public INavire getNavire(ENavire enav) {
		return grillep.getNavire(enav);
	}
	
	public INavire getRandomNavire() {
		return grillep.getRandomNavire();
	}
	
	public ICase getCase(int posX, int posY) {
		return grillep.getCaze(posX, posY);
	}
	
	public void aLEclair(IJoueur adverse, int posX, int posY) {
		SousMarin sousm = (SousMarin) this.getGrillep().getNavire(ENavire.SousMarin);
		sousm.aLEclair(adverse, posX, posY);
	}
	
	public void aLEclair(IJoueur adverse, ICase caze) {
		SousMarin sousm = (SousMarin) this.getGrillep().getNavire(ENavire.SousMarin);
		sousm.aLEclair(adverse, caze);
	}
	
	@Override
	public String toString() {
		return "Joueur-";
	}
}