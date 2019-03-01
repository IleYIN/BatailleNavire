package fr.ensma.a3.ia.TPBatailleNavale.mvpCase;

import fr.ensma.a3.ia.TPBatailleNavale.mvpGlobal.IObserverOfCase;

public interface IObservableCase {
	public void addObserver(IObserverOfCase iobr);
    public void removeObserver(IObserverOfCase iobr);
    public void notifyObserver();
}
