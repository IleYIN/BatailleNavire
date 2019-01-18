package fr.ensma.a3.ia.TPBatailleNavale.grille;

import java.util.List;
import java.util.logging.Logger;


/**
 * Grille qui stocke la “mémoire” des tirs déjà effectués
 * 
 * @author yinyiliang
 *
 */
public class GrilleMemoire extends Grille {

private final static Logger LOGGER = Logger.getLogger(GrilleMemoire.class.getName());
	
	private List<Pion> lpion;
	
	
	public GrilleMemoire() {
		super();
	}
	
	public void addPion(Pion pion) {
		lpion.add(pion);
	}

}
