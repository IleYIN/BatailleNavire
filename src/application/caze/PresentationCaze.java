package application.caze;

public class PresentationCaze {
	
	private ModelCaze modelCaze;
	private IViewCaze viewCaze;
	
	public PresentationCaze() {
		// TODO Auto-generated constructor stub
	}

	public void setView(final IViewCaze viewCaze) {
		this.viewCaze = viewCaze;
	}
}
