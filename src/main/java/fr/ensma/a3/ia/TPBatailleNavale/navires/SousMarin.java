package fr.ensma.a3.ia.TPBatailleNavale.navires;

import java.util.ArrayList;

import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.AttaqueClassique;
import fr.ensma.a3.ia.TPBatailleNavale.grille.CaseNavire;

public class SousMarin extends Navire {

	private static final int longueur = 3;

	public SousMarin() {
		enav = ENavire.SousMarin;
		this.setLongueur(longueur);
		this.setCompoAttaque(new AttaqueClassique());
		this.setNvieCase(longueur);
		this.setEtatCourant(enFonction);
		this.setLcaseNav(new ArrayList<CaseNavire>());
		this.setPuissanceAttaque(longueur);
	}
	public String toString() {
		return "SousMarin"+super.toString();
	}

}
