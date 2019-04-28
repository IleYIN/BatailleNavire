package application.playscene.automate;

import java.util.logging.Logger;

import application.playscene.ModelPLayScene;
import application.playscene.PresentationPlayScene;

public class EtatChosenShip extends AbstractEtatPlayScene{

	private Logger LOGGER = Logger.getLogger(EtatChosenShip.class.getName());
	
	public EtatChosenShip(PresentationPlayScene pres, ModelPLayScene model) {
		super(pres, model);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void shoot() throws PlaySceneException {
		pres.setEtatCourant(pres.getEtatAttacked());
		LOGGER.info("Pass to EtatAttacked");
	}

}
