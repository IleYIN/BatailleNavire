package fr.ensma.a3.ia.TPBatailleNavale;

import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.AttaqueClassique;
import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.AttaqueEnCroix;
import fr.ensma.a3.ia.TPBatailleNavale.grille.Case;
import fr.ensma.a3.ia.TPBatailleNavale.grille.Pion;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Croiseur;
import fr.ensma.a3.ia.TPBatailleNavale.navires.EOrientation;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Navire;
import fr.ensma.a3.ia.TPBatailleNavale.navires.PorteAvion;
import fr.ensma.a3.ia.TPBatailleNavale.navires.SousMarin;
import fr.ensma.a3.ia.TPBatailleNavale.navires.Torpilleur;

public class App {
	public static void main(String[] args) {

		Joueur humain = new Humain();
		Joueur ordinateur = new Ordinateur();

		//initializer la grille avec les caseMer
		System.out.println("-------ordinateur grilleplacement---------");
		for(Case caze : ordinateur.getGrillePlacement().getLcaze() ) {
			System.out.println(caze.toString());
		}

		System.out.println("-------humain grilleplacement---------");
		Navire croiseurHum = new Croiseur(humain, 0, 0, EOrientation.vertical, new AttaqueClassique());
		Navire sousMarinHum = new SousMarin(humain, 5, 5, EOrientation.vertical, new AttaqueEnCroix());
		//mettre une navire dans la grille
		for(Case caze : humain.getGrillePlacement().getLcaze() ) {
			System.out.println(caze.toString());
		}


		System.out.println("-------ordinateur grilleplacement---------");
		
		Navire porteAvionOrdi = new PorteAvion(ordinateur, 2, 2, EOrientation.horizontal, new AttaqueClassique());
		Navire torpilleurOrdi = new Torpilleur(ordinateur, 5, 3, EOrientation.vertical, new AttaqueClassique());
		
		//mettre une navire dans la grille
		for(Case caze : ordinateur.getGrillePlacement().getLcaze() ) {
			System.out.println(caze.toString());
		}

		Pion humainpion = new Pion(humain,croiseurHum,ordinateur,2,2);
		humainpion.afficher();
		
		humainpion = new Pion(humain,sousMarinHum,ordinateur,5,2);
		humainpion.afficher();
		
		humainpion = new Pion(humain,croiseurHum,ordinateur,6,2);
		humainpion.afficher();

		humainpion = new Pion(humain,croiseurHum,ordinateur,3,2);
		humainpion.afficher();
		
		for(Case caze : ordinateur.getGrillePlacement().getLcaze() ) {
			System.out.println(caze.toString());
		}
		
		//la porteAvion de l'ordinateur est en panne
		Pion ordinpion = new Pion(ordinateur, porteAvionOrdi, humain, 5, 5);
		ordinpion.afficher();
		
		ordinpion = new Pion(ordinateur, torpilleurOrdi, humain, 5,5);
		ordinpion.afficher();

		System.out.println("-------humain grilleplacement---------");
		for(Case caze : humain.getGrillePlacement().getLcaze() ) {
			System.out.println(caze.toString());
		}

	}

}
