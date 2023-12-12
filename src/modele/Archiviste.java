package modele;

import java.util.ArrayList;
import java.util.Random;

import Controleur.Interaction;

/**
 * La classe Archiviste représente un personnage de type Archiviste dans le jeu.
 * Il possède des pouvoirs liés à la pioche de cartes et la sélection de l'une d'entre elles.
 */
public class Archiviste extends Personnage {

    /**
     * Constructeur de la classe Archiviste.
     * Initialise le personnage avec le nom "Archiviste", le rang 7, et la caractéristique ARCHIVISTE.
     */
    public Archiviste(){
        super("Archiviste", 7, Caracteristiques.ARCHIVISTE);
    }

    /**
     * Méthode pour utiliser le pouvoir du Archiviste.
     * Permet au joueur de piocher 7 cartes, d'en choisir une à garder, et de remettre les autres dans la pioche.
     */
    @Override
    public void utiliserPouvoir() {
        ArrayList<Quartier> piocheJoueur = new ArrayList<Quartier>();
        System.out.println("Vous pouvez piocher 7 cartes et en garder 1. \nVeuillez choisir une carte à garder.");
        for(int i=0; i<7; i++){
            if(this.getPlateau().getPioche().nombreElements()>0){
                piocheJoueur.add(this.getPlateau().getPioche().piocher());
                System.out.println((i+1)+". Nom: "+piocheJoueur.get(i).getNom()+"\ntype: "+piocheJoueur.get(i).getType()+"\ncout: "+piocheJoueur.get(i).getCout());
            }else{
                System.out.println("La pioche est vide");
                break;
            }
        }
        if(piocheJoueur.size()!=0){
            int choix = Interaction.lireUnEntier(1, piocheJoueur.size())-1;
            this.getJoueur().ajouterQuartierDansMain(piocheJoueur.get(choix));
            piocheJoueur.remove(choix);
            for(int i=0;i<6;i++){
                this.getPlateau().getPioche().ajouter(piocheJoueur.get(i));
            }  
        }
        
        piocheJoueur.clear();
        this.getPlateau().getPioche().melanger();
    }

    /**
     * Méthode pour utiliser le pouvoir spécial du Archiviste (version aléatoire).
     * Permet au joueur de piocher 7 cartes, d'en choisir une à garder de manière aléatoire, et de remettre les autres dans la pioche.
     */
    @Override
    public void utiliserPouvoirAvatar() {
        ArrayList<Quartier> piocheJoueur = new ArrayList<Quartier>();
        System.out.println("Vous pouvez piocher 7 cartes et en garder 1. \nVeuillez choisir une carte à garder.");
        for(int i=0; i<7; i++){
            if(this.getPlateau().getPioche().nombreElements()>0){
                piocheJoueur.add(this.getPlateau().getPioche().piocher());
                System.out.println((i+1)+". Nom: "+piocheJoueur.get(i).getNom()+"\ntype: "+piocheJoueur.get(i).getType()+"\ncout: "+piocheJoueur.get(i).getCout());
            }else{
                System.out.println("La pioche est vide");
                break;
            }   
        }
        Random random = new Random();
        if(piocheJoueur.size()!=0){
            int choix = random.nextInt(piocheJoueur.size());
            this.getJoueur().ajouterQuartierDansMain(piocheJoueur.get(choix));
            piocheJoueur.remove(choix);
            for(int i=0;i<piocheJoueur.size();i++){
                this.getPlateau().getPioche().ajouter(piocheJoueur.get(i));
            }
        }
        
        piocheJoueur.clear();
        this.getPlateau().getPioche().melanger();
    }

    /**
     * Méthode pour l'activation du pouvoir face à la sorcière.
     * Non implémentée pour le Archiviste.
     * @param joueurSorciere Joueur cible de la sorcière.
     */
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // Non implémenté pour le Archiviste
    }
}
