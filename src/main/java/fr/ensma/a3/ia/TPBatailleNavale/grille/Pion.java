package fr.ensma.a3.ia.TPBatailleNavale.grille;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.AbsJoueur;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Navire;


/**
 * des pions blancs pour les tirs dans l’eau (ne touchant aucun bateau adverse)
 *  et des pions rouges pour les “touché”
 * 
 * @author yinyiliang
 *
 */
public class Pion extends ElementsGrille {

	private final static Logger LOGGER = Logger.getLogger(Pion.class.getName());
	private static int numinstance;
	private final int posX, posY;
	private Navire nav;
	private AbsJoueur adversal;
	
	public Pion(/*Joueur joueur,*/ Navire nav, AbsJoueur adversal,int posX, int posY) {
	
		super(/*joueur+*/"-Pion-"+numinstance);
//		this.joueur = joueur;
		this.posX = posX;
		this.posY = posY;
		this.nav = nav;
		this.adversal = adversal;
		numinstance++;
	}


	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	
	@Override
	public String toString() {
		return this.getId()+"("+posX+","+posY+")";
	}

	public void afficher() {
		
		nav.aLAttaque(adversal, posX, posY);
		
		if(nav.getEtatCourant().equals(nav.getEnFonction()) &&  //si navire n'attaque pas, pion blanc???
				adversal.getGrilleb().getGrillePlacement().getCaze(posX, posY) instanceof CaseNavire) {
			LOGGER.info(this.toString()+" est rouge ");
		} else {
			LOGGER.info(this.toString()+" est blanc ");
		}
		
	}

}
