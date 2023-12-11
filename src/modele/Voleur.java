// Package "modele"
package modele;

// Import des classes nécessaires
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import Exception.RangException;
import Exception.SelfChosen;

// Déclaration de la classe "Voleur" qui étend la classe "Personnage"
public class Voleur extends Personnage {

    // Constructeur de la classe "Voleur"
    public Voleur() {
        super("Voleur", 2, Caracteristiques.VOLEUR);
    }

    // Méthode pour utiliser le pouvoir du voleur
    @Override
    public void utiliserPouvoir() {
        // Vérifie si le personnage est assassiné
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

                    // Vérifie si le joueur tente de se voler lui-même
                    if (this.getPlateau().getPersonnage(k).equals(this)) {
                        throw new SelfChosen();
                    } else if (this.getPlateau().getPersonnage(k).getRang() == 1) {
                        throw new RangException();
                    }

                    // Active le pouvoir de voler sur le personnage choisi
                    this.getPlateau().getPersonnage(k).setVole();
                    // Gérer les pièces ??

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

    // Méthode pour utiliser le pouvoir du voleur (avatar)
    @Override
    public void utiliserPouvoirAvatar() {
        // Vérifie si le personnage est assassiné
        if (this.getAssassine()) {
            System.out.println("Votre personnage a été assassiné");
        } else {
            boolean continu = true;
            System.out.println("Quel personnage voulez-vous voler ?");

            // Affiche la liste des personnages disponibles
            for (int i = 0; i < this.getPlateau().getNombrePersonnages(); i++) {
                System.out.println((i + 1) + "." + this.getPlateau().getPersonnage(i).getNom());
            }

            do {
                System.out.println("Votre choix : ");
                try {
                    int j = ThreadLocalRandom.current().nextInt(0, this.getPlateau().getNombrePersonnages()) + 1;
                    int k = j - 1;

                    // Vérifie si le joueur tente de se voler lui-même
                    if (this.getPlateau().getPersonnage(k).equals(this)) {
                        throw new SelfChosen();
                    } else if (this.getPlate
