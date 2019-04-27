package application.caze;

public class PresentationCaze {
	
	private ModelCaze modelCaze;
	private IViewCaze viewCaze;
	
	public PresentationCaze(int posX, int posY) {
		modelCaze = new ModelCaze(posX, posY);
	}

	public void setView(final IViewCaze viewCaze) {
		this.viewCaze = viewCaze;
	}
	
	public ModelCaze getModelCaze() {
		return modelCaze;
	}
}
