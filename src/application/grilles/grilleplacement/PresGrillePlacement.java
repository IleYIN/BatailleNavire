package application.grilles.grilleplacement;

import java.util.List;
import java.util.logging.Logger;

import application.caze.PresentationCaze;
import application.grilles.IPresGrille;
import application.playscene.PresentationPlayScene;

public class PresGrillePlacement implements IPresGrille{

	private ModelGrillePlacement modelGrillePlacement;
	private IViewGrillePlacement viewGrillePlacement;
	
	private	PresentationPlayScene presPlayScene;
	
	private final static Logger LOGGER = Logger.getLogger(PresGrillePlacement.class.getName());
	
	public PresGrillePlacement() {
		modelGrillePlacement = new ModelGrillePlacement();
	}
	
	public void setView(final IViewGrillePlacement viewGrillePlacement) {
		this.viewGrillePlacement = viewGrillePlacement;
	}
	
	public PresentationPlayScene getPresPlayScene() {
		return presPlayScene;
	}
	
	public void setPresPlayScene(PresentationPlayScene presPlayScene) {
		this.presPlayScene = presPlayScene;
	}

	@Override
	public void chosenCase(int posX, int posY) {
		if(presPlayScene != null) {
			modelGrillePlacement.setChosenX(posX);
			modelGrillePlacement.setChosenY(posY);
			presPlayScene.chosenCasePlacement(modelGrillePlacement.getChosenX(), modelGrillePlacement.getChosenY());
		}		
	}
}
