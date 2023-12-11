// Package "Controleur"
package Controleur;

// Import des classes nécessaires
import java.util.InputMismatchException;
import java.util.Scanner;

import Exception.NulleString;
import Exception.OutOufBounds;
import Exception.WrongInput;

// Déclaration de la classe "Interaction"
public class Interaction {

    // Scanner pour la lecture depuis la console
    private static Scanner sc = new Scanner(System.in);

    // Lit et renvoie un entier saisi au clavier.
    public static int lireUnEntier() {
        int i = 0;
        boolean continu = true;
        do {
            try {
                i = sc.nextInt();
                continu = false;
            } catch (InputMismatchException e) {
                System.out.print("Veuillez rentrer un entier : ");
                sc.next(); // Ignore l'entrée pour éviter de boucler
            }
        } while (continu);
        return i;
    }

    // Lit et renvoie un entier saisi au clavier dans l'intervalle [borneMin, borneMax[.
    public static int lireUnEntier(int borneMin, int borneMax) {
        int i = 0;
        boolean continu = true;
        do {
            try {
                i = sc.nextInt();
                if (i < borneMin || i >= borneMax) {
                    throw new OutOufBounds();
                }
                continu = false;
            } catch (InputMismatchException e) {
                System.out.print("Veuillez rentrer un entier : ");
                sc.next();
            } catch (OutOufBounds e) {
                System.out.println("Veuillez rentrer un entier compris entre " + borneMin + " et " + (borneMax - 1));
            }
        } while (continu);
        return i;
    }

    // Lit et renvoie un booléen en fonction de la réponse "oui", "non", "o" ou "n".
    public static boolean lireOuiOuNon() {
        boolean retour = true;
        boolean continu = true;
        String i;
        do {
            try {
                i = sc.nextLine();
                if (!i.equals("o") && !i.equals("oui") && !i.equals("non") && !i.equals("n")) {
                    throw new WrongInput();
                } else if (i.equals("o") || i.equals("oui")) {
                    retour = true;
                } else {
                    retour = false;
                }
                continu = false;
            } catch (WrongInput e) {
                System.out.print("Veuillez rentrer (o)ui ou (n)on : ");
            }
        } while (continu);
        System.out.println(retour);
        return retour;
    }

    // Lit et renvoie une chaîne de caractères saisie au clavier.
    public static String lireUneChaine() {
        String retour = "";
        boolean reponse = false;
        boolean continu = true;
        do {
            try {
                retour = sc.nextLine();
                if (retour.equals("")) {
                    throw new NulleString();
                }
                continu = false;
            } catch (InputMismatchException e) {
                if (!reponse) {
                    System.out.print("Veuillez rentrer un mot : ");
                    reponse = true;
                }
            } catch (NulleString e) {
                System.out.println("Les entrées vides ne sont pas valables, veuillez rentrer un mot : ");
            }
        } while (continu);
        return retour;
    }
}
