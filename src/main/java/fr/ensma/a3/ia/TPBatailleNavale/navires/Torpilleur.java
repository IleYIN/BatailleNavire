package fr.ensma.a3.ia.TPBatailleNavale.navires;

import java.util.ArrayList;

import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.AttaqueClassique;
import fr.ensma.a3.ia.TPBatailleNavale.grille.CaseNavire;

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
