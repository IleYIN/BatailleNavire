package noyauFonction.navires.typeNavire;

import java.util.List;
import java.util.logging.Logger;

import noyauFonction.navires.ENavire;
import noyauFonction.navires.attaquesNavire.AttaquePas;
import noyauFonction.navires.attaquesNavire.IAttaque;
import noyauFonction.navires.automateNavire.IEtatNavire;
import noyauFonction.navires.automateNavire.etatsNavire.ActionNavireNonPermiseException;
import noyauFonction.navires.automateNavire.etatsNavire.EnDetruitNavire;
import noyauFonction.navires.automateNavire.etatsNavire.EnFonction;
import noyauFonction.navires.automateNavire.etatsNavire.EnPanne;
import noyauFonction.caze.CaseNavire;
import noyauFonction.joueur.IJoueur;

/**
 * les navires avec des differents types
 */
public abstract class Navire implements INavire {



	private final static Logger LOGGER = Logger.getLogger(Navire.class.getName());
	private int longueur;
	private int puissanceAttaque;
	private int nvieCase;
	private IAttaque compoAttaque;
	private List<CaseNavire> lcaseNav;
	private int posX, posY;
	private boolean ori;//false horzontal ; true vertical
	protected ENavire enav;

	// Gestion Etat
	protected IEtatNavire etatCourant;
	protected IEtatNavire enFonction = new EnFonction(this);
	protected IEtatNavire enPanne = new EnPanne(this);
	protected IEtatNavire enDetruitNavire = new EnDetruitNavire(this);


	public ENavire getEnav() {
		return enav;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}


	public boolean isOri() {
		return ori;
	}

	public void setOri(boolean ori) {
		this.ori = ori;
	}

	public IAttaque getCompoAttaque() {
		return compoAttaque;
	}

	public void setCompoAttaque(IAttaque compoAttaque) {
		this.compoAttaque = compoAttaque;
	}


	public void setLcaseNav(List<CaseNavire> lcaseNav) {
		this.lcaseNav = lcaseNav;
	}

	public List<CaseNavire> getLcaseNav() {
		return lcaseNav;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLongueur() {
		return longueur;
	}

	public int getPuissanceAttaque() {
		return puissanceAttaque;
	}


	public void setPuissanceAttaque(int puissanceAttaque) {
		this.puissanceAttaque = puissanceAttaque;
	}

	public void setNvieCase(int nvieCase) {
		this.nvieCase = nvieCase;
	}


	public int getNvieCase() {
		return nvieCase;
	}

	//	public Navire(String id, final int longueur, IAttaque compoA, final int nvieCase) {
	//
	//		this.id = id;
	//		this.longueur = longueur;
	//		this.compoAttaque = compoA;
	//		this.nvieCase = nvieCase;
	//		this.puissanceAttaque = longueur;
	//		this.etatCourant = enFonction;
	//		lcaseNav = new ArrayList<CaseNavire> ();
	//
	//	}



	public void aLAttaque(IJoueur joueur, IJoueur adversal, int posX,int posY) {
		compoAttaque.aLAttaque(joueur, adversal, posX, posY,puissanceAttaque);
	}

	public void renouvelerEtatNavire() {

		int panne = 0;
		int detruit = 0;

		for (CaseNavire caseNav:this.getLcaseNav()) {

			if( caseNav.getEtatCourant().equals(caseNav.getEnDetruit())) {
				detruit++;
			} else if (caseNav.getEtatCourant().equals(caseNav.getEnTouche()) ) {
				panne++;
			}
		}

		if(detruit == this.getLongueur()) {
			try {
				etatCourant.estEnDetruit();
				this.setCompoAttaque(new AttaquePas());
				this.setPuissanceAttaque(0);
			} catch (ActionNavireNonPermiseException e) {
				LOGGER.info(this+e.getMessage());
			}
		} else if(panne+detruit == this.getLongueur()) {
			try {
				etatCourant.estEnPanne();
				this.setCompoAttaque(new AttaquePas());
				this.setPuissanceAttaque(0);
			} catch (ActionNavireNonPermiseException e) {
				LOGGER.info(this+e.getMessage());
			} 
		} else if(panne+detruit<this.getLongueur()) {
			this.setPuissanceAttaque(this.getLongueur()-panne-detruit);
		}
	}



	//ETAT
	public IEtatNavire getEtatCourant() {
		return etatCourant;
	}


	public void setEtatCourant(IEtatNavire etat) {
		this.etatCourant = etat;
	}


	public IEtatNavire getEnPanne() {
		return enPanne;
	}


	public IEtatNavire getEnDetruitNavire() {
		return enDetruitNavire;
	}


	public IEtatNavire getEnFonction() {
		return enFonction;
	}


	@Override
	public String toString() {
		return "-[("+this.posX+","+this.posY+"),"+(this.ori?"horizontal":"vertical")+",len:"+this.longueur+",puiss:"+this.getPuissanceAttaque()+"]";
	}

}
