package fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.AbsJoueur;
import fr.ensma.a3.ia.TPBatailleNavale.grille.Case;
import fr.ensma.a3.ia.TPBatailleNavale.grille.IEstAttaque;

/**
 * Attaque pas si la navire est en panne (toutes les cases navire sont touche)
 * 
 * @author yinyiliang
 *
 */
public class AttaquePas implements IAttaque{

	private final static Logger LOGGER = Logger.getLogger(AttaquePas.class.getName());
	


	public void aLAttaque(AbsJoueur joueur, int posX, int posY, int puiss) {
		Case caze = joueur.getGrilleb().getGrillePlacement().getCaze(posX, posY);
		attaquePas(caze);

	}

	private void attaquePas(IEstAttaque c) {
		LOGGER.info("N'attaque Pas a la case "+c.toString());
	}
	
}
