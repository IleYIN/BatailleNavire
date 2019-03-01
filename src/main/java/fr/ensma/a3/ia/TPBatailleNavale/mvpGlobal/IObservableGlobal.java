package fr.ensma.a3.ia.TPBatailleNavale.mvpGlobal;

import fr.ensma.a3.ia.TPBatailleNavale.mvpCase.IObserverOfGlobal;

public interface IObservableGlobal {
	public void addObserver(IObserverOfGlobal iobr);
    public void removeObserver(IObserverOfGlobal iobr);
    public void notifyObserver();
    
}
