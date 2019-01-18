package fr.ensma.a3.ia.TPBatailleNavale.navires;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.AbsJoueur;
import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.AttaquePas;
import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.IAttaque;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.IEtatNavire;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.IGestionEtatNavire;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.etatsNavire.ActionNavireNonPermiseException;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.etatsNavire.EnDetruitNavire;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.etatsNavire.EnFonction;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.etatsNavire.EnPanne;
import fr.ensma.a3.ia.TPBatailleNavale.grille.Case;
import fr.ensma.a3.ia.TPBatailleNavale.grille.CaseMer;
import fr.ensma.a3.ia.TPBatailleNavale.grille.CaseNavire;
import fr.ensma.a3.ia.TPBatailleNavale.grille.ElementsGrille;
import fr.ensma.a3.ia.TPBatailleNavale.grille.Grille;

/**
 * les navires avec des differents types
 */
public abstract class Navire extends ElementsGrille implements IEtatNavire, INavire, IGestionEtatNavire {



	private final static Logger LOGGER = Logger.getLogger(Navire.class.getName());
	private final int longueur;
	private int puissanceAttaque;
	private int posX;
	private int posY;
	private boolean ori;//false:horizontal ; true:vertical
	private int nvieCase;
	protected IAttaque compoAttaque;
	private List<CaseNavire> lcaseNav;

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


