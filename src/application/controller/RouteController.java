package application.controller;

import java.util.logging.Logger;

import application.Main;
import application.endscene.IViewEnd;
import application.endscene.PresentationEnd;
import application.exceptionscenes.PresentationOnWorkingNotification;
import application.exceptionscenes.ViewOnWorkingNotification;
import application.grilles.grillememoire.IViewGrilleMemoire;
import application.grilles.grilleplacement.IViewGrillePlacement;
import application.placementscene.IViewPlacementScene;
import application.placementscene.PresentationPlacementScene;
import application.placementscene.automate.EtatPassedPlace;
import application.placementscene.automate.EtatPlayer1Place;
import application.placementscene.automate.EtatPlayer2Place;
import application.placementscene.automate.EtatSleepingPlace;
import application.playscene.IViewPlayScene;
import application.playscene.PresentationPlayScene;
import application.startscene.IViewStarter;
import application.startscene.PresentationStarter;
import application.startscene.automate.EtatOffline;
import application.startscene.automate.EtatOnline;
import application.startscene.automate.EtatSinglePlayer;
import application.startscene.automate.EtatVide;
import application.startscene.automate.StarterException;
import noyauFonction.LogicController;

public class RouteController {

	private Logger LOGGER = Logger.getLogger(RouteController.class.getName());
	
	private Main main;
	private LogicController logicController;
	
	/*
	 *  Tracking basic information of view
	 *  We use String in order to repeat view and state 
	 */
	private int currentPlayer;
	private String currentView;
	private String previousView;
	private String currentEtat;
	private String previousEtat;
	
	// Connection to Presentations
	private PresentationStarter presStarter;
	private PresentationPlacementScene presPlacement;
	private PresentationPlayScene presPlay;
	private PresentationEnd presEnd;
	private PresentationOnWorkingNotification presOnWorking;
	
	public RouteController(final Main main) {
		this.main = main;
		logicController = new LogicController(this);
		
		currentPlayer = 1;
		currentView = "ViewStarter";
		currentEtat = "EtatVide";
	}
	
	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	public int getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void setCurrentView(IView view) {
		this.previousView = this.currentView;
		if (view instanceof IViewStarter) {
			this.currentView = "ViewStarter";
		} else if (view instanceof IViewPlacementScene) {
			this.currentView = "ViewPlacementScene";
		} else if (view instanceof IViewPlayScene) {
			this.currentView = "ViewPlayScene";
		} else if (view instanceof IViewEnd) {
			this.currentView = "ViewEnd";
		} else if (view instanceof ViewOnWorkingNotification) {
			this.currentView = "ViewOnWorkingNotification";
		} else {
			LOGGER.info("View type does not exist!!!");
		}
	}
	
	public String getCurrentView() {
		return currentView;
	}
	
	public String getPreviousView() {
		return previousView;
	}
	
	public void setCurrentEtat(IEtat etat) {
		this.previousEtat = currentEtat;
		// Etat of ViewStarter
		if(etat instanceof EtatSinglePlayer) {
			this.currentEtat = "EtatSinglePlayer";
		} else if(etat instanceof EtatOffline) {
			this.currentEtat = "EtatOffline";
		} else if(etat instanceof EtatOnline) {
			this.currentEtat = "EtatOnline";
		} else if(etat instanceof EtatVide) {
			this.currentEtat = "EtatVide";
		// Etat of ViewPlacementScene
		} else if(etat instanceof EtatSleepingPlace) {
			this.currentEtat = "EtatSleepingPlace";
		} else if(etat instanceof EtatPlayer1Place) {
			this.currentEtat = "EtatPlayer1Place";
		} else if(etat instanceof EtatPlayer2Place) {
			this.currentEtat = "EtatPlayer2Place";
		} else if(etat instanceof EtatPassedPlace) {
			this.currentEtat = "EtatPassedPlace";
		} else {
			LOGGER.info("Etat type does not exist!!!");
		}
	}
	
	public String getCurrentEtat() {
		return currentEtat;
	}
	
	public String getPreviousEtat() {
		return previousEtat;
	}
	
	/*
	 *  Those functions're called by Presentation of currentView
	 *  to notify their changes to logicController
	 */
	public void notifyStartGame() {
		logicController.startGame();
	}
	
	public void notifyBackToStarter() {
		logicController.backToStarter();
	}
	
	public void notifyPlaceShipsRandomly() {
		logicController.placeShipsRandomly();
	}
	
	public void notifyPlaceShipsPlayer2() {
		logicController.placeShipsPlayer2();
	}
	
