package fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.caze.Case;
import fr.ensma.a3.ia.TPBatailleNavale.caze.IEstAttaque;
import fr.ensma.a3.ia.TPBatailleNavale.joueur.AbsJoueur;

/**
 * Attaque pas si la navire est en panne (toutes les cases navire sont touche)
 * 
 * @author yinyiliang
 *
 */
public class AttaquePas implements IAttaque{

	private final static Logger LOGGER = Logger.getLogger(AttaquePas.class.getName());
	


	public void aLAttaque(AbsJoueur joueur, AbsJoueur adverse, int posX, int posY, int puiss) {
		Case caze = adverse.getGrillep().getCaze(posX, posY);
		attaquePas(caze);

	}

	private void attaquePas(IEstAttaque c) {
		LOGGER.info("N'attaque Pas a la case "+c.toString());
	}

	public void aLAttaque(AbsJoueur joueur, AbsJoueur adversal, Case caze, int puiss) {
		aLAttaque(joueur, adversal, caze.getPosX(), caze.getPosY(), puiss);
		
	}
	
}
