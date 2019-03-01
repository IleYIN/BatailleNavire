package fr.ensma.a3.ia.TPBatailleNavale.mvpGlobal;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.TPBatailleNavale.mvpCase.IObservableCase;
import fr.ensma.a3.ia.TPBatailleNavale.mvpCase.IObserverOfGlobal;
import fr.ensma.a3.ia.TPBatailleNavale.mvpCase.PresCase;
import fr.ensma.a3.ia.TPBatailleNavale.navires.ENavire;

public class PresGlobal implements IObservableGlobal, IObserverOfCase {

	private IVueGlobal vueGlobal;
	private ModelGlobal modelGlobal;
	private List<IObserverOfGlobal> listIObserverOfG;
	private List<IObservableCase> listPresCase;

	public PresGlobal() {
		modelGlobal = new ModelGlobal();
		modelGlobal.randomInit();
		listIObserverOfG = new ArrayList<IObserverOfGlobal>();
	}


	public void setVue (final IVueGlobal v) {
		vueGlobal = v;
	}

	public IVueGlobal getVue() {
		return vueGlobal;
	}

	public ModelGlobal getModel() {
		return modelGlobal;
	}


	public void addObserver(IObserverOfGlobal iobr) {
		listIObserverOfG.add(iobr);
	}


	public void removeObserver(IObserverOfGlobal iobr) {
		listIObserverOfG.remove(iobr);
	}


	public void notifyObserver() {
		for(IObserverOfGlobal iobr:listIObserverOfG){
			PresCase pc = (PresCase)iobr;
			pc.updateFromGlobal();
		}
	}


	public void subscribeCase(IObservableCase iobs) {
		listPresCase.add(iobs);
        iobs.addObserver(this);
	}


	public void updateFromCase(IObservableCase iobCase) {
		PresCase presCase = (PresCase)iobCase;
		
		//choisir navire!!!!
		this.getModel().getHumain().alAttaque(this.getModel().getHumain().getNavire(ENavire.SousMarin), this.getModel().getOrdinateur(), presCase.getModelCase().getCaze());
		
		this.notifyObserver();
	}
	


}
