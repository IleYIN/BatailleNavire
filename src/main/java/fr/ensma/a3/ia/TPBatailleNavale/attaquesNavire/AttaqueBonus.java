package fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.AbsJoueur;
import fr.ensma.a3.ia.TPBatailleNavale.grille.Case;
import fr.ensma.a3.ia.TPBatailleNavale.grille.IEstAttaque;

/**
 * Attaquer en ajoutant la puissance avec une bonus
 * 
 * @author yinyiliang
 *
 */
public class AttaqueBonus implements IAttaque{

	private final static Logger LOGGER = Logger.getLogger(AttaqueBonus.class.getName());
	private final static int bonus = 2;



	public void aLAttaque(AbsJoueur joueur, int posX, int posY, int puiss) {
		Case caze = joueur.getGrilleb().getGrillePlacement().getCaze(posX, posY);
		attaqueEnBonus(caze, puiss+bonus);
		joueur.estAttaque();
	}

	private void attaqueEnBonus(IEstAttaque c, int puissbonus) {
		LOGGER.info("Attaque en bonus a la case:"+c.toString());
		c.estAttaque(puissbonus);
	}


}
