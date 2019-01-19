package fr.ensma.a3.ia.TPBatailleNavale.grille;

import java.util.List;
import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.caze.Case;
import fr.ensma.a3.ia.TPBatailleNavale.pion.ECouleur;
import fr.ensma.a3.ia.TPBatailleNavale.pion.Pion;


/**
 * Grille qui stocke la “mémoire” des tirs déjà effectués
 * 
 * @author yinyiliang
 *
 */
public class GrilleMemoire extends Grille implements IGrilleM {

	private final static Logger LOGGER = Logger.getLogger(GrilleMemoire.class.getName());

	private List<Pion> lpion;


	public GrilleMemoire() {
		super();
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

	public void addPion(Case caze, boolean tir) {
		addPion(caze.getPosX(),caze.getPosY(),tir);
	}


}
