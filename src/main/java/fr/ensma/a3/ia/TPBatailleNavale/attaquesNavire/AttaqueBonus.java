package fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.Joueur;
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



	public void aLAttaque(Joueur joueur, int posX, int posY, int puiss) {
		Case caze = joueur.getGrillePlacement().getCaze(posX, posY);
		attaqueEnBonus(caze, puiss+bonus);
	}

	private void attaqueEnBonus(IEstAttaque c, int puissbonus) {
		LOGGER.info("Attaque en bonus a la case:"+c.toString());
		c.estAttaque(puissbonus);
	}


}
