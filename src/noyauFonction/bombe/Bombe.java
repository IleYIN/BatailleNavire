package noyauFonction.bombe;

import java.util.logging.Logger;


/**
 * pattern singleton
 * 
 * @author yinyiliang
 *
 */

public class Bombe {
	

	private final static Logger LOGGER = Logger.getLogger(Bombe.class.getName());
	private int resistance = 3;
	private final int posX = (int) (Math.random()*10);
	private final int posY = (int) (Math.random()*10);
	
	/**Constructeur Privé*/
	private Bombe() {
	}

	/**Holder chargé lors du premier acces à la classe */
	private static class holder{
		/**L'instance unique créé lors du premier chargement*/
		private static final Bombe moninstance = new Bombe();
	}
	
	/**
	 * Obtient l'instance Unique
	 * @return Bombe
	 */
	public static Bombe retournerUneBombe() {
		return holder.moninstance;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}


	public int getResistance() {
		return resistance;
	}
	

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	/**
	 * 
	 * @param puiss la puissance attaque
	 * @return retourner la nouvelle puissance attaque 
	 */
	public int estAttaque(int puiss) {
		LOGGER.info("tir dans une bombe "+this.toString());
		int r = this.getResistance();
		if(r > puiss) {
			this.setResistance(r-puiss);
			return 0;
		} else {
			this.setResistance(0);
			return (puiss - r);
		}
	}
	
	@Override
	public String toString() {
		return "Bombe("+this.posX+","+this.posY+")-nvie:"+this.resistance;
	}	
}
