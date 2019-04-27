package application.grilles.grilleplacement;

import application.grilles.IPresGrille;
import application.playscene.PresentationPlayScene;

public class PresGrillePlacement implements IPresGrille{

	private ModelGrillePlacement modelGrillePlacement;
	private IViewGrillePlacement viewGrillePlacement;
	
	private	PresentationPlayScene presPlayScene;
	
	public PresGrillePlacement() {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		
	}
}
