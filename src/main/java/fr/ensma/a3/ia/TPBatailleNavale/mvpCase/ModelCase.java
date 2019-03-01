package fr.ensma.a3.ia.TPBatailleNavale.mvpCase;

import fr.ensma.a3.ia.TPBatailleNavale.caze.CaseMer;
import fr.ensma.a3.ia.TPBatailleNavale.caze.CaseNavire;
import fr.ensma.a3.ia.TPBatailleNavale.caze.ICase;

public class ModelCase {
	
	private String couleur;
	private ICase caze;
	private Integer nvie;
	
	
	public ModelCase(ICase caze) {
		this.caze = caze;
	}

	public String getCouleur() {
		return couleur;
	}
	
	
	public void setCaze(ICase caze) {
		this.caze = caze;
	}

	public ICase getCaze() {
		return caze;
	}

	public Integer getNvie() {
		return nvie;
	}

	public void updateCase() {
		if(caze instanceof CaseNavire) {
			this.couleur = "yellow";
			this.nvie = ((CaseNavire) caze).getNvie();
		} else if (caze instanceof CaseMer) {
			this.couleur = "blue";
			this.nvie = null;
		}
	}

}
