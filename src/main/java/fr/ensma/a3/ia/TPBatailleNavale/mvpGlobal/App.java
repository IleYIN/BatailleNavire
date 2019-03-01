package fr.ensma.a3.ia.TPBatailleNavale.mvpGlobal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	private PresGlobal presGlobal = new PresGlobal();
	
	@Override
	public void start(Stage primaryStage) {
		VueGlobal root = new VueGlobal(presGlobal);
		
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setTitle("Bataille Navale");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
