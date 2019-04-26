package application.placementscene.automate;

import application.placementscene.ModelPlacementScene;
import application.placementscene.PresentationPlacementScene;

public abstract class AbstractEtatPlmtScene implements IEtatPlmtScene{

	protected PresentationPlacementScene pres;
	protected ModelPlacementScene model;
	
	public AbstractEtatPlmtScene(final PresentationPlacementScene pres, final ModelPlacementScene model) {
		this.pres = pres;
		this.model = model;
	}
	public ModelPlacementScene getModel() {
		return model;
	}
	
	@Override
	public void leadTo() throws PlmtSceneException {
		throw new PlmtSceneException();		
	}
	
	@Override
	public void clickedNext() throws PlmtSceneException {
		throw new PlmtSceneException();		
	}
	
	@Override
	public void clickedBack() throws PlmtSceneException {
		throw new PlmtSceneException();		
	}
}
