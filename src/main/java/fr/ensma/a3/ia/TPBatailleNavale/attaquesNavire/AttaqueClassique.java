package fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.Joueur;
import fr.ensma.a3.ia.TPBatailleNavale.grille.Case;
import fr.ensma.a3.ia.TPBatailleNavale.grille.IEstAttaque;

/**
 * Attaque classique est l'attaque avec la puissance d'une navire
 * 
 * @author yinyiliang
 *
 */
public class AttaqueClassique implements IAttaque{

	private final static Logger LOGGER = Logger.getLogger(AttaqueClassique.class.getName());

	public void aLAttaque(Joueur joueur, int posX, int posY, int puiss) {
		Case caze = joueur.getGrillePlacement().getCaze(posX, posY);
		attaqueClassique(caze, puiss);
	}

	private void attaqueClassique(IEstAttaque c, int puiss) {
		LOGGER.info("Attaque Classique a la case:"+c.toString());
		c.estAttaque(puiss);
	}



}
