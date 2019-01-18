package fr.ensma.a3.ia.TPBatailleNavale.pion;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.AbsJoueur;
import fr.ensma.a3.ia.TPBatailleNavale.factory.EJoueur;
import fr.ensma.a3.ia.TPBatailleNavale.grille.CaseNavire;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Navire;


/**
 * des pions blancs pour les tirs dans l’eau (ne touchant aucun bateau adverse)
 *  et des pions rouges pour les “touché”
 * 
 * @author yinyiliang
 *
 */
public class AbstractPion implements IPion {

	private final static Logger LOGGER = Logger.getLogger(AbstractPion.class.getName());
	protected int posX, posY;
	protected Navire nav;
	protected AbsJoueur adversal;
	protected EJoueur ejoueur;
	
//	private static int numinstance;
	
	
//	public AbstractPion(/*Joueur joueur,*/ Navire nav, Joueur adversal,int posX, int posY) {
//	
//		super(/*joueur+*/"-Pion-"+numinstance);
////		this.joueur = joueur;
//		this.posX = posX;
//		this.posY = posY;
//		this.nav = nav;
//		this.adversal = adversal;
////		numinstance++;
//	}


	
	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setNav(Navire nav) {
		this.nav = nav;
	}

	public void setAdversal(AbsJoueur adversal) {
		this.adversal = adversal;
	}

	
	@Override
	public String toString() {
		return "-Pion("+posX+","+posY+")";
	}

	public void afficher() {
		
//		boolean couleur;
		nav.aLAttaque(adversal, posX, posY);
		
		if(nav.getEtatCourant().equals(nav.getEnFonction()) &&  //si navire n'attaque pas, pion blanc???
				adversal.getGrilleb().getGrillePlacement().getCaze(posX, posY) instanceof CaseNavire) {
//			couleur = true;//rouge
			LOGGER.info(this.toString()+" est rouge ");
		} else {
//			couleur = false; //blanc
			LOGGER.info(this.toString()+" est blanc ");
		}
		
	}


}
