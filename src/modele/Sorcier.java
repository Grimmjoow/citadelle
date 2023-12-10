// Package "modele"
package modele;

// Import de la classe "Random"
import java.util.Random;

// Import de la classe "Interaction" du package "Controleur" 

// Import de la classe "ArrayList" pour gérer les listes dynamiques
import java.util.ArrayList;

// Déclaration de la classe "Sorcier" qui étend la classe "Personnage"
public class Sorcier extends Personnage {

    // Constructeur
    public Sorcier() {
        super("Sorcier", 3, Caracteristiques.SORCIER);
    }

    // Méthode pour utiliser le pouvoir du Sorcier
    public void utiliserPouvoir() {

        // Affiche la liste des joueurs non-Sorciers
        for (int i = 0; i < this.getPlateau().getNombreJoueurs(); i++) {
            Joueur joueur = this.getPlateau().getJoueur(i);
            if (joueur.getPersonnage().getRang() != 3) {
                System.out.println((i + 1) + ". " + joueur.getNom());
            } else {
            }
        }

        System.out.println("Veuillez sélectionner le Joueur dont vous voulez voir la main : (0 pour ne rien faire) ");

        // Lit le choix de l'utilisateur
        int joueurVoirMain = Interaction.lireUnEntier(0, this.getPlateau().getNombreJoueurs()) - 1;

        if (joueurVoirMain != -1 && this.getPlateau().getJoueur(joueurVoirMain).getMain() != null) {

            // Affiche les quartiers dans la main du joueur choisi
            for (int k = 0; k < this.getPlateau().getJoueur(joueurVoirMain).getMain().size(); k++) {
                System.out.println((k + 1) + ". " + this.getPlateau().getJoueur(joueurVoirMain).getMain().get(k).getNom() + " (" + this.getPlateau().getJoueur(joueurVoirMain).getMain().get(k).getCout() + " piece(s))");
            }

            System.out.println("Quel quartier souhaitez-vous choisir ?");

            // Vérifie s'il y a des quartiers réels dans la main du joueur choisi
            if (this.getPlateau().getJoueur(joueurVoirMain).nbQuartiersReelDansMain() > 0) {

                // Lit le choix du quartier à prendre
                int quartierAPrendre = Interaction.lireUnEntier(1, this.getPlateau().getJoueur(joueurVoirMain).getMain().size()) - 1;

                Quartier quartierC2 = this.getPlateau().getJoueur(joueurVoirMain).getMain().get(quartierAPrendre);

                this.getPlateau().getJoueur(joueurVoirMain).getMain().remove(quartierAPrendre);

                // Vérifie si le joueur a assez d'argent pour construire le quartier choisi
                if (this.getJoueur().nbPieces() < quartierC2.getCout()) {
                    this.getJoueur().ajouterQuartierDansMain(quartierC2);
                    System.out.println("Vous n'avez pas assez d'argent pour bâtir ce quartier, il est ajouté à votre main.");
                }

                else {
                    System.out.println("Le quartier coûte : " + quartierC2.getCout() + " piece(s) vous avez " + this.getJoueur().nbPieces() + " piece(s) d'or, voulez-vous le bâtir ?");

                    // Lit la décision de construire le quartier ou non
                    Boolean construire = Interaction.lireOuiOuNon();

                    if (construire) {
                        this.getJoueur().retirerPieces(quartierC2.getCout());
                        this.getJoueur().ajouterQuartierDansCite(quartierC2);
                    } else {
                        this.getJoueur().ajouterQuartierDansMain(quartierC2);
                        System.out.println("Le quartier va dans votre main");
                    }
                }
            } else {
                System.out.println("Vous n'avez pas de quartier dans la main");
            }

        }

    }

    // Méthode pour utiliser le pouvoir Avatar du Sorcier
    public void utiliserPouvoirAvatar() {

        // Générateur de nombres aléatoires
        Random generateur = new Random();

        // Affiche la liste des joueurs non-Sorciers
        for (int i = 0; i < this.getPlateau().getNombreJoueurs(); i++) {
            Joueur joueur = this.getPlateau().getJoueur(i);
            if (joueur.getPersonnage().getRang() != 3) {
                System.out.println((i + 1) + ". " + joueur.getNom());
            } else {
            }
        }

        System.out.println("Veuillez sélectionner le Joueur dont vous voulez voir la main : (0 pour ne rien faire) ");

        // Choix aléatoire du joueur dont on veut voir la main
        int joueurVoirMain = generateur.nextInt(this.getPlateau().getNombreJoueurs() + 1) - 1;

        if (joueurVoirMain != -1 && this.getPlateau().getJoueur(joueurVoirMain).getMain() != null) {

            // Affiche les quartiers dans la main du joueur choisi
            for (int k = 0; k < this.getPlateau().getJoueur(joueurVoirMain).getMain().size(); k++) {
                System.out.println((k + 1) + ". " + this.getPlateau().getJoueur(joueurVoirMain).getMain().get(k).getNom() + " (" + this.getPlateau().getJoueur(joueurVoirMain).getMain().get(k).getCout() + " piece(s))");
            }

            System.out.println("Quel quartier souhaitez-vous choisir ?");
            // Vérifie s'il y a des quartiers réels dans la main du joueur choisi
            if (this.getPlateau().getJoueur(joueurVoirMain).nbQuartiersReelDansMain() > 0) {

                // Choix aléatoire du quartier à prendre
                int quartierAPrendre = generateur.nextInt(this.getPlateau().getJoueur(joueurVoirMain).getMain().size());

                Quartier quartierC2 = this.getPlateau().getJoueur(joueurVoirMain).getMain().get(quartierAPrendre);

                this.getPlateau().getJoueur(joueurVoirMain).getMain().remove(quartierAPrendre);

                // Vérifie si le joueur a assez d'argent pour construire le quartier choisi
                if (this.getJoueur().nbPieces() < quartierC2.getCout()) {
                    this.getJoueur().ajouterQuartierDansMain(quartierC2);
                    System.out.println("Vous n'avez pas assez d'argent pour bâtir ce quartier, il est ajouté à votre main.");
                }

                else {
                    System.out.println("Le quartier coûte : " + quartierC2.getCout() + " piece(s) vous avez " + this.getJoueur().nbPieces() + " piece(s) d'or, voulez-vous le bâtir ?");

                    // Décision aléatoire de construire le quartier ou non
                    Boolean construire = generateur.nextBoolean();

                    if (construire) {
                        this.getJoueur().retirerPieces(quartierC2.getCout());
                        this.getJoueur().ajouterQuartierDansCite(quartierC2);
                    } else {
                        this.getJoueur().ajouterQuartierDansMain(quartierC2);
                        System.out.println("Le quartier va dans votre main");
                    }
                }
            } else {
                System.out.println("Vous n'avez pas de quartier dans la main");
            }

        }
    }

    // Implémentation de la méthode d'activation du pouvoir de la Sorcière (non utilisée dans cette classe)
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO Auto-generated method stub
    }
}
