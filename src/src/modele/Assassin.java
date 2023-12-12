package modele;

import java.util.concurrent.ThreadLocalRandom;
import Controleur.Interaction;
import Exception.SelfChosen;
import Exception.WrongInput;

/**
 * La classe Assassin représente un personnage de type Assassin dans le jeu.
 * Il possède des pouvoirs liés à l'assassinat d'autres personnages.
 */
public class Assassin extends Personnage {

    /**
     * Constructeur de la classe Assassin.
     * Initialise le personnage avec le nom "Assassin", le rang 1, et la caractéristique ASSASSIN.
     */
    public Assassin(){
        super("Assassin", 1, Caracteristiques.ASSASSIN); 
    }

    /**
     * Méthode pour utiliser le pouvoir du Assassin.
     * Permet au joueur de choisir un personnage à assassiner parmi les personnages du plateau.
     * Si le choix est valide, le personnage ciblé est assassiné.
     * Gère les exceptions SelfChosen et WrongInput.
     */
    @Override
    public void utiliserPouvoir() {
        boolean continu = true;
        Interaction sc = new Interaction();
        System.out.println("Quel personnage voulez-vous assassiner ?");
        for(int i = 0; i<this.getPlateau().getNombrePersonnages(); i++){
            System.out.println((i+1) + "." + this.getPlateau().getPersonnage(i).getNom());
        }
        do{
            System.out.println("Votre choix : ");
            try{
                int j = sc.lireUnEntier(1, this.getPlateau().getNombrePersonnages());
                int k = j-1;
                if(this.getPlateau().getPersonnage(k).equals(this)){
                    throw new SelfChosen();
                }
                this.getPlateau().getPersonnage(k).setAssassine();
                System.out.println(this.getPlateau().getPersonnage(k).getNom() + " a été assassiné.");
                continu = false;
            }catch(SelfChosen e){
                System.out.println("Vous ne pouvez pas vous assassiner.");
            }
        }while(continu);   
    }

    /**
     * Méthode pour utiliser le pouvoir spécial du Assassin.
     * Permet au joueur, de manière aléatoire, de choisir un personnage à assassiner parmi les joueurs du plateau.
     * Si le choix est valide, le personnage ciblé est assassiné.
     * Gère les exceptions SelfChosen et WrongInput.
     */
    @Override
    public void utiliserPouvoirAvatar() {
        boolean continu = true;
        System.out.println("Quel personnage voulez-vous assassiner ?");
        for(int i = 0; i<this.getPlateau().getNombrePersonnages(); i++){
            System.out.println((i+1) + "." + this.getPlateau().getPersonnage(i).getNom());
        }
        do{
            System.out.println("Choix de " + this.getJoueur().getNom() + " :");
            try{
                int j = ThreadLocalRandom.current().nextInt(-1, this.getPlateau().getNombreJoueurs()) + 1;
                int k = j-1;
                if(!(this.getPlateau().getPersonnage(k) == null) && this.getPlateau().getPersonnage(k).equals(this)){
                    throw new SelfChosen();
                }else if(this.getPlateau().getPersonnage(k) == null){
                    throw new WrongInput();
                }
                this.getPlateau().getPersonnage(k).setAssassine();
                System.out.println(this.getPlateau().getPersonnage(k).getNom() + " a été assassiné.");
                continu = false;
            }catch(SelfChosen e){
            }catch(WrongInput e){
            }
        }while(continu);
    }

    /**
     * Méthode pour l'activation du pouvoir face à la sorcière.
     * Non implémentée pour le Assassin.
     * @param joueurSorciere Joueur cible de la sorcière.
     */
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // Non implémenté pour le Assassin
    }
}
