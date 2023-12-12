package modele;

import java.util.Random;
import Controleur.Interaction;

/**
 * La classe Artiste représente un personnage de type Artiste dans le jeu.
 * Il possède des pouvoirs liés à l'embellissement des quartiers.
 */
public class Artiste extends Personnage {

    /**
     * Constructeur de la classe Artiste.
     * Initialise le personnage avec le nom "Artiste", le rang 9, et la caractéristique ARTISTE.
     */
    public Artiste(){
        super("Artiste",9,Caracteristiques.ARTISTE);
    }

    Random random = new Random();

    /**
     * Méthode pour utiliser le pouvoir du Artiste.
     * Permet au joueur de choisir jusqu'à deux quartiers dans sa cité à embellir.
     * Si le joueur a suffisamment de pièces, il peut choisir des quartiers à embellir, sinon il ne peut rien faire.
     */
    public void utiliserPouvoir(){
        System.out.println("\nVoici votre cité :");
        for(int l=0; l<this.getJoueur().nbQuartiersReelDansCite(); l++){
            Quartier quartier =this.getJoueur().getCite()[l];
            System.out.println((l+1));
            System.out.println("Nom du quartier: "+quartier.getNom());
            System.out.println("Type du quartier: "+quartier.getType());
            System.out.println("Coût de construction: "+quartier.getCout());
        }
        for(int i=0; i<2; i++){
            if(this.getJoueur().nbPieces()<1){
                System.out.println("Vous n'avez pas assez de pièces");
                break;
            }else{
                System.out.println("\nChoisissez le quartier n°"+(i+1)+" à embellir, 0 pour ne rien choisir");
                int choix = Interaction.lireUnEntier(0, this.getJoueur().nbQuartiersReelDansCite())-1;
                if(choix!=-1 && this.getJoueur().getCite()[choix]!=null){
                    this.getJoueur().getCite()[choix].embellir();
                    this.getJoueur().retirerPieces(1);
                }else{
                    System.out.println("Vous avez choisi de ne rien faire.");
                    break;
                }
            }
            
        }
    }

    /**
     * Méthode pour utiliser le pouvoir spécial du Artiste (version aléatoire).
     * Permet au joueur de choisir jusqu'à deux quartiers dans sa cité à embellir de manière aléatoire.
     * Si le joueur a suffisamment de pièces, il peut embellir des quartiers de manière aléatoire, sinon il ne peut rien faire.
     */
    public void utiliserPouvoirAvatar(){
        for(int i=0; i<2; i++){
            if(this.getJoueur().nbPieces()<1){
                System.out.println("Vous n'avez pas assez de pièces");
                break;
            }else{
                System.out.println("\nChoisissez le quartier n°"+(i+1)+" à embellir, 0 pour ne rien choisir");
                int choix = random.nextInt(this.getJoueur().nbQuartiersReelDansCite()+1)-1;
                if(choix!=-1 && this.getJoueur().getCite()[choix]!=null){
                    this.getJoueur().getCite()[choix].embellir();
                    this.getJoueur().retirerPieces(1);
                }else{
                    System.out.println("Vous avez choisi de ne rien faire.");
                    break;
                }
            }
            
        }
    }

    /**
     * Méthode pour l'activation du pouvoir face à la sorcière.
     * Non implémentée pour le Artiste.
     * @param joueurSorciere Joueur cible de la sorcière.
     */
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // Non implémenté pour le Artiste
    }
}
