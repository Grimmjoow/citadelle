package modele;

import java.util.Random;
import controleur.Interaction;
import application.Jeu;

public class Bailli extends Personnage {

    // Constructeur par défaut de la classe Bailli
    public Bailli() {
        super("Bailli", 9, Caracteristiques.BAILLI);
    }

    // Méthode pour utiliser le pouvoir du Bailli
    @Override
    public void utiliserPouvoir() {
        if (Jeu.orDesTaxes != 0) {
            boolean recupererLOr = false;
            System.out.println("Voulez-vous récupérer l'or des taxes ?");
            recupererLOr = Interaction.lireOuiOuNon();

            if (recupererLOr) {
                this.getJoueur().ajouterPieces(Jeu.orDesTaxes);
                Jeu.orDesTaxes = 0;
            }
        }
    }

    // Méthode non utilisée dans la classe Bailli, héritée de la classe Personnage
    @Override
    public void percevoirRessourcesSpecifiques() {
        // Non utilisée dans la classe Bailli
    }

    // Méthode pour utiliser le pouvoir du Bailli (version avatar)
    @Override
    public void utiliserPouvoirAvatar() {
        Random generateur = new Random();
        if (Jeu.orDesTaxes != 0) {
            boolean recupererLOr = false;
            System.out.println("Voulez-vous récupérer l'or des taxes ?");
            recupererLOr = generateur.nextBoolean();

            if (recupererLOr) {
                this.getJoueur().ajouterPieces(Jeu.orDesTaxes);
                Jeu.orDesTaxes = 0;
            }
        }
    }

    // Méthode d'activation du pouvoir de la sorcière (non implémentée ici)
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO Auto-generated method stub
    }
}
