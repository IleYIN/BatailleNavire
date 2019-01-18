package fr.ensma.a3.ia.TPBatailleNavale.pion;

import fr.ensma.a3.ia.TPBatailleNavale.factory.EJoueur;

public class HumainPion extends AbstractPion {

	public HumainPion(EJoueur p) {
		ejoueur = p;
	}
	
	@Override
	public String toString() {
		return EJoueur.Humain + super.toString();
	}
}