	public void setLcaseNav(List<CaseNavire> lcaseNav) {
		this.lcaseNav = lcaseNav;
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

	public void setNvieCase(int nvieCase) {
		this.nvieCase = nvieCase;
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

	public int getNvieCase() {
		return nvieCase;
	}

	public static boolean OKToPlaceNavire(final AbsJoueur joueur, int posX, int posY, final int longueur,
			final boolean ori) {

		Grille grille = joueur.getGrilleb().getGrillePlacement();
		Case caze = grille.getCaze(posX, posY);

		if(caze instanceof CaseNavire || caze == null) {
			return false;
		} else if (ori==false) {//horizontal
			if((caze.getPosX()+longueur>Grille.getTaille())) {
				return false;
			} else {
				for(int i=1; i<longueur; i++) {
					if(grille.getCaze(posX+i, posY) instanceof CaseNavire) {
						return false;
					}
				}
			}
		} else if (ori==true) {
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


	public Navire(String id, int posX, int posY, final int longueur, 
			boolean ori, IAttaque compoA, final int nvieCase) {

		super(id);
		this.posX = posX;
		this.posY = posY;
		this.longueur = longueur;
		this.ori = ori;
		this.compoAttaque = compoA;
		this.nvieCase = nvieCase;
		this.puissanceAttaque = longueur;

		this.etatCourant = enFonction;

		CaseNavire cazeNavint = new CaseNavire(posX, posY, nvieCase);
		lcaseNav = new ArrayList<CaseNavire> ();
		lcaseNav.add(cazeNavint);

		if(ori==false) {
			for( int i=1; i<longueur; i++) {
				CaseNavire cazeNav = new CaseNavire(posX+i, posY, nvieCase);
				lcaseNav.add(cazeNav);
				//				System.out.println(cazeNav);

			}
		} else if (ori==true) {
			for( int i=1; i<longueur; i++) {
				CaseNavire cazeNav = new CaseNavire(posX, posY+i, nvieCase);
				lcaseNav.add(cazeNav);
				//				System.out.println(cazeNav);
			}
		}
	}



	public void aLAttaque(AbsJoueur joueur, int posX,int posY) {
		compoAttaque.aLAttaque(joueur, posX, posY,puissanceAttaque);
	}


	public void deplacerX(AbsJoueur joueur,int x) {

		boolean deplacable = true;
		boolean bonnecaze = false;
		
		//enlever les case navires dans la grille
		for(CaseNavire cazeNav : this.getLcaseNav()) {
			int posX = cazeNav.getPosX();
			int posY = cazeNav.getPosY();
			joueur.getGrilleb().getGrillePlacement().setCaze(posX, posY, new CaseMer(posX,posY));
			//			System.out.println("--"+cazeNav);
			if(cazeNav.getEtatCourant().equals(cazeNav.getEnDetruit())) {
				deplacable = false;
			}
			if (cazeNav.getPosX()==posX && cazeNav.getPosY()==posY) {
				bonnecaze = true;
			}
		}

		//juger si la navire est deplacable et on peut placer la navire dans une nouvelle position
		if(deplacable && bonnecaze && Navire.OKToPlaceNavire(joueur, this.getPosX()+x, this.getPosY(), this.getLongueur(), this.isOri())) {
			
			this.setPosX(this.getPosX()+x);//translation de la navire 
			
			for(CaseNavire cazeNav : this.getLcaseNav()) {
				//modification des cases navires dans la navire
				cazeNav.setPosX(cazeNav.getPosX()+x);
				//System.out.println("---"+cazeNav);
				
				//poser les cases navires dans la grille
				joueur.getGrilleb().getGrillePlacement().setCaze(cazeNav.getPosX(), cazeNav.getPosY(), cazeNav);
			}

		} else {//remettre les cases navires a la position originale dans la grille
			for(CaseNavire cazeNav : this.getLcaseNav()) {
				int posX = cazeNav.getPosX();
				int posY = cazeNav.getPosY();
				joueur.getGrilleb().getGrillePlacement().setCaze(posX, posY, cazeNav);
			}
			LOGGER.info("impossible de deplacer dans la direction x vers "+x);
		}
	}


		public void deplacerY(AbsJoueur joueur,int y) {

			boolean deplacable = true;
			boolean bonnecaze = false;

			for(CaseNavire cazeNav : this.getLcaseNav()) {
				int posX = cazeNav.getPosX();
				int posY = cazeNav.getPosY();
				joueur.getGrilleb().getGrillePlacement().setCaze(posX, posY, new CaseMer(posX,posY));
				if(cazeNav.getEtatCourant().equals(cazeNav.getEnDetruit())) {
					deplacable = false;
				}
				if (cazeNav.getPosX()==posX && cazeNav.getPosY()==posY) {
					bonnecaze = true;
				}
			}

			if(deplacable && bonnecaze && Navire.OKToPlaceNavire(joueur, this.getPosX(), this.getPosY()+y, this.getLongueur(), this.isOri())) {
				
				this.setPosY(this.getPosY()+y);
				
				for(CaseNavire cazeNav : this.getLcaseNav()) {
					cazeNav.setPosY(cazeNav.getPosY()+y);
					joueur.getGrilleb().getGrillePlacement().setCaze(cazeNav.getPosX(), cazeNav.getPosY(), cazeNav);
				}
			} else {
				for(CaseNavire cazeNav : this.getLcaseNav()) {
					int posX = cazeNav.getPosX();
					int posY = cazeNav.getPosY();
					joueur.getGrilleb().getGrillePlacement().setCaze(posX, posY, cazeNav);
				}
				LOGGER.info("impossible de deplacer dans la direction y vers "+y);
			}
		}


		public void pivoter(AbsJoueur joueur, int posX, int posY) {

			
			boolean deplacable = true;
			boolean bonnecaze = false;

			for(CaseNavire cazeNav : this.getLcaseNav()) {
				int x = cazeNav.getPosX();
				int y = cazeNav.getPosY();
				joueur.getGrilleb().getGrillePlacement().setCaze(x, y, new CaseMer(x,y));
				if(cazeNav.getEtatCourant().equals(cazeNav.getEnDetruit())) {
					deplacable = false;
				}
				if (cazeNav.getPosX()==posX && cazeNav.getPosY()==posY) {
					bonnecaze = true;
				}
			}

			if (this.isOri() == false) {//horizontal
				
				int dist = posX - this.getPosX();
				if(deplacable && bonnecaze && Navire.OKToPlaceNavire(joueur, posX, this.getPosY()-dist, this.getLongueur(), !this.isOri())) {
					
					this.setPosX(posX);
					this.setPosY(this.getPosY()-dist);
					this.setOri(!this.isOri());
					
					for(CaseNavire cazeNav : this.getLcaseNav()) {
						int d = posX - cazeNav.getPosX();
						cazeNav.setPosX(posX);
						cazeNav.setPosY(cazeNav.getPosY()-d);
						joueur.getGrilleb().getGrillePlacement().setCaze(cazeNav.getPosX(), cazeNav.getPosY(), cazeNav);
					}
				} else {
					for(CaseNavire cazeNav : this.getLcaseNav()) {
						int pX = cazeNav.getPosX();
						int pY = cazeNav.getPosY();
						joueur.getGrilleb().getGrillePlacement().setCaze(pX, pY, cazeNav);
					}
					LOGGER.info("impossible de pivoter");
				}
				
			} else {

				int dist = posY - this.getPosY();
				if(deplacable && bonnecaze && Navire.OKToPlaceNavire(joueur, this.getPosX()-dist, posY, this.getLongueur(), !this.isOri())) {
					
					this.setPosX(this.getPosX()-dist);
					this.setPosY(posY);
					this.setOri(!this.isOri());
					
					
					for(CaseNavire cazeNav : this.getLcaseNav()) {
						int d = posY - cazeNav.getPosY();
						cazeNav.setPosX(cazeNav.getPosX()-d);
						cazeNav.setPosY(posY);
						joueur.getGrilleb().getGrillePlacement().setCaze(cazeNav.getPosX(), cazeNav.getPosY(), cazeNav);
					}
				} else {
					for(CaseNavire cazeNav : this.getLcaseNav()) {
						int pX = cazeNav.getPosX();
						int pY = cazeNav.getPosY();
						joueur.getGrilleb().getGrillePlacement().setCaze(pX, pY, cazeNav);
					}
					LOGGER.info("impossible de pivoter");
				}
				
			}

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

			this.setPuissanceAttaque(this.getPuissanceAttaque() - panne - detruit);
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
			return "-("+this.posX+","+this.posY+")";
		}

	}
