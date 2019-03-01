package fr.ensma.a3.ia.TPBatailleNavale.mvpCase;

import fr.ensma.a3.ia.TPBatailleNavale.mvpGlobal.IObservableGlobal;

public interface IObserverOfGlobal {
	public void subscribeGlobal(IObservableGlobal iobs);
	public void updateFromGlobal();
}
