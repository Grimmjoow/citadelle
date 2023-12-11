package modele;

import java.util.Random;
import controleur.Interaction;
import java.util.ArrayList;

/**
 * La classe Cardinal représente le personnage Cardinal du jeu.
 */
public class Cardinal extends Personnage {

    /**
     * Constructeur de la classe Cardinal.
     */
    public Cardinal() {
        super("Cardinal", 5, Caracteristiques.CARDINAL);
    }

    /**
     * Perçoit des ressources spécifiques en fonction de son état assassiné ou non.
     */
    public void percevoirRessourcesSpecifiques() {
        if (this.getJoueur() != null && !this.getAssassine()) {
            for (int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++) {
                if (this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[0]) &&
                        this.getJoueur().getCite()[i] != null) {
                    this.getJoueur().ajouterPieces(1);
                }
            }
            if (this.getJoueur().getPossedeEcoleMag()) {
                // La merveille Ecole de Magie change de type à la perception des ressources
                this.getJoueur().ajouterPieces(1);
            }
        }
    }

    /**
     * Utilise le pouvoir du Cardinal (non implémenté dans le code actuel).
     */
    public void utiliserPouvoir() {
        // À implémenter
    }

    /**
     * Utilise le pouvoir du Cardinal en mode Avatar (non implémenté dans le code actuel).
     */
    public void utiliserPouvoirAvatar() {
        // À implémenter
    }

    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO Auto-generated method stub
    }
}
