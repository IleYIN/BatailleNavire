package fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.caze.ICase;
import fr.ensma.a3.ia.TPBatailleNavale.joueur.IJoueur;

/**
 * Attaque en plus de la ICase désignée, les ICases haut, bas, gauche et droite sont touchées
 * 
 * @author yinyiliang
 *
 */
public class AttaqueEnCroix extends AbsAttaque {

	private final static Logger LOGGER = Logger.getLogger(AttaqueEnCroix.class.getName());

	public void aLAttaque(IJoueur joueur,IJoueur adverse, int posX, int posY, int puiss) {
		attaqueEnCroix(joueur,adverse,posX,posY, puiss);
		adverse.estAttaque();
	}

	private void attaqueEnCroix(IJoueur joueur, IJoueur adverse, int posX, int posY, int puiss) {
		
		ICase caze = adverse.getGrillep().getCaze(posX, posY);
		LOGGER.info(joueur+ " attaque en Croix a la case:"+caze.toString()+" de " +adverse);
		
		int puiss1 = checkbombe(adverse, posX, posY, puiss);
		boolean a = caze.estAttaque(puiss1);
		joueur.getGrillem().addPion(caze, a);
		
		try {
			ICase cazehaut = adverse.getGrillep().getCaze(posX, posY+1);
			int puiss2 = checkbombe(adverse, posX, posY+1, puiss);
			joueur.getGrillem().addPion(cazehaut, cazehaut.estAttaque(puiss2));
		} catch (Exception e) {
			LOGGER.info("case haut n'existe pas");
		}
		
		try {
			ICase cazebas = adverse.getGrillep().getCaze(posX, posY-1);
			int puiss2 = checkbombe(adverse, posX, posY-1, puiss);
			joueur.getGrillem().addPion(cazebas,cazebas.estAttaque(puiss2));
		} catch (Exception e) {
			LOGGER.info("case bas n'existe pas");
		}
		
		try {
			ICase cazegauche = adverse.getGrillep().getCaze(posX-1, posY);
			int puiss2 = checkbombe(adverse, posX-1, posY, puiss);
			joueur.getGrillem().addPion(cazegauche,cazegauche.estAttaque(puiss2));
		}  catch (Exception e) {
			LOGGER.info("case gauche n'existe pas");
		}
		
		try {
			ICase cazedroite = adverse.getGrillep().getCaze(posX+1, posY);
			int puiss2 = checkbombe(adverse, posX+1, posY, puiss);
			joueur.getGrillem().addPion(cazedroite,cazedroite.estAttaque(puiss2));
		}  catch (Exception e) {
			LOGGER.info("case droit n'existe pas");
		}
		
	}

	public void aLAttaque(IJoueur joueur, IJoueur adversal, ICase caze, int puiss) {
		aLAttaque(joueur, adversal, caze.getPosX(), caze.getPosY(), puiss);
	}
	
}