	/*
	 * Those functions're called by logicController
	 * to command currentView 
	 */	
	public void commandSwitchEtatInitial() {
		if(currentView.equals("ViewStarter") 
		&& previousView.equals("ViewOnWorkingNotification")) {
			try {
				presStarter.getEtatCourant().backToEtatVide();
			} catch (StarterException e) {
				e.printStackTrace();
			}
		} else if (currentView.equals("ViewStarter")
		&& previousView.equals("ViewPlacementScene")) {
			try {
				presStarter.getEtatCourant().backToEtatVide();
			} catch (StarterException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void commandDrawInitAllShips() {
		if(currentView.equals("ViewPlacementScene")
				&& currentEtat.equals("EtatPlayer1Place")) {
			presPlacement.notifyDrawInitAllShips();
		}
		if(currentView.equals("ViewPlayScene")) {
			presPlay.notifyDrawInitAllShips();
		}
		
	}
	
	public void commandDrawOcean(int posX, int posY) {
		if(currentView.equals("ViewPlacementScene")
				&& currentEtat.equals("EtatPlayer1Place")) {
			presPlacement.notifyDrawOcean(posX, posY);
		}
		if(currentView.equals("ViewPlayScene")) {
			presPlay.notifyDrawOcean(posX, posY);
		}
		
	}
	
	public void commandShowTorpilleurShips(int posX, int posY) {
		if(currentView.equals("ViewPlacementScene")
				&& currentEtat.equals("EtatPlayer1Place")) {
			presPlacement.notifyDrawTorpilleurShip(posX, posY);
		}
		if(currentView.equals("ViewPlayScene")) {
			presPlay.notifyDrawTorpilleurShip(posX, posY);
		}
	}
	
	public void commandShowSousMarinShips(int posX, int posY) {
		if(currentView.equals("ViewPlacementScene")
				&& currentEtat.equals("EtatPlayer1Place")) {
			presPlacement.notifyDrawSousMarinShip(posX, posY);
		}
		if(currentView.equals("ViewPlayScene")) {
			presPlay.notifyDrawSousMarinShip(posX, posY);
		}
	}
	
	public void commandShowPorteAvionShips(int posX, int posY) {
		if(currentView.equals("ViewPlacementScene")
				&& currentEtat.equals("EtatPlayer1Place")) {
			presPlacement.notifyDrawPorteAvionShip(posX, posY);
		}
		if(currentView.equals("ViewPlayScene")) {
			presPlay.notifyDrawPorteAvionShip(posX, posY);
		}
	}
	
	public void commandShowContreTorpilleurShips(int posX, int posY) {
		if(currentView.equals("ViewPlacementScene")
				&& currentEtat.equals("EtatPlayer1Place")) {
			presPlacement.notifyDrawContreTorpilleurShip(posX, posY);
		}
		if(currentView.equals("ViewPlayScene")) {
			presPlay.notifyDrawContreTorpilleurShip(posX, posY);
		}
	}
	
	public void commandShowCroisseurShips(int posX, int posY) {
		if(currentView.equals("ViewPlacementScene")
				&& currentEtat.equals("EtatPlayer1Place")) {
			presPlacement.notifyDrawCroisseurShip(posX, posY);
		}
		if(currentView.equals("ViewPlayScene")) {
			presPlay.notifyDrawCroisseurShip(posX, posY);
		}
	}
	
	public void commandStopAutoPlace() {
		presPlacement.notifyStopAutoPlace();
	}
	
	public void commandEndPlacement() {
		presPlacement.notifyEndPlacement();
	}
	/*
	 * Those functions're called by logicController
	 * to command Main
	 */
	public void commandChangeView() {		
		main.setScene();
		if(presPlacement.getEtatCourant().equals(presPlacement.getEtatSleeping())) {
			presPlacement.leadToPlayer1();;
		}
	}
	
	// Set connection to Presentations
	public void setPresStarter(PresentationStarter presStarter) {
		this.presStarter = presStarter;
	}
	
	public PresentationStarter getPresStarter() {
		return presStarter;
	}
	
	public void setPresPlacement(PresentationPlacementScene presPlacement) {
		this.presPlacement = presPlacement;
	}
	
	public PresentationPlacementScene getPresPlacement() {
		return presPlacement;
	}
	
	public void setPresPlay(PresentationPlayScene presPlay) {
		this.presPlay = presPlay;
	}
	
	public PresentationPlayScene getPresPlay() {
		return presPlay;
	}
	
	public void setPresEnd(PresentationEnd presEnd) {
		this.presEnd = presEnd;
	}
	
	public PresentationEnd getPresEnd() {
		return presEnd;
	}
	
	public void setPresOnWorking(PresentationOnWorkingNotification presOnWorking) {
		this.presOnWorking = presOnWorking;
	}
	
	public PresentationOnWorkingNotification getPresOnWorking() {
		return presOnWorking;
	}
}
