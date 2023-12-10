// Package "modele"
package modele;

// Import de la classe "Random"
import java.util.Random;

// Import de la classe "Interaction" du package "Controleur" 

// Déclaration de la classe "Sorciere" qui étend la classe "Personnage"
public class Sorciere extends Personnage {

    // Attribut pour stocker le personnage ensorcelé
    public Personnage persoEnsorcele = null;

    // Constructeur
    public Sorciere() {
        super("Sorciere", 1, Caracteristiques.SORCIERE);
        //TODO Auto-generated constructor stub
    }

    // Implémentation de la méthode pour utiliser le pouvoir de la Sorciere
    @Override
    public void utiliserPouvoir() {
        int choix = -1;
        do {
            for (int i = 0; i < this.getPlateau().getNombrePersonnages(); i++) {
                System.out.println((i + 1) + ". " + this.getPlateau().getPersonnage(i).getNom());
            }
            System.out.println("Choisissez un personnage à ensorceler (vous ne pouvez pas vous choisir)");
            choix = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages()) - 1;
            persoEnsorcele = this.getPlateau().getPersonnage(choix);
        } while (persoEnsorcele.equals(this));
        System.out.println("Vous avez choisi: " + persoEnsorcele.getNom() + ", votre tour reprendra que ce personnage sera appelé");
        
        persoEnsorcele.setEnsorcele(true);
    }

    // Implémentation de la méthode pour utiliser le pouvoir Avatar de la Sorciere
    @Override
    public void utiliserPouvoirAvatar() {
        int choix = -1;

        // Utilisation d'un objet Random pour choisir aléatoirement un personnage
        Random random = new Random();
        do {
            for (int i = 0; i < this.getPlateau().getNombrePersonnages(); i++) {
                System.out.println((i + 1) + ". " + this.getPlateau().getPersonnage(i).getNom());
            }
            System.out.println("Choisissez un personnage à ensorceler (vous ne pouvez pas vous choisir)");
            choix = random.nextInt(this.getPlateau().getNombrePersonnages());
            persoEnsorcele = this.getPlateau().getPersonnage(choix);
        } while (persoEnsorcele.equals(this));
        System.out.println("Vous avez choisi: " + persoEnsorcele.getNom() + ", votre tour reprendra que ce personnage sera appelé");
        persoEnsorcele.setEnsorcele(true);
    }

    // Méthode pour activer le pouvoir de la Sorciere
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        persoEnsorcele.setJoueur(joueurSorciere);
    }
}
