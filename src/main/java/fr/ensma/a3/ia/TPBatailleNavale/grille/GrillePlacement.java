package fr.ensma.a3.ia.TPBatailleNavale.grille;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.bombe.Bombe;
import fr.ensma.a3.ia.TPBatailleNavale.caze.CaseMer;
import fr.ensma.a3.ia.TPBatailleNavale.caze.CaseNavire;
import fr.ensma.a3.ia.TPBatailleNavale.caze.ICase;
import fr.ensma.a3.ia.TPBatailleNavale.navires.ENavire;
import fr.ensma.a3.ia.TPBatailleNavale.navires.INavire;


/**
 * Grille du jeu
 * 
 * @author yinyiliang
 *
 */

public class GrillePlacement extends Grille implements IGrilleP {

	private final static Logger LOGGER = Logger.getLogger(GrillePlacement.class.getName());

	private final Map<ENavire,INavire> lnavire;

	private Bombe bombe;


	public GrillePlacement() {
		super();
		lnavire = new HashMap<ENavire,INavire>();
		//initialer une bombe
		this.bombe = Bombe.retournerUneBombe();
	}

	public void setBombe(Bombe bombe) {
		this.bombe = bombe;
	}

	public Bombe getBombe() {
		return bombe;
	}


	public Map<ENavire, INavire> getLnavire() {
		return lnavire;
	}
	
