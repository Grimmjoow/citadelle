package modele;

import java.util.concurrent.ThreadLocalRandom;

import Controleur.Interaction;

/**
 * La classe Abbe représente un personnage de type Abbé dans le jeu.
 * Il a le pouvoir de percevoir des ressources (pièces ou quartiers) en fonction du nombre de quartiers religieux dans sa cité.
 */
public class Abbe extends Personnage {

    /**
     * Constructeur de la classe Abbé.
     * Initialise le personnage avec le nom "Abbé", le rang 5, et la caractéristique ABBE.
     */
    public Abbe() {
        super("Abbé", 5, Caracteristiques.ABBE);
    }

    /**
     * Méthode pour utiliser le pouvoir de l'Abbé.
     * L'Abbé peut percevoir un certain nombre de ressources (pièces ou quartiers) en fonction du nombre de quartiers religieux dans sa cité.
     */
    @Override
    public void utiliserPouvoir() {
        if (this.getAssassine()) {
            System.out.println("Votre personnage a été assassiné");
        } else {
            int count = 0;
            for (int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++) {
                if (this.getJoueur().getCite()[i] != null && this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[0])) {
                    count++;
                }
            }
            System.out.println("Vous pouvez percevoir " + count + " ressources (pièces ou quartiers)");
            System.out.println("Veuillez saisir le nombre de pièces que vous souhaitez percevoir : "
                    + "(si vous inscrivez le nombre maximal, vous ne percevrez que des pièces, sinon, vous percevrez le reste des ressources comme quartiers)");
            int choix = Interaction.lireUnEntier(0, count);
            this.getJoueur().ajouterPieces(choix);
            for (int i = 0; i < count - choix; i++) {
                this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
            }
            System.out.println("Vous avez reçu " + choix + " pièces et " + (count - choix) + " quartiers");

            // Trouver le joueur le plus riche
            int id = 0;
            int tresorMax = 0;
            String nomJ = "";
            for (int i = 0; i < this.getPlateau().getNombreJoueurs(); i++) {
                if (this.getPlateau().getJoueur(i).nbPieces() > tresorMax) {
                    tresorMax = this.getPlateau().getJoueur(i).nbPieces();
                    id = i;
                    nomJ = this.getPlateau().getJoueur(i).getNom();
                } else if (this.getPlateau().getJoueur(i).nbPieces() == tresorMax
                        && this.getPlateau().getJoueur(i).nbPieces() != 0
                        && !this.getPlateau().getJoueur(i).getNom().equals(this.getJoueur().getNom())) {
                    System.out.println("Deux joueurs ont le même nombre de pièces. Choisissez le joueur à qui vous voulez prendre des pièces:");
                    System.out.println("1 - " + nomJ + " ( " + tresorMax + " )");
                    System.out.println("2 - " + this.getPlateau().getJoueur(i).getNom() + " ( " + this.getPlateau().getJoueur(i).nbPieces() + " )");
                    int choixJ = Interaction.lireUnEntier(1, 2);
                    if (choixJ == 2) {
                        tresorMax = this.getPlateau().getJoueur(i).nbPieces();
                        id = i;
                        nomJ = this.getPlateau().getJoueur(i).getNom();
                    }
                }
            }

            // Si l'Abbé n'est pas le joueur le plus riche, il reçoit 1 pièce du joueur le plus riche
            if (!nomJ.equals(this.getJoueur().getNom())) {
                System.out.println("Vous allez maintenant recevoir 1 pièce du joueur le plus riche");
                this.getPlateau().getJoueur(id).retirerPieces(1);
                this.getJoueur().ajouterPieces(1);
            } else {
                System.out.println("Vous êtes le joueur le plus riche et vous ne pouvez donc pas recevoir d'or du joueur le plus riche");
            }
        }
    }

    /**
     * Méthode pour utiliser le pouvoir spécial de l'Abbé.
     * L'Abbé peut percevoir un certain nombre de ressources (pièces ou quartiers) en fonction du nombre de quartiers religieux dans sa cité.
     * La différence ici est que le nombre de pièces est choisi aléatoirement.
     */
    @Override
    public void utiliserPouvoirAvatar() {
        if (this.getAssassine()) {
            System.out.println("Votre personnage a été assassiné");
        } else {
            int count = 0;
            for (int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++) {
                if (this.getJoueur().getCite()[i] != null && this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[0])) {
                    count++;
                }
            }
            System.out.println("Vous pouvez percevoir " + count + " ressources (pièces ou quartiers)");
            System.out.println("Veuillez saisir le nombre de pièces que vous souhaitez percevoir : "
                    + "(si vous inscrivez le nombre maximal, vous ne percevrez que des pièces, sinon, vous percevrez le reste des ressources comme quartiers)");
            int choix = ThreadLocalRandom.current().nextInt(0, count + 1);
            this.getJoueur().ajouterPieces(choix);
            for (int i = 0; i < count - choix; i++) {
                this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
            }
            System.out.println("Vous avez reçu " + choix + " pièces et " + (count - choix) + " quartiers");

            // Trouver le joueur le plus riche
            int id = 0;
            int tresorMax = 0;
            String nomJ = "";
            for (int i = 0; i < this.getPlateau().getNombreJoueurs(); i++) {
                if (this.getPlateau().getJoueur(i).nbPieces() > tresorMax) {
                    tresorMax = this.getPlateau().getJoueur(i).nbPieces();
                    id = i;
                    nomJ = this.getPlateau().getJoueur(i).getNom();
                } else if (this.getPlateau().getJoueur(i).nbPieces() == tresorMax
                        && this.getPlateau().getJoueur(i).nbPieces() != 0
                        && !this.getPlateau().getJoueur(i).getNom().equals(this.getJoueur().getNom())) {
                    System.out.println("Deux joueurs ont le même nombre de pièces. Choisissez le joueur à qui vous voulez prendre des pièces:");
                    System.out.println("1 - " + nomJ + " ( " + tresorMax + " )");
                    System.out.println("2 - " + this.getPlateau().getJoueur(i).getNom() + " ( " + this.getPlateau().getJoueur(i).nbPieces() + " )");
                    int choixJ = ThreadLocalRandom.current().nextInt(1, 3);
                    if (choixJ == 2) {
                        tresorMax = this.getPlateau().getJoueur(i).nbPieces();
                        id = i;
                        nomJ = this.getPlateau().getJoueur(i).getNom();
                    }
                }
            }

            // Si l'Abbé n'est pas le joueur le plus riche, il reçoit 1 pièce du joueur le plus riche
            if (!nomJ.equals(this.getJoueur().getNom())) {
                System.out.println("Vous allez maintenant recevoir 1 pièce du joueur le plus riche");
                this.getPlateau().getJoueur(id).retirerPieces(1);
                this.getJoueur().ajouterPieces(1);
            } else {
                System.out.println("Vous êtes le joueur le plus riche et vous ne pouvez donc pas recevoir d'or du joueur le plus riche");
            }
        }
    }

    /**
     * Méthode pour l'activation du pouvoir face à la sorcière.
     * Non implémentée pour l'Abbé.
     * @param joueurSorciere Joueur cible de la sorcière.
     */
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // Non implémenté pour l'Abbé
    }
}
