package fr.ensma.a3.ia.TPBatailleNavale.automateCase;


/**
 * l'interface de gestion d'etat d'une case
 * 
 * @author yinyiliang
 *
 */
public interface IGestionEtatCase {
	
	public IEtatCase getEtatCourant();
	public void setEtatCourant(final IEtatCase etat);
	public IEtatCase getEnTouche();
	public IEtatCase getEnDetruit();
	public IEtatCase getEnNormal();
	
}
