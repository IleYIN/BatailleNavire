package fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.caze.ICase;
import fr.ensma.a3.ia.TPBatailleNavale.joueur.IJoueur;

/**
 * Attaquer en ajoutant la puissance avec une bonus
 * 
 * @author yinyiliang
 *
 */
public class AttaqueBonus  extends AbsAttaque {

	private final static Logger LOGGER = Logger.getLogger(AttaqueBonus.class.getName());
	private final static int bonus = 2;



	public void aLAttaque(IJoueur joueur, IJoueur adverse, int posX, int posY, int puiss) {
		attaqueEnBonus(joueur, adverse, posX, posY, puiss+bonus);
		adverse.estAttaque();
	}

	private void attaqueEnBonus(IJoueur joueur, IJoueur adverse, int posX, int posY, int puissbonus) {
		ICase caze = adverse.getGrillep().getCaze(posX, posY);
		LOGGER.info(joueur+ " attaque en bonus a la case:"+caze.toString()+" de "+adverse);
		int puiss1 = checkbombe(adverse, posX, posY, puissbonus);
		joueur.getGrillem().addPion(caze, caze.estAttaque(puiss1));
	}

	public void aLAttaque(IJoueur joueur, IJoueur adversal, ICase caze, int puiss) {
		aLAttaque(joueur, adversal, caze.getPosX(), caze.getPosY(),puiss);
	}


}
