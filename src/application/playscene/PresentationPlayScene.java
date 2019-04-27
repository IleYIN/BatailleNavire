package application.playscene;

import application.controller.RouteController;

public class PresentationPlayScene {
	
	private ModelPLayScene modelPlayScene;
	private IViewPlayScene viewPlayScene;
	
	private RouteController routeController;
	
	public PresentationPlayScene() {
		modelPlayScene = new ModelPLayScene();
	}

	public void setView(IViewPlayScene view) {
		viewPlayScene = view;
	}
	
	public IViewPlayScene getViewPlayScene() {
		return viewPlayScene;
	}
	
	public void setRouteController(RouteController routeController) {
		this.routeController = routeController;
	}
	
	/*
	 * Those functions're called by View
	 * to notify RouteController
	 */
	
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
}
