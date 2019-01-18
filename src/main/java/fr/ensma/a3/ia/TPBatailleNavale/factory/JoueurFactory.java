package fr.ensma.a3.ia.TPBatailleNavale.factory;

import fr.ensma.a3.ia.TPBatailleNavale.pion.IPion;

public abstract class JoueurFactory {

	public static JoueurFactory createFactory(EJoueur p) {
		JoueurFactory fact;
		if (p == EJoueur.Humain) {
			fact =  new HumainFactory();
		} else {
			fact = new OrdinateurFactory();
		}
		return fact;
	}
	
	public abstract IPion createPion();
}
