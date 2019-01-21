package fr.ensma.a3.ia.TPBatailleNavale.joueur;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

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

		Iterator<Entry<ENavire, List<INavire>>> it = humain.getGrillep().getMapnavire().entrySet().iterator();

		while(it.hasNext()) {
			Entry<ENavire, List<INavire>> entry = it.next();
			for(INavire nav : entry.getValue()) {
				System.out.println(nav.toString());
				for(CaseNavire cazeNav : nav.getLcaseNav()) {
					System.out.println(cazeNav.toString());
				}
			}
		}


		humain.deplacerX(humain.getNavire(ENavire.PorteAvion), 3);
		humain.deplacerY(humain.getNavire(ENavire.PorteAvion), 1);
		humain.pivoter(humain.getNavire(ENavire.PorteAvion), 
				humain.getNavire(ENavire.PorteAvion).getPosX(),
				humain.getNavire(ENavire.PorteAvion).getPosY());


		System.out.println("-------humain grilleplacement---------");
		
		it = humain.getGrillep().getMapnavire().entrySet().iterator();
		while(it.hasNext()) {
			Entry<ENavire, List<INavire>> entry = it.next();
			for(INavire nav : entry.getValue()) {
				System.out.println(nav.toString());
				for(CaseNavire cazeNav : nav.getLcaseNav()) {
					System.out.println(cazeNav.toString());
				}
			}
		}

		System.out.println("-------ordinateur grilleplacement---------");

		Iterator<Entry<ENavire, List<INavire>>> it2 = ordinateur.getGrillep().getMapnavire().entrySet().iterator();

		while(it2.hasNext()) {
			Entry<ENavire, List<INavire>> entry = it2.next();
			for(INavire nav : entry.getValue()) {
				System.out.println(nav.toString());
				for(CaseNavire cazeNav : nav.getLcaseNav()) {
					System.out.println(cazeNav.toString());
				}
			}
		}


		humain.alAttaque(humain.getNavire(ENavire.SousMarin), ordinateur, 4, 6);

		humain.aLEclair(ordinateur, 6,7);
		

		INavire na = humain.getNavire(ENavire.PorteAvion);
		//		nav.setCompoAttaque(new AttaqueEnCroix());

		for(int i=0;i<=(int)(Math.random()*10);i++) {
			for(int j=0;j<=(int)(Math.random()*10);j++) {
				na.aLAttaque(humain, ordinateur, i, j);
			}
		}
		/*nav.aLAttaque(humain, ordinateur, 2, 2);
		nav.aLAttaque(humain, ordinateur, 4, 4);
		nav.aLAttaque(humain, ordinateur, 6, 6);
		nav.aLAttaque(humain, ordinateur, 8, 8);*/

		System.out.println("-------ordinateur grilleplacement---------");

		it2 = ordinateur.getGrillep().getMapnavire().entrySet().iterator();
		while(it2.hasNext()) {
			Entry<ENavire, List<INavire>> entry = it2.next();
			for(INavire nav : entry.getValue()) {
				System.out.println(nav.toString());
				for(CaseNavire cazeNav : nav.getLcaseNav()) {
					System.out.println(cazeNav.toString());
				}
			}

		}
	}
}
