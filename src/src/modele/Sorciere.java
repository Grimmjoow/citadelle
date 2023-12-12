package modele;

import java.util.Random;
import Controleur.Interaction;

// Classe représentant le personnage "Sorcière" du jeu
public class Sorciere extends Personnage{

    // Variable pour stocker le personnage ensorcelé
    public Personnage persoEnsorcele=null;

    // Constructeur de la classe Sorcière
    public Sorciere() {
        // Appelle le constructeur de la classe mère (Personnage) avec des valeurs spécifiques
        super("Sorciere", 1, Caracteristiques.SORCIERE);
        // TODO: Compléter si nécessaire
    }

    // Méthode pour utiliser le pouvoir du personnage
    @Override
    public void utiliserPouvoir() {
        int choix=-1;
        // Boucle pour choisir un personnage à ensorceler (le joueur ne peut pas se choisir lui-même)
        do {
            // Affiche la liste des personnages disponibles
            for(int i=0; i<this.getPlateau().getNombrePersonnages(); i++){
                System.out.println((i+1)+". "+this.getPlateau().getPersonnage(i).getNom());
            }
            System.out.println("Choisissez un personnage à ensorceler (vous ne pouvez pas vous choisir)");
            // Lecture de l'entrée utilisateur
            choix = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages())-1;
            // Récupère le personnage choisi
            persoEnsorcele = this.getPlateau().getPersonnage(choix);
        } while (persoEnsorcele.equals(this)); // Répète tant que le joueur se choisit lui-même
        System.out.println("Vous avez choisi: "+persoEnsorcele.getNom()+", votre tour reprendra que ce personnage sera appelé");
        
        // Active le pouvoir d'ensorcellement sur le personnage choisi
        persoEnsorcele.setEnsorcele(true);
    }

    // Méthode pour utiliser le pouvoir de l'avatar du personnage
    @Override
    public void utiliserPouvoirAvatar() {
        int choix=-1;
        Random random = new Random();
        // Boucle pour choisir aléatoirement un personnage à ensorceler (le joueur ne peut pas se choisir lui-même)
        do {
            // Affiche la liste des personnages disponibles
            for(int i=0; i<this.getPlateau().getNombrePersonnages(); i++){
                System.out.println((i+1)+". "+this.getPlateau().getPersonnage(i).getNom());
            }
            System.out.println("Choisissez un personnage à ensorceler (vous ne pouvez pas vous choisir)");
            // Génère un choix aléatoire
            choix = random.nextInt(this.getPlateau().getNombrePersonnages());
            // Récupère le personnage choisi
            persoEnsorcele = this.getPlateau().getPersonnage(choix);
        } while (persoEnsorcele.equals(this)); // Répète tant que le joueur se choisit lui-même
        System.out.println("Vous avez choisi: "+persoEnsorcele.getNom()+", votre tour reprendra que ce personnage sera appelé");
        // Active le pouvoir d'ensorcellement sur le personnage choisi
        persoEnsorcele.setEnsorcele(true);
    }

    // Méthode pour activer le pouvoir de la Sorcière sur un joueur
    public void activationPouvoirSorciere(Joueur joueurSorciere){
        // Associe le joueurSorciere au personnage ensorcelé
        persoEnsorcele.setJoueur(joueurSorciere);
    }
}
