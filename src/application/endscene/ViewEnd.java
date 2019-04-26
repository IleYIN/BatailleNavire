package application.endscene;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewEnd extends VBox implements IViewEnd{
	
	private PresentationEnd presEnd;

	private Stage parent;
	private Scene nextScene;
	
	private String info;
	private Label informWinnerLab;
	private Button playAgainBtn, menuBtn, quitBtn;
	
	public ViewEnd(final PresentationEnd pres) {
		presEnd = pres;
		
		informWinnerLab = new Label(info);
		playAgainBtn = new Button("Play Again");
		menuBtn = new Button("Menu");
		quitBtn = new Button("Quit");
			
	}
	
	public void setStage(Stage parent) {
		this.parent = parent;
	}
	
	public void informWinner(String info) {
		this.info = info;
	}
}
