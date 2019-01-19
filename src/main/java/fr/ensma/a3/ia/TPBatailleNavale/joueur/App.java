package fr.ensma.a3.ia.TPBatailleNavale.joueur;

import fr.ensma.a3.ia.TPBatailleNavale.caze.Case;

public class App {
	public static void main(String[] args) {

		AbsJoueur humain = new Humain();
		humain.initialiserRandomGrilleP();
		AbsJoueur ordinateur = new Ordinateur();
		ordinateur.initialiserRandomGrilleP();


		//		System.out.println("-------humain grilleplacement---------");
		//		Navire croiseurHum = new Croiseur(0, 0, true, new AttaqueClassique());
		//		Navire sousMarinHum = new SousMarin(5, 5, true, new AttaqueEnCroix());
		//		humain.getGrilleb().getGrillePlacement().addNavires(croiseurHum,sousMarinHum);
		////		mettre une navire dans la grille
		//		for(Case caze : humain.getGrilleb().getGrillePlacement().getLcaze() ) {
		//			System.out.println(caze.toString());
		//		}

		System.out.println("-------ordinateur grilleplacement---------");

		//		Navire porteAvionOrdi = new PorteAvion(2, 2, false, new AttaqueClassique());
		//		Navire torpilleurOrdi = new Torpilleur(5, 3, true, new AttaqueClassique());
		//		ordinateur.getGrilleb().getGrillePlacement().addNavires(porteAvionOrdi,torpilleurOrdi);
		//		
		//mettre une navire dans la grille
		for(Case caze : ordinateur.getGrillep().getLcaze() ) {
			System.out.println(caze.toString());
		}

		//		porteAvionOrdi.deplacerX(ordinateur, 8);
		//		porteAvionOrdi.deplacerX(ordinateur, 2);
		//		porteAvionOrdi.pivoter(ordinateur, 6, 2);
		//		porteAvionOrdi.pivoter(ordinateur, 2, 2);
		//		torpilleurOrdi.pivoter(ordinateur, 5, 3);



		System.out.println("-------ordinateur grilleplacement---------");
		for(Case caze : ordinateur.getGrillep().getLcaze() ) {
			System.out.println(caze.toString());
		}
	}
}
