package application.placementscene.automate;

import java.util.logging.Logger;

import application.placementscene.ModelPlacementScene;
import application.placementscene.PresentationPlacementScene;

public class EtatPlayer2Place extends AbstractEtatPlmtScene{

	private Logger LOGGER = Logger.getLogger(EtatPlayer2Place.class.getName());
	
	public EtatPlayer2Place(PresentationPlacementScene pres, ModelPlacementScene model) {
		super(pres, model);
	}
	
	@Override
	public void clickedNext() throws PlmtSceneException {
		pres.setEtatCourant(pres.getEtatPassed());
		model.setPlayer(3);
		LOGGER.info("Pass to EtatPassed");
	}
	
	@Override
	public void clickedBack() throws PlmtSceneException {
		pres.setEtatCourant(pres.getEtatSleeping());
		model.setPlayer(0);
		LOGGER.info("Pass to EtatSleeping");
	}
}
