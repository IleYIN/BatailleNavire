package fr.ensma.a3.ia.TPBatailleNavale.navires;

import java.util.ArrayList;
import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.AttaqueClassique;
import fr.ensma.a3.ia.TPBatailleNavale.caze.CaseNavire;
import fr.ensma.a3.ia.TPBatailleNavale.caze.ICase;
import fr.ensma.a3.ia.TPBatailleNavale.fuseeEclairante.IEclair;
import fr.ensma.a3.ia.TPBatailleNavale.joueur.IJoueur;

public class SousMarin extends Navire implements IEclair {
	
	private final static Logger LOGGER = Logger.getLogger(SousMarin.class.getName());
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
	
	public void aLEclair(IJoueur adverse, int posX, int posY) {
		int res = this.getNvieCase();
		for(CaseNavire caze : this.getLcaseNav()) {
			if(caze.getNvie()<res) {
				res = caze.getNvie();
			}
		}
		if(res>=1) {
			for(int i=0; i<=res;i++) {
				for(int j=0; j<=res;j++) {
					try {
					LOGGER.info(this.toString()+" affiche la partie de carte de "+adverse.toString()+" "
					+adverse.getGrillep().getCaze(posX+i, posY+j).toString());
					} catch (Exception e) {
						LOGGER.info("case("+(posX+i)+","+(posY+j)+") de "+adverse.toString()+" n'existe pas.");
					}
				}
			}
		} else {
			LOGGER.info(this.toString()+" ne peut plus eclarer la carte de "+adverse.toString());
		}
		
	}
	
	public void aLEclair(IJoueur adverse, ICase caze) {
		aLEclair(adverse, caze.getPosX(), caze.getPosY());
	}

}
