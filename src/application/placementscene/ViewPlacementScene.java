package application.placementscene;

import application.grilles.grilleplacement.PresGrillePlacement;
import application.grilles.grilleplacement.ViewGrillePlacement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ViewPlacementScene extends VBox implements IViewPlacementScene {
	
	private PresentationPlacementScene presPlacementScene;
	
	private Stage parent;
	
	private Label infoLabel;
	private Label instructionLabel;
	private PresGrillePlacement presGrillePlacement;
	private ViewGrillePlacement grillePlacement;
	private Label inforShipsLabel;
	private ListView<String> shiplist = new ListView<>();
	private ObservableList<String> shiptype =FXCollections.observableArrayList (
	    "Porte Avion", "Croiseur", "Contre Torpilleur", "Sous-Marin", "Torpilleur");
	private Button btnHorizontal;
	private VBox listBox;
	private HBox contentBox;
	private Button nextBtn, autoBtn, returnBtn;
	private HBox buttonBox;
	
	public ViewPlacementScene(final PresentationPlacementScene pres) {
		presPlacementScene = pres;
		
		infoLabel = new Label("Player 1 organizes his ships");
		instructionLabel = new Label("Click 'Auto Place' to place your ships");
		presGrillePlacement = new PresGrillePlacement();
		grillePlacement = new ViewGrillePlacement(presGrillePlacement);
		presGrillePlacement.setView(grillePlacement);
		inforShipsLabel = new Label("Ships to be placed");
		inforShipsLabel.setPrefHeight(25);
		shiplist = new ListView<>();
		shiplist.setItems(shiptype);
		shiplist.setOrientation(Orientation.VERTICAL);
		shiplist.setPrefHeight(200);
		shiplist.setPrefWidth(250);
		btnHorizontal = new Button("Set Horizontal");
		btnHorizontal.setDisable(true);
		listBox= new VBox();
		listBox.setAlignment(Pos.CENTER);;
		listBox.getChildren().addAll(inforShipsLabel, shiplist, btnHorizontal);
		contentBox = new HBox();
		contentBox.setSpacing(30);
		contentBox.getChildren().addAll(grillePlacement, listBox);
		nextBtn = new Button("Next");
		autoBtn = new Button("Auto Place");
		returnBtn = new Button("Back");
		nextBtn.setDisable(true);
		buttonBox = new HBox();
		buttonBox.setSpacing(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(nextBtn, autoBtn, returnBtn);

		getChildren().addAll(infoLabel, instructionLabel, contentBox, buttonBox);
		
		setMinWidth(2000);
		setMinHeight(1000d);
		setSpacing(30);
		setAlignment(Pos.CENTER);

		autoBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				presPlacementScene.clickedAuto();
			}
		});
		
		returnBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				presPlacementScene.clickedBack();				
			}
		});
		
		// Not active in this version
		btnHorizontal.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void setStage(Stage parent) {
		this.parent = parent;
	}

	@Override
	public void notifyDrawInitAllShips() {
		this.grillePlacement.drawInitAllShips();
	}
	
	@Override
	public void notifyDrawOcean(int posX, int posY) {
		this.grillePlacement.drawOcean( posX, posY);
	}
	
	@Override
	public void notifyDrawTorpilleurShip(int posX, int posY) {
		this.grillePlacement.drawTorpilleurShip(posX, posY);	
	}

	@Override
	public void notifyDrawSousMarinShip(int posX, int posY) {
		this.grillePlacement.drawSousMarinShip(posX, posY);
		
	}

	@Override
	public void notifyDrawContreTorpilleurShip(int posX, int posY) {
		this.grillePlacement.drawContreTorpilleurShip(posX, posY);
		
	}

	@Override
	public void notifyDrawPorteAvionShip(int posX, int posY) {
		this.grillePlacement.drawPorteAvionShip(posX, posY);
		
	}

	@Override
	public void notifyDrawCroisseurShip(int posX, int posY) {
		this.grillePlacement.drawCroisseurShip(posX, posY);
		
	}
	
	@Override
	public void notifyStopAutoPlace(){
		autoBtn.setDisable(true);
		nextBtn.setDisable(false);
		
		nextBtn.setOnAction(new EventHandler<ActionEvent>() {		
			@Override
			public void handle(ActionEvent event) {			
				if(presPlacementScene.getModel().getPlayer()==1) {
					infoLabel.setText("Player 2 organizes his ships");
				} else {
					
				}
				presPlacementScene.clickedNext();
			}
		});
		returnBtn.setDisable(true);
		instructionLabel.setText("Click 'Next' to play");
	}
}