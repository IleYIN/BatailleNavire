package fr.ensma.a3.ia.TPBatailleNavale.caze;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.automateCase.IEtatCaseN;
import fr.ensma.a3.ia.TPBatailleNavale.automateCase.IGestionEtatCaseN;
import fr.ensma.a3.ia.TPBatailleNavale.automateCase.etatsCase.ActionCaseNonPermiseException;
import fr.ensma.a3.ia.TPBatailleNavale.automateCase.etatsCase.EnDetruit;
import fr.ensma.a3.ia.TPBatailleNavale.automateCase.etatsCase.EnNormal;
import fr.ensma.a3.ia.TPBatailleNavale.automateCase.etatsCase.EnTouche;
/**
 * une case qui represent la navire
 * 
 * @author yinyiliang
 *
 */
public class CaseNavire extends Case implements IGestionEtatCaseN {

	private final static Logger LOGGER = Logger.getLogger(CaseNavire.class.getName());
	private int nvie;

	// Gestion Etat
	private IEtatCaseN etatCourant;
	private IEtatCaseN enNormal = new EnNormal(this);
	private IEtatCaseN enTouche = new EnTouche(this);
	private IEtatCaseN enDetruit = new EnDetruit(this);
	
	
	
	public CaseNavire(final int positionX, final int positionY, final int nvie) {
		super(positionX, positionY);
		this.nvie = nvie;
		etatCourant = enNormal;
	}

	public void setNvie(int nvie) {
		this.nvie = nvie;
	}
	
	public int getNvie() {
		return nvie;
	}

	@Override
	public String toString() {
		return  "CaseNavire("+this.getPosX()+","+this.getPosY()+")-nvie:"+ nvie;
	}

	
	public boolean estAttaque(int puiss) {
		LOGGER.info("tir dans une case navire "+this.toString());
		if (this.getNvie() > puiss) {
			try {
				this.setNvie(this.getNvie() - puiss);
				LOGGER.info(this.toString() + " est touche ");
				etatCourant.subirAttaque(); 
				return true;
				//pion rouge
			} catch (ActionCaseNonPermiseException e) {
				LOGGER.info(this.toString()+e.getMessage());
				return false;
			}
		} else {
			try {
				this.setNvie(0);
				LOGGER.info(this.toString() + " est detruit ");
				etatCourant.toDetruit();  
				return true;
				//pion rouge
			} catch (ActionCaseNonPermiseException e) {
				LOGGER.info(this.toString()+e.getMessage());
				return false;
			}
			
		}
	}


	//ETAT
	public IEtatCaseN getEtatCourant() {
		return etatCourant;
	}


	public void setEtatCourant(IEtatCaseN etat) {
		this.etatCourant = etat;
	}


	public IEtatCaseN getEnTouche() {
		return enTouche;
	}


	public IEtatCaseN getEnDetruit() {
		return enDetruit;
	}


	public IEtatCaseN getEnNormal() {
		return enNormal;
	}

}
