package fr.ensma.a3.ia.TPBatailleNavale.mvpCase;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.TPBatailleNavale.caze.ICase;
import fr.ensma.a3.ia.TPBatailleNavale.mvpGlobal.IObservableGlobal;
import fr.ensma.a3.ia.TPBatailleNavale.mvpGlobal.IObserverOfCase;
import fr.ensma.a3.ia.TPBatailleNavale.mvpGlobal.PresGlobal;

public class PresCase implements IObserverOfGlobal, IObservableCase {

	private IVueCase vueCase;
	private ModelCase modelCase;
	private PresGlobal presGlobal;
	private List<IObserverOfCase> listObserverCase;
	
	public PresCase(ICase caze) {
		modelCase = new ModelCase(caze);
	    listObserverCase = new ArrayList<IObserverOfCase>();
	}

	public IVueCase getVueCase() {
		return vueCase;
	}

	public void setVueCase(IVueCase vueCase) {
		this.vueCase = vueCase;
	}

	public ModelCase getModelCase() {
		return modelCase;
	}

	

	public void actionClick() {
		this.notifyObserver();
		
	}

	public void subscribeGlobal(IObservableGlobal iobs) {
		this.presGlobal = (PresGlobal)iobs;
		iobs.addObserver(this);
	}

	public void updateFromGlobal() {
//		this.modelCase.setCaze(caze);
	}


	public void notifyObserver() {
		 for(IObserverOfCase observer:listObserverCase){
	            observer.updateFromCase(this);
	        }
	}

	public void addObserver(IObserverOfCase iobr) {
		listObserverCase.add(iobr);
	}

	public void removeObserver(IObserverOfCase iobr) {
		listObserverCase.remove(iobr);
	}

}
