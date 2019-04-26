package application.grilles.grilleplacement;

public interface IViewGrillePlacement {
	public void drawInitAllShips();
	
	public void drawOcean(int posX, int posY);
	public void drawTorpilleurShip(int posX, int posY);
	public void drawSousMarinShip(int posX, int posY);
	public void drawContreTorpilleurShip(int posX, int posY);
	public void drawPorteAvionShip(int posX, int posY);
	public void drawCroisseurShip(int posX, int posY);
	
}
