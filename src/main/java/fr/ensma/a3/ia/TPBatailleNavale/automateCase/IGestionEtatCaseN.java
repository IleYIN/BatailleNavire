package fr.ensma.a3.ia.TPBatailleNavale.automateCase;


/**
 * l'interface de gestion d'etat d'une case
 * 
 * @author yinyiliang
 *
 */
public interface IGestionEtatCaseN {
	
	public IEtatCaseN getEtatCourant();
	public void setEtatCourant(final IEtatCaseN etat);
	public IEtatCaseN getEnTouche();
	public IEtatCaseN getEnDetruit();
	public IEtatCaseN getEnNormal();
	
}
