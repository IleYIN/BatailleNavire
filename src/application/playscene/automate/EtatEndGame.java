package application.playscene.automate;

import java.util.logging.Logger;

import application.playscene.ModelPLayScene;
import application.playscene.PresentationPlayScene;

public class EtatEndGame extends AbstractEtatPlayScene {

	private Logger LOGGER = Logger.getLogger(EtatEndGame.class.getName());
	
	public EtatEndGame(PresentationPlayScene pres, ModelPLayScene model) {
		super(pres, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void leadTo() throws PlaySceneException {
		pres.setEtatCourant(pres.getEtatSleeping());
		LOGGER.info("Pass to EtatSleepingPlay");
	}
}
