package fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire;

import java.util.logging.Logger;
import fr.ensma.a3.ia.TPBatailleNavale.caze.ICase;
import fr.ensma.a3.ia.TPBatailleNavale.joueur.IJoueur;

/**
 * Attaque pas si la navire est en panne (toutes les ICases navire sont touche)
 * 
 * @author yinyiliang
 *
 */
public class AttaquePas extends AbsAttaque {

	private final static Logger LOGGER = Logger.getLogger(AttaquePas.class.getName());
	


	public void aLAttaque(IJoueur joueur, IJoueur adverse, int posX, int posY, int puiss) {
	
		attaquePas(joueur, adverse, posX, posY, puiss);

	}

	private void attaquePas(IJoueur joueur, IJoueur adverse, int posX, int posY, int puiss) {
		ICase caze = adverse.getGrillep().getCaze(posX, posY);
		LOGGER.info(joueur+ "ne peut pas attaquer a la case "+caze.toString()+" de "+adverse);
	}

	public void aLAttaque(IJoueur joueur, IJoueur adversal, ICase caze, int puiss) {
		aLAttaque(joueur, adversal, caze.getPosX(), caze.getPosY(), puiss);
		
	}
	
}
