package fr.ensma.a3.ia.TPBatailleNavale.mvpCase;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class VueCase extends StackPane implements EventHandler<MouseEvent> {

	private final PresCase presCase;
	private final Rectangle square;
	private final Text text;

	public VueCase(PresCase presCase) {
		this.presCase = presCase;
		square = new Rectangle();
		text = new Text("...");
		this.getChildren().addAll(square, text);
	}

	public void handle(MouseEvent arg0) {
		presCase.actionClick();		
	}

	public void notifValeur() {

	}

	public PresCase getPresCase() {
		return presCase;
	}

	public Rectangle getSquare() {
		return square;
	}

	public Text getText() {
		return text;
	}
	
	
}

