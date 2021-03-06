package fr.ensma.a3.ia.TPBatailleNavale.navires;

import java.util.ArrayList;

import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.AttaqueClassique;
import fr.ensma.a3.ia.TPBatailleNavale.caze.CaseNavire;

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
