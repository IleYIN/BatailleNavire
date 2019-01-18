package fr.ensma.a3.ia.TPBatailleNavale.grille;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.navires.Navire;

/**
 * Grille du jeu
 * 
 * @author yinyiliang
 *
 */

public class GrillePlacement extends Grille {
	
	private final static Logger LOGGER = Logger.getLogger(GrillePlacement.class.getName());
	
	private List<Navire> lnavire;


	public GrillePlacement() {

		super();
		lnavire = new ArrayList<Navire>();
	}

	public List<Navire> getLnavire() {
		return lnavire;
	}

	public void setLnavire(List<Navire> lnavire) {
		this.lnavire = lnavire;
	}


	private boolean OKToPlaceNavire(Navire nav, int posX, int posY, boolean ori) {

		Case caze = this.getCaze(posX, posY);

		if(caze instanceof CaseNavire || caze == null) {
			return false;
		} else if (ori==false) {//horizontal
			if((caze.getPosX()+nav.getLongueur()>GrillePlacement.getTaille())) {
				return false;
			} else {
				for(int i=1; i<nav.getLongueur(); i++) {
					if(this.getCaze(posX+i, posY) instanceof CaseNavire) {
						return false;
					}
				}
			}
		} else if (ori==true) {
			if(caze.getPosY()+nav.getLongueur()>GrillePlacement.getTaille()) {
				return false;
			} else {

				for(int i=1; i<nav.getLongueur(); i++) {
					if(this.getCaze(posX, posY+i) instanceof CaseNavire) {
						return false;
					}
				}
			}
		}
		return true;
	}



	public void addNavire(Navire nav, int posX, int posY, boolean ori) {

		if(OKToPlaceNavire(nav, posX, posY, ori)) {


			CaseNavire cazeNavint = new CaseNavire(posX, posY, nav.getNvieCase());

			nav.getLcaseNav().add(cazeNavint);
			nav.setPosX(posX);
			nav.setPosY(posY);
			nav.setOri(ori);

			if(ori==false) {
				for( int i=0; i<nav.getLongueur(); i++) {
					CaseNavire cazeNav = new CaseNavire(posX+i, posY, nav.getNvieCase());
					nav.getLcaseNav().add(cazeNav);
					this.setCaze(cazeNav.getPosX(), cazeNav.getPosY(), cazeNav);
					//				System.out.println(cazeNav);

				}
			} else if (ori==true) {
				for( int i=0; i<nav.getLongueur(); i++) {
					CaseNavire cazeNav = new CaseNavire(posX, posY+i, nav.getNvieCase());
					nav.getLcaseNav().add(cazeNav);
					this.setCaze(cazeNav.getPosX(), cazeNav.getPosY(), cazeNav);
					//				System.out.println(cazeNav);
				}
			}

			lnavire.add(nav);
		} else {
			LOGGER.info("impossible d'ajouter la navire");
		}

	}

	public void addRandomNavire(Navire nav) {

		int posX, posY, trueOrFalse;
		boolean ori;

		posX = (int) (Math.random() * 10);
		posY = (int) (Math.random() * 10);
		trueOrFalse = (int) (Math.random() * 2);
		if (trueOrFalse == 1) {
			ori = true;
		}
		else {
			ori = false;
		}

		while (!OKToPlaceNavire(nav, posX, posY, ori)) {
			posX = (int) (Math.random() * 10);
			posY = (int) (Math.random() * 10);
			trueOrFalse = (int) (Math.random() * 2);
			if (trueOrFalse == 1) {
				ori = true;
			}
			else {
				ori = false;
			}
		}

		addNavire(nav, posX, posY, ori);
	}


	public void deplacerX(Navire nav, int x) {

		boolean deplacable = true;
		boolean bonnecaze = false;

		//enlever les case navires dans la grille
		for(CaseNavire cazeNav : nav.getLcaseNav()) {
			int posX = cazeNav.getPosX();
			int posY = cazeNav.getPosY();
			this.setCaze(posX, posY, new CaseMer(posX,posY));
			//			System.out.println("--"+cazeNav);
			if(cazeNav.getEtatCourant().equals(cazeNav.getEnDetruit())) {
				deplacable = false;
			}
			if (cazeNav.getPosX()==posX && cazeNav.getPosY()==posY) {
				bonnecaze = true;
			}
		}

		//juger si la navire est deplacable et on peut placer la navire dans une nouvelle position
		if(deplacable && bonnecaze && this.OKToPlaceNavire(nav, nav.getPosX()+x, nav.getPosY(), nav.isOri())) {

			nav.setPosX(nav.getPosX()+x);//translation de la navire 

			for(CaseNavire cazeNav : nav.getLcaseNav()) {
				//modification des cases navires dans la navire
				cazeNav.setPosX(cazeNav.getPosX()+x);
				//System.out.println("---"+cazeNav);

				//poser les cases navires dans la grille
				this.setCaze(cazeNav.getPosX(), cazeNav.getPosY(), cazeNav);
			}

		} else {//remettre les cases navires a la position originale dans la grille
			for(CaseNavire cazeNav : nav.getLcaseNav()) {
				int posX = cazeNav.getPosX();
				int posY = cazeNav.getPosY();
				this.setCaze(posX, posY, cazeNav);
			}
			LOGGER.info("impossible de deplacer dans la direction x de "+x);
		}
	}


