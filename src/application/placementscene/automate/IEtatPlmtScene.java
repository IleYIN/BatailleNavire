package application.placementscene.automate;

import application.controller.IEtat;

public interface IEtatPlmtScene extends IEtat{
	void leadTo() throws PlmtSceneException;
	void clickedNext() throws PlmtSceneException;
	//void clickedAuto() throws PlmtSceneException;
	void clickedBack() throws PlmtSceneException;
}
