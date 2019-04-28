package application.playscene.automate;

import application.controller.IEtat;

public interface IEtatPlayScene extends IEtat{
	public void leadTo() throws PlaySceneException;
	public void chooseShip() throws PlaySceneException;
	public void shoot() throws PlaySceneException;
	public void end() throws PlaySceneException;
}
