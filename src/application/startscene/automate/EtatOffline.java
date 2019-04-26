package application.startscene.automate;

import java.util.logging.Logger;

import application.startscene.ModelStarter;
import application.startscene.PresentationStarter;

public class EtatOffline extends AbstractEtatStarter{
	
	private Logger LOGGER = Logger.getLogger(EtatOffline.class.getName());

	public EtatOffline(PresentationStarter pres, ModelStarter model) {
		super(pres, model);
	}
	
	@Override
	public void backToEtatVide() throws StarterException {
		pres.setEtatCourant(pres.getEtatVide());
		// model part
		LOGGER.info("Pass to EtatVide");
	}

}
