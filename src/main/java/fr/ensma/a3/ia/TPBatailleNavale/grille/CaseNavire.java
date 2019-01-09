package fr.ensma.a3.ia.TPBatailleNavale.grille;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.automateCase.IEtatCase;
import fr.ensma.a3.ia.TPBatailleNavale.automateCase.IGestionEtatCase;
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
public class CaseNavire extends Case implements IEtatCase, IGestionEtatCase {

	private final static Logger LOGGER = Logger.getLogger(CaseNavire.class.getName());
	private int nvie;

	// Gestion Etat
	private IEtatCase etatCourant;
	private IEtatCase enNormal = new EnNormal(this);
	private IEtatCase enTouche = new EnTouche(this);
	private IEtatCase enDetruit = new EnDetruit(this);
	
	
	
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
	
	public void afficher() {
		
	}

	@Override
	public String toString() {
		return  "CaseNavire("+this.getPosX()+","+this.getPosY()+")-nvie:"+ nvie;
	}

	
	public void estAttaque(int puiss) {
		LOGGER.info("tir dans une case navire "+this.toString());
		if (this.getNvie() > puiss) {
			this.setNvie(this.getNvie() - puiss);
			LOGGER.info(this.toString() + " est touche ");
			try {
				etatCourant.subirAttaque();  
				//pion rouge
			} catch (ActionCaseNonPermiseException e) {
				LOGGER.info(this.toString()+e.getMessage());
			}
		} else {
			this.setNvie(0);
			LOGGER.info(this.toString() + " est detruit ");
			try {
				etatCourant.toDetruit();  
				//pion rouge
			} catch (ActionCaseNonPermiseException e) {
				LOGGER.info(this.toString()+e.getMessage());
			}
			
		}
	}


	//ETAT
	public IEtatCase getEtatCourant() {
		return etatCourant;
	}


	public void setEtatCourant(IEtatCase etat) {
		this.etatCourant = etat;
	}


	public IEtatCase getEnTouche() {
		return enTouche;
	}


	public IEtatCase getEnDetruit() {
		return enDetruit;
	}


	public IEtatCase getEnNormal() {
		return enNormal;
	}


	public void subirAttaque() throws ActionCaseNonPermiseException {
	}


	public void retournerEnNormal() throws ActionCaseNonPermiseException {
	}


	public void toDetruit() throws ActionCaseNonPermiseException {
	}
	
}
