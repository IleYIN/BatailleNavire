package noyauFonction;

import java.util.List;
import java.util.logging.Logger;

import application.controller.RouteController;
import application.grilles.grilleplacement.IViewGrillePlacement;
import application.grilles.grilleplacement.ViewGrillePlacement;
import application.placementscene.PresentationPlacementScene;
import noyauFonction.caze.CaseNavire;
import noyauFonction.caze.ICase;
import noyauFonction.joueur.Humain;
import noyauFonction.joueur.IJoueur;
import noyauFonction.joueur.Ordinateur;
import noyauFonction.navires.ENavire;
import noyauFonction.navires.typeNavire.INavire;

public class LogicController {
	
	private Logger LOGGER = Logger.getLogger(LogicController.class.getName());
	
	private RouteController routeController;
	
	private IJoueur player1;
	private IJoueur player2;
	
	private int gameType = 0;
	
	public LogicController(RouteController routeController) {
		// TODO Initialize logical elements
		this.routeController = routeController;
	}
	
	// Receive from Starter
	public void startGame() {
		
		if (routeController.getCurrentView().equals("ViewStarter")) {
			if (routeController.getCurrentEtat().equals("EtatSinglePlayer")) {		
				routeController.setCurrentView(routeController.getPresPlacement().getViewPlacementScene());
				routeController.commandChangeView();
				player1 = new Humain();
				player2 = new Ordinateur();
				gameType = 1;
			};
			if (routeController.getCurrentEtat().equals("EtatOffline")) {
				routeController.setCurrentView(routeController.getPresOnWorking().getViewOnWorkingNotification());
				routeController.commandChangeView();
			};
			if (routeController.getCurrentEtat().equals("EtatOnline")) {
				routeController.setCurrentView(routeController.getPresOnWorking().getViewOnWorkingNotification());
				routeController.commandChangeView();
			};
		}else {
			LOGGER.info("startGame with wrong View!!!");
		}
	}
	
	// Receive from OnWorking, Placement
	public void backToStarter() {
		if (routeController.getCurrentView().equals("ViewOnWorkingNotification")) {
			routeController.setCurrentView(routeController.getPresStarter().getViewStarter());
			routeController.setCurrentEtat(routeController.getPresStarter().getEtatVide());
			routeController.commandSwitchEtatInitial();
			routeController.commandChangeView();
		} else if (routeController.getCurrentView().equals("ViewPlacementScene")
				&& routeController.getCurrentEtat().equals("EtatSleepingPlace")) {
			routeController.setCurrentView(routeController.getPresStarter().getViewStarter());
			routeController.setCurrentEtat(routeController.getPresStarter().getEtatVide());
			routeController.commandSwitchEtatInitial();
			routeController.commandChangeView();
		} else {
			LOGGER.info("backToStarter with wrong View or Etat!!!");
		}
	}
	
	// Place ships manually 
	public void startPlaceShips() {
		Boolean pass = false;
		int nbPlacedShips = 0;
		
	}
	
