package noyauFonction.navires.typeNavire;

import java.util.ArrayList;

import noyauFonction.navires.ENavire;
import noyauFonction.navires.attaquesNavire.AttaqueClassique;
import noyauFonction.caze.CaseNavire;

public class Torpilleur extends Navire {

	private static final int longueur = 2;
	
	public Torpilleur() {
		enav = ENavire.Torpilleur;
		this.setLongueur(longueur);
		this.setCompoAttaque(new AttaqueClassique());
		this.setNvieCase(longueur);
		this.setEtatCourant(enFonction);
		this.setLcaseNav(new ArrayList<CaseNavire>());
		this.setPuissanceAttaque(longueur);	}
	@Override
	public String toString() {
		return "Torpilleur"+super.toString();
	}

}
