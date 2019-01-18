package fr.ensma.a3.ia.TPBatailleNavale;


import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.AttaqueClassique;
import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.AttaqueEnCroix;
import fr.ensma.a3.ia.TPBatailleNavale.grille.Case;
import fr.ensma.a3.ia.TPBatailleNavale.grille.Pion;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Croiseur;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Navire;
import fr.ensma.a3.ia.TPBatailleNavale.navires.PorteAvion;
import fr.ensma.a3.ia.TPBatailleNavale.navires.SousMarin;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Torpilleur;

public class App {
	public static void main(String[] args) {

		AbsJoueur humain = new Humain();
//		humain.addRandomNavires();
		AbsJoueur ordinateur = new Ordinateur();
//		ordinateur.addRandomNavires();
		
		

		//initializer la grille avec les caseMer

//		System.out.println("-------humain grilleplacement---------");
//		Navire croiseurHum = new Croiseur(0, 0, true, new AttaqueClassique());
//		Navire sousMarinHum = new SousMarin(5, 5, true, new AttaqueEnCroix());
//		humain.getGrilleb().getGrillePlacement().addNavires(croiseurHum,sousMarinHum);
////		mettre une navire dans la grille
//		for(Case caze : humain.getGrilleb().getGrillePlacement().getLcaze() ) {
//			System.out.println(caze.toString());
//		}

		System.out.println("-------ordinateur grilleplacement---------");
		
		Navire porteAvionOrdi = new PorteAvion(2, 2, false, new AttaqueClassique());
		Navire torpilleurOrdi = new Torpilleur(5, 3, true, new AttaqueClassique());
		ordinateur.getGrilleb().getGrillePlacement().addNavires(porteAvionOrdi,torpilleurOrdi);
		
		//mettre une navire dans la grille
		for(Case caze : ordinateur.getGrilleb().getGrillePlacement().getLcaze() ) {
			System.out.println(caze.toString());
		}

//		porteAvionOrdi.deplacerX(ordinateur, 8);
//		porteAvionOrdi.deplacerX(ordinateur, 2);
		porteAvionOrdi.pivoter(ordinateur, 6, 2);
//		porteAvionOrdi.pivoter(ordinateur, 2, 2);
//		torpilleurOrdi.pivoter(ordinateur, 5, 3);
		
		
		
		System.out.println("-------ordinateur grilleplacement---------");
		for(Case caze : ordinateur.getGrilleb().getGrillePlacement().getLcaze() ) {
			System.out.println(caze.toString());
		}
//		
//		Pion humainpion = new Pion(croiseurHum,ordinateur,2,2);
//		humainpion.afficher();
//		
//		humainpion = new Pion(sousMarinHum,ordinateur,5,2);
//		humainpion.afficher();
//		
//		humainpion = new Pion(croiseurHum,ordinateur,6,2);
//		humainpion.afficher();
//
//		humainpion = new Pion(croiseurHum,ordinateur,3,2);
//		humainpion.afficher();
//		
//		for(Case caze : ordinateur.getGrilleb().getGrillePlacement().getLcaze() ) {
//			System.out.println(caze.toString());
//		}
//		
//		//la porteAvion de l'ordinateur est en panne
//		Pion ordinpion = new Pion(porteAvionOrdi, humain, 5, 5);
//		ordinpion.afficher();
//		
//		ordinpion = new Pion(torpilleurOrdi, humain, 5,5);
//		ordinpion.afficher();
//
//		System.out.println("-------humain grilleplacement---------");
//		for(Case caze : humain.getGrilleb().getGrillePlacement().getLcaze() ) {
//			System.out.println(caze.toString());
//		}
//
	}

}
