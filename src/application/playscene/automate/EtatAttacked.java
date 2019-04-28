package application.playscene.automate;

import java.util.logging.Logger;

import application.playscene.ModelPLayScene;
import application.playscene.PresentationPlayScene;

public class EtatAttacked extends AbstractEtatPlayScene{

	private Logger LOGGER = Logger.getLogger(EtatAttacked.class.getName());
	
	public EtatAttacked(PresentationPlayScene pres, ModelPLayScene model) {
		super(pres, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void leadTo() throws PlaySceneException {
		pres.setEtatCourant(pres.getEtatSleeping());
		LOGGER.info("Pass to EtatSleepingPlay");
	}
	
	@Override
	public void end() throws PlaySceneException {
		pres.setEtatCourant(pres.getEtatEndGame());
		LOGGER.info("Pass to EtatEndGame");
	}
}
