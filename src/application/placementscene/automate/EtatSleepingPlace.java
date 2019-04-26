package application.placementscene.automate;

import java.util.logging.Logger;

import application.placementscene.ModelPlacementScene;
import application.placementscene.PresentationPlacementScene;

public class EtatSleepingPlace extends AbstractEtatPlmtScene{
	
	private Logger LOGGER = Logger.getLogger(EtatSleepingPlace.class.getName());
	
	public EtatSleepingPlace(PresentationPlacementScene pres, ModelPlacementScene model) {
		super(pres, model);		
	}
	
//	@Override
//	public void clickedNext() throws PlmtSceneException {
//		pres.setEtatCourant(pres.getEtatPlayer1());
//		model.setPlayer(1);
//		LOGGER.info("Pass to EtatPlayer1");
//	}
	
	@Override
	public void leadTo() throws PlmtSceneException {
		pres.setEtatCourant(pres.getEtatPlayer1());
		LOGGER.info("Pass to EtatPlayer1");
	}
}
