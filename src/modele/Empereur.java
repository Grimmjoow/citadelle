package modele;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import controleur.Interaction;

public class Empereur extends Personnage {

    // Constructeur par défaut de la classe Empereur
    public Empereur() {
        super("Empereur", 4, Caracteristiques.EMPEREUR);
    }

    // Méthode pour utiliser le pouvoir du personnage Empereur
    @Override
    public void utiliserPouvoir() {
        // Liste pour stocker les joueurs éligibles à recevoir la couronne
        ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();

        // Parcourt tous les joueurs sur le plateau
        for(int i = 0; i < this.getPlateau().getNombreJoueurs(); i++) {
            // Si le joueur possède déjà la couronne, elle lui est retirée
            if(this.getPlateau().getJoueur(i).getPossedeCouronne()) {
                this.getPlateau().getJoueur(i).setPossedeCouronne(false);
            }
            // Si le joueur n'est pas l'Empereur lui-même, il est éligible à recevoir la couronne
            else if(!this.getPlateau().getJoueur(i).getNom().equals(this.getJoueur().getNom())) {
                listeJoueur.add(this.getPlateau().getJoueur(i));
            }
        }

        System.out.println("Veuillez choisir à qui vous voulez donner la couronne");
        // Affiche la liste des joueurs éligibles
        for(int j = 0; j < listeJoueur.size(); j++) {
            System.out.println((j + 1) + " - " + listeJoueur.get(j).getNom());
        }

        // Demande au joueur de choisir le destinataire de la couronne
        int choix = Interaction.lireUnEntier(1, listeJoueur.size() + 1) - 1;
        System.out.println("Vous avez choisi " + listeJoueur.get(choix).getNom() + ", il va recevoir la couronne");
        listeJoueur.get(choix).setPossedeCouronne(true);
    }

    // Méthode pour utiliser le pouvoir spécial de l'Empereur avec un choix aléatoire du destinataire de la couronne
    @Override
    public void utiliserPouvoirAvatar() {
        // Liste pour stocker les joueurs éligibles à recevoir la couronne
        ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();

        // Parcourt tous les joueurs sur le plateau
        for(int i = 0; i < this.getPlateau().getNombreJoueurs(); i++) {
            // Si le joueur possède déjà la couronne, elle lui est retirée
            if(this.getPlateau().getJoueur(i).getPossedeCouronne()) {
                this.getPlateau().getJoueur(i).setPossedeCouronne(false);
            }
            // Si le joueur n'est pas l'Empereur lui-même, il est éligible à recevoir la couronne
            else if(!this.getPlateau().getJoueur(i).getNom().equals(this.getJoueur().getNom())) {
                listeJoueur.add(this.getPlateau().getJoueur(i));
            }
        }

        // Choix aléatoire du destinataire de la couronne
        int choix = ThreadLocalRandom.current().nextInt(0, listeJoueur.size());
        System.out.println("Vous avez choisi " + listeJoueur.get(choix).getNom() + ", il va recevoir la couronne");
        listeJoueur.get(choix).setPossedeCouronne(true);
    }

    // Méthode d'activation du pouvoir de la sorcière (non implémentée ici)
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO Auto-generated method stub
    }
}
