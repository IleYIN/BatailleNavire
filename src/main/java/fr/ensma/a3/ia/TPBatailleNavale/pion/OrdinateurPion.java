package fr.ensma.a3.ia.TPBatailleNavale.pion;

import fr.ensma.a3.ia.TPBatailleNavale.factory.EJoueur;

public class OrdinateurPion extends AbstractPion {

	public OrdinateurPion(EJoueur p) {
		ejoueur = p;
	}
	
	@Override
	public String toString() {
		return EJoueur.Oridnateur + super.toString();
	}
}
