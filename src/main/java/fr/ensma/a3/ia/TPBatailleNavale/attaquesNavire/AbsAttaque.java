package fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.bombe.Bombe;
import fr.ensma.a3.ia.TPBatailleNavale.joueur.AbsJoueur;

/**
 * Attaque abstrait pour juger d'abord s'il y a une bombe
 * 
 * @author yinyiliang
 *
 */
public abstract class AbsAttaque implements IAttaque{

	private final static Logger LOGGER = Logger.getLogger(AbsAttaque.class.getName());

	public int checkbombe(AbsJoueur adverse, int posX, int posY, int puiss) {
		
		Bombe bombe = adverse.getGrillep().getBombe();
		
		if(null != bombe 
				&& posX == bombe.getPosX()
				&& posY == bombe.getPosY()) {
			
			int puiss2 = bombe.estAttaque(puiss);
			//la bombe est attaque et la puissance est modifier
			
			if (bombe.getResistance()==0) {
				LOGGER.info(" bombe de "+adverse+" explose!!!");
				adverse.getGrillep().explodeBombe();
				adverse.getGrillep().setBombe(null);
			}
			return puiss2;
		}
		
		return puiss;
	}

}
