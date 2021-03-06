package fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.bombe.Bombe;
import fr.ensma.a3.ia.TPBatailleNavale.joueur.IJoueur;

/**
 * Attaque abstrait pour juger d'abord s'il y a une bombe
 * 
 * @author yinyiliang
 *
 */
public abstract class AbsAttaque implements IAttaque{

	private final static Logger LOGGER = Logger.getLogger(AbsAttaque.class.getName());

	//problem!!! Est-ce qu'il a besoin d'jouter un Pion quand la bombe explose?
	
	/**
	 * 
	 * @param adverse joueur adverse
	 * @param posX check si la position X est la meme que celle de la bombe
	 * @param posY check si la position Y est la meme que celle de la bombe
	 * @param puiss modifier la puissance attaque si la position est meme
	 * @return retourner la nouvelle puissance attaque
	 */
	public int checkbombe(IJoueur adverse, int posX, int posY, int puiss) {
		
		Bombe bombe = adverse.getGrillep().getBombe();
		
		if(null != bombe 
				&& posX == bombe.getPosX()
				&& posY == bombe.getPosY()) {
			
			int puiss2 = bombe.estAttaque(puiss);
			//la bombe est attaque et la puissance est modifier
			
			if (bombe.getResistance()==0) {
				LOGGER.info(" bombe "+bombe.toString()+" de "+adverse+" explose!!!");
				adverse.getGrillep().explodeBombe();
				adverse.getGrillep().setBombe(null);
			}
			return puiss2;
		}
		
		return puiss;
	}

}