	private boolean OKToPlaceNavirelong(INavire nav, int posX, int posY, boolean ori, int longueur) {
		
		
		ICase caze = this.getCaze(posX, posY);

		if(caze instanceof CaseNavire || caze == null) {
			return false;
		} else if (ori==false) {//horizontal
			if((caze.getPosX()+longueur>this.getTaille())) {
				return false;
			} else {
				for(int i=1; i<longueur; i++) {
					if(this.getCaze(posX+i, posY) instanceof CaseNavire) {
						return false;
					}
				}
			}
		} else if (ori==true) {
			if(caze.getPosY()+longueur>this.getTaille()) {
				return false;
			} else {

				for(int i=1; i<longueur; i++) {
					if(this.getCaze(posX, posY+i) instanceof CaseNavire) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	
	private boolean OKToPlaceNavire(INavire nav, int posX, int posY, boolean ori) {
		int longueur = nav.getLongueur();
		return OKToPlaceNavirelong(nav, posX, posY, ori, longueur);
	}



	public void addNavire(INavire nav, int posX, int posY, boolean ori) {

		if(OKToPlaceNavire(nav, posX, posY, ori)) {
			
			nav.setPosX(posX);
			nav.setPosY(posY);
			nav.setOri(ori);

			if(nav.getEnav().equals(ENavire.PorteAvion)) {
				
				//ori==false horizontal    ori==true vertical
				if(OKToPlaceNavirelong(nav, posX+(ori?1:0), posY+(ori?0:1), ori, 3)) {
					
					for( int i=0; i<nav.getLongueur(); i++) {
						CaseNavire cazeNav = new CaseNavire(posX+(ori?0:i), posY+(ori?i:0), nav.getNvieCase());
						nav.getLcaseNav().add(cazeNav);
						this.setCaze(cazeNav.getPosX(), cazeNav.getPosY(), cazeNav);
					}
					//la deuxieme ligne(horizontal) ou colonne(vertical)
					for( int i=0; i<3; i++) {
						CaseNavire cazeNav = new CaseNavire(posX+(ori?0:i)+(ori?1:0), posY+(ori?i:0)+(ori?0:1), nav.getNvieCase());
						nav.getLcaseNav().add(cazeNav);
						this.setCaze(cazeNav.getPosX(), cazeNav.getPosY(), cazeNav);
					}
					
					lnavire.put(nav.getEnav(), nav);
					
				} else {
					LOGGER.info("impossible d'ajouter la navire " + nav.toString());
				}
				
			} else {

				for( int i=0; i<nav.getLongueur(); i++) {
					CaseNavire cazeNav = new CaseNavire(posX+(ori?0:i), posY+(ori?i:0), nav.getNvieCase());
					nav.getLcaseNav().add(cazeNav);
					this.setCaze(cazeNav.getPosX(), cazeNav.getPosY(), cazeNav);
				}
				
				lnavire.put(nav.getEnav(), nav);
				
				
				/*if(ori==false) {
					for( int i=0; i<nav.getLongueur(); i++) {
						CaseNavire cazeNav = new CaseNavire(posX+i, posY, nav.getNvieCase());
						nav.getLcaseNav().add(cazeNav);
						this.setCaze(cazeNav.getPosX(), cazeNav.getPosY(), cazeNav);
					}
				} else if (ori==true) {
					for( int i=0; i<nav.getLongueur(); i++) {
						CaseNavire cazeNav = new CaseNavire(posX, posY+i, nav.getNvieCase());
						nav.getLcaseNav().add(cazeNav);
						this.setCaze(cazeNav.getPosX(), cazeNav.getPosY(), cazeNav);
					}
				}*/

			}
			
		} else {
			
			LOGGER.info("impossible d'ajouter la navire "+nav.toString());
			
		}
	}


	public void addRandomNavire(INavire nav) {

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
		
		if(nav.getEnav().equals(ENavire.PorteAvion)) {
			while (!OKToPlaceNavire(nav, posX, posY, ori) 
					&& OKToPlaceNavirelong(nav, posX+(ori?1:0), posY+(ori?0:1), ori, 3)) {
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
		}

		addNavire(nav, posX, posY, ori);
	}

	public void addRandomNavires(INavire... navs) {
		for(INavire nav : navs ) {
			addRandomNavire(nav);
		}
	}

	public void deplacerX(INavire nav, int x) {

		boolean deplacable = true;
		boolean bonnecaze = false;

		//enlever les case navires dans la grille
		for(CaseNavire cazeNav : nav.getLcaseNav()) {
			int posX = cazeNav.getPosX();
			int posY = cazeNav.getPosY();
			this.setCaze(posX, posY, new CaseMer(posX,posY));
			//			System.out.println("--"+cazeNav);

			//si une des cases est detruit 
			//ou x est superieur a la vie d'une case navire la plus petite
			//il ne peut pas deplacer
			if(cazeNav.getEtatCourant().equals(cazeNav.getEnDetruit())
					|| cazeNav.getNvie() < x || x < 1) {
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
			LOGGER.info(nav.toString() + "a deplace dans la direction x de "+x);

		} else {//remettre les cases navires a la position originale dans la grille
			for(CaseNavire cazeNav : nav.getLcaseNav()) {
				int posX = cazeNav.getPosX();
				int posY = cazeNav.getPosY();
				this.setCaze(posX, posY, cazeNav);
			}
			LOGGER.info(nav.toString()+"impossible de deplacer dans la direction x de "+x);
		}
	}


	public void deplacerY(INavire nav,int y) {

		boolean deplacable = true;
		boolean bonnecaze = false;

		for(CaseNavire cazeNav : nav.getLcaseNav()) {
			int posX = cazeNav.getPosX();
			int posY = cazeNav.getPosY();
			this.setCaze(posX, posY, new CaseMer(posX,posY));


			if(cazeNav.getEtatCourant().equals(cazeNav.getEnDetruit())
					|| cazeNav.getNvie() < y || y < 1) {
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

			LOGGER.info(nav.toString() + " deplace dans la direction y de "+y);
		} else {
			for(CaseNavire cazeNav : nav.getLcaseNav()) {
				int posX = cazeNav.getPosX();
				int posY = cazeNav.getPosY();
				this.setCaze(posX, posY, cazeNav);
			}
			LOGGER.info(nav.toString()+"impossible de deplacer dans la direction y de "+y);
		}
	}

	public void pivoter(INavire nav, int posX, int posY) {


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
				LOGGER.info(nav.toString()+ " pivote a la direction "+ (nav.isOri()?"horizontal":"vertical"));
			} else {
				for(CaseNavire cazeNav : nav.getLcaseNav()) {
					int pX = cazeNav.getPosX();
					int pY = cazeNav.getPosY();
					this.setCaze(pX, pY, cazeNav);
				}
				LOGGER.info(nav.toString()+"impossible de pivoter");
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


	public void pivoter(INavire nav,CaseNavire cazeNav) {
		pivoter(nav, cazeNav.getPosX(), cazeNav.getPosY());
	}

	//	public INavire getRandomNavireAttaque() {
	//		int i = (int) (Math.random() * this.getLnavire().size());
	//		while (!(this.getLnavire().get(i).getEtatCourant().equals(this.getLnavire().get(i).getEnFonction()))
	//				|| (this.getLnavire().get(i) instanceof Voilier)) {
	//			i = (int) (Math.random() * this.getLnavire().size());
	//		}
	//		return this.getLnavire().get(i);
	//	}

	public void explodeBombe() {

		int posX = this.bombe.getPosX();
		int posY = this.bombe.getPosY();
		this.getCaze(posX, posY).estAttaque(3);

		/////////////////////

		try {
			this.getCaze(posX+1, posY).estAttaque(2);
		} catch (Exception e) {
			LOGGER.info("case("+(posX+1)+","+posY+") n'existe pas");
		}

		try {
			this.getCaze(posX+1, posY-1).estAttaque(2);
		} catch (Exception e) {
			LOGGER.info("case("+(posX+1)+","+(posY-1)+") n'existe pas");
		}

		try {
			this.getCaze(posX+1, posY+1).estAttaque(2);
		} catch (Exception e) {
			LOGGER.info("case("+(posX+1)+","+(posY+1)+") n'existe pas");
		}

		try {
			this.getCaze(posX-1, posY).estAttaque(2);
		} catch (Exception e) {
			LOGGER.info("case("+(posX-1)+","+posY+") n'existe pas");
		}


		try {
			this.getCaze(posX-1, posY+1).estAttaque(2);
		} catch (Exception e) {
			LOGGER.info("case("+(posX-1)+","+(posY+1)+") n'existe pas");
		}

		try {
			this.getCaze(posX-1, posY-1).estAttaque(2);
		} catch (Exception e) {
			LOGGER.info("case("+(posX-1)+","+(posY-1)+") n'existe pas");
		}

		try {
			this.getCaze(posX, posY+1).estAttaque(2);
		} catch (Exception e) {
			LOGGER.info("case("+posX+","+(posY+1)+") n'existe pas");
		}

		try {
			this.getCaze(posX, posY-1).estAttaque(2);
		} catch (Exception e) {
			LOGGER.info("case("+posX+","+(posY-1)+") n'existe pas");
		}


		try {
			this.getCaze(posX, posY+1).estAttaque(2);
		} catch (Exception e) {
			LOGGER.info("case("+(posX-1)+","+(posY+1)+") n'existe pas");
		}

		///////////////////

		for(int i=-2;i<=2;i++) {
			try {
				this.getCaze(posX-2, posY+i).estAttaque(1);
			} catch (Exception e) {
				LOGGER.info("case("+(posX-2)+","+(posY+i)+") n'existe pas");
			}

			try {
				this.getCaze(posX+2, posY+i).estAttaque(1);
			} catch (Exception e) {
				LOGGER.info("case("+(posX+2)+","+(posY+i)+") n'existe pas");
			}
		}

		for(int i=-1;i<=1;i++) {
			try {
				this.getCaze(posX+i, posY+2).estAttaque(1);
			} catch (Exception e) {
				LOGGER.info("case("+(posX+i)+","+(posY+2)+") n'existe pas");
			}

			try {
				this.getCaze(posX+i, posY-2).estAttaque(1);
			} catch (Exception e) {
				LOGGER.info("case("+(posX+i)+","+(posY-2)+") n'existe pas");
			}
		}
	}


	public INavire getNavire(ENavire enav) {
		if(this.getLnavire().keySet().contains(enav)){
			return this.getLnavire().get(enav);
		} else {
			LOGGER.info("la navire "+enav+" n'existe pas.");
			return null;
		}
	}


	public void addNavire(INavire nav, ICase caze, boolean ori) {
		addNavire(nav, caze.getPosX(), caze.getPosY(), ori);
	}

}
