package application.playscene.automate;

import java.util.logging.Logger;

import application.playscene.ModelPLayScene;
import application.playscene.PresentationPlayScene;


public class EtatSleepingPlay extends AbstractEtatPlayScene{

	private Logger LOGGER = Logger.getLogger(EtatSleepingPlay.class.getName());
	
	public EtatSleepingPlay(PresentationPlayScene pres, ModelPLayScene model) {
		super(pres, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void chooseShip() throws PlaySceneException {
		pres.setEtatCourant(pres.getEtatChosenShip());
		LOGGER.info("Pass to EtatChosenShip");
	}
}
