package fr.ensma.a3.ia.TPBatailleNavale.navires;


import fr.ensma.a3.ia.TPBatailleNavale.AbsJoueur;
import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.IAttaque;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.IEtatNavire;
import fr.ensma.a3.ia.TPBatailleNavale.deplacer.IDeplacer;

public interface INavire extends IDeplacer {

	public void aLAttaque(AbsJoueur joueur, int posX,int posY);
	public void setCompoAttaque(IAttaque att);
	public IAttaque getCompoAttaque();
	public IEtatNavire getEtatCourant();
}
