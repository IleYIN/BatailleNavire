package fr.ensma.a3.ia.TPBatailleNavale.joueur;

import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.AttaqueEnCroix;
import fr.ensma.a3.ia.TPBatailleNavale.caze.CaseNavire;
import fr.ensma.a3.ia.TPBatailleNavale.caze.ICase;
import fr.ensma.a3.ia.TPBatailleNavale.navires.ENavire;
import fr.ensma.a3.ia.TPBatailleNavale.navires.INavire;

public class App {
	public static void main(String[] args) {

		IJoueur humain = new Humain();
		humain.initialiserRandomGrilleP();
		IJoueur ordinateur = new Ordinateur();
		ordinateur.initialiserRandomGrilleP();
		

		System.out.println("-------humain grilleplacement---------");
		for(ICase caze : humain.getGrillep().getLcaze() ) {
			if(caze instanceof CaseNavire) {
				System.out.println(caze.toString());
			}
		}
		
		
		humain.deplacerX(humain.getNavire(ENavire.PorteAvion), 3);
		humain.deplacerY(humain.getNavire(ENavire.PorteAvion), 1);
		humain.pivoter(humain.getNavire(ENavire.PorteAvion), 
				humain.getNavire(ENavire.PorteAvion).getPosX(),
				humain.getNavire(ENavire.PorteAvion).getPosY());
		
		
		System.out.println("-------humain grilleplacement---------");
		for(ICase caze : humain.getGrillep().getLcaze() ) {
			if(caze instanceof CaseNavire) {
				System.out.println(caze.toString());
			}
		}
		
		System.out.println("-------ordinateur grilleplacement---------");
		
		for(ICase caze : ordinateur.getGrillep().getLcaze() ) {
			if(caze instanceof CaseNavire) {
				System.out.println(caze.toString());
			}
		}
		
		humain.alAttaque(humain.getNavire(ENavire.SousMarin), ordinateur, 4, 6);
		
		INavire nav = humain.getNavire(ENavire.PorteAvion);
//		nav.setCompoAttaque(new AttaqueEnCroix());
		
		for(int i=0;i<=9;i++) {
			for(int j=0;j<=9;j++) {
				nav.aLAttaque(humain, ordinateur, i, j);
			}
		}
		/*nav.aLAttaque(humain, ordinateur, 2, 2);
		nav.aLAttaque(humain, ordinateur, 4, 4);
		nav.aLAttaque(humain, ordinateur, 6, 6);
		nav.aLAttaque(humain, ordinateur, 8, 8);*/
		
		System.out.println("-------ordinateur grilleplacement---------");

		for(ICase caze : ordinateur.getGrillep().getLcaze() ) {
			if(caze instanceof CaseNavire) {
				System.out.println(caze.toString());
			}
		}
		

	}
}