package noyauFonction.grille;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import noyauFonction.caze.ICase;
import noyauFonction.pion.ECouleur;
import noyauFonction.pion.Pion;

/**
 * Grille qui stocke la “mémoire�? des tirs déjà effectués
 * 
 * @author yinyiliang
 *
 */
public class GrilleMemoire extends Grille implements IGrilleM {

	private final static Logger LOGGER = Logger.getLogger(GrilleMemoire.class.getName());

	private List<Pion> lpion;


	public GrilleMemoire() {
		super();
		lpion = new ArrayList<Pion>();
	}

	public void addPion(int posX, int posY, boolean tir) {
		if(tir == true) {
			Pion pion = new Pion(posX, posY, ECouleur.rouge);
			lpion.add(pion);
			LOGGER.info("ajouter un pion "+pion.toString());
		} else {
			Pion pion = new Pion(posX, posY, ECouleur.blanc);
			lpion.add(pion);
			LOGGER.info("ajouter un pion "+pion.toString());
		}
	}

	public void addPion(ICase caze, boolean tir) {
		addPion(caze.getPosX(),caze.getPosY(),tir);
	}


}
