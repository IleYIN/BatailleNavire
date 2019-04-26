package application.exceptionscenes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewOnWorkingNotification extends VBox implements IViewOnworking{	
	
	private PresentationOnWorkingNotification presOnWorkingNotification;
	
	private Stage parent;
	
	private Label notifLab;
	private Button returnBtn;
	
	public ViewOnWorkingNotification(final PresentationOnWorkingNotification pres) {
		presOnWorkingNotification = pres;
		
		notifLab = new Label("This part is still on working process!");
		returnBtn = new Button("OK");		
		getChildren().addAll(notifLab, returnBtn);
		
		setMinWidth(200d);
		setSpacing(30);
		setAlignment(Pos.CENTER);
		
		returnBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				presOnWorkingNotification.clickOK();		
			}
		});
	}
	
	public void setStage(Stage parent) {
		this.parent = parent;
	}
	
}
