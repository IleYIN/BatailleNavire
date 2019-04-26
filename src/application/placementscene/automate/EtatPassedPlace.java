package application.placementscene.automate;

import java.util.logging.Logger;

import application.placementscene.ModelPlacementScene;
import application.placementscene.PresentationPlacementScene;

public class EtatPassedPlace extends AbstractEtatPlmtScene{

	private Logger LOGGER = Logger.getLogger(EtatPassedPlace.class.getName());
	
	public EtatPassedPlace(PresentationPlacementScene pres, ModelPlacementScene model) {
		super(pres, model);
		
	}

}
