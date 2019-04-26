package noyauFonction.navires.typeNavire;

import java.util.ArrayList;

import noyauFonction.navires.attaquesNavire.AttaqueClassique;
import noyauFonction.caze.CaseNavire;
import noyauFonction.navires.ENavire;

public class Croiseur extends Navire {


	private static final int longueur = 4;
	

	public Croiseur() {
		enav = ENavire.Croiseur;
		this.setLongueur(longueur);
		this.setCompoAttaque(new AttaqueClassique());
		this.setNvieCase(longueur);
		this.setEtatCourant(enFonction);
		this.setLcaseNav(new ArrayList<CaseNavire>());
		this.setPuissanceAttaque(longueur);
	}
	
	@Override
	public String toString() {
		return "Croiseur"+super.toString();
	}
	
}
