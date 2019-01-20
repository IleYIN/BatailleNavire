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
public class AttaquePas extends AbsAttaque {

	private final static Logger LOGGER = Logger.getLogger(AttaquePas.class.getName());
	


	public void aLAttaque(AbsJoueur joueur, AbsJoueur adverse, int posX, int posY, int puiss) {
	
		attaquePas(joueur, adverse, posX, posY, puiss);

	}

	private void attaquePas(AbsJoueur joueur, AbsJoueur adverse, int posX, int posY, int puiss) {
		Case caze = adverse.getGrillep().getCaze(posX, posY);
		LOGGER.info(joueur+ "ne peut pas attaquer a la case "+caze.toString()+" de "+adverse);
	}

	public void aLAttaque(AbsJoueur joueur, AbsJoueur adversal, Case caze, int puiss) {
		aLAttaque(joueur, adversal, caze.getPosX(), caze.getPosY(), puiss);
		
	}
	
}
