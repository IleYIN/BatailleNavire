package application.startscene.automate;

import application.controller.IEtat;

public interface IEtatStarter extends IEtat{
	void clickSinglePlayer() throws StarterException;
	void clickOffline() throws StarterException;
	void clickSOnline() throws StarterException;
	void backToEtatVide() throws StarterException;
}
