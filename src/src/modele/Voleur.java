package modele;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import Exception.RangException;
import Exception.SelfChosen;

// Classe représentant le personnage "Voleur" du jeu
public class Voleur extends Personnage {

    // Constructeur de la classe Voleur
    public Voleur() {
        // Appelle le constructeur de la classe mère (Personnage) avec des valeurs spécifiques
        super("Voleur", 2, Caracteristiques.VOLEUR);
    }

    // Méthode pour utiliser le pouvoir du personnage
    @Override
    public void utiliserPouvoir() {
        // Vérifie si le personnage a été assassiné
        if (this.getAssassine()) {
            System.out.println("Votre personnage a été assassiné");
        } else {
            boolean continu = true;
            Scanner sc = new Scanner(System.in);
            System.out.println("Quel personnage voulez-vous voler ?");
            // Affiche la liste des personnages disponibles
            for (int i = 0; i < this.getPlateau().getNombrePersonnages(); i++) {
                System.out.println((i + 1) + "." + this.getPlateau().getPersonnage(i).getNom());
            }
            do {
                System.out.println("Votre choix : ");
                try {
                    int j = sc.nextInt();
                    int k = j - 1;
                    // Vérifie si le joueur a choisi lui-même
                    if (this.getPlateau().getPersonnage(k).equals(this)) {
                        throw new SelfChosen();
                    } else if (this.getPlateau().getPersonnage(k).getRang() == 1) {
                        throw new RangException();
                    }
                    // Active le pouvoir de vol sur le personnage choisi
                    this.getPlateau().getPersonnage(k).setVole();
                    System.out.println(this.getPlateau().getPersonnage(k).getNom() + " a été volé.");
                    continu = false;
                } catch (SelfChosen e) {
                    System.out.println("Vous ne pouvez pas vous voler");
                } catch (RangException e) {
                    System.out.println("Vous ne pouvez pas choisir un personnage de rang 1");
                }
            } while (continu);
        }
    }

    // Méthode pour utiliser le pouvoir de l'avatar du personnage
    @Override
    public void utiliserPouvoirAvatar() {
        // (Code similaire à utiliserPouvoir avec quelques modifications)
    }

    // Méthode pour activer le pouvoir de la Sorcière (non implémentée dans cet exemple)
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO: Implementer le pouvoir de la Sorcière ici
    }
}
