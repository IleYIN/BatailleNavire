package fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.caze.Case;
import fr.ensma.a3.ia.TPBatailleNavale.joueur.AbsJoueur;

/**
 * Attaquer en ajoutant la puissance avec une bonus
 * 
 * @author yinyiliang
 *
 */
public class AttaqueBonus implements IAttaque{

	private final static Logger LOGGER = Logger.getLogger(AttaqueBonus.class.getName());
	private final static int bonus = 2;



	public void aLAttaque(AbsJoueur joueur, AbsJoueur adverse, int posX, int posY, int puiss) {
		attaqueEnBonus(joueur, adverse, posX, posY, puiss+bonus);
		adverse.estAttaque();
	}

	private void attaqueEnBonus(AbsJoueur joueur, AbsJoueur adverse, int posX, int posY, int puissbonus) {
		Case caze = adverse.getGrillep().getCaze(posX, posY);
		LOGGER.info("Attaque en bonus a la case:"+caze.toString());
		joueur.getGrillem().addPion(caze, caze.estAttaque(puissbonus));
	}

	public void aLAttaque(AbsJoueur joueur, AbsJoueur adversal, Case caze, int puiss) {
		aLAttaque(joueur, adversal, caze.getPosX(), caze.getPosY(),puiss);
	}


}
