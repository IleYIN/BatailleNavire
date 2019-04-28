package application.playscene;

import application.controller.RouteController;
import application.grilles.grillememoire.PresGrilleMemoire;
import application.grilles.grilleplacement.PresGrillePlacement;
import application.playscene.automate.EtatAttacked;
import application.playscene.automate.EtatChosenShip;
import application.playscene.automate.EtatEndGame;
import application.playscene.automate.EtatSleepingPlay;
import application.playscene.automate.IEtatPlayScene;
import application.playscene.automate.PlaySceneException;

public class PresentationPlayScene {
	
	private ModelPLayScene modelPlayScene;
	private IViewPlayScene viewPlayScene;
	
	private IEtatPlayScene etatCourant;
	private IEtatPlayScene etatSleeping;
	private IEtatPlayScene etatChosenShip;
	private IEtatPlayScene etatAttacked;
	private IEtatPlayScene etatEndGame;
	
	private PresGrillePlacement presGrillePlacement;
	private PresGrilleMemoire presGrilleMemoire;
	
	private RouteController routeController;
	
	public PresentationPlayScene() {
		modelPlayScene = new ModelPLayScene();
		
		etatSleeping = new EtatSleepingPlay(this, modelPlayScene);
		etatChosenShip = new EtatChosenShip(this, modelPlayScene);
		etatAttacked = new EtatAttacked(this, modelPlayScene);
		etatEndGame = new EtatEndGame(this, modelPlayScene);
		etatCourant = etatSleeping;
	}

	//----------Point to Views and Model
	public void setView(IViewPlayScene view) {
		viewPlayScene = view;
	}
	
	public IViewPlayScene getViewPlayScene() {
		return viewPlayScene;
	}
	
	public PresGrillePlacement getPresGrillePlacement() {
		return presGrillePlacement;
	}
	
	public void setPresGrillePlacement(PresGrillePlacement presGrillePlacement) {
		this.presGrillePlacement = presGrillePlacement;
	}
	
	public PresGrilleMemoire getPresGrilleMemoire() {
		return presGrilleMemoire;
	}
	
	public void setPresGrilleMemoire(PresGrilleMemoire presGrilleMemoire) {
		this.presGrilleMemoire = presGrilleMemoire;
	}
	
	public void setRouteController(RouteController routeController) {
		this.routeController = routeController;
	}
	
	/*
	 * Those functions're called by ViewPlayScene
	 * to notify RouteController
	 */
	public void changePlayAction(String newAction) {
		modelPlayScene.setChosenAction(newAction);
	}
	
	/*
	 * Those functions're called by PresGrille
	 * to notify RouteController
	 */
	public void chosenCasePlacement(int chosenX, int chosenY) {
		try {
			etatCourant.chooseShip();
			routeController.setCurrentPlayer(1);
			routeController.setCurrentView(viewPlayScene);
			routeController.setCurrentEtat(etatChosenShip);
			routeController.notifyChosenCase(chosenX, chosenY, modelPlayScene.getChosenAction());
		} catch (PlaySceneException e) {
		}
		
	}
	
	/*
	 * Those functions're called by RouteController
	 * to command View 
	 */
	public void notifyDrawInitAllShips() {
		viewPlayScene.notifyDrawInitAllShips();
	}
	
	public void notifyDrawOcean(int posX, int posY) {
		viewPlayScene.notifyDrawOcean(posX, posY);
	}
	
	public void notifyDrawTorpilleurShip(int posX, int posY) {
		viewPlayScene.notifyDrawTorpilleurShip(posX, posY);
	}
	
	public void notifyDrawSousMarinShip(int posX, int posY) {
		viewPlayScene.notifyDrawSousMarinShip(posX, posY);
	}
	
	public void notifyDrawContreTorpilleurShip(int posX, int posY) {
		viewPlayScene.notifyDrawContreTorpilleurShip(posX, posY);
	}
	
	public void notifyDrawPorteAvionShip(int posX, int posY) {
		viewPlayScene.notifyDrawPorteAvionShip(posX, posY);
	}
	
	public void notifyDrawCroisseurShip(int posX, int posY) {
		viewPlayScene.notifyDrawCroisseurShip(posX, posY);
	}
	
	//----------Gestion Automate
	public void setEtatCourant(final IEtatPlayScene etatCourant) {
		this.etatCourant = etatCourant;
	}
	
	public IEtatPlayScene getEtatCourant() {
		return etatCourant;
	}
	
	public IEtatPlayScene getEtatSleeping() {
		return etatSleeping;
	}
	
	public IEtatPlayScene getEtatChosenShip() {
		return etatChosenShip;
	}
	
	public IEtatPlayScene getEtatAttacked() {
		return etatAttacked;
	}
	
	public IEtatPlayScene getEtatEndGame() {
		return etatEndGame;
	}
}
