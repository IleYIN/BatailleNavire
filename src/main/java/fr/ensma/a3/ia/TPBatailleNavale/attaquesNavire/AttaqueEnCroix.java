package fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.caze.Case;
import fr.ensma.a3.ia.TPBatailleNavale.joueur.AbsJoueur;

/**
 * Attaque en plus de la case désignée, les cases haut, bas, gauche et droite sont touchées
 * 
 * @author yinyiliang
 *
 */
public class AttaqueEnCroix implements IAttaque{

	private final static Logger LOGGER = Logger.getLogger(AttaqueEnCroix.class.getName());

	public void aLAttaque(AbsJoueur joueur,AbsJoueur adverse, int posX, int posY, int puiss) {
		attaqueEnCroix(joueur,adverse,posX,posY, puiss);
		adverse.estAttaque();
	}

	private void attaqueEnCroix(AbsJoueur joueur, AbsJoueur adverse, int posX, int posY, int puiss) {
		
		Case caze = adverse.getGrillep().getCaze(posX, posY);
		LOGGER.info("Attaque en Croix a la case:"+caze.toString());
		
		boolean a = caze.estAttaque(puiss);
		joueur.getGrillem().addPion(caze, a);
		
		try {
			Case cazehaut = adverse.getGrillep().getCaze(posX, posY+1);
			joueur.getGrillem().addPion(cazehaut, cazehaut.estAttaque(puiss));
		} catch (Exception e) {
			LOGGER.info("case haut n'existe pas");
		}
		
		try {
			Case cazebas = adverse.getGrillep().getCaze(posX, posY-1);
			joueur.getGrillem().addPion(cazebas,cazebas.estAttaque(puiss));
		} catch (Exception e) {
			LOGGER.info("case bas n'existe pas");
		}
		
		try {
			Case cazegauche = adverse.getGrillep().getCaze(posX-1, posY);
			joueur.getGrillem().addPion(cazegauche,cazegauche.estAttaque(puiss));
		}  catch (Exception e) {
			LOGGER.info("case gauche n'existe pas");
		}
		
		try {
			Case cazedroite = adverse.getGrillep().getCaze(posX+1, posY);
			joueur.getGrillem().addPion(cazedroite,cazedroite.estAttaque(puiss));
		}  catch (Exception e) {
			LOGGER.info("case droit n'existe pas");
		}
		
	}

	public void aLAttaque(AbsJoueur joueur, AbsJoueur adversal, Case caze, int puiss) {
		aLAttaque(joueur, adversal, caze.getPosX(), caze.getPosY(), puiss);
		
	}

}
