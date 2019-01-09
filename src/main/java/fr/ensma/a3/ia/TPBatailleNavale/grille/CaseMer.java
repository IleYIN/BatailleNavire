package fr.ensma.a3.ia.TPBatailleNavale.grille;

import java.util.logging.Logger;

/**
 * une case qui represente la mer
 * 
 * @author yinyiliang
 *
 */
public class CaseMer extends Case {
	
	private final static Logger LOGGER = Logger.getLogger(CaseMer.class.getName());
	
	
	public CaseMer(final int positionX, final int positionY) {
		super(positionX, positionY);
	}

	public void afficher() {
		//TODO
	}

	public void estAttaque(int puiss) {
		LOGGER.info("tir dans la mer "+ this.toString());
	}
	
	@Override
	public String toString() {
		return "CaseMer("+this.getPosX() +","+this.getPosY()+")";
	}

}
