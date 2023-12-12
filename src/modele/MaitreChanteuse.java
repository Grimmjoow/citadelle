package modele;

import java.util.Random;

import Controleur.Interaction;

/**
 * La classe MaitreChanteuse représente un type de personnage du jeu appelé "Maître-Chanteuse".
 * Elle hérite de la classe abstraite Personnage.
 */
public class MaitreChanteuse extends Personnage {

    /**
     * Constructeur de la classe MaitreChanteuse.
     * Initialise le nom, le rang et les caractéristiques de la Maître-Chanteuse.
     */
    public MaitreChanteuse() {
        super("Maître-Chanteuse", 2, Caracteristiques.MAITRE_CHANTEUSE);
    }

    /**
     * Redéfinition de la méthode utiliserPouvoir pour la Maître-Chanteuse.
     * Permet au joueur de menacer deux personnages, l'un avec une vraie menace et l'autre avec une fausse menace.
     * Les menaces ne peuvent pas être adressées à elle-même, à un personnage de rang 1 ou à un personnage ensorcelé.
     */
    @Override
    public void utiliserPouvoir() {
        if (this.getJoueur() != null && !this.getAssassine()) {
            boolean continu = true;
            System.out.println("Quels personnages voulez-vous menacer ?");

            for (int i = 0; i < this.getPlateau().getNombrePersonnages(); i++) {
                Personnage personnage = this.getPlateau().getPersonnage(i);
                System.out.println((i + 1) + ". " + personnage.getNom());
            }

            do {
                System.out.println("À qui adressez-vous la vraie menace ?");
                int choix1 = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages());

                System.out.println("À qui adressez-vous la fausse menace ?");
                int choix2 = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages());

                Personnage persoC1 = this.getPlateau().getPersonnage(choix1 - 1);
                Personnage persoC2 = this.getPlateau().getPersonnage(choix2 - 1);

                if ((choix1 != choix2) && (persoC1.getRang() != 1 && persoC2.getRang() != 1)
                        && !persoC1.getEnsorcele() && !persoC2.getEnsorcele() && !persoC1.getAssassine()
                        && !persoC2.getAssassine()) {
                    persoC1.setVraieMenace(true);
                    persoC2.setFausseMenace(true);
                    continu = false;
                } else {
                    System.out.println("Vous ne pouvez pas vous choisir ou choisir plusieurs fois le même personnage ou un personnage ensorcelé");
                }

            } while (continu);
        }
    }

    /**
     * Redéfinition de la méthode utiliserPouvoirAvatar pour la Maître-Chanteuse.
     * Menace automatiquement deux personnages, l'un avec une vraie menace et l'autre avec une fausse menace.
     * Les menaces ne peuvent pas être adressées à elle-même, à un personnage de rang 1 ou à un personnage ensorcelé.
     */
    public void utiliserPouvoirAvatar() {
        if (this.getJoueur() != null && !this.getAssassine()) {
            boolean continu = true;

            do {
                Random ran = new Random();
                int choix1 = ran.nextInt(this.getPlateau().getNombrePersonnages());
                int choix2 = ran.nextInt(this.getPlateau().getNombrePersonnages());

                Personnage persoC1 = this.getPlateau().getPersonnage(choix1);
                Personnage persoC2 = this.getPlateau().getPersonnage(choix2);

                if ((choix1 != choix2) && (persoC1.getRang() != 1 && persoC2.getRang() != 1)
                        && !persoC1.getEnsorcele() && !persoC2.getEnsorcele() && !persoC1.getAssassine()
                        && !persoC2.getAssassine()) {
                    persoC1.setVraieMenace(true);
                    persoC2.setFausseMenace(true);
                    continu = false;
                } else {
                    System.out.println("Vous ne pouvez pas vous choisir ou plusieurs fois le même personnage ou un personnage ensorcelé");
                }

            } while (continu);
        }
    }

    /**
     * Redéfinition de la méthode activationPouvoirSorciere pour la Maître-Chanteuse.
     * Cette méthode ne contient aucune action spécifique pour la Maître-Chanteuse.
     */
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // Aucune action spécifique pour la Maître-Chanteuse lors de l'activation du pouvoir de sorcière
    }
}
