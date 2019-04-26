package application.exceptionscenes;

import application.controller.RouteController;

public class PresentationOnWorkingNotification {

	private IViewOnworking viewOnWorkingNotification;
	
	private RouteController routeController;
	
	public PresentationOnWorkingNotification() {
		// TODO Auto-generated constructor stub
	}
	
	public void setView(IViewOnworking viewOnWorkingNotification) {
		this.viewOnWorkingNotification = viewOnWorkingNotification;
	}
	
	public IViewOnworking getViewOnWorkingNotification() {
		return viewOnWorkingNotification;
	}
	
	public void setRouteController(RouteController routeController) {
		this.routeController = routeController;
	}
	
	//-----------ViewOnWorking calls PresentationStarter
	public void clickOK() {
		routeController.setCurrentView(viewOnWorkingNotification);		
		routeController.notifyBackToStarter();
	}
}
