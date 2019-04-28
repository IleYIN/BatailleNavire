package application.playscene;

import application.grilles.grillememoire.PresGrilleMemoire;
import application.grilles.grillememoire.ViewGrilleMemoire;
import application.grilles.grilleplacement.PresGrillePlacement;
import application.grilles.grilleplacement.ViewGrillePlacement;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewPlayScene extends VBox implements IViewPlayScene{
	
	private PresentationPlayScene presPlayScene;

	private Stage parent;
	
	private Label playerLabel, infoLabel, placementLabel, memoireLabel, actionLabel, bonusLabel;
	private PresGrillePlacement presGrillePlacement;
	private ViewGrillePlacement grillePlacement;
	private PresGrilleMemoire presGrilleMemoire;
	private ViewGrilleMemoire grilleMemoire;
	private ObservableList<String> stringActionList
    = FXCollections.observableArrayList("Normal Attack", "Cross Attack", "Flare Shot", "Shift Ship", "Rotate Ship");
	private ChoiceBox<String> actionList;
	private Button improveBtn;
	private VBox leftBox, rightBox;
	private HBox grillesBox;
	
	public ViewPlayScene(final PresentationPlayScene pres) {
		presPlayScene = pres;
		
		playerLabel = new Label("Player 1 begins his turn");
		infoLabel = new Label("Choose an action below to begin your turn");
		
		placementLabel = new Label("Grille Placement");
		presGrillePlacement = new PresGrillePlacement();
		grillePlacement = new ViewGrillePlacement(presGrillePlacement);
		presGrillePlacement.setView(grillePlacement);
		presPlayScene.setPresGrillePlacement(presGrillePlacement);
		presGrillePlacement.setPresPlayScene(presPlayScene);
		actionLabel = new Label("Actions");
		actionList = new ChoiceBox(stringActionList);
		actionList.setValue("Normal Attack");
		
		leftBox = new VBox(placementLabel, grillePlacement, actionLabel, actionList);
		leftBox.setSpacing(20);
		leftBox.setAlignment(Pos.CENTER);
		
		memoireLabel = new Label("Grille Memoire");
		presGrilleMemoire = new PresGrilleMemoire();
		grilleMemoire = new ViewGrilleMemoire(presGrilleMemoire);
		presGrilleMemoire.setView(grilleMemoire);
		presPlayScene.setPresGrilleMemoire(presGrilleMemoire);
		presGrilleMemoire.setPresPlayScene(presPlayScene);
		bonusLabel = new Label("Bonus");
		improveBtn = new Button("Improve Defense");
		improveBtn.setDisable(true);
		
		rightBox = new VBox(memoireLabel, grilleMemoire, bonusLabel, improveBtn);
		rightBox.setSpacing(20);
		rightBox.setAlignment(Pos.CENTER);
		
		grillesBox = new HBox(leftBox, rightBox);
		grillesBox.setSpacing(30);		
		getChildren().addAll(playerLabel, infoLabel, grillesBox);
		
		setSpacing(30);
		setAlignment(Pos.CENTER);	
		
		ChangeListener<String> changeActionListener = new ChangeListener<String>() {
			@Override
        	public void changed(ObservableValue<? extends String> observable, 
                	String oldValue, String newValue) {
            	if (newValue != null) {
            		System.out.println(newValue);
            		presPlayScene.changePlayAction(newValue);
            	}
        	}
		};
		actionList.getSelectionModel().selectedItemProperty().addListener(changeActionListener);
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

}
