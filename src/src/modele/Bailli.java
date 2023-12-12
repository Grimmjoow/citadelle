package modele;

import java.util.Random;
import Controleur.Interaction;
import application.Jeu;
import java.util.ArrayList;

/**
 * La classe Bailli représente un personnage de type Bailli dans le jeu.
 * Il possède des pouvoirs liés à la récupération de l'or des taxes.
 */
public class Bailli extends Personnage {

    /**
     * Constructeur de la classe Bailli.
     * Initialise le personnage avec le nom "Bailli", le rang 9, et la caractéristique BAILLI.
     */
    public Bailli(){
        super("Bailli", 9, Caracteristiques.BAILLI);
    }

    /**
     * Méthode pour utiliser le pouvoir du Bailli.
     * Permet au joueur de choisir s'il veut récupérer l'or des taxes accumulé dans le jeu.
     * Si oui, ajoute cet or à la réserve du joueur et réinitialise l'or des taxes à zéro.
     */
    public void utiliserPouvoir(){
        if(Jeu.orDesTaxes != 0){
            boolean recupererLOr = false;
            System.out.println("Voulez-vous récupérer l'or des taxes ?");
            recupererLOr = Interaction.lireOuiOuNon();

            if(recupererLOr){
                this.getJoueur().ajouterPieces(Jeu.orDesTaxes);
                Jeu.orDesTaxes = 0;
            }
        }
    }

    /**
     * Méthode pour percevoir des ressources spécifiques.
     * Non implémentée pour le Bailli, car il n'a pas de ressources spécifiques à percevoir.
     */
    public void percevoirRessourcesSpecifiques(){
        // Non implémenté pour le Bailli
    }

    /**
     * Méthode pour utiliser le pouvoir spécial du Bailli.
     * Permet au joueur, de manière aléatoire, de choisir s'il veut récupérer l'or des taxes accumulé dans le jeu.
     * Si oui, ajoute cet or à la réserve du joueur et réinitialise l'or des taxes à zéro.
     */
    public void utiliserPouvoirAvatar(){
        Random generateur = new Random();
        if(Jeu.orDesTaxes != 0){
            boolean recupererLOr = false;
            System.out.println("Voulez-vous récupérer l'or des taxes ?");
            recupererLOr = generateur.nextBoolean();

            if(recupererLOr){
                this.getJoueur().ajouterPieces(Jeu.orDesTaxes);
                Jeu.orDesTaxes = 0;
            }
        }
    }

    /**
     * Méthode pour l'activation du pouvoir face à la sorcière.
     * Non implémentée pour le Bailli.
     * @param joueurSorciere Joueur cible de la sorcière.
     */
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // Non implémenté pour le Bailli
    }
}
