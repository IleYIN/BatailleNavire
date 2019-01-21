package fr.ensma.a3.ia.TPBatailleNavale.navires;

import java.util.List;
import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.AttaquePas;
import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.IAttaque;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.IEtatNavire;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.etatsNavire.ActionNavireNonPermiseException;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.etatsNavire.EnDetruitNavire;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.etatsNavire.EnFonction;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.etatsNavire.EnPanne;
import fr.ensma.a3.ia.TPBatailleNavale.caze.CaseNavire;
import fr.ensma.a3.ia.TPBatailleNavale.joueur.IJoueur;

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
			} catch (ActionNavireNonPermiseException e) {
				LOGGER.info(this+e.getMessage());
			}
		} else if(panne+detruit == this.getLongueur()) {
			try {
				etatCourant.estEnPanne();
				this.setCompoAttaque(new AttaquePas());
			} catch (ActionNavireNonPermiseException e) {
				LOGGER.info(this+e.getMessage());
			}
		}

		if(this.getPuissanceAttaque()>panne+detruit) {
			this.setPuissanceAttaque(this.getPuissanceAttaque() - panne - detruit);
		} else {
			this.setPuissanceAttaque(0);
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


	public void estEnPanne() throws ActionNavireNonPermiseException {
	}


	public void retournerEnFonction() throws ActionNavireNonPermiseException {
	}


	public void estEnDetruit() throws ActionNavireNonPermiseException {
	}

	@Override
	public String toString() {
		return "-[("+this.posX+","+this.posY+"),"+(this.ori?"horizontal":"vertical")+",len:"+this.longueur+",puiss:"+this.getPuissanceAttaque()+"]";
	}

}
