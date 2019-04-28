package application.playscene.automate;

import application.playscene.ModelPLayScene;
import application.playscene.PresentationPlayScene;

public abstract class AbstractEtatPlayScene implements IEtatPlayScene{

	protected PresentationPlayScene pres;
	protected ModelPLayScene model;
	
	public AbstractEtatPlayScene(final PresentationPlayScene pres, final ModelPLayScene model) {
		this.pres = pres;
		this.model = model;
	}
	public ModelPLayScene getModel() {
		return model;
	}
	
	@Override
	public void leadTo() throws PlaySceneException {
		throw new PlaySceneException();	
	}
	
	@Override
	public void chooseShip() throws PlaySceneException {
		throw new PlaySceneException();	
	}
	
	@Override
	public void shoot() throws PlaySceneException {
		throw new PlaySceneException();	
	}
	
	@Override
	public void end() throws PlaySceneException {
		throw new PlaySceneException();	
	}
}
