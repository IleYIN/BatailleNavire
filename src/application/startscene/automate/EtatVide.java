package application.startscene.automate;

import java.util.logging.Logger;

import application.startscene.ModelStarter;
import application.startscene.PresentationStarter;

public class EtatVide extends AbstractEtatStarter{
	
	private Logger LOGGER = Logger.getLogger(EtatVide.class.getName());

	public EtatVide(PresentationStarter pres, ModelStarter model) {
		super(pres, model);
	}
	
	@Override
	public void clickSinglePlayer() throws StarterException {
		pres.setEtatCourant(pres.getEtatSinglePlayer());
		// model part
		LOGGER.info("Pass to EtatSinglePlayer");
	}
	
	@Override
	public void clickOffline() throws StarterException {
		pres.setEtatCourant(pres.getEtatOffline());
		// model part
		LOGGER.info("Pass to EtatOffline");
	}
	
	@Override
	public void clickSOnline() throws StarterException {
		pres.setEtatCourant(pres.getEtatOnline());
		// model part
		LOGGER.info("Pass to EtatOnline");
	}

}
