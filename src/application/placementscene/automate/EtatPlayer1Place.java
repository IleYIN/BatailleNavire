package application.placementscene.automate;

import java.util.logging.Logger;

import application.placementscene.ModelPlacementScene;
import application.placementscene.PresentationPlacementScene;

public class EtatPlayer1Place extends AbstractEtatPlmtScene{

	private Logger LOGGER = Logger.getLogger(EtatPlayer1Place.class.getName());
	
	public EtatPlayer1Place(PresentationPlacementScene pres, ModelPlacementScene model) {
		super(pres, model);
	}
	
	@Override
	public void clickedNext() throws PlmtSceneException {
		pres.setEtatCourant(pres.getEtatPlayer2());
		model.setPlayer(2);
		LOGGER.info("Pass to EtatPlayer2");
	}
	
	@Override
	public void clickedBack() throws PlmtSceneException {
		pres.setEtatCourant(pres.getEtatSleeping());
		model.setPlayer(0);
		LOGGER.info("Pass to EtatSleeping");
	}

}
