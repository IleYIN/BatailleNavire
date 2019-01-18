package fr.ensma.a3.ia.TPBatailleNavale;

import fr.ensma.a3.ia.TPBatailleNavale.grille.GrilleMemoireBuilder;
import fr.ensma.a3.ia.TPBatailleNavale.grille.GrillePlacementBuilder;
import fr.ensma.a3.ia.TPBatailleNavale.grille.IGrilleBuilder;
import fr.ensma.a3.ia.TPBatailleNavale.navires.ContreTorpilleur;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Croiseur;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Navire;
import fr.ensma.a3.ia.TPBatailleNavale.navires.PorteAvion;
import fr.ensma.a3.ia.TPBatailleNavale.navires.SousMarin;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Torpilleur;

/**
 * Joueur du jeu
 */
public abstract class AbsJoueur {

	
	private final String id;
	private final IGrilleBuilder grillepb;
	private final IGrilleBuilder grillemb;
	
	
	public AbsJoueur(final String id) {
		this.id = id;
		grillepb = new GrillePlacementBuilder();
		grillemb = new GrilleMemoireBuilder();
	}

	public void initialiserRandomGrille() {
		grillepb.addNavires(new PorteAvion(),.randomNavire(this), 
				Croiseur.randomNavire(this),
				ContreTorpilleur.randomNavire(this),
				SousMarin.randomNavire(this),
				Torpilleur.randomNavire(this));
	}
	
	
	public void estAttaque() {
		for(Navire nav : grilleb.getGrillePlacement().getLnavire()) {
			nav.renouvelerEtatNavire();
		}
	}
	
	public IGrilleBuilder getGrilleb() {
		return grilleb;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return this.getId();
	}
	
}
