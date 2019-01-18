package fr.ensma.a3.ia.TPBatailleNavale.pion;

import fr.ensma.a3.ia.TPBatailleNavale.AbsJoueur;
import fr.ensma.a3.ia.TPBatailleNavale.grille.IAfficher;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Navire;

public interface IPion extends IAfficher {

	public void setPosX(int posX);
	public void setPosY(int posY);
	public void setNav(Navire nav);
	public void setAdversal(AbsJoueur adversal);
	
}
