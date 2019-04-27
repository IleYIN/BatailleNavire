package application.grilles.grillememoire;

import application.grilles.IPresGrille;
import application.playscene.PresentationPlayScene;

public class PresGrilleMemoire implements IPresGrille{

	private ModelGrilleMemoire modelGrilleMemoire;
	private IViewGrilleMemoire viewGrilleMemoire;
	
	private	PresentationPlayScene presPlayScene;
	
	public PresGrilleMemoire() {
		// TODO Auto-generated constructor stub
	}
	
	public void setView(final IViewGrilleMemoire viewGrilleMemoire) {
		this.viewGrilleMemoire = viewGrilleMemoire;
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
