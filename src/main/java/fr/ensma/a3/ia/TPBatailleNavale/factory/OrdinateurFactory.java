package fr.ensma.a3.ia.TPBatailleNavale.factory;

import fr.ensma.a3.ia.TPBatailleNavale.pion.HumainPion;
import fr.ensma.a3.ia.TPBatailleNavale.pion.IPion;

public class OrdinateurFactory extends JoueurFactory {

	public IPion createPion() {
		return new HumainPion(EJoueur.Oridnateur);
	}

}