	// Place ships automatically
	public void placeShipsRandomly() {	
		if(routeController.getCurrentView().equals("ViewPlacementScene")
		&& routeController.getCurrentEtat().equals("EtatPlayer1Place")) {				
			this.player1.initialiserRandomGrilleP();
			routeController.setCurrentEtat(routeController.getPresPlacement().getEtatPlayer1());

//			for(int i=0; i<10; i++) {
//				for(int j=0; j<10; j++) {
//					ICase caze = this.player1.getGrillep().getCaze(i, j);
//					if(caze instanceof CaseNavire) {
//						routeController.commandShowTorpilleurShips(i, j);
//					}
//				}
//			}
			
//			for(int i=0; i<10; i++) {
//				for(int j=0; j<10; j++) {				
//						routeController.commandDrawOcean(i, j);
//				}
//			}
			
//			routeController.commandDrawInitAllShips();
//			for(ENavire enavire: this.player1.getGrillep().getMapnavire().keySet()) {
//				// List all ENavires		
//				int sizeNavire = this.player1.getGrillep().getMapnavire().get(enavire).size();
//				for(int i = 0; i<sizeNavire; i++) {
//					// List all caseNavire
//					List<CaseNavire> lcaseNavire = this.player1.getGrillep().getMapnavire().get(enavire.ContreTorpilleur).get(i).getLcaseNav();
//					for (CaseNavire caseNavire: lcaseNavire) {
//						ENavire enaContreTorpilleur = enavire.ContreTorpilleur;
//						ENavire enaCroiseur = enavire.Croiseur;
//						ENavire enaPorteAvion = enavire.PorteAvion;
//						ENavire enaSousMarin = enavire.SousMarin;
//						ENavire enaTorpilleur = enavire.Torpilleur;
//						int posX = caseNavire.getPosX();
//						int posY = caseNavire.getPosY();
//						if(enavire.equals(enaContreTorpilleur)) {
//							System.out.println(" ContreTorpilleur-3");
//							routeController.commandShowContreTorpilleurShips(posX, posY);
//						}
//						if(enavire.equals(enaCroiseur)) {
//							System.out.println("Croiseur-4");
//							routeController.commandShowCroisseurShips(posX, posY);
//						}
//						if(enavire.equals(enaPorteAvion)) {
//							System.out.println("PorteAvion-8");
//							routeController.commandShowPorteAvionShips(posX, posY);
//						}
//						if(enavire.equals(enaSousMarin)) {
//							System.out.println("SousMarin-3");
//							routeController.commandShowSousMarinShips(posX, posY);
//						}
//						if(enavire.equals(enaTorpilleur)) {
//							System.out.println("Torpilleur-2");
//							routeController.commandShowTorpilleurShips(posX, posY);
//						}
//					}
//				}
//			}
			
			showPlacedShips();
			routeController.commandStopAutoPlace();
		} else if(routeController.getCurrentView().equals("ViewPlacementScene")
		&& routeController.getCurrentEtat().equals("EtatPlayer2Place")) {
			LOGGER.info("We haven't created this part!!!");
		} else {
			LOGGER.info("placeShipsRandomly with wrong View or Etat!!!");
		}
	}
	
	public void showPlacedShips() {
		ENavire enaContreTorpilleur = ENavire.ContreTorpilleur;
		ENavire enaCroiseur = ENavire.Croiseur;
		ENavire enaPorteAvion = ENavire.PorteAvion;
		ENavire enaSousMarin = ENavire.SousMarin;
		ENavire enaTorpilleur = ENavire.Torpilleur;
		
		for(CaseNavire caseNav: this.player1.getGrillep().getNavire(enaContreTorpilleur).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			routeController.commandShowContreTorpilleurShips(posX, posY);
			System.out.println("ContreTorpilleur-Purple:" +posX+", "+posY);
		}
		for(CaseNavire caseNav: this.player1.getGrillep().getNavire(enaCroiseur).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			routeController.commandShowCroisseurShips(posX, posY);
			System.out.println("Croisseur-Yellow:" +posX+", "+posY);
		}
		for(CaseNavire caseNav: this.player1.getGrillep().getNavire(enaPorteAvion).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			routeController.commandShowPorteAvionShips(posX, posY);
			System.out.println("PorteAvion-Gray:" +posX+", "+posY);
		}
		for(CaseNavire caseNav: this.player1.getGrillep().getNavire(enaSousMarin).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			routeController.commandShowSousMarinShips(posX, posY);
			System.out.println("SousMarin-GreenYellow:" +posX+", "+posY);
		}
		for(CaseNavire caseNav: this.player1.getGrillep().getNavire(enaTorpilleur).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			routeController.commandShowTorpilleurShips(posX, posY);
			System.out.println("Torpilleur-Green:" +posX+", "+posY);
		}
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				ICase caze = this.player1.getGrillep().getCaze(i, j);
				if(caze instanceof CaseNavire) {
					System.out.println(i+", "+j);
				}
			}
		}
	}

	// Auto place ships for computer
	public void placeShipsPlayer2() {
		if(routeController.getCurrentView().equals("ViewPlacementScene")
				&& routeController.getCurrentEtat().equals("EtatPlayer2Place") 
				&& gameType == 1) {
			this.player2.initialiserRandomGrilleP();
			routeController.commandEndPlacement();
			routeController.setCurrentView(routeController.getPresPlay().getViewPlayScene());
			routeController.commandChangeView();
			showPlacedShips();
		}
	}
}
