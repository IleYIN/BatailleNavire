package application.startscene.automate;

import application.startscene.ModelStarter;
import application.startscene.PresentationStarter;

public abstract class AbstractEtatStarter implements IEtatStarter{

	protected PresentationStarter pres;
	protected ModelStarter model;
	
	public AbstractEtatStarter(final PresentationStarter pres, final ModelStarter model) {
		this.pres = pres;
		this.model = model;
	}
	
	public ModelStarter getModel() {
		return model;
	}
	
	@Override
	public void clickSinglePlayer() throws StarterException {
		throw new StarterException();
	}
	
	@Override
	public void clickOffline() throws StarterException {
		throw new StarterException();
	}
	
	@Override
	public void clickSOnline() throws StarterException {
		throw new StarterException();
	}
	
	@Override
	public void backToEtatVide() throws StarterException {
		throw new StarterException();
	}
}
