package fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.caze.Case;
import fr.ensma.a3.ia.TPBatailleNavale.joueur.AbsJoueur;

/**
 * Attaque classique est l'attaque avec la puissance d'une navire
 * 
 * @author yinyiliang
 *
 */
public class AttaqueClassique implements IAttaque{

	private final static Logger LOGGER = Logger.getLogger(AttaqueClassique.class.getName());

	public void aLAttaque(AbsJoueur joueur, AbsJoueur adverse, int posX, int posY, int puiss) {
		
		attaqueClassique(joueur, adverse, posX, posY, puiss);
		adverse.estAttaque();
	}

	private void attaqueClassique(AbsJoueur joueur, AbsJoueur adverse, int posX, int posY, int puiss) {
		Case caze = adverse.getGrillep().getCaze(posX, posY);
		LOGGER.info("Attaque Classique a la case:"+caze.toString());
		joueur.getGrillem().addPion(caze,caze.estAttaque(puiss));
	}

	public void aLAttaque(AbsJoueur joueur, AbsJoueur adversal, Case caze, int puiss) {
		aLAttaque(joueur, adversal, caze.getPosX(), caze.getPosY(),puiss);
	}



}
