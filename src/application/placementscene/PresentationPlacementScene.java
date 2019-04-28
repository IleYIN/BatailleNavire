package application.placementscene;

import application.controller.RouteController;
import application.placementscene.automate.EtatPassedPlace;
import application.placementscene.automate.EtatPlayer1Place;
import application.placementscene.automate.EtatPlayer2Place;
import application.placementscene.automate.EtatSleepingPlace;
import application.placementscene.automate.IEtatPlmtScene;
import application.placementscene.automate.PlmtSceneException;
import application.startscene.automate.IEtatStarter;

public class PresentationPlacementScene {
	
	private ModelPlacementScene modelPlacementScene;
	private IViewPlacementScene viewPlacementScene;
	
	private IEtatPlmtScene etatCourant;
	private IEtatPlmtScene etatSleeping;
	private IEtatPlmtScene etatPlayer1;
	private IEtatPlmtScene etatPlayer2;
	private IEtatPlmtScene etatPassed;
	
	private RouteController routeController;
	
	public PresentationPlacementScene() {
		modelPlacementScene = new ModelPlacementScene();
		
		etatSleeping = new EtatSleepingPlace(this, modelPlacementScene);
		etatPlayer1 = new EtatPlayer1Place(this, modelPlacementScene);
		etatPlayer2 = new EtatPlayer2Place(this, modelPlacementScene);
		etatPassed = new EtatPassedPlace(this, modelPlacementScene);
		etatCourant = etatPlayer1;
	}
	
	/*
	 * Those functions're called by ViewPlacementScene
	 * to notify RouteController
	 */
	public void leadToPlayer1() {
		try {
			etatCourant.leadTo();
		} catch (PlmtSceneException e) {
		}
	}
	
	public void clickedNext() {
		try {
			etatCourant.clickedNext();
			routeController.setCurrentView(viewPlacementScene);
			routeController.setCurrentEtat(etatPlayer2);
			routeController.notifyPlaceShipsPlayer2();
		} catch (PlmtSceneException e) {
		}
	}
	
	public void clickedAuto() {
		viewPlacementScene.notifyDrawInitAllShips();
		routeController.setCurrentView(viewPlacementScene);
		routeController.setCurrentEtat(etatPlayer1);
		routeController.notifyPlaceShipsRandomly();
	}
	
	public void clickedBack() {
		try {
			etatCourant.clickedBack();
			routeController.setCurrentView(viewPlacementScene);
			routeController.setCurrentEtat(etatSleeping);
			routeController.notifyBackToStarter();
		} catch (PlmtSceneException e) {
		}
	}
	
	/*
	 * Those functions're called by RouteController
	 * to command View 
	 */
	public void notifyDrawInitAllShips() {
		viewPlacementScene.notifyDrawInitAllShips();
	}
	
	public void notifyDrawOcean(int posX, int posY) {
		viewPlacementScene.notifyDrawOcean(posX, posY);
	}
	
	public void notifyDrawTorpilleurShip(int posX, int posY) {
		viewPlacementScene.notifyDrawTorpilleurShip(posX, posY);
	}
	
	public void notifyDrawSousMarinShip(int posX, int posY) {
		viewPlacementScene.notifyDrawSousMarinShip(posX, posY);
	}
	
	public void notifyDrawContreTorpilleurShip(int posX, int posY) {
		viewPlacementScene.notifyDrawContreTorpilleurShip(posX, posY);
	}
	
	public void notifyDrawPorteAvionShip(int posX, int posY) {
		viewPlacementScene.notifyDrawPorteAvionShip(posX, posY);
	}
	
	public void notifyDrawCroisseurShip(int posX, int posY) {
		viewPlacementScene.notifyDrawCroisseurShip(posX, posY);
	}
	
	public void notifyStopAutoPlace() {
		viewPlacementScene.notifyStopAutoPlace();
	}
	
	public void notifyEndPlacement() {
		try {
			etatCourant.clickedNext();
		} catch (PlmtSceneException e) {
		}
	}

	//----------Point to View and Model
	public void setView(final IViewPlacementScene view) {
		viewPlacementScene = view;
	}
	
	public IViewPlacementScene getViewPlacementScene() {
		return viewPlacementScene;
	}
	
	public void setRouteController(RouteController routeController) {
		this.routeController = routeController;
	}
	
	public ModelPlacementScene getModel() {
		return modelPlacementScene;
	}
	
	//----------Gestion Automate
	public void setEtatCourant(final IEtatPlmtScene e) {
		etatCourant = e;
	}
	
	public IEtatPlmtScene getEtatCourant() {
		return etatCourant;
	}
	
	public IEtatPlmtScene getEtatSleeping() {
		return etatSleeping;
	}
	
	public IEtatPlmtScene getEtatPlayer1() {
		return etatPlayer1;
	}
	
	public IEtatPlmtScene getEtatPlayer2() {
		return etatPlayer2;
	}
	
	public IEtatPlmtScene getEtatPassed() {
		return etatPassed;
	}
	

}
