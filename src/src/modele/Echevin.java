package modele;

import java.util.Random;

import Controleur.Interaction;

/**
 * La classe Echevin représente un personnage de type Echevin dans le jeu.
 * Il possède des pouvoirs permettant d'attribuer des mandats spécifiques à d'autres personnages.
 */
public class Echevin extends Personnage {
    
    /**
     * Constructeur de la classe Echevin.
     * Initialise le personnage avec le nom "Echevin", le rang 1, et la caractéristique ECHEVIN.
     */
    public Echevin() {
        super("Echevin", 1, Caracteristiques.ECHEVIN);
    }

    /**
     * Méthode pour utiliser le pouvoir du personnage Echevin.
     * Permet de choisir trois personnages et d'attribuer des mandats spécifiques à chacun d'eux.
     */
    @Override
    public void utiliserPouvoir() {
        if(this.getJoueur() != null && !this.getAssassine()){
            boolean continu = true;

            // Affiche la liste des personnages disponibles pour le choix
            System.out.println("Quels personnages voulez-vous cibler ?");
            for (int i = 0; i < this.getPlateau().getNombrePersonnages(); i++){
                Personnage personnage = this.getPlateau().getPersonnage(i);
                System.out.println((i + 1) + ". " + personnage.getNom());
            }

            do {
                // Demande au joueur de choisir trois personnages
                System.out.println("A qui attribuez-vous le mandat signé ?");
                int choix1 = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages());

                System.out.println("A qui attribuez-vous un mandat sans effet ?");
                int choix2 = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages());
                int choix3 = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages());

                // Récupère les personnages choisis
                Personnage persoC1 = this.getPlateau().getPersonnage(choix1 - 1);
                Personnage persoC2 = this.getPlateau().getPersonnage(choix2 - 1);
                Personnage persoC3 = this.getPlateau().getPersonnage(choix3 - 1);

                // Vérifie les conditions pour attribuer les mandats
                if ((choix1 != choix2 && choix2 != choix3 && choix1 != choix3) &&
                    (persoC1.getRang() != 1 && persoC2.getRang() != 1 && persoC3.getRang() != 1)){
                    persoC1.setVraiEchevin(true);
                    persoC2.setFauxEchevin(true);
                    persoC3.setFauxEchevin(true);
                    continu = false;
                } else {
                    System.out.println("Vous ne pouvez pas vous choisir ou choisir plusieurs fois le même personnage");
                }

            } while (continu);
        }
    }

    /**
     * Méthode pour utiliser le pouvoir de l'avatar du personnage Echevin.
     * Permet de choisir trois personnages de manière aléatoire et d'attribuer des mandats spécifiques à chacun d'eux.
     */
    public void utiliserPouvoirAvatar() {
        if(this.getJoueur() != null && !this.getAssassine()){
            boolean continu = true;

            // Affiche la liste des personnages disponibles pour le choix
            System.out.println("Quels personnages voulez-vous cibler ?");
            for (int i = 0; i < this.getPlateau().getNombrePersonnages(); i++){
                Personnage personnage = this.getPlateau().getPersonnage(i);
                System.out.println((i + 1) + ". " + personnage.getNom());
            }

            do {
                Random ran = new Random();

                // Choix aléatoire de trois personnages
                int choix1 = ran.nextInt(this.getPlateau().getNombrePersonnages());
                int choix2 = ran.nextInt(this.getPlateau().getNombrePersonnages());
                int choix3 = ran.nextInt(this.getPlateau().getNombrePersonnages());

                // Récupère les personnages choisis
                Personnage persoC1 = this.getPlateau().getPersonnage(choix1);
                Personnage persoC2 = this.getPlateau().getPersonnage(choix2);
                Personnage persoC3 = this.getPlateau().getPersonnage(choix3);

                // Vérifie les conditions pour attribuer les mandats
                if ((choix1 != choix2 && choix2 != choix3 && choix1 != choix3) &&
                    (persoC1.getRang() != 1 && persoC2.getRang() != 1 && persoC3.getRang() != 1)){
                    persoC1.setVraiEchevin(true);
                    persoC2.setFauxEchevin(true);
                    persoC3.setFauxEchevin(true);
                    continu = false;
                } else {
                    System.out.println("Vous ne pouvez pas vous choisir ou choisir plusieurs fois le même personnage");
                }

            } while (continu);
        }
    }

    /**
     * Méthode pour activer le pouvoir de sorcière du personnage Echevin.
     * TODO: Ajouter l'implémentation du pouvoir de sorcière.
     */
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO: Ajouter l'implémentation du pouvoir de sorcière
    }
}
