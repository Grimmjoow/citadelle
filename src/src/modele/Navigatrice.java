package modele;

import java.util.Random;

import Controleur.Interaction;

/**
 * La classe Navigatrice représente un type de personnage du jeu appelé "Navigatrice".
 * Elle hérite de la classe abstraite Personnage.
 */
public class Navigatrice extends Personnage {

    /**
     * Constructeur de la classe Navigatrice.
     * Initialise le nom, le rang et les caractéristiques de la Navigatrice.
     */
    public Navigatrice() {
        super("Navigatrice", 7, Caracteristiques.NAVIGATRICE);
    }

    /**
     * Redéfinition de la méthode utiliserPouvoir pour la Navigatrice.
     * Affiche le trésor du joueur, puis propose de recevoir 4 pièces ou 4 cartes.
     * En fonction du choix du joueur, ajoute les pièces ou les cartes à son trésor.
     */
    @Override
    public void utiliserPouvoir() {
        System.out.println("Voici votre trésor: " + this.getJoueur().nbPieces());
        System.out.println("Voulez-vous recevoir 4 pièces ou 4 cartes (1 pour les pièces, 2 pour les cartes)?");
        int choix = Interaction.lireUnEntier(1, 2);
        if (choix == 1) {
            this.getJoueur().ajouterPieces(4);
            System.out.println("Vous recevez 4 pièces, voici votre trésor: " + this.getJoueur().nbPieces());
        } else {
            System.out.println("Voici les cartes piochées: \n");
            for (int i = 0; i < 4; i++) {
                Quartier piocheJoueur = this.getPlateau().getPioche().piocher();
                System.out.println((i + 1) + ". Nom: " + piocheJoueur.getNom() + "\ntype: " + piocheJoueur.getType() + "\ncout: " + piocheJoueur.getCout() + "\n");
                this.getJoueur().ajouterQuartierDansMain(piocheJoueur);
            }
        }
    }

    /**
     * Redéfinition de la méthode utiliserPouvoirAvatar pour la Navigatrice.
     * Propose aléatoirement de recevoir 4 pièces ou 4 cartes.
     * En fonction du choix, ajoute les pièces ou les cartes au trésor du joueur.
     */
    @Override
    public void utiliserPouvoirAvatar() {
        System.out.println("Voulez-vous recevoir 4 pièces ou 4 cartes (0 pour les pièces, 1 pour les cartes)?");
        Random random = new Random();
        int choix = random.nextInt(2);
        if (choix == 0) {
            this.getJoueur().ajouterPieces(4);
            System.out.println("Vous recevez 4 pièces");
        } else {
            System.out.println("4 cartes ont été piochées. \n");
            for (int i = 0; i < 4; i++) {
                Quartier piocheJoueur = this.getPlateau().getPioche().piocher();
                this.getJoueur().ajouterQuartierDansMain(piocheJoueur);
            }
        }
    }

    /**
     * Redéfinition de la méthode activationPouvoirSorciere pour la Navigatrice.
     * Cette méthode ne contient aucune action spécifique pour la Navigatrice.
     */
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // Aucune action spécifique pour la Navigatrice lors de l'activation du pouvoir de sorcière
    }
}
