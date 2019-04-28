package application.playscene;

public class ModelPLayScene {
	
	private String chosenAction;
	// "Normal Attack", "Cross Attack", "Flare Shot", "Shift Ship", "Rotate Ship"
	
	public ModelPLayScene() {
		chosenAction = "Normal Attack";
	}
	
	public void setChosenAction(String chosenAction) {
		this.chosenAction = chosenAction;
	}
	
	public String getChosenAction() {
		return chosenAction;
	}
}
