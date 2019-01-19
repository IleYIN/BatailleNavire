package fr.ensma.a3.ia.TPBatailleNavale.joueur;

import fr.ensma.a3.ia.TPBatailleNavale.grille.GrilleMemoire;
import fr.ensma.a3.ia.TPBatailleNavale.grille.GrillePlacement;
import fr.ensma.a3.ia.TPBatailleNavale.grille.IGrilleM;
import fr.ensma.a3.ia.TPBatailleNavale.grille.IGrilleP;
import fr.ensma.a3.ia.TPBatailleNavale.navires.ContreTorpilleur;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Croiseur;
import fr.ensma.a3.ia.TPBatailleNavale.navires.INavire;
import fr.ensma.a3.ia.TPBatailleNavale.navires.PorteAvion;
import fr.ensma.a3.ia.TPBatailleNavale.navires.SousMarin;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Torpilleur;

/**
 * Joueur du jeu
 */
public abstract class AbsJoueur {

	protected final IGrilleP grillep;
	protected final IGrilleM grillem;
	
	
	public AbsJoueur() {
		grillep = new GrillePlacement();
		grillem = new GrilleMemoire();
	}
	
	
	public IGrilleP getGrillep() {
		return grillep;
	}


	public IGrilleM getGrillem() {
		return grillem;
	}


	public void initialiserRandomGrilleP() {
		grillep.addRandomNavires((INavire)new PorteAvion(), 
				(INavire)new Croiseur(),
				(INavire)new ContreTorpilleur(),
				(INavire)new SousMarin(),
				(INavire)new Torpilleur());
	}
	
	public void alAttaque(INavire nav, AbsJoueur adverse, int posX, int posY) {
		nav.aLAttaque(this, adverse, posX, posY);
	}
	public void estAttaque() {
		for(INavire nav : grillep.getLnavire()) {
			nav.renouvelerEtatNavire();
		}
	}

	@Override
		public String toString() {
			return "Joueur-";
		}
}
