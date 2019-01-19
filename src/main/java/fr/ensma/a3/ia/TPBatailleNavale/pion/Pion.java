package fr.ensma.a3.ia.TPBatailleNavale.pion;


/**
 * des pions blancs pour les tirs dans l’eau (ne touchant aucun bateau adverse)
 *  et des pions rouges pour les “touché”
 * 
 * @author yinyiliang
 *
 */
public class Pion {

//	private final static Logger LOGGER = Logger.getLogger(Pion.class.getName());
	private final int posX, posY;
	private final ECouleur cou;
	
	public Pion(int posX, int posY, ECouleur cou) {
		this.posX = posX;
		this.posY = posY;
		this.cou = cou;
//		LOGGER.info(this.toString());
	}
	

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	
	@Override
	public String toString() {
		return "Pion"+"("+posX+","+posY+")-"+cou.toString();
	}

}
