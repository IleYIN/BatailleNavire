package fr.ensma.a3.ia.TPBatailleNavale.navires;


import fr.ensma.a3.ia.TPBatailleNavale.AbsJoueur;
import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.IAttaque;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.IEtatNavire;
import fr.ensma.a3.ia.TPBatailleNavale.automateNavire.IGestionEtatNavire;
import fr.ensma.a3.ia.TPBatailleNavale.deplacer.IDeplacer;
import fr.ensma.a3.ia.TPBatailleNavale.grille.IEstAttaque;

public interface INavire extends IDeplacer, IEtatNavire, IGestionEtatNavire {

	public void aLAttaque(AbsJoueur joueur, int posX,int posY);
	public void setCompoAttaque(IAttaque att);
	public IAttaque getCompoAttaque();
}
