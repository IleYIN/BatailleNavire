package fr.ensma.a3.ia.TPBatailleNavale.navires;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.Joueur;
import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.AttaquePas;
import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.IAttaque;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.IEtatNavire;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.IGestionEtatNavire;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.etatsNavire.ActionNavireNonPermiseException;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.etatsNavire.EnDetruitNavire;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.etatsNavire.EnFonction;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.etatsNavire.EnPanne;
import fr.ensma.a3.ia.TPBatailleNavale.grille.Case;
import fr.ensma.a3.ia.TPBatailleNavale.grille.CaseNavire;
import fr.ensma.a3.ia.TPBatailleNavale.grille.ElementsGrille;
import fr.ensma.a3.ia.TPBatailleNavale.grille.Grille;

/**
 * les navires avec des differents types
 */
public abstract class Navire extends ElementsGrille implements IEtatNavire, IGestionEtatNavire {



	private final static Logger LOGGER = Logger.getLogger(Navire.class.getName());
	private final int longueur;
	private int nvieNavire;
	private int puissanceAttaque;
	protected IAttaque compoAttaque;
	//	private final EOrientation ori;
	private final List<CaseNavire> lcaseNav;



	// Gestion Etat
	private IEtatNavire etatCourant;
	private IEtatNavire enFonction = new EnFonction(this);
	private IEtatNavire enPanne = new EnPanne(this);
	private IEtatNavire enDetruitNavire = new EnDetruitNavire(this);

	public IAttaque getCompoAttaque() {
		return compoAttaque;
	}

	public void setCompoAttaque(IAttaque compoAttaque) {
		this.compoAttaque = compoAttaque;
	}

	public int getNvieNavire() {
		return nvieNavire;
	}

	public void setNvieNavire(int nvieNavire) {
		this.nvieNavire = nvieNavire;
	}

	public List<CaseNavire> getLcaseNav() {
		return lcaseNav;
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

	public static boolean OKToPlaceNavire(final Joueur joueur, int posX, int posY, final int longueur,
			final EOrientation ori) {
		
		Grille grille = joueur.getGrillePlacement();
		Case caze = grille.getCaze(posX, posY);
		
		if(caze instanceof CaseNavire) {
			return false;
		} else if (ori.getValOri()==0){
			if(caze.getPosX()+longueur>Grille.getTaille()) {
				return false;
			} else {
				for(int i=1; i<longueur; i++) {
					if(grille.getCaze(posX+i, posY) instanceof CaseNavire) {
						return false;
					}
				}
			}
		} else if (ori.getValOri()==1) {
			if(caze.getPosY()+longueur>Grille.getTaille()) {
				return false;
			} else {

				for(int i=1; i<longueur; i++) {
					if(grille.getCaze(posX, posY+i) instanceof CaseNavire) {
						return false;
					}
				}
			}
		}
		return true;
	}


	public Navire(final String id, final Joueur joueur, int posX, int posY, final int longueur,
			final EOrientation ori, final IAttaque compoA) {

		super(joueur+id, joueur.getGrillePlacement());

		Case caze = joueur.getGrilleMemoire().getCaze(posX, posY);
		this.longueur = longueur;
		this.puissanceAttaque = longueur;
		this.nvieNavire = longueur * longueur;
		this.compoAttaque = compoA;

		etatCourant = enFonction;


		CaseNavire cazeNavint = new CaseNavire(caze.getPosX(),caze.getPosY(), longueur);
		joueur.getGrillePlacement().setCaze(caze.getPosX(), caze.getPosY(), cazeNavint);
		lcaseNav = new ArrayList<CaseNavire> ();
		lcaseNav.add(cazeNavint);



		if(ori.getValOri() == 0) {
			for( int i=1; i<longueur; i++) {
				CaseNavire cazeNav = new CaseNavire(caze.getPosX()+i,caze.getPosY(), longueur);
				lcaseNav.add(cazeNav);
				joueur.getGrillePlacement().setCaze(caze.getPosX()+i, caze.getPosY(), cazeNav);
			}
		} else if (ori.getValOri() == 1) {
			for( int i=1; i<longueur; i++) {
				CaseNavire cazeNav = new CaseNavire(caze.getPosX(),caze.getPosY()+i, longueur);
				lcaseNav.add(cazeNav);
				joueur.getGrillePlacement().setCaze(caze.getPosX(), caze.getPosY()+i, cazeNav );
			}
			//border problem pas encore modifier!!!!!!
		}
	}


	public void aLAttaque(Joueur joueur, int posX,int posY) {

		this.renouvelerEtatNavire();

		if(etatCourant.equals(enFonction)) {
			compoAttaque.aLAttaque(joueur, posX, posY,puissanceAttaque);
		} else {
			this.setCompoAttaque(new AttaquePas());
			compoAttaque.aLAttaque(joueur, posX,posY, puissanceAttaque);
		}

	}

	private void renouvelerEtatNavire() {

		int panne = 0;
		int detruit = 0;
		int nvieN = 0;

		for (CaseNavire caseNav:this.getLcaseNav()) {
			nvieN += caseNav.getNvie();

			if( caseNav.getEtatCourant().equals(caseNav.getEnDetruit())) {
				detruit++;
			} else if (caseNav.getEtatCourant().equals(caseNav.getEnTouche()) ) {
				panne++;
			}
		}

		if(detruit == this.getLongueur()) {
			try {
				etatCourant.estEnDetruit();
			} catch (ActionNavireNonPermiseException e) {
				LOGGER.info(this.getId()+e.getMessage());
			}
		} else if(panne+detruit == this.getLongueur()) {
			try {
				etatCourant.estEnPanne();
			} catch (ActionNavireNonPermiseException e) {
				LOGGER.info(this.getId()+e.getMessage());
			}
		}

		this.setPuissanceAttaque(this.getPuissanceAttaque() - panne - detruit);
		this.setNvieNavire(nvieN);
	}

	@Override
	public String toString() {
		return this.getId()+"(puissAtt:"+ puissanceAttaque + "): ";
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



}
