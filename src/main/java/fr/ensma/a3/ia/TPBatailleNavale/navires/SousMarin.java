package fr.ensma.a3.ia.TPBatailleNavale.navires;

import fr.ensma.a3.ia.TPBatailleNavale.AbsJoueur;
import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.AttaqueClassique;
import fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire.IAttaque;

public class SousMarin extends Navire {

	private static final int longueur = 3;
	
	public SousMarin(int posX, int posY, boolean ori, IAttaque compoA) {
		super("SousMarin-", posX, posY, longueur, ori, compoA, longueur);
	}
	
	public void afficher() {
		
	}
	
	public static Navire randomNavire(AbsJoueur joueur) {

		int posX, posY, trueOrFalse;
		boolean ori;
		
		posX = (int) (Math.random() * 10);
		posY = (int) (Math.random() * 10);
		trueOrFalse = (int) (Math.random() * 2);
		if (trueOrFalse == 1) {
			ori = true;
		}
		else {
			ori = false;
		}
		
		while (!Navire.OKToPlaceNavire(joueur, posX, posY, longueur, ori)) {
			posX = (int) (Math.random() * 10);
			posY = (int) (Math.random() * 10);
			trueOrFalse = (int) (Math.random() * 2);
			if (trueOrFalse == 1) {
				ori = true;
			}
			else {
				ori = false;
			}
		}
		
		return new SousMarin(posX,posY,ori,new AttaqueClassique());
	}
	
	@Override
	public String toString() {
		return "SousMarin"+super.toString();
	}

}
