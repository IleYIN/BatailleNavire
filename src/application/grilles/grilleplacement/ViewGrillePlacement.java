package application.grilles.grilleplacement;

import application.caze.PresentationCaze;
import application.caze.ViewCaze;
import javafx.scene.layout.GridPane;

public class ViewGrillePlacement extends GridPane implements IViewGrillePlacement{

	private PresGrillePlacement presGP;
	
	private ViewCaze[][] viewCaze;
	private PresentationCaze[][] presCaze;
	private static int numberOfCaze = 10;
	
	public ViewGrillePlacement(final PresGrillePlacement presGP) {
		this.presGP = presGP;
		
		viewCaze = new ViewCaze[numberOfCaze][numberOfCaze];
		presCaze = new PresentationCaze[numberOfCaze][numberOfCaze];
		for(int i = 0; i<numberOfCaze; i ++) {
			for(int j = 0; j<numberOfCaze; j++) {
				presCaze[i][j] = new PresentationCaze();
				viewCaze[i][j] = new ViewCaze(presCaze[i][j]);
				presCaze[i][j].setView(viewCaze[i][j]);
				add(viewCaze[i][j], i, j);
			}
		}
	}

	@Override
	public void drawInitAllShips() {
		for(int i = 0; i<numberOfCaze; i ++) {
			for(int j = 0; j<numberOfCaze; j++) {
				viewCaze[i][j].drawInit(viewCaze[i][j].getGraphicsContext2D());
				viewCaze[i][j].drawSquare(viewCaze[i][j].getGraphicsContext2D());
//				System.out.println("true");
			}
		}
	}
	
	@Override
	public void drawOcean(int posX, int posY) {
		viewCaze[posX][posY].drawInit(viewCaze[posX][posY].getGraphicsContext2D());
		viewCaze[posX][posY].drawSquare(viewCaze[posX][posY].getGraphicsContext2D());
	}
	
	@Override
	public void drawTorpilleurShip(int posX, int posY) {
		viewCaze[posX][posY].drawTorpilleur(viewCaze[posX][posY].getGraphicsContext2D());
	}

	@Override
	public void drawSousMarinShip(int posX, int posY) {
		viewCaze[posX][posY].drawSousMarin(viewCaze[posX][posY].getGraphicsContext2D());
		
	}

	@Override
	public void drawContreTorpilleurShip(int posX, int posY) {
		viewCaze[posX][posY].drawContreTorpilleur(viewCaze[posX][posY].getGraphicsContext2D());
		
	}

	@Override
	public void drawPorteAvionShip(int posX, int posY) {
		viewCaze[posX][posY].drawPorteAvion(viewCaze[posX][posY].getGraphicsContext2D());
		
	}

	@Override
	public void drawCroisseurShip(int posX, int posY) {
		viewCaze[posX][posY].drawCroisseur(viewCaze[posX][posY].getGraphicsContext2D());
		
	}
}
