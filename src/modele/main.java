package modele;

import controleur.Interaction;

/**
 * La classe Main est la classe principale du programme, contenant la méthode main.
 */
public class Main {
    /**
     * Méthode principale du programme.
     * @param args Les arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        System.out.println("Choisissez :");
        Interaction interaction = new Interaction();
        int choix = interaction.lireUnEntier(1, 2);
    }
}
