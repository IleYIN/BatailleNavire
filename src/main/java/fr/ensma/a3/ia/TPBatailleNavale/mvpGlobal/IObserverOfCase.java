package fr.ensma.a3.ia.TPBatailleNavale.mvpGlobal;

import fr.ensma.a3.ia.TPBatailleNavale.mvpCase.IObservableCase;

public interface IObserverOfCase {
	public void subscribeCase(IObservableCase iobs);
	public void updateFromCase(IObservableCase presCase);
}
