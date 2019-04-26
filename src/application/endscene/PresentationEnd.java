package application.endscene;

import application.controller.RouteController;

public class PresentationEnd {

	private ModelEnd modelEnd;
	private IViewEnd viewEnd;
	
	private RouteController routeController;
	
	public PresentationEnd() {
		modelEnd = new ModelEnd();
		
	}
	
	public void setView(IViewEnd viewEnd) {
		this.viewEnd = viewEnd;
	}
	
	public IViewEnd getViewEnd() {
		return viewEnd;
	}
	
	public void setRouteController(RouteController routeController) {
		this.routeController = routeController;
	}
}
