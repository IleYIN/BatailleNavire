package application.startscene.automate;

import java.util.logging.Logger;

import application.startscene.ModelStarter;
import application.startscene.PresentationStarter;

public class EtatOnline extends AbstractEtatStarter{
	
	private Logger LOGGER = Logger.getLogger(EtatOnline.class.getName());

	public EtatOnline(PresentationStarter pres, ModelStarter model) {
		super(pres, model);
	}

	@Override
	public void backToEtatVide() throws StarterException {
		pres.setEtatCourant(pres.getEtatVide());
		// model part
		LOGGER.info("Pass to EtatVide");
	}
}
