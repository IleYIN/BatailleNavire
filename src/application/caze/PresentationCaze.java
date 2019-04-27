package application.caze;

import application.grilles.IPresGrille;

public class PresentationCaze {
	
	private ModelCaze modelCaze;
	private IViewCaze viewCaze;
	
	private IPresGrille presGrille;
	
	public PresentationCaze(int posX, int posY) {
		modelCaze = new ModelCaze(posX, posY);
	}

	public void setView(final IViewCaze viewCaze) {
		this.viewCaze = viewCaze;
	}
	
	public ModelCaze getModelCaze() {
		return modelCaze;
	}
	
	public void setPresGrille(IPresGrille presGrille) {
		this.presGrille = presGrille;
	}
}
