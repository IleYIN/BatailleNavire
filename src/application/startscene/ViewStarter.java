package application.startscene;

import application.placementscene.PresentationPlacementScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewStarter extends VBox implements IViewStarter{
	
	private PresentationStarter presStarter;
	
	private Stage parent;
	
	private Label labWelcome;
	private Button singlePlayerBtn, offlineMultiBtn, onlineMultiBtn;
	
	public ViewStarter(final PresentationStarter pres) {
		presStarter = pres;
		
		labWelcome = new Label("Welcome to Bataille Navale!!!");
		singlePlayerBtn = new Button("Single Player");
		offlineMultiBtn = new Button("Offline MultiPlayer");
		onlineMultiBtn = new Button("Online MultiPlayer");
		getChildren().addAll(labWelcome, singlePlayerBtn, offlineMultiBtn, onlineMultiBtn);
		
		setMinWidth(200d);
		setSpacing(30);
		setAlignment(Pos.CENTER);
		
		singlePlayerBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				presStarter.clickSinglePlayer();	
			}
		});
		
		offlineMultiBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				presStarter.clickOffline();	
			}
		});
		
		onlineMultiBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				presStarter.clickOnline();			
			}
		});
	}
	
	public void setStage(Stage parent) {
		this.parent = parent;
	}
	
}
