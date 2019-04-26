package noyauFonction.navires.typeNavire;

import java.util.ArrayList;

import noyauFonction.navires.attaquesNavire.AttaquePas;
import noyauFonction.navires.attaquesNavire.IAttaque;
import noyauFonction.caze.CaseNavire;
import noyauFonction.navires.ENavire;

public class Voilier extends Navire {

	private static final int longueur = 1;

	public Voilier() {
		enav = ENavire.Voilier;
		this.setLongueur(longueur);
		this.setCompoAttaque(new AttaquePas());
		this.setNvieCase(4); //Resistance = 4
		this.setEtatCourant(enFonction);
		this.setLcaseNav(new ArrayList<CaseNavire>());
		this.setPuissanceAttaque(0);
	}
	
	@Override
	public void setCompoAttaque(IAttaque compoAttaque) {
		super.setCompoAttaque(new AttaquePas()); //toujours n'attaque pas 
	}



	@Override
	public String toString() {
		return "Voilier"+super.toString();
	}

}
