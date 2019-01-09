package fr.ensma.a3.ia.TPBatailleNavale.attaquesNavire;

import java.util.logging.Logger;

import fr.ensma.a3.ia.TPBatailleNavale.Joueur;
import fr.ensma.a3.ia.TPBatailleNavale.grille.Case;
import fr.ensma.a3.ia.TPBatailleNavale.grille.Grille;

/**
 * Attaque en plus de la case désignée, les cases haut, bas, gauche et droite sont touchées
 * 
 * @author yinyiliang
 *
 */
public class AttaqueEnCroix implements IAttaque{

	private final static Logger LOGGER = Logger.getLogger(AttaqueEnCroix.class.getName());

	public void aLAttaque(Joueur joueur, int posX, int posY, int puiss) {
		attaqueEnCroix(joueur.getGrillePlacement(),posX,posY, puiss);
	}

	private void attaqueEnCroix(Grille grille, int posX, int posY, int puiss) {
		
		Case caze = grille.getCaze(posX, posY);
		LOGGER.info("Attaque en Croix a la case:"+caze.toString());
		caze.estAttaque(puiss);
		try {
			Case cazehaut = grille.getCaze(posX, posY+1);
			cazehaut.estAttaque(puiss);
		} catch (Exception e) {
			LOGGER.info("case haut n'existe pas");
		}
		
		try {
			Case cazebas = grille.getCaze(posX, posY-1);
			cazebas.estAttaque(puiss);
		} catch (Exception e) {
			LOGGER.info("case bas n'existe pas");
		}
		
		try {
			Case cazegauche = grille.getCaze(posX-1, posY);
			cazegauche.estAttaque(puiss);
		}  catch (Exception e) {
			LOGGER.info("case gauche n'existe pas");
		}
		
		try {
			Case cazedroite = grille.getCaze(posX+1, posY);
			cazedroite.estAttaque(puiss);
		}  catch (Exception e) {
			LOGGER.info("case droit n'existe pas");
		}
		
	}

}
