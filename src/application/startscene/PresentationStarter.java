package application.startscene;

import application.controller.RouteController;
import application.startscene.automate.EtatOffline;
import application.startscene.automate.EtatOnline;
import application.startscene.automate.EtatSinglePlayer;
import application.startscene.automate.EtatVide;
import application.startscene.automate.IEtatStarter;
import application.startscene.automate.StarterException;

public class PresentationStarter {
	
	private ModelStarter modelStarter;
	private IViewStarter viewStarter;

	private IEtatStarter etatCourant;
	private IEtatStarter etatVide;
	private IEtatStarter etatSinglePlayer;
	private IEtatStarter etatOffline;
	private IEtatStarter etatOnline;
	
	private RouteController routeController;
	
	public PresentationStarter() {
		modelStarter = new ModelStarter();
		
		etatVide = new EtatVide(this, modelStarter);
		etatSinglePlayer = new EtatSinglePlayer(this, modelStarter);
		etatOffline = new EtatOffline(this, modelStarter);
		etatOnline = new EtatOnline(this, modelStarter);
		etatCourant = etatVide;
	}
	
	public void setView(IViewStarter viewStarter) {
		this.viewStarter = viewStarter;
	}
	
	public IViewStarter getViewStarter() {
		return viewStarter;
	}
	
	public void setRouteController(RouteController routeController) {
		this.routeController = routeController;
	}
	
	//----------Gestion Automate
	public void setEtatCourant(IEtatStarter etatCourant) {
		this.etatCourant = etatCourant;
	}
	
	public IEtatStarter getEtatCourant() {
		return etatCourant;
	}

	public IEtatStarter getEtatSinglePlayer() {
		return etatSinglePlayer;
	}
	
	public IEtatStarter getEtatOffline() {
		return etatOffline;
	}
	
	public IEtatStarter getEtatOnline() {
		return etatOnline;
	}
	
	public IEtatStarter getEtatVide() {
		return etatVide;
	}
	
	//-----------ViewStarter calls PresentationStarter
	public void clickSinglePlayer() {
		try {
			etatCourant.clickSinglePlayer();
			routeController.setCurrentView(viewStarter);
			routeController.setCurrentEtat(etatSinglePlayer);
			routeController.notifyStartGame();
		} catch (StarterException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOffline() {
		try {
			etatCourant.clickOffline();
			routeController.setCurrentView(viewStarter);
			routeController.setCurrentEtat(etatOffline);
			routeController.notifyStartGame();
		} catch (StarterException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnline() {
		try {
			etatCourant.clickSOnline();
			routeController.setCurrentView(viewStarter);
			routeController.setCurrentEtat(etatOnline);
			routeController.notifyStartGame();
		} catch (StarterException e) {
			e.printStackTrace();
		}
	}
	
	//---------RouteController calls PresentationStarter
	public void backToEtatVide() {
		try {
			etatCourant.backToEtatVide();
			// TODO
		} catch (StarterException e) {
			e.printStackTrace();
		}
	}
}
