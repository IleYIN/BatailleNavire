package fr.ensma.a3.ia.TPBatailleNavale.automateNavire;


/**
 * l'interface de gestion d'etat d'une navire
 * 
 * @author yinyiliang
 *
 */
public interface IGestionEtatNavire {
	
	public IEtatNavire getEtatCourant();
	public void setEtatCourant(final IEtatNavire etat);
	public IEtatNavire getEnPanne();
	public IEtatNavire getEnDetruitNavire();
	public IEtatNavire getEnFonction();
	
}
