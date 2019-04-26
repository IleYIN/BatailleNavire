package application;
	
import application.controller.RouteController;
import application.endscene.PresentationEnd;
import application.endscene.ViewEnd;
import application.exceptionscenes.PresentationOnWorkingNotification;
import application.exceptionscenes.ViewOnWorkingNotification;
import application.placementscene.PresentationPlacementScene;
import application.placementscene.ViewPlacementScene;
import application.playscene.PresentationPlayScene;
import application.playscene.ViewPlayScene;
import application.startscene.PresentationStarter;
import application.startscene.ViewStarter;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * There are 3 important classes :
 * - this class (Main.java)
 * - RouteController.java (in controller package)
 * - LogicalController.java (I create in noyauFonction part)
 * 
 * @author tranv
 *
 */

public class Main extends Application {
	
	Stage window;
	Scene startscene, placementscene, playscene, endscene, onworkingscene;
	
	ViewStarter viewStarter;
	ViewPlacementScene viewPlacementScene;
	ViewPlayScene viewPLayScene;
	ViewEnd viewEnd;
	ViewOnWorkingNotification viewOnWorking;
	
	PresentationStarter presStarter;
	PresentationPlacementScene presPlacementScene;
	PresentationPlayScene presPlayScene;
	PresentationEnd presEnd;
	PresentationOnWorkingNotification presOnWorking;
	
	RouteController routeController;
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Bataille Navale Jeux");
		
		// Initialize Layouts
		presStarter = new PresentationStarter();
		viewStarter = new ViewStarter(presStarter);
		viewStarter.setStage(window);
		presStarter.setView(viewStarter);
		
		presPlacementScene = new PresentationPlacementScene();
		viewPlacementScene = new ViewPlacementScene(presPlacementScene);
		viewPlacementScene.setStage(window);		
		presPlacementScene.setView(viewPlacementScene);
		
		presPlayScene = new PresentationPlayScene();
		viewPLayScene = new ViewPlayScene(presPlayScene);
		viewPLayScene.setStage(window);
		presPlayScene.setView(viewPLayScene);
		
		presEnd = new PresentationEnd();
		viewEnd = new ViewEnd(presEnd);
		viewEnd.setStage(window);
		presEnd.setView(viewEnd);
		
		presOnWorking = new PresentationOnWorkingNotification();
		viewOnWorking = new ViewOnWorkingNotification(presOnWorking);
		viewOnWorking.setStage(window);
		presOnWorking.setView(viewOnWorking);
		
		// Initialize Scenes
		startscene = new Scene(viewStarter, 300, 200);
		placementscene = new Scene(viewPlacementScene, 540, 460);
		playscene = new Scene(viewPLayScene, 560, 600);
		endscene = new Scene(viewEnd, 300, 200);
		
		onworkingscene = new Scene(viewOnWorking, 300, 200);
		
		// Initialize RouteController and set relations with Presentation views
		routeController = new RouteController(this);
		routeController.setPresStarter(presStarter);
		routeController.setPresPlacement(presPlacementScene);
		routeController.setPresPlay(presPlayScene);
		routeController.setPresEnd(presEnd);
		routeController.setPresOnWorking(presOnWorking);
		presStarter.setRouteController(routeController);
		presPlacementScene.setRouteController(routeController);
		presPlayScene.setRouteController(routeController);
		presEnd.setRouteController(routeController);
		presOnWorking.setRouteController(routeController);
		
		// Set relation between Views and RouteController
		/* TODO */
		
		window.setScene(startscene);
		window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void setScene() {
		if(this.routeController.getCurrentView().equals("ViewStarter")) {
			this.window.setScene(startscene);
		};
		if(this.routeController.getCurrentView().equals("ViewPlacementScene")) {
			this.window.setScene(placementscene);
		};
		if(this.routeController.getCurrentView().equals("ViewPlayScene")) {
			this.window.setScene(playscene);
		};
		if(this.routeController.getCurrentView().equals("ViewEnd")) {
			this.window.setScene(endscene);
		};
		if(this.routeController.getCurrentView().equals("ViewOnWorkingNotification")) {			
			this.window.setScene(onworkingscene);
		};
	}
}
