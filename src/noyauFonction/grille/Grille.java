package noyauFonction.grille;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import noyauFonction.caze.ICase;
import noyauFonction.caze.CaseMer;

/**
 * Grille du jeu
 * 
 * @author yinyiliang
 *
 */

public abstract class Grille implements IGrille {
	
	protected List<ICase> lcaze;
	protected final static int taille = 10;// 10 * 10 cases
	private final static Logger LOGGER = Logger.getLogger(Grille.class.getName());
	

	public Grille() {

		lcaze = new ArrayList<ICase>();

		for (int posX = 0; posX < taille; posX++) {
			for (int posY = 0; posY < taille; posY++) {

				lcaze.add(new CaseMer(posX, posY));
			}
		}

	}

	public int getTaille() {
		return taille;
	}

	public void setCaze(int posX, int posY, ICase caze) {
		lcaze.remove(getCaze(posX, posY));
		lcaze.add(caze);

	}

	public ICase getCaze(int posX, int posY) {
		for(ICase caze : lcaze) {
			if (posX == caze.getPosX() && posY == caze.getPosY()) {
				return caze;
			}
		}
		LOGGER.info("impossible de trouver cette case dans la grille");
		return null;
	}


	public List<ICase> getLcaze() {
		return lcaze;
	}

}
