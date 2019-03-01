package fr.ensma.a3.ia.TPBatailleNavale.mvpGlobal;

import fr.ensma.a3.ia.TPBatailleNavale.mvpCase.PresCase;
import fr.ensma.a3.ia.TPBatailleNavale.mvpCase.VueCase;
import javafx.scene.layout.GridPane;

public class VueGlobal extends GridPane implements IVueGlobal {
	
	private PresGlobal presGlobal;
	private PresCase[][] presCases;
	private VueCase [][] vueCases;
	private final int taille;
	

	public VueGlobal(final PresGlobal presGlobal) {
		
		this.presGlobal = presGlobal;
		this.taille = presGlobal.getModel().getHumain().getGrillem().getTaille();
		this.presCases = new PresCase[taille][taille];
		this.vueCases = new VueCase[taille][taille];
		
		for(int i=0; i<taille; i++) {
			for(int j=0; j<taille; j++) {
				
				presCases[i][j] = new PresCase(presGlobal.getModel().getHumain().getCase(i, j));
				presCases[i][j].subscribeGlobal(presGlobal);
								
				vueCases[i][j] = new VueCase(presCases[i][j]);
				
				this.add(vueCases[i][j], i, j);
				
				vueCases[i][j].getSquare().widthProperty().bind(this.widthProperty().divide(taille));
				vueCases[i][j].getSquare().heightProperty().bind(this.heightProperty().divide(taille));
				
			}
		}
	}

}