	public void deplacerY(Navire nav,int y) {

		boolean deplacable = true;
		boolean bonnecaze = false;

		for(CaseNavire cazeNav : nav.getLcaseNav()) {
			int posX = cazeNav.getPosX();
			int posY = cazeNav.getPosY();
			this.setCaze(posX, posY, new CaseMer(posX,posY));
			if(cazeNav.getEtatCourant().equals(cazeNav.getEnDetruit())) {
				deplacable = false;
			}
			if (cazeNav.getPosX()==posX && cazeNav.getPosY()==posY) {
				bonnecaze = true;
			}
		}

		if(deplacable && bonnecaze && OKToPlaceNavire(nav, nav.getPosX(), nav.getPosY()+y, nav.isOri())) {

			nav.setPosY(nav.getPosY()+y);

			for(CaseNavire cazeNav : nav.getLcaseNav()) {
				cazeNav.setPosY(cazeNav.getPosY()+y);
				this.setCaze(cazeNav.getPosX(), cazeNav.getPosY(), cazeNav);
			}
		} else {
			for(CaseNavire cazeNav : nav.getLcaseNav()) {
				int posX = cazeNav.getPosX();
				int posY = cazeNav.getPosY();
				this.setCaze(posX, posY, cazeNav);
			}
			LOGGER.info("impossible de deplacer dans la direction y de "+y);
		}
	}


	public void pivoter(Navire nav, Case caze) {
		pivoter(nav, caze.getPosX(), caze.getPosY());
	}
	
	
	public void pivoter(Navire nav, int posX, int posY) {


		boolean deplacable = true;
		boolean bonnecaze = false;

		for(CaseNavire cazeNav : nav.getLcaseNav()) {
			int x = cazeNav.getPosX();
			int y = cazeNav.getPosY();
			this.setCaze(x, y, new CaseMer(x,y));
			if(cazeNav.getEtatCourant().equals(cazeNav.getEnDetruit())) {
				deplacable = false;
			}
			if (cazeNav.getPosX()==posX && cazeNav.getPosY()==posY) {
				bonnecaze = true;
			}
		}

		if (nav.isOri() == false) {//horizontal

			int dist = posX - nav.getPosX();
			if(deplacable && bonnecaze && OKToPlaceNavire(nav, posX, nav.getPosY()-dist, !nav.isOri())) {

				nav.setPosX(posX);
				nav.setPosY(nav.getPosY()-dist);
				nav.setOri(!nav.isOri());

				for(CaseNavire cazeNav : nav.getLcaseNav()) {
					int d = posX - cazeNav.getPosX();
					cazeNav.setPosX(posX);
					cazeNav.setPosY(cazeNav.getPosY()-d);
					this.setCaze(cazeNav.getPosX(), cazeNav.getPosY(), cazeNav);
				}
			} else {
				for(CaseNavire cazeNav : nav.getLcaseNav()) {
					int pX = cazeNav.getPosX();
					int pY = cazeNav.getPosY();
					this.setCaze(pX, pY, cazeNav);
				}
				LOGGER.info("impossible de pivoter");
			}

		} else {

			int dist = posY - nav.getPosY();
			if(deplacable && bonnecaze && OKToPlaceNavire(nav, nav.getPosX()-dist, posY, !nav.isOri())) {

				nav.setPosX(nav.getPosX()-dist);
				nav.setPosY(posY);
				nav.setOri(!nav.isOri());


				for(CaseNavire cazeNav : nav.getLcaseNav()) {
					int d = posY - cazeNav.getPosY();
					cazeNav.setPosX(cazeNav.getPosX()-d);
					cazeNav.setPosY(posY);
					this.setCaze(cazeNav.getPosX(), cazeNav.getPosY(), cazeNav);
				}
			} else {
				for(CaseNavire cazeNav : nav.getLcaseNav()) {
					int pX = cazeNav.getPosX();
					int pY = cazeNav.getPosY();
					this.setCaze(pX, pY, cazeNav);
				}
				LOGGER.info("impossible de pivoter");
			}

		}

	}

}
