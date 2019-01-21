package fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.caze.ICase;
import fr.ensma.a3.ia.TPBatailleNavale.joueur.IJoueur;

/**
 * Attaque classique est l'attaque avec la puissance d'une navire
 * 
 * @author yinyiliang
 *
 */
public class AttaqueClassique  extends AbsAttaque {

	private final static Logger LOGGER = Logger.getLogger(AttaqueClassique.class.getName());

	public void aLAttaque(IJoueur joueur, IJoueur adverse, int posX, int posY, int puiss) {
		
		attaqueClassique(joueur, adverse, posX, posY, puiss);
		adverse.getGrillep().estAttaque();
	}

	private void attaqueClassique(IJoueur joueur, IJoueur adverse, int posX, int posY, int puiss) {
		ICase caze = adverse.getGrillep().getCaze(posX, posY);
		LOGGER.info(joueur+" attaque Classique a la case:"+caze.toString()+" de "+adverse);
		int puiss1 = checkbombe(adverse, posX, posY, puiss);
		joueur.getGrillem().addPion(caze,caze.estAttaque(puiss1));
	}

	public void aLAttaque(IJoueur joueur, IJoueur adversal, ICase caze, int puiss) {
		aLAttaque(joueur, adversal, caze.getPosX(), caze.getPosY(),puiss);
	}



}
