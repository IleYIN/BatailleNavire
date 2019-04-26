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
}
