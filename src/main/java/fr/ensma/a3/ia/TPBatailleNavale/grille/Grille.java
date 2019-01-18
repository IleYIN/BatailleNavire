package fr.ensma.a3.ia.TPBatailleNavale.grille;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.navires.Navire;

/**
 * Grille du jeu
 * 
 * @author yinyiliang
 *
 */
public abstract class Grille {

	private List<Case> lcaze;
	private final static int taille = 10;// 10 * 10 cases
	private final static Logger LOGGER = Logger.getLogger(Grille.class.getName());
	private List<Navire> lnavire;


	public Grille() {

		lcaze = new ArrayList<Case>();

		for (int posX = 0; posX < taille; posX++) {
			for (int posY = 0; posY < taille; posY++) {

				lcaze.add(new CaseMer(posX, posY));
			}
		}

		lnavire = new ArrayList<Navire>();
	}

	public static int getTaille() {
		return taille;
	}

	public void setCaze(int posX, int posY, Case caze) {
		lcaze.remove(getCaze(posX, posY));
		lcaze.add(caze);

	}

	public Case getCaze(int posX, int posY) {
		for(Case caze : lcaze) {
			if (posX == caze.getPosX() && posY == caze.getPosY()) {
				return caze;
			}
		}
		LOGGER.info("can't find such case in this grille");
		return null;
	}


	public List<Case> getLcaze() {
		return lcaze;
	}



	public List<Navire> getLnavire() {
		return lnavire;
	}

	public void setLnavire(List<Navire> lnavire) {
		this.lnavire = lnavire;
	}


	public void addNavires(Navire... navires ) {

		for(Navire navire : navires) {

			lnavire.add(navire);
			int posX = navire.getPosX();
			int posY = navire.getPosY();

			Case caze = this.getCaze(posX, posY);
			this.setCaze(posX, posY, caze);

			for(Case cazeNav : navire.getLcaseNav()) {
				this.setCaze(cazeNav.getPosX(), cazeNav.getPosY(), cazeNav);
			}
		}
	}

}
