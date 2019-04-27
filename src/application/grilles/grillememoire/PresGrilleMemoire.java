package application.grilles.grillememoire;

import application.grilles.grilleplacement.IViewGrillePlacement;

public class PresGrilleMemoire {

	private ModelGrilleMemoire modelGrilleMemoire;
	private IViewGrilleMemoire viewGrilleMemoire;
	
	public PresGrilleMemoire() {
		// TODO Auto-generated constructor stub
	}
	
	public void setView(final IViewGrilleMemoire viewGrilleMemoire) {
		this.viewGrilleMemoire = viewGrilleMemoire;
	}
}
